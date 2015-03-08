package org.c0f3.MapReduceTest;

import java.util.List;
import java.util.Map;

/**
 * Created by KostaPC on 3/8/2015.
 */
public interface Reducer {
    public Object reduce(Map.Entry<MRKey,List<MRObject>> result);
}
