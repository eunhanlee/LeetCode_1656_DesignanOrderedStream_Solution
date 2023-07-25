package org.example;

import java.util.*;

/**
 * The OrderedStream class represents a data structure that receives a stream of data
 * with integer keys and stores them in a specific order. It allows inserting data with
 * a given ID key and retrieves a list of data in a consecutive manner when possible.
 */
public class OrderedStream {
    private String[] stream; // The array to store the stream data
    private int ptr; // Pointer to keep track of the current position in the stream

    /**
     * Constructs an OrderedStream object with the specified size.
     *
     * @param n The maximum size of the stream.
     */
    public OrderedStream(int n) {
        stream = new String[n + 1];
        ptr = 0;
    }

    /**
     * Inserts a new data entry with the given ID key and value into the stream.
     *
     * @param idKey The ID key of the data entry.
     * @param value The value to be inserted into the stream.
     * @return A list containing consecutive data entries from the current pointer position.
     */
    public List<String> insert(int idKey, String value) {
        stream[idKey - 1] = value;
        List<String> tempList = new ArrayList<>();

        // Move the pointer to the next empty slot (or the end of the stream)
        while (ptr < stream.length && stream[ptr] != null) {
            tempList.add(stream[ptr]);
            ptr++;
        }

        return tempList;
    }
}
