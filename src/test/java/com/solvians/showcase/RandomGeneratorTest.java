package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static com.solvians.showcase.RandomGenerator.generateISIN;

public class RandomGeneratorTest {

    @Test
    public void testRandomGenerator() {
        String isin = generateISIN();
        CertificateUpdateTest certificateUpdateTest = new CertificateUpdateTest();
        certificateUpdateTest.testISIN(isin);
    }
}
