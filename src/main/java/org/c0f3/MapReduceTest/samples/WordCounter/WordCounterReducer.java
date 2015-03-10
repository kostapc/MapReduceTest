package org.c0f3.MapReduceTest.samples.WordCounter;

import org.c0f3.MapReduceTest.MRKey;
import org.c0f3.MapReduceTest.MRObject;
import org.c0f3.MapReduceTest.Reducer;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

/**
 * KostaPC on 3/10/2015.
 */
public class WordCounterReducer implements Reducer<Integer> {

    @Override
    public Object reduce(Map.Entry<MRKey, List<MRObject<Integer>>> result) {
        int totalCount = 0;
        for(MRObject<Integer> object: result.getValue()) {
            Integer count = object.getValue();
            totalCount += count;
        }
        return new AbstractMap.SimpleEntry<>(result.getKey().toString(),totalCount);
    }
}
