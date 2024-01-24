package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

    private final ISymptomReader symptomReader;
    private final ISymptomWriter symptomWriter;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.symptomReader = reader;
        this.symptomWriter = writer;
    }

    public List<String> getSymptoms() {
        return symptomReader.GetSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCount = new HashMap<>();
        for (String symptom : symptoms) {
            symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
        }
        return symptomCount;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        LinkedHashMap<String, Integer> sortedSymptoms = new LinkedHashMap<>();
        symptoms.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(entry -> sortedSymptoms.put(entry.getKey(), entry.getValue()));
        return sortedSymptoms;
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        symptomWriter.writeSymptoms(symptoms);
    }

    public void execute() {
        List<String> symptomsList = getSymptoms();
        Map<String, Integer> countedSymptoms = countSymptoms(symptomsList);
        Map<String, Integer> sortedSymptoms = sortSymptoms(countedSymptoms);
        writeSymptoms(sortedSymptoms);
    }
}
