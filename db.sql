DROP TABLE calculator;
DROP TABLE Integration;
DROP TABLE slau;

CREATE TABLE calculator (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
firstOperand DOUBLE,
secondOperand DOUBLE,
operation VARCHAR(1),
answer DOUBLE
);

CREATE TABLE Integration (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
c_x3 DOUBLE,
c_x2 DOUBLE,
c_x DOUBLE,
c DOUBLE,
numSteps INTEGER,
leftLimit DOUBLE,
rightLimit DOUBLE,
answer DOUBLE
);

CREATE TABLE slau (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
sizeSlau INTEGER,
equations VARCHAR(200),
answer VARCHAR(200)
);