package org.c0f3.MapReduceTest.processor;

import org.c0f3.MapReduceTest.MRKey;
import org.c0f3.MapReduceTest.MRObject;
import org.c0f3.MapReduceTest.Mapper;
import org.c0f3.MapReduceTest.Reducer;

import java.util.*;

/**
 * KostaPC on 3/8/2015.
 */
public class MRProcessor {
    private int threadsCount;

    public MRProcessor(int threadsCount) {
        this.threadsCount = threadsCount;
    }

    public Collection mapReduce(Object[] sourceData, Mapper mapper, Reducer reducer) {
        MRThreads threads = new MRThreads(threadsCount);
        Map<MRKey,List<MRObject>> mapResults = threads.map(sourceData, mapper);
        Collection calculationResult = threads.reduce(mapResults, reducer);
        return calculationResult;
    }

}
