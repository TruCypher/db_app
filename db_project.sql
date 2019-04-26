DROP TABLE IF EXISTS PURCHASE;
DROP TABLE IF EXISTS CLIENT;
DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS SHOES;


CREATE TABLE EMPLOYEE (
    e_id INT AUTO_INCREMENT,
    e_fName VARCHAR(255),
    e_lName VARCHAR(255),
    e_rank VARCHAR(255),
    PRIMARY KEY(e_id)
);

CREATE TABLE CLIENT (
    c_id INT AUTO_INCREMENT,
    c_fName VARCHAR(225),
    c_lName VARCHAR(225),
    c_numShoes INT,
    c_dayJoined VARCHAR(255),
    c_loyal INT,
    e_id INT,
    PRIMARY KEY (c_id),
    FOREIGN KEY (e_id) REFERENCES EMPLOYEE(e_id)
);

CREATE TABLE SHOES (
    s_id INT AUTO_INCREMENT,
    s_quantity INT,
    s_rate INT,
    s_brandName VARCHAR(255),
    s_price DOUBLE(10,2),
    PRIMARY KEY (s_id)
);

CREATE TABLE PURCHASE (
    p_id INT AUTO_INCREMENT,
    c_id INT,
    s_id INT,
    p_dayPurchase VARCHAR(255),
    p_return VARCHAR(255),
    PRIMARY KEY(p_id),
    FOREIGN KEY (c_id) REFERENCES CLIENT(c_id),
    FOREIGN KEY (s_id) REFERENCES SHOES(s_id)
);


INSERT INTO EMPLOYEE (e_fName, e_lName, e_rank) 
VALUES 
    ("tru","nguyen","CEO"),
    ("steff","mike","Manager"),
    ("anh","le","salesman"),
    ("son","le","salesman"),
    ("michael","mike","Supervisor");

INSERT INTO CLIENT (c_fName, c_lName, c_numShoes, c_dayJoined, c_loyal, e_id)
VALUES 

("tru","nguyen",23,"08-28-2016",10, 1),
("michael","johnson",30,"02-12-2017",2, 3),
("nidael","michael",2,"01-23-2018",5, 4),
("blitz","johnson",40,"07-24-2007",8, 3),
("thresh","mike",1,"03-15-2008",3, 2),
("irealia","lizz",9,"09-21-2012",2,3),
("anh","ga",2,"05-30-2002",10,4),
("anh","lizz",23,"01-8-2019",1,3),
("lucian","ben",14,"09-11-2017",5,4),
("zed","mast",3,"10-22-2017",10,4),
("salt","john",21,"11-12-2007",3,2);



INSERT INTO SHOES (s_quantity, s_rate, s_brandName, s_price) 
VALUES 
    (24,4,"addidas",300),
    (50,10,"jordan",500),
    (100,10,"Gucci",700),
    (121,4,"ESCADA",200),
    (39,2,"Appaman",240),
    (200,10,"levi",500),
    (69,7,"salomon",350),
    (40,8,"samsonite",140),
    (21,7,"samuel hubbard", 245),
    (90,5,"sam edelman", 230),
    (321,10,"nike",900),
    (149,4,"eberjey",111),
    (72,7,"acorn",132),
    (100,5,"acorn kid",20);

INSERT INTO PURCHASE (c_id, s_id, p_dayPurchase, p_return)
VALUES
(2,6,"1-13-2007","false"),
(1,10,"9-09-2002","true"),
(10,3,"8-05-2018","false"),
(7,5,"5-17-2019","false"),
(4,7,"12-21-2015","true"),
(3,6,"11-02-2014","false"),
(2,8,"4-18-2013","true"),
(1,6,"3-20-2004","false"),
(6,8,"8-02-2005","false"),
(5,9,"7-21-2009","false");