package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Repository marks the specific class as a Data Access Object
 */
@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    /**
     * Using @Query parameter to fetch data from database
     */
    @Query(value = "SELECT t FROM Track t WHERE t.trackName like ?1")
    public List<Track> findByName(String trackName);
}
