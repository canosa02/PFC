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
	rating decimal(3,1) not null
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

create table reviews(
	review_id SERIAL primary key,
	game_id int not null,
	user_id int not null,
	review_text varchar(3000),
	rating decimal(3,1) not null,
	review_date DATE not null,
	foreign key (game_id) references games(game_id) on delete cascade,
	foreign key (user_id) references users(user_id) on delete cascade
);
