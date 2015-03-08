package org.c0f3.MapReduceTest.processor;

import org.c0f3.MapReduceTest.MRKey;
import org.c0f3.MapReduceTest.MRObject;
import org.c0f3.MapReduceTest.Mapper;
import org.c0f3.MapReduceTest.Reducer;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by KostaPC on 3/8/2015.
 */
public class MRProcessor {

    public Object mapReduce(Object[] sourceData, Mapper mapper, Reducer reducer) {
        MRThreads threads = new MRThreads();
        Map<MRKey,List<MRObject>> mapResults = threads.map(sourceData, mapper);
        Collection calculationResult = threads.reduce(mapResults, reducer);
        return null;
    }

    private Map<MRKey,List<MRObject>> combine() {
        return null;
    }
}
