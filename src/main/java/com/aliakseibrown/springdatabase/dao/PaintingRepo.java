package com.aliakseibrown.springdatabase.dao;

import com.aliakseibrown.springdatabase.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaintingRepo extends JpaRepository<Painting, Integer> { // JpaRepository extends CrudRepository

    List<Painting> findByYear(int year);
    List<Painting> findByYearGreaterThan(int year);

    @Query("from Painting where year>?1 order by year")
    List<Painting> findByYearGreaterThanSorted(int year);
}
