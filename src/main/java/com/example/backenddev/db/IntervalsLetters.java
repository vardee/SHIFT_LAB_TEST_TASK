package com.example.backenddev.db;
import jakarta.persistence.*;
@Entity
@Table(name="intervalsletters")
public class IntervalsLetters implements Interval<String> {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long Id;
    @Column(name = "START", nullable = false)
    private String start;
    @Column(name = "ENDVALUE", nullable = false)
    private String end;
    public IntervalsLetters(String start, String end) {
        this.start = start;
        this.end = end;
    }
    public IntervalsLetters() {

    }
    @Override
    public String getStart() {
        return start;
    }

    @Override
    public void setStart(String start) {
        this.start = start;
    }

    @Override
    public String getEnd() {
        return end;
    }

    @Override
    public void setEnd(String end) {
        this.end = end;
    }
    @Override
    public String toString() {
        return"[" + start + "," + end + ']';
    }
}
