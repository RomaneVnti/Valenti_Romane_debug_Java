package com.hemebiotech.analytics;

/**
 * Main class to execute the symptom analytics application.
 */
public class Main {

    /**
     * The main method to run the symptom analytics.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create an ISymptomReader object
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

        // Create an ISymptomWriter object
        ISymptomWriter writer = new MySymptomWriter("result_out");

        // Create an AnalyticsCounter object
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        // Call the execute method of AnalyticsCounter to perform the analysis and write the result
        analyticsCounter.execute();
    }
}
