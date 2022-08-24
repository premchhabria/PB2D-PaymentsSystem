package com.payments.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.model.Transaction;

@Service
public class CsvExportService {

	@Autowired
	TransactionService transactionService;

    public void writeEmployeesToCsv(Writer writer, int consumerId, String billerCode, String startDate, String endDate) {

        List<Transaction> transactions = transactionService.getPaymentsWithAllFilters(consumerId, billerCode, startDate, endDate);
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (Transaction transaction : transactions) {
                csvPrinter.printRecord(transaction.getTransaction_id(), transaction.getBill_id(), transaction.getAccount_id(), transaction.getDate_time());
            }
        } catch (IOException e) {
            System.out.println("Error While writing CSV "+e);
        }
    }
}