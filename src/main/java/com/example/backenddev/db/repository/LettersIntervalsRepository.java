package com.example.backenddev.db.repository;
import com.example.backenddev.db.IntervalsLetters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LettersIntervalsRepository extends JpaRepository<IntervalsLetters, Long> {

}