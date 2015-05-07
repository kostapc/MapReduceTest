package net.c0f3.SimpleMapReduce;

/**
 * KostaPC on 3/8/2015.
 */
public interface MRObject<T> {

    public void setValue(T value);
    public T getValue();

}
