CREATE TABLE users (
    user_id int NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE permission (
    permission_id int NOT NULL AUTO_INCREMENT,
    permission_name varchar(255) NOT NULL,
    PRIMARY KEY (permission_id)
);

CREATE TABLE users_permission_map (
    user_id int NOT NULL,
    permission_id int NOT NULL
);