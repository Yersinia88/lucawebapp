create DATABASE IF NOT EXISTS luca_webapp;

USE luca_webapp;

CREATE TABLE IF NOT EXISTS access_level (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`access_level` VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS `user` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    access_level_id INT NOT NULL,
	`active` BOOLEAN NOT NULL DEFAULT 1,
	registration_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`email` VARCHAR(250) UNIQUE NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
    FOREIGN KEY (access_level_id)
        REFERENCES `access_level` (id)
);

CREATE TABLE IF NOT EXISTS `dog_breed` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `breed_name` VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS `dog` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dog_breed_id INT NOT NULL,
    `active` BOOLEAN NOT NULL DEFAULT 1,
    name VARCHAR(25) NOT NULL,
    sex VARCHAR(7) NOT NULL,
    `chip_number` VARCHAR(20) UNIQUE DEFAULT 0,
    birthday DATE NOT NULL,
    `birth_place` VARCHAR(50) NOT NULL,
     FOREIGN KEY (dog_breed_id)
        REFERENCES `dog_breed` (id)
);
CREATE TABLE IF NOT EXISTS `user_comment` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    dog_id INT NOT NULL,
    `user_comment` VARCHAR(250) NOT NULL,
    user_comment_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (dog_id)
        REFERENCES dog (id),
    FOREIGN KEY (user_id)
        REFERENCES user (id)
);

CREATE TABLE IF NOT EXISTS `favourite_dog` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    dog_id INT NOT NULL,
    favourite BOOLEAN NOT NULL DEFAULT 1,
    FOREIGN KEY (dog_id)
        REFERENCES dog (id),
    FOREIGN KEY (user_id)
        REFERENCES user (id)
);