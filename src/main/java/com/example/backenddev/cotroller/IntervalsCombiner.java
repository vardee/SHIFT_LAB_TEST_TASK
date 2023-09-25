package com.example.backenddev.cotroller;

import com.example.backenddev.db.Interval;
import com.example.backenddev.db.IntervalInteger;
import com.example.backenddev.db.IntervalsLetters;
import com.example.backenddev.db.repository.IntegerIntervalsRepository;
import com.example.backenddev.db.repository.LettersIntervalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/intervals")
public class IntervalsCombiner {

    @Autowired
    private MergingAlgorithm<Long, IntervalInteger> mergingAlgorithmInteger; // Экземпляр для IntervalInteger

    @Autowired
    private MergingAlgorithm<String, IntervalsLetters> mergingAlgorithmLetters; // Экземпляр для IntervalsLetters

    @Autowired
    private IntegerIntervalsRepository integerIntervalsRepository;

    @Autowired
    private LettersIntervalsRepository lettersIntervalsRepository;

    @PostMapping("/merge")
    public ResponseEntity<String> mergeIntervals(@RequestParam("kind") String kind, @RequestBody List<List<Object>> intervals) {
        if ("digits".equals(kind)) {
            List<IntervalInteger> intervalObjects = new ArrayList<>();
            for (List<Object> interval : intervals) {
                if (interval.size() == 2 && interval.get(0) instanceof Integer && interval.get(1) instanceof Integer) {
                    Integer start = (Integer) interval.get(0);
                    Integer end = (Integer) interval.get(1);
                    intervalObjects.add(new IntervalInteger(start.longValue(), end.longValue())); // Преобразуем в Long
                }
            }
            List<IntervalInteger> mergedIntegerIntervals = mergingAlgorithmInteger.mergeIntervals(intervalObjects);
            integerIntervalsRepository.saveAll(mergedIntegerIntervals);
            return ResponseEntity.ok(mergedIntegerIntervals.toString());
        } else if ("letters".equals(kind)) {
            List<IntervalsLetters> intervalLetObjects = new ArrayList<>();
            for (List<Object> interval : intervals) {
                if (interval.size() == 2 && interval.get(0) instanceof String && interval.get(1) instanceof String) {
                    String start = String.valueOf(interval.get(0));
                    String end = String.valueOf(interval.get(1));
                    intervalLetObjects.add(new IntervalsLetters(start, end));
                }
            }
            List<IntervalsLetters> mergedIntervals = mergingAlgorithmLetters.mergeIntervals(intervalLetObjects);
            lettersIntervalsRepository.saveAll(mergedIntervals);
            return ResponseEntity.ok(mergedIntervals.toString());
        } else {
            return ResponseEntity.badRequest().body("Неподдерживаемый вид данных.");
        }
    }


    @GetMapping("/min")
    public ResponseEntity<String> getMinimumInterval(@RequestParam("kind") String kind) {
        if ("digits".equals(kind)) {
            Interval minimumInterval = mergingAlgorithmInteger.findMinimumIntervalFromSQL(IntervalInteger.class);
            return ResponseEntity.ok(minimumInterval.toString());
        } else if ("letters".equals(kind)) {
            Interval minimumInterval = mergingAlgorithmLetters.findMinimumIntervalFromSQL(IntervalsLetters.class);
            return ResponseEntity.ok(minimumInterval.toString());
        } else {
            return ResponseEntity.badRequest().body("Неподдерживаемый вид данных.");
        }
    }
}
