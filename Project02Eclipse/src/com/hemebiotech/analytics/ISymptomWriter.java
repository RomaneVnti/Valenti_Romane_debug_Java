package com.hemebiotech.analytics;

import java.util.Map;

/**
 * An interface for writing symptoms to an output source.
 */
public interface ISymptomWriter {

    /**
     * Write the symptoms and their occurrences to an output source.
     *
     * @param symptoms A map containing symptoms as keys and their occurrences as values.
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
