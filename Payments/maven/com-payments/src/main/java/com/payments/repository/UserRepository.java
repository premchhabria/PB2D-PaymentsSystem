package com.payments.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.payments.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//	findById 
//	findAll
//	insert 
//	update 
//	delete

//	public abstract List<User> findByFirstName(String firstName);

}
