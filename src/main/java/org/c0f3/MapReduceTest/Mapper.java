package org.c0f3.MapReduceTest;

import java.util.Map;

/**
 * Created by KostaPC on 3/8/2015.
 */
public interface Mapper {
    public Map<Long,Object> map(Object sourceData);
}
