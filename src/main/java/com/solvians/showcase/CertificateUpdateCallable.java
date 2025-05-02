package com.solvians.showcase;

import java.time.LocalDate;
import java.util.concurrent.Callable;

import static com.solvians.showcase.RandomGenerator.*;

public class CertificateUpdateCallable implements Callable<CertificateUpdate> {

    @Override
    public CertificateUpdate call() throws Exception {
        long timestamp = System.currentTimeMillis();
        String isin = generateISIN();
        double bidPrice = getRandomDoubleValue(100.00, 200.01, 2);
        int bidSize = getRandomIntegerValue(1000, 5001);
        double askPrice = getRandomDoubleValue(100.00, 200.01, 2);
        int askSize = getRandomIntegerValue(1000, 10001);
        LocalDate maturityDate = getRandomFutureDateWithinYears(2);

        return new CertificateUpdate(timestamp, isin, bidPrice, bidSize, askPrice, askSize, maturityDate);
    }
}
