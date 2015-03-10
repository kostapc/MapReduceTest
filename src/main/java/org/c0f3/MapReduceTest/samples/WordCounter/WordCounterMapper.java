package org.c0f3.MapReduceTest.samples.WordCounter;

import org.c0f3.MapReduceTest.MRKey;
import org.c0f3.MapReduceTest.MRObject;
import org.c0f3.MapReduceTest.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * KostaPC on 3/10/2015.
 */
public class WordCounterMapper implements Mapper {

    @Override
    public Map<MRKey, MRObject<Integer>> map(Object sourceData) {
        if(!(sourceData instanceof String)) {
            return null;
        }
        String page;
        try {
            page = getUrlSource(sourceData.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        page = clearHtml(page);
        page = page.replace("\n","");
        String[] words = page.split(" ");
        Map<MRKey, MRObject<Integer>> mapResult = new HashMap<>();
        for (String word: words) {
            WordCounterKey key = new WordCounterKey(word.trim());
            MRObject<Integer> object = mapResult.get(key);
            if(object == null) {
                object = new WordCounterObject(0);
                mapResult.put(key,object);
            }
            object.setValue(1 + object.getValue());
        }
        return mapResult;
    }

    private String getUrlSource(String url) throws IOException {
        URL pageUrl = new URL(url);
        URLConnection pageConnection = pageUrl.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(pageConnection.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();
        return a.toString();
    }

    private String clearHtml(String source) {
        return source
                .replaceAll("<style.+?>.+?</style>|<script.+?>.+?</script>|<(?:!|/?[a-zA-Z]+).*?/?>", "");
    }
}
