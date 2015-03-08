package org.c0f3.MapReduceTest;

import java.util.Map;

/**
 * Created by KostaPC on 3/8/2015.
 */
public abstract class Mapper implements Runnable{

    public abstract Map<MRKey,MRObject> map(Object sourceData);

    @Override
    public void run() {

    }
}
