CREATE DATABASE payment;

USE payment;

CREATE TABLE Role (
	role_id INT PRIMARY KEY NOT NULL,
    name ENUM('Bank manager', 'Consumer', 'Biller') NOT NULL
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
    account_id int NOT NULL,
    FOREIGN KEY(role_id) REFERENCES Role(role_id),
    FOREIGN KEY(account_id) REFERENCES Account(account_id)
);

CREATE TABLE MasterBiller (
	biller_code INT PRIMARY KEY NOT NULL,
    biller_account_id INT NOT NULL,
    name VARCHAR(30) NOT NULL,
    FOREIGN KEY(biller_account_id) REFERENCES Account(account_id)
);

CREATE TABLE RegisteredBiller (
	biller_code INT NOT NULL,
    consumer_no INT NOT NULL,
    account_no INT NOT NULL,
    autopay BOOL DEFAULT FALSE,
    autopay_limit DOUBLE DEFAULT NULL,
    FOREIGN KEY(biller_code) REFERENCES MasterBiller(biller_code),
    PRIMARY KEY(biller_code, consumer_no)
);

CREATE TABLE Bill (
	bill_id int PRIMARY KEY NOT NULL,
    biller_code INT NOT NULL,
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

