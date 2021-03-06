CREATE TABLE user_group (
  id INT AUTO_INCREMENT,
  name VARCHAR(255),
  PRIMARY KEY(id)
);

CREATE TABLE users (
  id BIGINT(20) AUTO_INCREMENT,
  username VARCHAR(255),
  email VARCHAR(255) UNIQUE,
  password VARCHAR(255),
  user_group_id int,
  PRIMARY KEY(id),
  FOREIGN KEY(user_group_id) REFERENCES user_group(id)
);

CREATE TABLE exercise (
  id INT AUTO_INCREMENT,
  title VARCHAR(255),
  description TEXT,
  PRIMARY KEY(id)
);

CREATE TABLE solution (
  id INT AUTO_INCREMENT,
  created DATETIME,
  updated DATETIME,
  description TEXT,
  exercise_id INT,
  users_id BIGINT(20),
  PRIMARY KEY(id),
  FOREIGN KEY(exercise_id) REFERENCES exercise(id),
  FOREIGN KEY(users_id) REFERENCES users(id)
);

