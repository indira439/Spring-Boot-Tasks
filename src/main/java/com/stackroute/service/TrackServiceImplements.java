package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
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
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        /**Throw TrackAlreadyExistsException if track already exists*/
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track savedTrack = trackRepository.save(track);
        if (savedTrack == null) {
            throw new TrackAlreadyExistsException("Track is empty");
        }
        return savedTrack;
    }

    /**
     * Implementation of getTrackById method
     */
    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        /**Throw TrackNotFoundException if track is not found*/
        if (trackRepository.existsById(id)) {
            Track retrieveTrackById = trackRepository.findById(id).get();
            return retrieveTrackById;
        } else {
            throw new TrackNotFoundException("Track not found");
        }
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
