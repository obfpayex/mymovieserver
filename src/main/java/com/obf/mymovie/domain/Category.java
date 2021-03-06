package com.obf.mymovie.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
    @SequenceGenerator(
        name = "categorySeq",
        sequenceName = "category_seq",
        allocationSize = 1,
        schema = "MYMOVIEDBA"
    )
    @Table(
        name = "categories",
        schema = "MYMOVIEDBA" // kan droppes
    )
    @Cache(
        usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE
    )

    public class Category implements Serializable {
        @NotNull
        @Id
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "categorySeq"
        )
        @Column(
            name = "oid",
            nullable = false
        )
        private Long oid;

        @NotNull
        @Size(
            max = 50
        )
        @Column(
            name = "title",
            nullable = false
        )
        private String title;

    @Column(
        name = "created",
        nullable = false
    )
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date created;

    @Column(
        name = "modified",
        nullable = false
    )
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date modified;

    @Size(
        max = 40
    )
    @Column(
        name = "created_by"
    )
    private String createdBy;

    @Size(
        max = 40
    )
    @Column(
        name = "modified_by"
    )

    private String modifiedBy;


    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

}
