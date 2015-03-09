package org.c0f3.MapReduceTest.samples.WordCounter;

import org.c0f3.MapReduceTest.MRKey;
import org.c0f3.MapReduceTest.MRObject;
import org.c0f3.MapReduceTest.Reducer;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

/**
 * Created by KostaPC on 3/10/2015.
 */
public class WordCounterReducer implements Reducer {

    @Override
    public Object reduce(Map.Entry<MRKey, List<MRObject>> result) {
        int totalCount = 0;
        for(MRObject object: result.getValue()) {
            Integer count = (Integer) object.getValue();
            totalCount += count;
        }
        if(totalCount<=1) {
            return null;
        }
        return new AbstractMap.SimpleEntry<>(result.getKey().toString(),totalCount);
    }
}
