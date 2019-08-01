package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**RestController annotation is used to create Restful web services using Spring MVC. */
@RestController
/**RequestMapping annotation maps HTTP requests to handler methods*/
@RequestMapping(value = "api/v1")
public class TrackController {

    public TrackService trackService;

    /**Constructor based Dependency injection to inject TrackService into controller*/
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    /**PostMapping Annotation for mapping HTTP POST requests onto specific handler methods. */
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        Track savedTrack = trackService.saveTrack(track);
        return new ResponseEntity<>(savedTrack, HttpStatus.ACCEPTED);
    }

    /**GetMapping Annotation for mapping HTTP GET requests onto specific handler methods. */
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) {
        Track retrieveTrackById = trackService.getTrackById(id);
        return new ResponseEntity<>(retrieveTrackById, HttpStatus.FOUND);
    }



}
