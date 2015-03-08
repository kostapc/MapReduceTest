package org.c0f3.MapReduceTest.processor;

import org.c0f3.MapReduceTest.MRKey;
import org.c0f3.MapReduceTest.MRObject;
import org.c0f3.MapReduceTest.Mapper;
import org.c0f3.MapReduceTest.Reducer;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by KostaPC on 3/8/2015.
 */
public class MRThreads {

    ExecutorService executor;

    public MRThreads() {
        executor = Executors.newFixedThreadPool(4);
    }

    public Collection reduce(Map<MRKey, List<MRObject>> mapResults, Reducer reducer) {
        List<Callable<Object>> tasks = new LinkedList<>();
        for(Map.Entry<MRKey, List<MRObject>> mapResult: mapResults.entrySet()) {
            tasks.add(() -> reducer.reduce(mapResult));
        }
        List<Future<Object>> allResults;
        try {
            allResults = executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        List reduceResults = new LinkedList<>();
        for(Future<Object> future : allResults) {
            try {
                reduceResults.add(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                continue;
            } catch (ExecutionException e) {
                e.printStackTrace();
                continue;
            }
        }
        return null;
    }

    public Map<MRKey,List<MRObject>> map(Object[] sources, Mapper mapper) {
        List<Callable<Map<MRKey, MRObject>>> tasks = new LinkedList<>();
        for(Object source: sources) {
            tasks.add(() -> mapper.map(source));
        }
        List<Future<Map<MRKey, MRObject>>> allResults;
        try {
            allResults = executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        Map<MRKey, List<MRObject>> groupResults = new HashMap<>();
        for(Future<Map<MRKey, MRObject>> future : allResults) {
            Map<MRKey, MRObject> result;
            try {
                result = future.get(); // waiting for task is end;
            } catch (InterruptedException e) {
                e.printStackTrace();
                continue;
            } catch (ExecutionException e) {
                e.printStackTrace();
                continue;
            }
            processGrouping(result, groupResults);
        }
        return groupResults;
    }

    private void processGrouping(Map<MRKey, MRObject> mapResult, Map<MRKey, List<MRObject>> groupResults) {
        for(Map.Entry<MRKey, MRObject> pair : mapResult.entrySet()) {
            List<MRObject> objects = groupResults.get(pair.getKey());
            if(objects==null) {
                objects = new LinkedList<>();
                groupResults.put(pair.getKey(), objects);
            }
            objects.add(pair.getValue());
        }
    }



}
