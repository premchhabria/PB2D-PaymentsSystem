package com.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.payments.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
//	Login findByUsernameAndPassword(int login_id, String password);
	
	@Query(value = "SELECT * FROM user u WHERE u.login_id = :login_id and u.password = :password", nativeQuery = true)
	Login findUserByStatusAndNameNamedParamsNative(@Param("login_id") int login_id, @Param("password") String name);

}




