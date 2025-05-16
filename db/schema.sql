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
