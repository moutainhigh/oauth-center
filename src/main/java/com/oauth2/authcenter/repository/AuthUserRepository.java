package com.oauth2.authcenter.repository;

import com.oauth2.authcenter.entity.AuthUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUserDetails,Integer> {
}
