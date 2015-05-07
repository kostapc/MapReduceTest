package net.c0f3.SimpleMapReduce.samples.WordCounter;

import net.c0f3.SimpleMapReduce.MRObject;

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
