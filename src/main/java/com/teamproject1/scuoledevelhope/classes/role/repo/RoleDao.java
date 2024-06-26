package com.teamproject1.scuoledevelhope.classes.role.repo;

import com.teamproject1.scuoledevelhope.classes.role.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into user_role(id_user, id_role) value ((select id from user where username = :username), (select id_role from role where role_name = :roleName))", nativeQuery = true)
    int addRoleWithUsername(@Param("username") String username, @Param("roleName") String roleEnum);

    @Transactional
    @Modifying
    @Query(value = "delete ur from user_role ur join user u on u.id = ur.id_user join role r on r.id_role = ur.id_role where u.username = :username and role_name = r.role_name = :roleName", nativeQuery = true)
    int deleteRoleByUsername(@Param("username") String username, @Param("roleName") String roleEnum);
}
