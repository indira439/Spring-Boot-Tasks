package com.stackroute.seedData;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
/**Command Line Runner is used to execute the code after the Spring Boot application started*/
public class CommandLineStartUpRunner implements CommandLineRunner {
    private TrackRepository trackRepository;

    /**Use constructor based DI to inject TrackRepository here*/
    @Autowired
    private CommandLineStartUpRunner(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /**Pre-fill the database whenever application starts*/
        Track track10 = new Track(10,"track10","comment11");
        Track track11 = new Track(11,"track10","comment11");
        trackRepository.save(track10);
        trackRepository.save(track11);
    }
}
