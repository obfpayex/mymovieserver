package com.obf.mymovie.repository;

import com.obf.mymovie.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    Language findOneByOid(Long aLong);
}
