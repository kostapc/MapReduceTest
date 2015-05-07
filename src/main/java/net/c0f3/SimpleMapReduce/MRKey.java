package net.c0f3.SimpleMapReduce;

/**
 * KostaPC on 3/8/2015.
 */
public interface MRKey {

    @Override
    public boolean equals(Object a);

    @Override
    public int hashCode();

}