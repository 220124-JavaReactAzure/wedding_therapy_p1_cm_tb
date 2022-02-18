--Database creation script for the wedding_therapy_p1_cm_tb project
--Formated with ctrl+f

--drop table if exists users;
--drop table if exists wedding_services;
--drop table if exists employees;
--drop table if exists weddings;


--need to figure out many to one relationship with wedding_services
CREATE TABLE weddings (
	wedding_id int PRIMARY KEY,
	wedding_name varchar (50) NOT NULL,
	wedding_date varchar (50) NOT NULL,
	wedding_budget numeric NOT NULL,
	caterer_id int NOT NULL,  --many to one relationship with wedding_services service_type_id. 
	florist_id int NOT NULL,  --many to one relationship with wedding_services service_type_id. 
	musician_id int NOT NULL,  --many to one relationship with wedding_services service_type_id. 
	photographer_id int NOT NULL,  --many to one relationship with wedding_services service_type_id. 
	venu_id int NOT NULL  --many to one relationship with wedding_services service_type_id. 
);

SELECT * FROM weddings;


CREATE TABLE users (
	user_id int PRIMARY KEY,
	wedding_roll varchar (50) NOT NULL,
	firstname varchar (50) NOT NULL,
	lastname varchar (50) NOT NULL,
	email varchar (255) UNIQUE NOT NULL,
	username varchar(50) UNIQUE NOT NULL,
	password varchar(50) NOT NULL,
	meal_id int NOT NULL,
	plus_one bit NOT NULL,
	plus_one_meal_id int NOT NULL,
	betrothed bit NOT NULL,
	wedding_id int NOT NULL,
	CONSTRAINT users_wedding_id_fk FOREIGN KEY (wedding_id)REFERENCES weddings(wedding_id)
);

SELECT * FROM users;


CREATE TABLE employees (
	employ_id int PRIMARY KEY,
	username varchar (50) NOT NULL,
	email varchar (255) UNIQUE NOT NULL,
	password varchar(50) NOT NULL
--	CONSTRAINT users_wedding_id_fk FOREIGN KEY (wedding_id)REFERENCES weddings(wedding_id)
);

SELECT * FROM employees;


CREATE TABLE wedding_services (
	service_id int PRIMARY KEY,
	service_name varchar (50) NOT NULL,
	service_cost numeric UNIQUE NOT NULL,
	service_type_id int NOT NULL,
--	service_type varchar (50) NOT NULL
--	CONSTRAINT service_type_id_fk FOREIGN KEY (service_type_id)REFERENCES service_types(service_type_id)
--	CONSTRAINT service_type_fk FOREIGN KEY (service_type)REFERENCES service_types(service_type)
);

SELECT * FROM wedding_services;


CREATE TABLE service_types (
	service_type_id int PRIMARY KEY,
	service_type varchar (50) NOT NULL
--	CONSTRAINT wedding_services_fk FOREIGN KEY (service_type_id)REFERENCES weddings(wedding_id)
);

SELECT * FROM service_types;


CREATE TABLE meal_types (
	meal_id int PRIMARY KEY,
	meal_type varchar (50) NOT NULL
--	CONSTRAINT wedding_services_fk FOREIGN KEY (service_type_id)REFERENCES weddings(wedding_id)
);

SELECT * FROM meal_types;