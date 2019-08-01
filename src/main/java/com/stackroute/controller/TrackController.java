package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
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
        Track savedTrack = trackService.saveTrack(track);
        return new ResponseEntity<>(savedTrack, HttpStatus.ACCEPTED);
    }

    /**
     * GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) {
        Track retrieveTrackById = trackService.getTrackById(id);
        return new ResponseEntity<>(retrieveTrackById, HttpStatus.FOUND);
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        List<Track> retrieveTracks = trackService.getAllTracks();
        return new ResponseEntity<>(retrieveTracks, HttpStatus.FOUND);
    }

    /**
     * DeleteMapping Annotation for mapping HTTP Delete requests onto specific handler methods.
     */
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) {
        trackService.deleteTrackById(id);
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.FOUND);
    }


}
