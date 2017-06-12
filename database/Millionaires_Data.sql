-- Poziom 1
INSERT INTO Questions(id, content, question_level) VALUES(1, 'W języku scala słowo kluczowe val używane jest do :', 1);
INSERT INTO Answers(content, question_id, is_correct) VALUES('deklaracji stałych', 1, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('deklaracji zmiennych', 1, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('deklaracji listy', 1, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('odpowiedź a i c jest poprawna', 1, false);

INSERT INTO Questions(id, content, question_level) VALUES(2, 'Jak nazywa się osoba podpowiadająca aktorom w teatrze?', 1);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Suflet', 2, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Sufler', 2, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Podpowiadacz', 2, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Podszeptywacz', 2, false);

-- Poziom 2
INSERT INTO Questions(id, content, question_level) VALUES(3, 'W sali do przyrody znajdują się słoje z eksponatami.Który z podanych niżej słoi jest źle oznakowany?', 2);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Motyl-owad', 3, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Jaszczurka-gad', 3, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Żaba-płaz', 3, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Szczupak-ssak', 3, true);

INSERT INTO Questions(id, content, question_level) VALUES(4, 'Napięcie prądu mierzy się w woltach (V) . Jakie jest napięcie produ w gniazdkach w Polsce ?', 2);
INSERT INTO Answers(content, question_id, is_correct) VALUES('230 V', 4, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('120 V', 4, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('245 V', 4, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('270 V', 4, false);

-- Poziom 3
INSERT INTO Questions(id, content, question_level) VALUES(5, 'Do odnawialnych źródeł energii , z których można wytworzyć prąd należy : ', 3);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Węgiel', 5, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Ropa naftowa', 5, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Woda', 5, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Gaz ziemny', 5, false);

INSERT INTO Questions(id, content, question_level) VALUES(6, 'Jak nazywa się zjawisko świetlne obserwowane tylko na biegunie?', 3);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Tęcza', 6, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Zorza', 6, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Łuna', 6, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Miraż', 6, false);

-- Poziom 4
INSERT INTO Questions(id, content, question_level) VALUES(7, 'Czyj marsz grany jest na ślubach?', 4);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Ogińskiego', 7, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Mendelsona', 7, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Straussa', 7, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Dąbrowskiego', 7, false);

INSERT INTO Questions(id, content, question_level) VALUES(8, 'Jaka moneta była opłatą dla przewoźnika w Hadesie', 4);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Dukat', 8, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Obol', 8, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Talar', 8, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Dinar', 8, false);

-- Poziom 5
INSERT INTO Questions(id, content, question_level) VALUES(9, 'Jak nazywa się wódka pędzona ze śliwek?', 5);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Tokaj', 9, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Sake', 9, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Rakija', 9, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Alasz', 9, false);

INSERT INTO Questions(id, content, question_level) VALUES(10, 'Jak nazywa się jednostka mocy?', 5);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Volt', 10, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Amper', 10, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Wat', 10, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Power', 10, false);

-- Poziom 6
INSERT INTO Questions(id, content, question_level) VALUES(11, 'Jak nazywa się grecka bogini miłości', 6);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Atena', 11, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Afrodyta', 11, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Eutrepe', 11, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Hekate', 11, false);

INSERT INTO Questions(id, content, question_level) VALUES(12, 'Jaką nazwę nosi oprogramowanie komputera, instalowane najczęściej bez wiedzy użytkownika?', 6);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Shareware', 12, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Slackware', 12, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Freeware', 12, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Malware', 12, true);

-- Poziom 7
INSERT INTO Questions(id, content, question_level) VALUES(13, 'Która z bitew kampanii wrześniowej została nazwana ''polskimi Termopilami''?', 7);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Bitwa pod Krasynmstawem', 13, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Obrona Przemyśla', 13, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Obrona Wizny', 13, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Szarża pod Wólką Węglową', 13, false);

INSERT INTO Questions(id, content, question_level) VALUES(14, 'W którym wieku urodził się Gall Anonim ?', 7);
INSERT INTO Answers(content, question_id, is_correct) VALUES('W XVI w.', 14, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('W IX w.', 14, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('W XI w.', 14, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('W XV w.', 14, false);

-- Poziom 8
INSERT INTO Questions(id, content, question_level) VALUES(15, 'Jarosław Kaczyński w jednym z wywiadów zwierzył się,że późno w nocy lubi oglądać w telewizji:', 8);
INSERT INTO Answers(content, question_id, is_correct) VALUES('NHL', 15, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Monster Trucki', 15, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Rodeo', 15, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Wrestling', 15, false);

INSERT INTO Questions(id, content, question_level) VALUES(16, 'Płetwą grzbietową nie pruje wody:', 8);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Długoszpar', 16, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Kosogon', 16, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Orka', 16, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Wal grenlandzki', 16, true);

-- Poziom 9
INSERT INTO Questions(id, content, question_level) VALUES(17, 'Z gry na jakim instrumencie słynie Czesław Mozil?', 9);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Na kornecie', 17, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Na akordeonie', 17, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Na dhembe', 17, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Na ksylofonie', 17, false);

INSERT INTO Questions(id, content, question_level) VALUES(18, 'Likier maraskino produkuje się z maraski, czyli odmiany:', 9);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Wiśni', 18, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Jabłoni', 18, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Figi', 18, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Gruszy', 18, false);

-- Poziom 10
INSERT INTO Questions(id, content, question_level) VALUES(19, 'Skąd pochodził Conan Barbarzyńca?', 10);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Z Rivii', 19, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Z Oz', 19, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Z Mordoru', 19, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Z Cimmerii', 19, true);

INSERT INTO Questions(id, content, question_level) VALUES(20, 'Kto jest mistrzem tego samego oręża, w jakim specjalizowała się mitologiczna Artemida?', 10);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Zorro', 20, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Legolas', 20, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Don Kichot', 20, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Longinus Podbipięta', 20, false);

-- Poziom 11
INSERT INTO Questions(id, content, question_level) VALUES(21, 'Mowa w obronie poety Archiasza przeszła do historii jako jedna z najświetniejszych popisów retorycznych: ', 11);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Izokratesa', 21, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Cycerona', 21, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Demostenesa', 21, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Kwintyliana', 21, false);

INSERT INTO Questions(id, content, question_level) VALUES(22, 'Rybą nie jest:', 11);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Świnka', 22, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Rozpiór', 22, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Krasnopiórka', 22, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Kraska', 22, true);

-- Poziom 11
INSERT INTO Questions(id, content, question_level) VALUES(23, 'Który utwór Juliusza Słowackiego napisany jest prozą?', 12);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Godzina myśli', 23, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('W Szwajcarii', 23, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Anhelli', 23, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Arab', 23, false);

INSERT INTO Questions(id, content, question_level) VALUES(24, 'Który aktor urodził się w roku opatentowania kinematografu braci Lumière?', 12);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Rudolph Valentino', 24, true);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Humphrey Bogart', 24, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Charlie Chaplin', 24, false);
INSERT INTO Answers(content, question_id, is_correct) VALUES('Fred Astaire', 24, false);