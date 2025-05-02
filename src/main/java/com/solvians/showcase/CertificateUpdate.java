package com.solvians.showcase;

import java.time.LocalDate;

public class CertificateUpdate {

    private final long timestamp;
    private final String isin;
    private final double bidPrice;
    private final int bidSize;
    private final double askPrice;
    private final int askSize;
    private final LocalDate maturityDate;

    public CertificateUpdate(long timestamp, String isin, double bidPrice, int bidSize,
                             double askPrice, int askSize, LocalDate maturityDate) {

        this.timestamp = timestamp;
        this.isin = isin;
        this.bidPrice = bidPrice;
        this.bidSize = bidSize;
        this.askPrice = askPrice;
        this.askSize = askSize;
        this.maturityDate = maturityDate;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getIsin() {
        return isin;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public int getBidSize() {
        return bidSize;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public int getAskSize() {
        return askSize;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%.2f,%d,%.2f,%d",
                timestamp, isin, bidPrice, bidSize, askPrice, askSize);
    }
}
