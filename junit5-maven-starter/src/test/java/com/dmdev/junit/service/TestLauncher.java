package com.dmdev.junit.service;

import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

public class TestLauncher {

    public static void  main(String[] args){
        var launcher = LauncherFactory.create();
//        launcher.registerTestExecutionListeners();

        var summaryGeneratingListener = new SummaryGeneratingListener();
//        launcher.registerTestExecutionListeners();
//        launcher.registerTestExecutionListeners(summaryGeneratingListeners);

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(DiscoverySelectors.selectClass(CalcTest.class))
                .selectors(DiscoverySelectors.selectPackage("com.dmdev.junit.service"))
                .listeners()
                .build();
        launcher.execute(request, summaryGeneratingListener);
        summaryGeneratingListener.getSummary().getTimeFinished();
        try (var writer = new PrintWriter(System.out)) {
            summaryGeneratingListener.getSummary().printTo(writer);
        }
    }
}
