package fr.harington;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main main;

    @BeforeEach
    void initialization(){
        main = new Main();
    }

    @Test
    void givenStringValue_whenToUpperCaseParamOrGetUnknown_thenGetUpperCaseStringValue() {
        final String givenParam = "hello";
        final String expectedName = "HELLO";
        assertEquals(expectedName, main.toUpperCaseParamOrGetUnknown(givenParam));
    }

    @Test
    void givenPersonWithValidAddress_whenGetPersonAddressNameOrGetUnknown_thenGetCorrectAddressName() {
        final String givenParam = "Asnières";
        final Main.Person givenPerson = new Main.Person(Optional.of(new Main.Address(givenParam)));
        final String exceptedName = "Asnières";
        assertEquals(exceptedName, main.getPersonAddressNameOrGetUnknown(givenPerson));
    }

    @Test
    void givenStringValue_whenToUpperCaseParamOrThrowIllegalArgumentException_thenThrowIllegalArgumentException() {
        final String givenParam = null;
        assertThrows(IllegalArgumentException.class, () -> main.toUpperCaseParamOrThrowIllegalArgumentException(givenParam));
    }

    @Nested
    class TestFilterAndGetMessageOrGetDefaultMessage {

        @Test
        void givenOptionalValidDouble_whenFilterAndGetMessageOrGetDefaultMessage_thenReturnGoodValue() {
            final Optional<Double> givenValue = Optional.of(12d);
            final String expectedMessage = "Valid value: 12.0";
            assertEquals(expectedMessage, main.filterAndGetMessageOrGetDefaultMessage(givenValue));
        }

        @Test
        void givenOptionalInvalidDouble_whenFilterAndGetMessageOrGetDefaultMessage_thenReturnDefaultValue() {
            final Optional<Double> givenValue = Optional.empty();
            final String expectedMessage = "Invalid value given";
            assertEquals(expectedMessage, main.filterAndGetMessageOrGetDefaultMessage(givenValue));
        }
    }
}