create table users(
	user_id SERIAL primary key,
	username varchar(30) not null,
	password varchar(30) not null
);

create table games(
	game_id SERIAL primary key,
	title varchar(50) not null,
	developer varchar(50) not null,
	description varchar(1000) not null,
	release_date int not null,
	rating decimal not null
);

create table genres(
	genre_id SERIAL primary key,
	genre_name varchar(30) not null
);

create table genres_in_games(
	genre_in_game_id SERIAL primary key,
	game_id int not null,
	genre_id int not null,
	foreign key (game_id) references games(game_id) on delete cascade,
	foreign key (genre_id) references genres(genre_id) on delete cascade
);