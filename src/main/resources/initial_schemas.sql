CREATE DATABASE `academy` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE academy.class (
	id bigint NOT NULL AUTO_INCREMENT,
	subject_id bigint NOT NULL,
	name varchar(200) NOT NULL,
	code varchar(45) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (class_id) REFERENCES class(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE academy.subject (
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(200) NOT NULL,
	code varchar(45) NOT NULL,
	PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE academy.student (
	id bigint NOT NULL AUTO_INCREMENT,
	first_name varchar(45) NOT NULL,
	last_name varchar(45) NOT NULL,
	email varchar(45) NOT NULL,
	class_id bigint NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (class_id) REFERENCES class(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE academy.teacher (
	id bigint NOT NULL AUTO_INCREMENT,
	first_name varchar(45) NOT NULL,
	last_name varchar(45) NOT NULL,
	email varchar(45) NOT NULL
	PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE academy.class_teacher (
	class_id bigint NOT NULL,
    	teacher_id bigint NOT NULL,
    	PRIMARY KEY (class_id, subject_id, teacher_id),
	FOREIGN KEY (class_id) REFERENCES class(id),
	FOREIGN KEY (teacher_id) REFERENCES teacher(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;



