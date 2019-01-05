-- Web resource for creating a table - http://sql-info.de/mysql/examples/CREATE-TABLE-examples.html

CREATE TABLE myschema.user (
         user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
         first_name VARCHAR(30) not null,
         middle_name CHAR(1),
         last_name VARCHAR(50) not null,
         address1 VARCHAR(75) not null,
         address2 VARCHAR(50),
         city VARCHAR(50) not null,
         state VARCHAR(2) not null,
         zip1 VARCHAR(5) not null,
         zip2 VARCHAR(4),
         phone VARCHAR(12),
         email VARCHAR(50)
);

select * from myschema.user;
