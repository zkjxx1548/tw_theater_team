CREATE TABLE movies(
    id INT NOT NULL,
    alt VARCHAR(255) NOT NULL,
    year YEAR NOT NULL,
    title VARCHAR(100) NOT NULL,
    rating FLOAT NOT NULL,
    origin_title VARCHAR(100) NOT NULL,
    directors VARCHAR(100) NOT NULL,
    casts VARCHAR(100) NOT NULL,
    genres VARCHAR(100) NOT NULL,
    image VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
)ENGINE = InnoDB, CHARSET = utf8mb4;