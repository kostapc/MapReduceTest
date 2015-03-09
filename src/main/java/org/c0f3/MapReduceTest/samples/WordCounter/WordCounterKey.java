package org.c0f3.MapReduceTest.samples.WordCounter;

import org.c0f3.MapReduceTest.MRKey;

/**
 * KostaPC on 3/10/2015.
 */

public class WordCounterKey implements MRKey {

    String keyValue;

    public WordCounterKey(String inKeyValue) {
        keyValue = inKeyValue;
    }

    @Override
    public String toString() {
        return keyValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordCounterKey that = (WordCounterKey) o;

        if (keyValue != null ? !keyValue.equals(that.keyValue) : that.keyValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return keyValue != null ? keyValue.hashCode() : 0;
    }
}
