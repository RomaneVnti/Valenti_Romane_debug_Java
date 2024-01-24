package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String outputFile;

    public WriteSymptomDataToFile(String outputFile) {
        this.outputFile = outputFile;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.println("Symptôme : " + entry.getKey() + ", Quantité : " + entry.getValue());
            }
            System.out.println("Les symptômes ont été écrits dans le fichier : " + outputFile);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture des symptômes dans le fichier : " + outputFile);
            e.printStackTrace();
        }
    }
}
