package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * An implementation of ISymptomWriter that writes symptoms to a file.
 */
public class MySymptomWriter implements ISymptomWriter {

    private String outputFile;

    /**
     * Constructor for MySymptomWriter.
     *
     * @param outputFile The file to write symptoms to.
     */
    public MySymptomWriter(String outputFile) {
        this.outputFile = outputFile;
    }

    /**
     * Write symptoms and their occurrences to a file.
     *
     * @param symptoms A map containing symptoms as keys and their occurrences as values.
     */
    @Override
    public void WriteSymptoms(Map<String, Integer> symptoms) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("Les symptômes ont été écrits dans le fichier : " + outputFile);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture des symptômes dans le fichier : " + outputFile);
            e.printStackTrace();
        }
    }
}
