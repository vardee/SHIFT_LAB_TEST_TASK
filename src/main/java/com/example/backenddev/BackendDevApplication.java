package com.example.backenddev;

import com.example.backenddev.db.Interval;
import com.example.backenddev.db.IntervalInteger;
import com.example.backenddev.db.IntervalsLetters;
import com.example.backenddev.db.repository.IntegerIntervalsRepository;
import com.example.backenddev.db.repository.LettersIntervalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "", produces = "application/json")
public class BackendDevApplication {

    @Autowired
    private LettersIntervalsRepository lettersIntervalsRepository;
    @Autowired
    private IntegerIntervalsRepository integerIntervalsRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendDevApplication.class, args);
    }

    @RequestMapping("create-integer")
    public IntervalInteger createIDforInterger(){
        return integerIntervalsRepository.save(new IntervalInteger());
    }
    @RequestMapping("create-letters")
    public IntervalsLetters createIDforLetters(){
        return lettersIntervalsRepository.save(new IntervalsLetters());
    }

}
