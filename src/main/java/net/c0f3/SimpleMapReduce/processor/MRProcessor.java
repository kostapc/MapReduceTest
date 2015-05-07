package net.c0f3.SimpleMapReduce.processor;

import net.c0f3.SimpleMapReduce.Mapper;
import net.c0f3.SimpleMapReduce.Reducer;
import net.c0f3.SimpleMapReduce.MRKey;
import net.c0f3.SimpleMapReduce.MRObject;

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
