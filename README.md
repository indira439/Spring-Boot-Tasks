## Muzix Application designed using Spring Boot

This Application allows all the users to perform the
following activities:

a. Save track information such as trackId,
trackName, comments of the track.
b. Display saved track.
c. Update comments of saved track.
d. Remove track.

## Project Structure


            src
            ├───main
            │   ├───java
            │   │   └───com
            │   │       └───stackroute
            │   │           │   TrackServiceApplication.java
            │   │           ├───controller
            │   │           │       TrackController.java
            │   │           ├───domain
            │   │           │       Track.java
            │   │           ├───repository
            │   │           │       TrackRepository.java
            │   │           └───service
            │   │                   TrackService.java
            │   │                   TrackServiceImplements.java
            │   └───resources
            │       │   application.properties
            │ 
            └───test
                └───java

            --pom.xml

