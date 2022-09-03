insert into character (character_name, character_gender, character_alias)
VALUES ('Gandalf', 'Male', 'None');
insert into character (character_name, character_gender, character_alias)
VALUES ('Frodo', 'Male', 'None');
insert into character (character_name, character_gender, character_alias)
VALUES ('Tony Stark', 'Male', 'Iron Man');
insert into character (character_name, character_gender, character_alias)
VALUES ('Bruce Banner', 'Male', 'Hulk');

insert into franchise (franchise_name, franchise_description)
VALUES ('Tolkkien saga', 'Fantasy saga created by J.J.R Tolkkien');
insert into franchise (franchise_name, franchise_description)
VALUES ('Marvel Universe', 'Superheroes base on Marvel Comics');

insert into movie (movie_title, movie_director, movie_genre, movie_release_year, franchise_id)
VALUES ('Lord of the Rings: The Fellowship of the Ring', 'Peter Jackson', 'Fantasy', '2001', 1);
insert into movie (movie_title, movie_director, movie_genre, movie_release_year, franchise_id)
VALUES ('The Hobbit: Battle of Five Armies', 'Peter Jackson', 'Fantasy', '2014', 1);
insert into movie (movie_title, movie_director, movie_genre, movie_release_year, franchise_id)
VALUES ('The Avangers', 'Joss Whedon', 'Action', '2012', 2);

insert into movie_character(movie_id, character_id) VALUES (2,1);
insert into movie_character(movie_id, character_id) VALUES (1,1);
insert into movie_character(movie_id, character_id) VALUES (1,2);
insert into movie_character(movie_id, character_id) VALUES (3,3);
insert into movie_character(movie_id, character_id) VALUES (3,4);


