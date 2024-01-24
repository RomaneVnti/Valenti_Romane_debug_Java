package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of ISymptomReader that reads symptom data from a file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filepath;

    /**
     * Constructor for ReadSymptomDataFromFile.
     *
     * @param filepath A full or partial path to a file with symptom strings in it, one per line.
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Read symptoms from the specified file.
     *
     * @return A list of symptom strings.
     */
    @Override
    public List<String> GetSymptoms() {
        ArrayList<String> result = new ArrayList<>();

        if (filepath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}