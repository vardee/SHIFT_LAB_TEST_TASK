package com.example.backenddev.db.repository;
import com.example.backenddev.db.IntervalInteger;
import com.example.backenddev.db.IntervalsLetters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntegerIntervalsRepository extends JpaRepository<IntervalInteger, Long> {

}
