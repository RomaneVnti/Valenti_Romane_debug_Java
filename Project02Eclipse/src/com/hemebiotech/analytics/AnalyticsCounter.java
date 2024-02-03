package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A class for analyzing symptoms and generating a report.
 */
public class AnalyticsCounter {

    private final ISymptomReader symptomReader;
    private final ISymptomWriter symptomWriter;

    /**
     * Constructor for AnalyticsCounter.
     *
     * @param reader The symptom reader. 
     * @param writer The symptom writer.
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.symptomReader = reader;
        this.symptomWriter = writer;
    }

    /**
     * Get the list of symptoms from the reader.
     *
     * @return A list of symptoms.
     */
    public List<String> getSymptoms() {
        return symptomReader.GetSymptoms();
    }

    /**
     * Count the occurrences of each symptom.
     *
     * @param symptoms The list of symptoms.
     * @return A map containing symptom counts.
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCount = new HashMap<>();
        for (String symptom : symptoms) {
            symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
        }
        return symptomCount;
    }

    /**
     * Sort symptoms alphabetically.
     *
     * @param symptoms The unsorted symptoms.
     * @return A map with sorted symptoms.
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        LinkedHashMap<String, Integer> sortedSymptoms = new LinkedHashMap<>();
        symptoms.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(entry -> sortedSymptoms.put(entry.getKey(), entry.getValue()));
        return sortedSymptoms;
    }

    /**
     * Write symptoms to the output using the writer.
     *
     * @param symptoms The symptoms to write.
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        symptomWriter.writeSymptoms(symptoms);
    }

    /**
     * Execute the analysis process.
     */
    public void execute() {
        List<String> symptomsList = getSymptoms();
        Map<String, Integer> countedSymptoms = countSymptoms(symptomsList);
        Map<String, Integer> sortedSymptoms = sortSymptoms(countedSymptoms);
        writeSymptoms(sortedSymptoms);
    }
}
