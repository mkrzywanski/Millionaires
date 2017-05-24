INSERT INTO Questions(id, content, question_level) VALUES(1, 'Jakieś pytanie', 1);
INSERT INTO Questions(id, content, question_level) VALUES(2, 'Jakieś pytani2', 2);

INSERT INTO Answers(id, content, question_id, is_correct) VALUES(1, 'Odpowiedz 1', 1, false);
INSERT INTO Answers(id, content, question_id, is_correct) VALUES(2, 'Odpowiedz 2', 1, false);
INSERT INTO Answers(id, content, question_id, is_correct) VALUES(3, 'Odpowiedz 3', 1, false);
INSERT INTO Answers(id, content, question_id, is_correct) VALUES(4, 'Odpowiedz 4', 1, true);

INSERT INTO Answers(id, content, question_id, is_correct) VALUES(5, 'Odpowiedz 1', 2, false);
INSERT INTO Answers(id, content, question_id, is_correct) VALUES(6, 'Odpowiedz 2', 2, false);
INSERT INTO Answers(id, content, question_id, is_correct) VALUES(7, 'Odpowiedz 3', 2, false);
INSERT INTO Answers(id, content, question_id, is_correct) VALUES(8, 'Odpowiedz 4', 2, true);
