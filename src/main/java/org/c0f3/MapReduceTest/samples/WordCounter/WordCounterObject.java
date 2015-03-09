package org.c0f3.MapReduceTest.samples.WordCounter;

import org.c0f3.MapReduceTest.MRObject;

/**
 * Created by KostaPC on 3/10/2015.
 */
public class WordCounterObject implements MRObject {

    private Integer count;

    public WordCounterObject(Integer count) {
        this.count = count;
    }

    @Override
    public void setValue(Object value) {
        if(value instanceof Number) {
            count = ((Number) value).intValue();
        }
    }

    @Override
    public Object getValue() {
        return count;
    }

    public void add(Integer i) {
        count += i;
    }
}
