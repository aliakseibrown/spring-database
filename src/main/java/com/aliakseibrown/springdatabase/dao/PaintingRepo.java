package com.aliakseibrown.springdatabase.dao;

import com.aliakseibrown.springdatabase.model.Painting;
import org.springframework.data.repository.CrudRepository;

public interface PaintingRepo extends CrudRepository<Painting, Integer> {

}
