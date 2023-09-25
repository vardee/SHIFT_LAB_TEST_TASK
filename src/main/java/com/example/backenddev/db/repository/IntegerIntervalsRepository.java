package com.example.backenddev.db.repository;
import com.example.backenddev.db.IntervalInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegerIntervalsRepository extends JpaRepository<IntervalInteger, Long> {

}
