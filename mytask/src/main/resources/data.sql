DROP TABLE IF EXISTS Batch;
CREATE TABLE Batch(batchPK INT PRIMARY KEY auto_increment, batchNK INT  auto_increment, filename VARCHAR(255), totalNumberOfRows INT, numberOfNewTrans INT, startDate TIMESTAMP, endDate TIMESTAMP, creationDate TIMESTAMP);

DROP TABLE IF EXISTS Transactiondescription;
CREATE TABLE Transactiondescription(transactiondescriptionPK INT PRIMARY KEY auto_increment, 
transactiondescriptionNK INT  auto_increment, description VARCHAR(255), creationDate TIMESTAMP,
 batchPK INT,  FOREIGN KEY (batchPK ) REFERENCES BATCH(batchPK ));

DROP TABLE IF EXISTS Transaction;
CREATE TABLE Transaction(transactionPK INT PRIMARY KEY auto_increment, transactionNK INT  auto_increment, 
transactionID INT, transactionDate TIMESTAMP, amount LONG, creationDate TIMESTAMP, transactiondescriptionPK INT, FOREIGN KEY (transactiondescriptionPK ) REFERENCES Transactiondescription(transactiondescriptionPK ), batchPK INT, FOREIGN KEY (batchPK) REFERENCES Transaction(batchPK ));
