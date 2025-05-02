package com.solvians.showcase;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final ThreadLocalRandom random;

    static {
        random = ThreadLocalRandom.current();
    }

    public static String generateISIN() {
        StringBuilder isin = new StringBuilder();
         isin.append(randomUpperCaseCharacter()).append(randomUpperCaseCharacter());

        for (int i = 0 ; i < 9 ; i++) {
            isin.append(ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length())));
        }

        return isin.append(getCheckDigit(isin.toString())).toString();
    }

    private static String randomUpperCaseCharacter() {
        return String.valueOf((char) ('A' + ThreadLocalRandom.current().nextInt(26)));
    }

    public static int getCheckDigit(String isinFirstPart) {
        StringBuilder lastPart = new StringBuilder();

        for (char c : isinFirstPart.toCharArray()) {
            if (Character.isDigit(c)) {
                lastPart.append(c);
            } else {
                int val = c - 'A' + 10;
                lastPart.append(val);
            }
        }

        String numStr = lastPart.toString();
        StringBuilder reversed = new StringBuilder(numStr).reverse();

        int sum = 0;
        for (int i = 0; i < reversed.length(); i++) {
            int digit = Character.getNumericValue(reversed.charAt(i));
            if (i % 2 == 0) {
                digit *= 2;
            }

            if (digit > 9) {
                sum += digit / 10 + digit % 10;
            } else {
                sum += digit;
            }
        }

        return (10 - (sum % 10)) % 10;
    }

    public static double getRandomDoubleValue(double min, double max, int decimalPlaces) {
        double factor = Math.pow(10, decimalPlaces);

        return Math.round((min + (max - min) * random.nextDouble()) * factor) / factor;
    }

    public static int getRandomIntegerValue(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static LocalDate getRandomFutureDateWithinYears(int years) {
        long todayEpochDay = LocalDate.now().toEpochDay();
        long maxEpochDay = LocalDate.now().plusYears(years).toEpochDay();
        long randomEpochDay = todayEpochDay + random.nextInt((int) (maxEpochDay - todayEpochDay));

        return LocalDate.ofEpochDay(randomEpochDay);
    }
}
