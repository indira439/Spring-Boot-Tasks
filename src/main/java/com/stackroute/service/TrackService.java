package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    /**
     * AbstractMethod to save a track
     */
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    /**
     * AbstractMethod to get a track by Id
     */
    public Track getTrackById(int id) throws TrackNotFoundException;

    /**
     * AbstractMethod to get all tracks
     */
    public List<Track> getAllTracks() throws HttpServerErrorException.InternalServerError;

    /**
     * AbstractMethod to delete track by Id
     * @return
     */
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException;

    /**
     * AbstractMethod to delete all tracks
     */
    public boolean deleteAllTracks() throws HttpServerErrorException.InternalServerError;

    /**
     * AbstractMethod to update comments of a track by its id
     */
    public Track updateTrackById(int id, Track track) throws TrackNotFoundException;

    /**
     * AbstractMethod to get track by Name
     */
    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException;

}
