package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**@Repository marks the specific class as a Data Access Object*/
@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
}
