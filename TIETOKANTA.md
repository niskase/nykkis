CREATE TABLE USER (
UserID int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
LoginStatus int,
UserName varchar(50),
PassWord varchar(50),
Role varchar(10),
UNIQUE (UserName)
);

INSERT INTO USER (LoginStatus, UserName, PassWord, Role)
VALUES(0,'admin','root', 'admin');

INSERT INTO USER (LoginStatus, UserName, PassWord, Role)
VALUES(0,'seller','root', 'seller');

INSERT INTO USER (LoginStatus, UserName, PassWord, Role)
VALUES(0,'boss','root', 'boss');


CREATE TABLE Customers (
CustomerID int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
UserID int(6) NOT NULL,
CustomerName varchar(100),
CustomerPhone char(22),
CustomerEmail varchar(100),
CustomerPhoto varchar(100),
CustomerCountry varchar(50),
CustomerSellerResp varchar(255),
CustomerAddress varchar(255),
CustomerZipCode int(10),
CustomerCity varchar(255),
CustomerStatus varchar(20),
FOREIGN KEY (UserID) REFERENCES USER(UserID),
UNIQUE (CustomerEmail)
);

INSERT INTO Customers (UserID, CustomerName, CustomerPhone, CustomerEmail, CustomerPhoto, CustomerCountry, CustomerSellerResp, CustomerAddress, CustomerZipCode, CustomerCity, CustomerStatus)
VALUES(1, 'Aki Asiakas', +358123456789, 'asiakas@netti.fi', 'profiilikuva.png', 'Finland', 'Luottomyynti Oy', 'Survontie 9', 12345, 'Jyväskylä', 'TestStatus');

INSERT INTO Customers (UserID, CustomerName, CustomerPhone, CustomerEmail, CustomerPhoto, CustomerCountry, CustomerSellerResp, CustomerAddress, CustomerZipCode, CustomerCity, CustomerStatus)
VALUES(1, 'Nakke Nakuttaja', +358123456789, 'asiakas@natsi.fi', 'profiilikuva.png', 'Finland', 'Luottomyynti Oy', 'Survontie 9', 12345, 'Jyväskylä', 'TestStatus');

CREATE TABLE Companies (
CompanyID int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
CustomerID int(6),
CompanyName varchar(50),
CompanyPhone char(22),
CompanyAddress varchar(255),
CompanyZipCode int(10),
CompanyCity varchar(255),
CompanyWebsite varchar(100),
CompanyBusinessID char(50),
FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
UNIQUE (CompanyName)
);

INSERT INTO Companies (CustomerID, CompanyName, CompanyPhone, CompanyAddress, CompanyZipCode, CompanyCity, CompanyWebsite, CompanyBusinessID)
VALUES(1, 'Komppany Oy', +3580989873647, 'Jokelantie 41', 40296, 'Pahvisaari', 'www.komppany.com', 52352825);

INSERT INTO Companies (CustomerID, CompanyName, CompanyPhone, CompanyAddress, CompanyZipCode, CompanyCity, CompanyWebsite, CompanyBusinessID)
VALUES(2, 'Kamppany Oy', +3580989873648, 'Jokelantie 40', 40296, 'Pahvisaari', 'www.kamppany.com', 52352825);

SELECT * FROM Users;
SELECT * FROM Customers;
SELECT * FROM Companies;
