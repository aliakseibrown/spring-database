package com.aliakseibrown.springdatabase.dao;

import com.aliakseibrown.springdatabase.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepo extends JpaRepository<Artist, String> {
}
