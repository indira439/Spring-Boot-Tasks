package com.stackroute.service;

import com.stackroute.domain.Track;

public interface TrackService {

    /**AbstractMethod to save a track*/
    public Track saveTrack(Track track);

    /**AbstractMethod to get a track by Id*/
    public Track getTrackById(int id);

}
