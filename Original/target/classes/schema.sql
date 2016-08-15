DROP TABLE IF EXISTS word CASCADE;
DROP TABLE IF EXISTS memo CASCADE;
DROP TABLE IF EXISTS user CASCADE;

CREATE TABLE user(
	userID		int				PRIMARY KEY AUTO_INCREMENT,
	name		varchar(31)		NOT NULL,
	password	varchar(31)		NOT NULL,
	email		varchar(255)	NOT NULL UNIQUE,
	newDate		timestamp		default CURRENT_TIMESTAMP
);

CREATE TABLE word(
	wordID		int				PRIMARY KEY AUTO_INCREMENT,
	userID		int				NOT NULL,
	word		varchar(255)	NOT NULL,
	translation	text			NOT NULL,
	language	varchar(15)		NOT NULL,
	newDate		timestamp		default CURRENT_TIMESTAMP, 
	FOREIGN KEY(userID) REFERENCES user(userID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE memo(
	memoID		int				PRIMARY KEY AUTO_INCREMENT,
	userID		int				NOT NULL,
	memo		text			NOT NULL,
	language	varchar(15)		NOT NULL,
	newDate 	timestamp		default CURRENT_TIMESTAMP,
	FOREIGN KEY(userID) REFERENCES user(userID) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO user(name,password,email)				VALUES('a','a','a'); 
INSERT INTO word(userID,word,translation,language)	VALUES('1','a','a','English'); 
INSERT INTO memo(userID,memo,language)				VALUES('1','test','English'); 
