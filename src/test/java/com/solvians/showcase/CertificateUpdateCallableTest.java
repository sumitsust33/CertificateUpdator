package com.solvians.showcase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CertificateUpdateCallableTest {

    private CertificateUpdateCallable callable;

    @BeforeEach
    void setUp() {
        callable = new CertificateUpdateCallable();
    }

    @Test
    public void testCertificateUpdateCallable() {
        try {
            CertificateUpdate certificateUpdate = callable.call();
            CertificateUpdateTest certificateUpdateTest = new CertificateUpdateTest();
            certificateUpdateTest.testCertificateUpdate(certificateUpdate);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get certificate update", e);
        }
    }
}
