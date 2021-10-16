package cinema.shows.rest;

import cinema.shows.dtos.MovieDTO;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class MovieRESTAPIImp {

    private final String BASE_PATH = "/api/movies";
    private final HttpHeaders headers = new HttpHeaders();

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    private String makeUrl(String path){
        String pathBuilded = "http://localhost:"+port+path;
        System.out.println(pathBuilded);
        return pathBuilded;
    }

    @Test
    @Sql("/createMovie.sql")
    void getMovie(){
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<MovieDTO> response = restTemplate.exchange(makeUrl(BASE_PATH+"/1"), HttpMethod.GET,
                entity,
                MovieDTO.class
        );
        assertEquals("Godfather",response.getBody().getTitle());
    }
//    void getCustomer() {
//        HttpEntity<String> entity = new HttpEntity<>(null,headers);
//        ResponseEntity<CustomerDTO> response = restTemplate.exchange(makeUrl(BASE_PATH+"/100"),
//                HttpMethod.GET,
//                entity,
//                CustomerDTO.class
//        );
//
//        assertEquals("aaa",response.getBody().getFirstName());
//    }
}
