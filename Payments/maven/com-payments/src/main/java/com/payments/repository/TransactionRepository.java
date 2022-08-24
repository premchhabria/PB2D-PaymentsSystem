package com.payments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.payments.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	@Query(value = "SELECT * FROM payment.transaction as t "
			+ "JOIN payment.bill as b "
			+ "ON b.bill_id = t.bill_id "
			+ "WHERE b.consumer_no= :cons and b.biller_code = :billerCode and t.date_time BETWEEN :startDate and :endDate", nativeQuery = true)
	List<Transaction> findPaymentsWithAllFilters(@Param("cons") int consumer_no, 
			@Param("billerCode") String biller_code, 
			@Param("startDate") String start_date, 
			@Param("endDate") String end_date); 
	
	
	@Query(value = "SELECT * FROM payment.transaction as t "
			+ "JOIN payment.bill as b "
			+ "ON b.bill_id = t.bill_id "
			+ "WHERE b.consumer_no= :cons and b.biller_code = :billerCode", nativeQuery = true)
	List<Transaction> findPaymentsWithoutDate(@Param("cons") int consumer_no, 
			@Param("billerCode") String biller_code);
	
	@Query(value = "SELECT * FROM payment.transaction as t "
			+ "JOIN payment.bill as b "
			+ "ON b.bill_id = t.bill_id "
			+ "WHERE b.consumer_no= :cons and t.date_time BETWEEN :startDate and :endDate", nativeQuery = true)
	List<Transaction> findPaymentsWithoutBiller(@Param("cons") int consumer_no, 
			@Param("startDate") String start_date, 
			@Param("endDate") String end_date); 
	
	@Query(value = "SELECT * FROM payment.transaction as t "
			+ "JOIN payment.bill as b "
			+ "ON b.bill_id = t.bill_id "
			+ "WHERE b.consumer_no= :cons", nativeQuery = true)
	List<Transaction> findPaymentsWithoutFilters(@Param("cons") int consumer_no); 
	
	
}
