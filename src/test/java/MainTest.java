
import org.c0f3.MapReduceTest.processor.MRProcessor;
import org.c0f3.MapReduceTest.samples.WordCounter.WordCounterMapper;
import org.c0f3.MapReduceTest.samples.WordCounter.WordCounterReducer;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;

/**
 * KostaPC on 2/24/2015.
 */
public class MainTest {

    @Test
    public void test() {
        MRProcessor mrProcessor = new MRProcessor();
        String[] sourceUrls = new String[] {
            "http://wastejunk.com/2014/07/publication_1/",
            "http://wastejunk.com/2014/07/useless_toolbox/",
            "http://wastejunk.com/2014/02/wind_of_chaos/",
            "http://wastejunk.com/2014/02/know_your_blackbox/"
        };
        Collection resultCollection = mrProcessor.mapReduce(sourceUrls, new WordCounterMapper(), new WordCounterReducer());
        for(Object entryObject: resultCollection) {
            Map.Entry<String,Integer> entry = (Map.Entry<String, Integer>) entryObject;
            System.out.println(entry.getKey()+" >> "+entry.getValue());
        }
    }
}
