package com.obf.mymovie.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@SequenceGenerator(
    name = "rolesSeq",
    sequenceName = "roles_seq",
    allocationSize = 1,
    schema = "MYMOVIEDBA"
)
@Table(
    name = "roles",
    schema = "MYMOVIEDBA"
)
@Cache(
    usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE
)

public class Role implements Serializable {

    @NotNull
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "rolesSeq"
    )
    @Column(
        name = "roleOid",
        nullable = false
    )
    private Long oid;

    @Size(
        max = 100
    )
    @Column(
        name = "caracter_name"
    )
    private String caracterName;


    @OneToOne
    private RoleType roleType;

    @ManyToOne
    @JoinColumn(name="moviePersonOid")
    private MoviePerson moviePerson;


    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getCaracterName() {
        return caracterName;
    }

    public void setCaracterName(String caracterName) {
        this.caracterName = caracterName;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public MoviePerson getMoviePerson() {
        return moviePerson;
    }

    public void setMoviePerson(MoviePerson moviePerson) {
        this.moviePerson = moviePerson;
    }
}
