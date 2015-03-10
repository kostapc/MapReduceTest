package org.c0f3.MapReduceTest;

import java.util.Map;

/**
 * KostaPC on 3/8/2015.
 */
public interface Mapper<T> {

    public abstract Map<MRKey,MRObject<T>> map(Object sourceData);

}
