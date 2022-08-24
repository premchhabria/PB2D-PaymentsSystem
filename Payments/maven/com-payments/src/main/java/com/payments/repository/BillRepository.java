package com.payments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.payments.model.Bill;


@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	@Query(value = "SELECT * FROM bill as b where b.consumer_no = :cons", nativeQuery = true)
	   List<Bill> findByConsumer(@Param("cons")int consumer_no);
	
	@Query(value = "SELECT * FROM bill as b where b.due_date <= :due", nativeQuery = true)
	   List<Bill> filterByDue(@Param("due")String due);
	
	@Query(value = "SELECT * FROM payment.bill as b "
			+ "JOIN payment.registeredbiller as r "
			+ "ON (b.biller_code = r.biller_code and b.consumer_no = r.consumer_no) "
			+ "WHERE r.autopay=1 and b.amount<=r.autopay_limit and b.status=1 and b.consumer_no= :cons", nativeQuery = true)
	   List<Bill> findScheduledBill(@Param("cons")int consumer_no);
	
	@Query(value = "SELECT * FROM payment.bill as b "+
			"JOIN payment.registeredbiller as r "+
			"ON (b.biller_code = r.biller_code and b.consumer_no = r.consumer_no) "+
			"WHERE b.status=1 and (r.autopay=0 or ( r.autopay=1 and b.amount>r.autopay_limit)) and b.consumer_no = :cons", nativeQuery = true)
	   List<Bill> findUnscheduledBill(@Param("cons")int consumer_no);
}

