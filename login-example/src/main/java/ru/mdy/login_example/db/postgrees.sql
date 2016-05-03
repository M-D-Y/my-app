 CREATE ROLE "login_example" LOGIN PASSWORD 'login_example'
  CREATEDB
   VALID UNTIL 'infinity';

   
--CREATE DATABASE "login_example"
--  WITH OWNER = login_example
--       ENCODING = 'WIN1251'
--       TABLESPACE = pg_default
--       LC_COLLATE = 'Russian_Russia.1251'
--       LC_CTYPE = 'Russian_Russia.1251'
--       CONNECTION LIMIT = -1;    
   

CREATE DATABASE "login_example"
  WITH OWNER "login_example"
	ENCODING = 'UTF8'
  	LC_COLLATE = 'Russian_Russia.1251'
  	LC_CTYPE = 'Russian_Russia.1251'
  	TEMPLATE = template0
	CONNECTION LIMIT = -1; 

CREATE TABLE IF NOT EXISTS users
(
  "FirstName" character(100),
  "LastName" character(100),
  username character(20) NOT NULL,
  password character(20),
  CONSTRAINT pk_user PRIMARY KEY (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO "login_example";

  
INSERT INTO users(
            "FirstName", "LastName", username, password)
    VALUES ('Иванов', 'Иван', 'test', 'test');

INSERT INTO users(
            "FirstName", "LastName", username, password)
    VALUES ('Login for example', 'log_ex', 'login_example', 'login_example');
    