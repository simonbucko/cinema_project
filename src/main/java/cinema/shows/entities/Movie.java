package cinema.shows.entities;

import cinema.shows.dtos.InputMovieDTO;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@ToString
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "Title", nullable = false, length = 45)
    private String title;

    @Column(name = "Rating", nullable = false)
    private double rating;

    @Column(name = "Min_Age", nullable = false)
    private short minAge;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "Category_id", nullable = false)
    private int categoryId;

    @OneToOne(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MoviePlaying moviePlaying;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "movie_actors",
            joinColumns = {
                    @JoinColumn(name = "Movies_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "Actors_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Actor> actorSet = new HashSet<>();

    public Movie(String title, double rating, short minAge, String description, int categoryId) {
        this.title = title;
        this.rating = rating;
        this.minAge = minAge;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Movie(String title, double rating, short minAge, String description, int categoryId, HashSet actorSet) {
        this.title = title;
        this.rating = rating;
        this.minAge = minAge;
        this.description = description;
        this.categoryId = categoryId;
        this.actorSet=actorSet;
    }

    public Movie(InputMovieDTO inputMovieDTO) {
        this.title = inputMovieDTO.getTitle();
        this.rating = inputMovieDTO.getRating();
        this.minAge = inputMovieDTO.getMinAge();
        this.description = inputMovieDTO.getDescription();
        this.categoryId = inputMovieDTO.getCategoryId();
        if (inputMovieDTO.getActorList() != null || inputMovieDTO.getActorList().size() != 0) {
            this.actorSet = new HashSet(inputMovieDTO.getActorList());
        } else {
            this.actorSet = new HashSet<>();
        }
    }

    public Movie(int id, String title, double rating, short minAge, String description, int categoryId) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.minAge = minAge;
        this.description = description;
        this.categoryId = categoryId;
        this.actorSet = new HashSet<>();
    }

    public void addActor(Actor actor) {
        actorSet.add(actor);
        actor.getMovieSet().add(this);
    }

}
