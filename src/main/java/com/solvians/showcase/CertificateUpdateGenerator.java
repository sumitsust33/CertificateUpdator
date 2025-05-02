package com.solvians.showcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class CertificateUpdateGenerator {
    private final int threads;
    private final int quotes;

    public CertificateUpdateGenerator(int threads, int quotes) {
        this.threads = threads;
        this.quotes = quotes;
    }

    public Stream<CertificateUpdate> generateQuotes() {
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        List<Future<CertificateUpdate>> futureCertificateUpdates = new ArrayList<>();

        for (int i = 0; i < threads * quotes; i++) {
            futureCertificateUpdates.add(executorService.submit(new CertificateUpdateCallable()));
        }

        executorService.shutdownNow();

        return futureCertificateUpdates.stream().map(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Failed to get certificate update", e);
            }
        });
    }
}
