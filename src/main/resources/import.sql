INSERT INTO cinemav2.categories(id, Name) VALUES (1, 'drama');
INSERT INTO cinemav2.actors(id, First_Name, Last_Name) VALUES (1, 'Al', 'Pacino');
INSERT INTO cinemav2.actors(id, First_Name, Last_Name) VALUES (2, 'Robert', 'De Niro');
INSERT INTO cinemav2.movies(id, Title, Rating, Min_Age, Description, Category_id) VALUES
(1, 'The Godfather', 10, 14, 'A classic for all times...', 1);
INSERT INTO cinemav2.theaters(id, Street, City, Zipcode) VALUES (1, 'Lygten 16', 'Copenhagen', 2400);
INSERT INTO movies_playing(Date_Starts, Date_Ends, Movies_id, Theaters_id) VALUES ('2021-11-11', '2021-11-22', 1, 1);