package net.c0f3.SimpleMapReduce.test;

import net.c0f3.SimpleMapReduce.processor.MRProcessor;
import net.c0f3.SimpleMapReduce.samples.WordCounter.WordCounterMapper;
import net.c0f3.SimpleMapReduce.samples.WordCounter.WordCounterReducer;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;

/**
 * KostaPC on 2/24/2015.
 */
public class MainTest {

    @Test
    public void test() {
        MRProcessor mrProcessor = new MRProcessor(4); // num of threads in thread pool
        String[] sourceUrls = new String[] {
            "http://wastejunk.com/2014/07/publication_1/",
            "http://wastejunk.com/2014/07/useless_toolbox/",
            "http://wastejunk.com/2014/02/wind_of_chaos/",
            "http://wastejunk.com/2014/02/know_your_blackbox/"
        };
        long time = System.currentTimeMillis();
        Collection resultCollection = mrProcessor.mapReduce(sourceUrls, new WordCounterMapper(), new WordCounterReducer());
        time = System.currentTimeMillis() - time;
        System.out.println("\n\n=========\n execution time: "+time+"\n=========\n");
        for(Object entryObject: resultCollection) {
            Map.Entry<String,Integer> entry = (Map.Entry<String, Integer>) entryObject;
            System.out.println(entry.getKey()+" >> "+entry.getValue());
        }
    }
}
