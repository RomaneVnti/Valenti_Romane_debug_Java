package com.hemebiotech.analytics;

public class Main {

    public static void main(String[] args) {
        // Créez un objet ISymptomReader
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

        // Créez un objet ISymptomWriter
        ISymptomWriter writer = new MySymptomWriter("result_out");

        // Créez un objet AnalyticsCounter
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        // Appelez les différentes méthodes d'AnalyticsCounter pour exécuter les traitements dans le bon ordre
        analyticsCounter.execute();
    }
}
