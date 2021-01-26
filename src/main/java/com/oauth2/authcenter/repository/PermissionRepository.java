package com.oauth2.authcenter.repository;

import com.oauth2.authcenter.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Integer> {
}
