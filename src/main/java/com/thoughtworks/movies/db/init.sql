CREATE TABLE movies(
    id INT NOT NULL,
    rating FLOAT NOT NULL,
    title VARCHAR(100) NOT NULL,
    origin_title VARCHAR(100) NOT NULL,
    genres VARCHAR(100) NOT NULL,
    year YEAR NOT NULL,
    pub_dates VARCHAR(100) NOT NULL,
    image VARCHAR(255) NOT NULL,
    summary VARCHAR(255) NOT NULL,
    durations VARCHAR(100) NOT NULL,
    photo VARCHAR(1024) NOT NULL,
    album VARCHAR(100) NOT NULL,
    cast VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
)ENGINE = InnoDB, CHARSET = utf8mb4;