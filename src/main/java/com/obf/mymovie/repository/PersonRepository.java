package com.obf.mymovie.repository;

import com.obf.mymovie.domain.Category;
import com.obf.mymovie.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findOneByOid(Long aLong);
}
