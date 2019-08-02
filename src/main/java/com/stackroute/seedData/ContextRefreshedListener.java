package com.stackroute.seedData;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
/**Context Refreshed Listener is used to execute the code after the Spring Boot application started*/
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    private TrackRepository trackRepository;

    /**
     * Use constructor based DI to inject TrackRepository here
     */
    @Autowired
    private ContextRefreshedListener(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        /**Pre-fill the database whenever application starts*/
        Track track1 = new Track(1, "track1", "comment1");
        Track track2 = new Track(2, "track2", "comment2");
        Track track3 = new Track(3, "track3", "comment3");
        Track track4 = new Track(4, "track4", "comment4");
        trackRepository.save(track1);
        trackRepository.save(track2);
        trackRepository.save(track3);
        trackRepository.save(track4);
    }
}
