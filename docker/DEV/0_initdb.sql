CREATE DATABASE IF NOT EXISTS `BOOK_API_DATA`;
USE `BOOK_API_DATA`;

CREATE TABLE IF NOT EXISTS `Book` (
    `id` int(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `pageCount` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `Index_name` (`name`)
    ) ENGINE=InnoDB AUTO_INCREMENT=235 DEFAULT CHARSET=utf8;

CREATE TABLE `Author` (
     `id` INT(20) NOT NULL AUTO_INCREMENT,
     `firstName` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
     `lastName` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
     `starRating` INT(20) NULL DEFAULT NULL,
     `bookId` INT(20) NULL DEFAULT NULL,
     PRIMARY KEY (`id`) USING BTREE,
     UNIQUE INDEX `Index_name` (`firstName`) USING BTREE,
     INDEX `FK_Author_Book` (`bookId`) USING BTREE,
     CONSTRAINT `FK_Author_Book` FOREIGN KEY (`bookId`) REFERENCES `BOOK_API_DATA`.`Book` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
    COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=235
;

CREATE TABLE `Design` (
	`id` INT(11) NOT NULL,
	`category` VARCHAR(255) NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`colour` VARCHAR(255) NULL DEFAULT '0' COLLATE 'latin1_swedish_ci',
	`basedMovie` VARCHAR(255) NULL DEFAULT '0' COLLATE 'latin1_swedish_ci',
	`audioBook` VARCHAR(255) NULL DEFAULT '0' COLLATE 'latin1_swedish_ci',
	INDEX `FK1_book_design` (`id`) USING BTREE,
	CONSTRAINT `FK1_book_design` FOREIGN KEY (`id`) REFERENCES `BOOK_API_DATA`.`Book` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;




INSERT INTO `Book` (`id`, `name`, `pageCount`) VALUES (1, 'the golden ticket', '255');
INSERT INTO `Book` (`id`, `name`, `pageCount`) VALUES (2, 'coding game', '300');
INSERT INTO `Book` (`id`, `name`, `pageCount`) VALUES (3, 'Java world', '200');
INSERT INTO `Book` (`id`, `name`, `pageCount`) VALUES (4, 'Intro to GraphQl', '150');

INSERT INTO `Author` (`id`, `firstName`, `LastName`,`starRating`, `bookId`) VALUES (4, 'Brendon', 'Bouchard',4, 1);
INSERT INTO `Author` (`id`, `firstName`, `LastName`,`starRating`, `bookId`) VALUES (5, 'John', 'Doe',3, 2);
INSERT INTO `Author` (`id`, `firstName`, `LastName`,`starRating`, `bookId`) VALUES (6, 'Johnny', 'Doe',2, 4);
INSERT INTO `Author` (`id`, `firstName`, `LastName`,`starRating`, `bookId`) VALUES (7, 'Brian', 'Williams',4, 3);
INSERT INTO `Author` (`id`, `firstName`, `LastName`,`starRating`, `bookId`) VALUES (8, 'Brandy', 'Smith',5, 2);


INSERT INTO `BOOK_API_DATA`.`Design` (`id`, `category`, `colour`, `basedMovie`, `audioBook`) VALUES (1, 'fiction', 'yes', 'no', 'in planning'),
(2, 'educational', 'few pages', 'no', 'no'),
(3, 'educational', 'no', 'no', 'few chapters'),
(4, 'educational', 'no', 'no', 'no');
