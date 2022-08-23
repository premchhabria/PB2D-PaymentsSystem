package com.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payments.model.MasterBiller;

@Repository
public interface MasterBillerRepository extends JpaRepository<MasterBiller, String>{

}
