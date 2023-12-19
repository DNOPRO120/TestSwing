CREATE TABLE `account` (
  `accountnumber` varchar(225) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `balance` double NOT NULL,
  `openingdate` date NOT NULL,
  `accounttype` varchar(225) NOT NULL
)
ALTER TABLE `account`
 ADD PRIMARY KEY (`accountnumber`);
COMMIT;