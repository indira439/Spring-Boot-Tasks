package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public TrackService trackService;

    /**
     * Constructor based Dependency injection to inject TrackService into controller
     */
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    /**
     * PostMapping Annotation for mapping HTTP POST requests onto specific handler methods.
     */
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;

        try {
            Track savedTrack = trackService.saveTrack(track);
            responseEntity = new ResponseEntity<>(savedTrack, HttpStatus.CREATED);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    /**
     * GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            Track retrieveTrackById = trackService.getTrackById(id);
            responseEntity = new ResponseEntity<>(retrieveTrackById, HttpStatus.FOUND);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity;

        try {
            List<Track> retrieveTracks = trackService.getAllTracks();
            responseEntity = new ResponseEntity<>(retrieveTracks, HttpStatus.FOUND);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    /**
     * DeleteMapping Annotation for mapping HTTP Delete requests onto specific handler methods.
     */
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            trackService.deleteTrackById(id);
            responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("track")
    public ResponseEntity<?> deleteAllTracks() {
        ResponseEntity responseEntity;

        try {
            trackService.deleteAllTracks();
            return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    /**
     * PutMapping Annotation for mapping HTTP PuT requests onto specific handler methods.
     */
    @PutMapping("track/{id}")
    public ResponseEntity<?> UpdateTrackById(@PathVariable int id, @RequestBody Track track) {
        ResponseEntity responseEntity;

        try {
            Track updatedTrack = trackService.updateTrackById(id, track);
            return new ResponseEntity<>(updatedTrack, HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_MODIFIED);
        }
        return responseEntity;
    }


}
