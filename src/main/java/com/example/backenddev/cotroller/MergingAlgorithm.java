package com.example.backenddev.cotroller;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Entity
public class MergingAlgorithm<T extends Comparable<T>, I extends com.example.backenddev.db.Interval<T>> {

    @Autowired
    private EntityManager entityManager;

    public List<I> mergeIntervals(List<I> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return Collections.emptyList();
        }

        List<I> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            I currentInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            I nextInterval = intervals.get(i);

            Comparable<T> currentEnd = currentInterval.getEnd();
            Comparable<T> nextStart = nextInterval.getStart();

            if (currentEnd != null && nextStart != null && currentEnd.compareTo((T) nextStart) >= 0) {
                Comparable<T> newEnd = max((T) currentEnd, nextInterval.getEnd());
                currentInterval.setEnd((T) newEnd);
            } else {
                mergedIntervals.add(nextInterval);
            }
        }

        return mergedIntervals;
    }

    public <R extends com.example.backenddev.db.Interval<T>> R findMinimumIntervalFromSQL(Class<R> intervalClass) {
        String sql = "SELECT start, endValue FROM " + intervalClass.getSimpleName() + " ORDER BY start, endValue LIMIT 1";
        Query query = entityManager.createNativeQuery(sql);

        Object[] result = (Object[]) query.getSingleResult();
        T minStart = (T) result[0];
        T minEnd = (T) result[1];

        try {
            R minimumInterval = intervalClass.getDeclaredConstructor().newInstance();
            minimumInterval.setStart(minStart);
            minimumInterval.setEnd(minEnd);
            return minimumInterval;
        } catch (Exception e) {
            return null;
        }
    }

    private T max(T a, T b) {
        return a != null && (b == null || a.compareTo(b) >= 0) ? a : b;
    }
}
