package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

/**
 * RestController annotation is used to create Restful web services using Spring MVC
 */
@RestController

/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RequestMapping(value = "api/v1")
public class TrackController {

    @Autowired
    private TrackService trackService;

    /**
     * Constructor based Dependency injection to inject TrackService into controller
     */

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    /**
     * PostMapping Annotation for mapping HTTP POST requests onto specific handler methods.
     */
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException, HttpServerErrorException.InternalServerError {

        Track savedTrack = trackService.saveTrack(track);
        return new ResponseEntity<>(savedTrack, HttpStatus.CREATED);
    }


    /**
     * GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFoundException, HttpServerErrorException.InternalServerError {

        Track retrieveTrackById = trackService.getTrackById(id);
        return new ResponseEntity<>(retrieveTrackById, HttpStatus.FOUND);
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() throws HttpServerErrorException.InternalServerError {

        List<Track> retrieveTracks = trackService.getAllTracks();
        return new ResponseEntity<>(retrieveTracks, HttpStatus.FOUND);
    }

    /**
     * DeleteMapping Annotation for mapping HTTP Delete requests onto specific handler methods.
     */
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) throws HttpServerErrorException.InternalServerError, TrackNotFoundException {

        trackService.deleteTrackById(id);
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    }

    @DeleteMapping("tracks")
    public ResponseEntity<?> deleteAllTracks() throws HttpServerErrorException.InternalServerError {

        trackService.deleteAllTracks();
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    }

    /**
     * PutMapping Annotation for mapping HTTP PuT requests onto specific handler methods.
     */
    @PutMapping("track/{id}")
    public ResponseEntity<?> UpdateTrackById(@PathVariable int id, @RequestBody Track track) throws TrackNotFoundException, HttpServerErrorException.InternalServerError {

        Track updatedTrack = trackService.updateTrackById(id, track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }

    @GetMapping("tracks/{trackName}")
    public ResponseEntity<?> getTrackByName(@PathVariable String trackName) throws TrackNotFoundException, HttpServerErrorException.InternalServerError {

        List<Track> retrieveTrackByNAme = trackService.getTrackByName(trackName);
        return new ResponseEntity<>(retrieveTrackByNAme, HttpStatus.FOUND);
    }


}
