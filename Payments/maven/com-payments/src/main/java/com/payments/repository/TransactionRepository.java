package com.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payments.model.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
