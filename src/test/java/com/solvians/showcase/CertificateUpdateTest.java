package com.solvians.showcase;

import java.time.LocalDate;

import static com.solvians.showcase.RandomGenerator.getCheckDigit;
import static org.junit.jupiter.api.Assertions.*;

public class CertificateUpdateTest {

    public void testCertificateUpdate(CertificateUpdate certificateUpdate) {
        assertNotNull(certificateUpdate, "Certificate object should not be null");

        testISIN(certificateUpdate.getIsin());

        assertTrue(certificateUpdate.getTimestamp() > 0, "Should be greater than zero");
        assertTrue(certificateUpdate.getTimestamp() <= System.currentTimeMillis(), "Should be less than or equal to now");

        assertTrue(certificateUpdate.getBidPrice() >= 100.00 && certificateUpdate.getBidPrice() <= 200.00, "Bid price out of range");
        assertTrue(certificateUpdate.getAskPrice() >= 100.00 && certificateUpdate.getAskPrice() <= 200.00, "Ask price out of range");

        assertTrue(certificateUpdate.getBidSize() >= 1000 && certificateUpdate.getBidSize() <= 5000, "Bid size out of range");
        assertTrue(certificateUpdate.getAskSize() >= 1000 && certificateUpdate.getAskSize() <= 10000, "Ask size out of range");

        testMaturityDate(certificateUpdate.getMaturityDate());
    }

    public void testISIN(String isin) {
        assertNotNull(isin, "should not be null");
        assertEquals(12, isin.length(), "ISIN should be exactly 12 characters");

        String countryCode = isin.substring(0, 2);
        assertTrue(countryCode.matches("[A-Z]{2}"), "First 2 characters must be uppercase");

        String body = isin.substring(2, 11);
        assertTrue(body.matches("[A-Z0-9]{9}"), "Second part of 9 characters must be alphanumeric");

        char checkDigitChar = isin.charAt(11);
        assertTrue(Character.isDigit(checkDigitChar), "Last character must be a digit");
        assertTrue(Character.getNumericValue(checkDigitChar) < 10);

        String withoutCheckDigit = isin.substring(0, 11);
        int expectedDigit = getCheckDigit(withoutCheckDigit);
        int actualDigit = Character.getNumericValue(checkDigitChar);
        assertEquals(expectedDigit, actualDigit, "Check digit must be valid");
    }

    private void testMaturityDate(LocalDate maturityDate) {
        LocalDate now = LocalDate.now();
        LocalDate maxDate = now.plusYears(2);

        assertNotNull(maturityDate, "Should not be null");
        assertFalse(maturityDate.isBefore(now), "Should not be before current date");
        assertFalse(maturityDate.isAfter(maxDate), "Should be within 2 years from today");
    }
}
