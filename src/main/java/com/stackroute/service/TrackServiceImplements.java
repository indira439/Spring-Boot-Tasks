package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class TrackServiceImplements implements TrackService {

    private TrackRepository trackRepository;

    /**
     * Constructor based Dependency injection to inject TrackRepository here
     */
    @Autowired
    public TrackServiceImplements(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    /**
     * Implementation of saveTrack method
     */
    @Override
    public Track saveTrack(Track track) {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    /**
     * Implementation of getTrackById method
     */
    @Override
    public Track getTrackById(int id) {
        Track retrieveTrackById = trackRepository.findById(id).get();
        return retrieveTrackById;
    }

    /**
     * Implementation of getAllTracks method
     */
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    /**
     * Implementation of deleteTrackById method
     */
    @Override
    public void deleteTrackById(int id) {
        trackRepository.deleteById(id);
    }

    /**
     * Implementation of deleteAllTracks method
     */
    @Override
    public void deleteAllTracks() {
        trackRepository.deleteAll();
    }


    /**
     * Implementation of updateTrack method
     */
    @Override
    public Track updateTrackById(int id, Track track) {
        Track getTrack = trackRepository.findById(id).get();
        getTrack.setComments(track.getComments());
        return trackRepository.save(getTrack);
    }

    /**
     * Implementation of getTrackByName method
     */
    @Override
    public List<Track> getTrackByName(String trackName) {
        return trackRepository.findByName(trackName);
    }


}
