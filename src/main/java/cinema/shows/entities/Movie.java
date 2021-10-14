package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
@Entity
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

    @OneToMany(mappedBy = "movie")
    private List<Show> shows;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "movie_actors",
            joinColumns = {
                    @JoinColumn(name = "Movies_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "Actors_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Actor> actorList = new ArrayList<>();

    public Movie(String title, double rating, short minAge, String description, int categoryId) {
        this.title = title;
        this.rating = rating;
        this.minAge = minAge;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Movie(String title, double rating, short minAge, String description, int categoryId, List<Actor> actorList) {
        this.title = title;
        this.rating = rating;
        this.minAge = minAge;
        this.description = description;
        this.categoryId = categoryId;
        this.actorList=actorList;
    }

    public Movie(int id, String title, double rating, short minAge, String description, int categoryId) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.minAge = minAge;
        this.description = description;
        this.categoryId = categoryId;
    }

    public void addActor(Actor actor) {
        actorList.add(actor);
        actor.getMovieList().add(this);
    }
}
