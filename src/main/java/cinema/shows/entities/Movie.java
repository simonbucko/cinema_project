package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
    private int id;
    @Basic@Column(name = "Title", nullable = false, length = 45)
    private String title;
    @Basic@Column(name = "Rating", nullable = false, precision = 0)
    private double rating;
    @Basic@Column(name = "Min_Age", nullable = false)
    private short minAge;
    @Basic@Column(name = "Description", nullable = false, length = 255)
    private String description;
    @Basic@Column(name = "Category_id", nullable = false)
    private int categoryId;
    @OneToMany(mappedBy = "moviesByMoviesId")
    private Collection<MovieActor> movieActorsById;
    @ManyToOne@JoinColumn(name = "Category_id", referencedColumnName = "id", nullable = false)
    private Category categoriesByCategoryId;
    @OneToMany(mappedBy = "moviesByMoviesId")
    private Collection<Show> showsById;

}
