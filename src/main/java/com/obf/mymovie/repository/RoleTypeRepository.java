package com.obf.mymovie.repository;

import com.obf.mymovie.domain.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleTypeRepository extends JpaRepository<RoleType, Long> {

    RoleType findOneByOid(Long aLong);
}
