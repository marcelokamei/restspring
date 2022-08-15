package pt.mmkamei.restspring.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.mmkamei.restspring.auth.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
