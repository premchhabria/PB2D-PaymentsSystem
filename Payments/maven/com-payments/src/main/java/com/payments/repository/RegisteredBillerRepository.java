package com.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.payments.model.RegisteredBiller;

@Repository
public interface RegisteredBillerRepository extends JpaRepository<RegisteredBiller, Integer>{

}
