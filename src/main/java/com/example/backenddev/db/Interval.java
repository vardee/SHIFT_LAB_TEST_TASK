package com.example.backenddev.db;

public interface Interval<T extends Comparable<T>> {
    T getStart();
    void setStart(T start);
    T getEnd();
    void setEnd(T end);
}