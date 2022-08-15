DROP TABLE IF EXISTS `dinosaur` CASCADE;
create table `dinosaur` (
	`id` INTEGER UNIQUE PRIMARY KEY AUTO_INCREMENT,
	`age` INTEGER,
	`dino_name` VARCHAR(255) NOT NULL, 
	`species` VARCHAR(255)
);
