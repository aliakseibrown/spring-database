package com.aliakseibrown.springdatabase.dao;

import com.aliakseibrown.springdatabase.model.Painting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaintingRepo extends CrudRepository<Painting, Integer> {
    List<Painting> findByYear(int year);
    List<Painting> findByYearGreaterThan(int year);


}
