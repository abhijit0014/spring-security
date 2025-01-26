package project.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.spring_security.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByPermissionName(String permissionName);
}
