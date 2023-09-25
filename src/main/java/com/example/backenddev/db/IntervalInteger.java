package com.example.backenddev.db;

import jakarta.persistence.*;

@Entity
@Table(name="intervalinteger")
public class IntervalInteger implements Interval<Long> {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long Id;

    @Column(name = "START", nullable = false)
    private Long start;

    @Column(name = "ENDVALUE", nullable = false)
    private Long end;

    public IntervalInteger(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public IntervalInteger() {

    }

    @Override
    public Long getStart() {
        return start;
    }

    @Override
    public void setStart(Long start) {
        this.start = start;
    }

    @Override
    public Long getEnd() {
        return end;
    }

    @Override
    public void setEnd(Long end) {
        this.end = end;
    }
    @Override
    public String toString() {
        return "[" + start + "," + end + ']';
    }

}
