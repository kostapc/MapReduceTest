package org.c0f3.MapReduceTest.samples.WordCounter;

import org.c0f3.MapReduceTest.MRObject;

/**
 * KostaPC on 3/10/2015.
 */
public class WordCounterObject implements MRObject<Integer> {

    private Integer count;

    public WordCounterObject(Integer count) {
        this.count = count;
    }

    @Override
    public void setValue(Integer value) {
        count = value;
    }

    @Override
    public Integer getValue() {
        return count;
    }

    public void add(Integer i) {
        count += i;
    }
}
