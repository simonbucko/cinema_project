package cinema.shows.rest;

import cinema.shows.dtos.MovieDTO;
import cinema.shows.entities.Category;
import cinema.shows.entities.Movie;
import cinema.shows.repos.CategoryRepo;
import cinema.shows.repos.MovieRepo;
import cinema.shows.testUtils.TestDataMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
//@AutoConfigureTestDatabase
@EnableAutoConfiguration
@SpringBootTest(classes = cinema.shows.CinemaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieRESTAPIImp {

    private final String BASE_PATH = "/api/movies";
    private final HttpHeaders headers = new HttpHeaders();
    private Category category;
    Movie movie;

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    MovieRepo movieRepo;

    @Autowired
    CategoryRepo categoryRepo;

    private String makeUrl(String path){
        String pathBuilded = "http://localhost:"+port+path;
        System.out.println(pathBuilded);
        return pathBuilded;
    }

    @BeforeEach
    public void setupDatabase(){
        category = TestDataMaker.createCategory(categoryRepo);
        movie = TestDataMaker.createMovie(movieRepo);
    }

    @Test
    void getMovie(){
        System.out.println(movie);
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<Movie> response = restTemplate.exchange(makeUrl(BASE_PATH+"/"+movie.getId()), HttpMethod.GET,
                entity,
                Movie.class
        );
        System.out.println(response.getBody());
        assertEquals("Godfather",response.getBody().getTitle());
    }


}
