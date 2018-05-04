package com.obf.mymovie.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@SequenceGenerator(
    name = "moviePersonsSeq",
    sequenceName = "movie_persons_seq",
    allocationSize = 1,
    schema = "MYMOVIEDBA"
)
@Table(
    name = "MoviePerson",
    schema = "MYMOVIEDBA"
)
@Cache(
    usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE
)
public class MoviePerson implements Serializable {
    @NotNull
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "moviePersonsSeq"
    )
    @Column(
        name = "moviePersonOid",
        nullable = false
    )
    private Long oid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieOid")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personOid")
    private Person person;

    @OneToMany
    @JoinColumn(name = "roleOid")
    private List<Role> role;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
