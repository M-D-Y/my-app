 CREATE ROLE login_example LOGIN PASSWORD 'login_example'
  CREATEDB
   VALID UNTIL 'infinity';

-- DROP SCHEMA login_example;

CREATE SCHEMA login_example
  AUTHORIZATION login_example;

CREATE DATABASE login_example
  WITH OWNER login_example
	ENCODING = 'UTF8'
  	LC_COLLATE = 'Russian_Russia.1251'
  	LC_CTYPE = 'Russian_Russia.1251'
  	TEMPLATE = template0
	CONNECTION LIMIT = -1;

-- DROP TABLE login_example.users;

CREATE TABLE IF NOT EXISTS login_example.users

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
ALTER TABLE login_example.users
  OWNER TO login_example;

ALTER TABLE login_example.users
  OWNER TO postgres;
  
INSERT INTO login_example.users(
            "FirstName", "LastName", username, password)
    VALUES ('Иванов', 'Иван', 'test', 'test');

INSERT INTO login_example.users(
            "FirstName", "LastName", username, password)
    VALUES ('Login for example', 'log_ex', 'login_example', 'login_example');
    