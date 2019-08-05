package com.stackroute.seedData;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
/**Command Line Runner is used to execute the code after the Spring Boot application started*/
public class CommandLineStartUpRunner implements CommandLineRunner {
    private TrackService trackService;

    /**
     * Use constructor based DI to inject TrackRepository here
     */

    /**
     * @Qualifier annotation is used to resolve the auto wiring conflict, when there are multiple beans of same type
     */
    @Autowired
    private CommandLineStartUpRunner(TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public void run(String... args) throws Exception {
        /**Pre-fill the database whenever application starts*/
        Track track10 = new Track(10, "track10", "comment10");
        Track track11 = new Track(11, "track11", "comment11");
        trackService.saveTrack(track10);
        trackService.saveTrack(track11);
    }
}
