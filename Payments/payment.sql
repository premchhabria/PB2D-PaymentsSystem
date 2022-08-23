DROP DATABASE IF EXISTS payment;

CREATE DATABASE payment;

USE payment;

CREATE TABLE Role (
	role_id INT PRIMARY KEY NOT NULL,
    name ENUM('Bank manager', 'Consumer') NOT NULL
);

CREATE TABLE Account (
	account_id INT PRIMARY KEY NOT NULL,
    account_no int NOT NULL,
    name VARCHAR(30) NOT NULL,
    email_id VARCHAR(45) NOT NULL,
    balance DOUBLE NOT NULL
);

CREATE TABLE User (
	login_id INT PRIMARY KEY NOT NULL,
    password VARCHAR(15) NOT NULL,
    role_id INT NOT NULL,
    account_id int,
    FOREIGN KEY(role_id) REFERENCES Role(role_id),
    FOREIGN KEY(account_id) REFERENCES Account(account_id)
);

CREATE TABLE MasterBiller (
	biller_code CHAR(4) PRIMARY KEY NOT NULL,
    biller_account_id INT NOT NULL,
    name VARCHAR(30) NOT NULL,
    FOREIGN KEY(biller_account_id) REFERENCES Account(account_id)
);

CREATE TABLE RegisteredBiller (
	biller_id INT PRIMARY KEY NOT NULL,
    biller_code CHAR(4) NOT NULL,
    consumer_no INT NOT NULL,
    account_no INT NOT NULL,
    autopay BOOL DEFAULT FALSE,
    autopay_limit DOUBLE DEFAULT NULL,
    FOREIGN KEY(biller_code) REFERENCES MasterBiller(biller_code),
    UNIQUE(biller_code, consumer_no)
);

CREATE TABLE Bill (
	bill_id int PRIMARY KEY NOT NULL,
    biller_code CHAR(4) NOT NULL,
	consumer_no INT NOT NULL,
    amount DOUBLE NOT NULL,
    due_date DATE NOT NULL,
    status ENUM('PENDING','PAID'),
    FOREIGN KEY(biller_code,consumer_no) REFERENCES RegisteredBiller(biller_code,consumer_no)
);

CREATE TABLE Transaction (
	transaction_id INT PRIMARY KEY NOT NULL,
    account_id INT NOT NULL,
    date_time DATETIME NOT NULL,
    amount DOUBLE NOT NULL,
    description VARCHAR(45) NOT NULL,
    bill_id INT NOT NULL,
    FOREIGN KEY(account_id) REFERENCES Account(account_id),
    FOREIGN KEY(bill_id) REFERENCES Bill(bill_id)
);

-- Bank Manager

INSERT INTO Role VALUES(1,1);
INSERT INTO User VALUES(99,'admin',1,NULL);

-- Consumers

INSERT INTO Role VALUES(2,2);
INSERT INTO Account VALUES(1,100,'Anuj Kotarkar','anuj@gmail.com',90000);
INSERT INTO User VALUES(100,'password',2,1);

INSERT INTO Account VALUES(2,101,'Prem Chhabria','prem@gmail.com',92000);
INSERT INTO User VALUES(101,'password',2,2);

INSERT INTO Account VALUES(3,102,'Rutuja More','rutuja@gmail.com',89000);
INSERT INTO User VALUES(102,'password',2,3);

INSERT INTO Account VALUES(4,103,'Swapnil Ghule','swapnil@gmail.com',90000);
INSERT INTO User VALUES(103,'password',2,4);

INSERT INTO Account VALUES(5,104,'Nishtha Sehgal','nishtha@gmail.com',90000);
INSERT INTO User VALUES(104,'password',2,5);

INSERT INTO Account VALUES(6,105,'Vaishnavi Deokate','vaishnavi@gmail.com',90000);
INSERT INTO User VALUES(105,'password',2,6);

INSERT INTO Account VALUES(7,106,'Sumit Raut','sumit@gmail.com',90000);
INSERT INTO User VALUES(106,'password',2,7);

INSERT INTO Account VALUES(8,107,'Vinod','vinod@gmail.com',90000);
INSERT INTO User VALUES(107,'password',2,8);

INSERT INTO Account VALUES(9,108,'Sravya','sravya@gmail.com',90000);
INSERT INTO User VALUES(108,'password',2,9);

-- Billers

INSERT INTO Account VALUES(10,109,'Airtel','airtel@gmail.com',90000);
INSERT INTO MasterBiller VALUES('B001',10,'Airtel');

INSERT INTO Account VALUES(11,110,'Jio','jio@gmail.com',90000);
INSERT INTO MasterBiller VALUES('B002',11,'Jio');

INSERT INTO Account VALUES(12,111,'Vi','vi@gmail.com',90000);
INSERT INTO MasterBiller VALUES('B003',12,'Vi');

INSERT INTO Account VALUES(13,112,'Tata Electric','tata@gmail.com',90000);
INSERT INTO MasterBiller VALUES('B011',13,'Tata Electric');

INSERT INTO Account VALUES(14,113,'Adani Electricity','adani@gmail.com',90000);
INSERT INTO MasterBiller VALUES('B012',14,'Adani Electricity');
