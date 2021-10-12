package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic@Column(name = "Title", nullable = false, length = 45)
    private String title;

    @Basic@Column(name = "Rating", nullable = false)
    private double rating;

    @Basic@Column(name = "Min_Age", nullable = false)
    private short minAge;

    @Basic@Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "Category_id", nullable = false)
    private int categoryId;

    @OneToMany(mappedBy = "movie")
    private List<Show> shows;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
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
}
