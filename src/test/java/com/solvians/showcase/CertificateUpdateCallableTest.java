package com.solvians.showcase;

import org.junit.jupiter.api.Test;

public class CertificateUpdateCallableTest {

    @Test
    public void testCertificateUpdateCallable() {
        CertificateUpdateCallable callable = new CertificateUpdateCallable();

        try {
            CertificateUpdate certificateUpdate = callable.call();
            CertificateUpdateTest certificateUpdateTest = new CertificateUpdateTest();
            certificateUpdateTest.testCertificateUpdate(certificateUpdate);

        } catch (Exception e) {

        }
    }
}
