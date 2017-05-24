CREATE DATABASE Millionaires CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE Millionaires;

CREATE TABLE Questions
(
id INT NOT NULL AUTO_INCREMENT,
content varchar(300),
question_level Int,
CONSTRAINT questions_PK PRIMARY KEY (id)
);

CREATE TABLE Answers
(
id INT NOT NULL AUTO_INCREMENT,
content varchar(300),
question_id INT,
is_correct boolean,
CONSTRAINT answers_PK PRIMARY KEY (id),
CONSTRAINT answer_question_FK FOREIGN KEY (question_id) REFERENCES Questions(id)
);