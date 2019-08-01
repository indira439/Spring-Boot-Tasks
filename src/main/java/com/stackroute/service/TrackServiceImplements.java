package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**@Service indicates annotated class is a service which hold business logic in the Service layer */
@Service
public class TrackServiceImplements implements TrackService {

    private TrackRepository trackRepository;

    /**Constructor based Dependency injection to inject TrackRepository here*/
    @Autowired
    public TrackServiceImplements(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    /**Implementation of saveTrack method*/
    @Override
    public Track saveTrack(Track track) {
        Track saveTrack = trackRepository.save(track);
        return saveTrack;
    }
}
