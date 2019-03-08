DROP SCHEMA ffgkp;
CREATE DATABASE ffgkp;

USE ffgkp;


CREATE TABLE IF NOT EXISTS `users` (
  user_id     VARCHAR(255) NOT NULL,
  username    VARCHAR(1000),
  userpic     VARCHAR(1000),

  f_name      VARCHAR(100),
  l_name      VARCHAR(100),

  info        VARCHAR(10000),

  created     DATE,
  last_login  DATE,

  PRIMARY KEY (user_id)
) ENGINE=INNODB;


ALTER TABLE users CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `sessions` (
  id          VARCHAR(255) NOT NULL,
  session     VARCHAR(1000) NOT NULL,
  user_id     VARCHAR(255) NOT NULL,
  expired     TINYINT NOT NULL,

  PRIMARY KEY (id)
) ENGINE=INNODB;

ALTER TABLE sessions CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `messages` (
  id          BIGINT AUTO_INCREMENT NOT NULL,
  chat_id     BIGINT NOT NULL,
  value       VARCHAR(10000),

  PRIMARY KEY (id)
) ENGINE=INNODB;

ALTER TABLE messages CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `chats` (
  id          BIGINT AUTO_INCREMENT NOT NULL,
  u1          VARCHAR(255) NOT NULL,
  u2          VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=INNODB;

ALTER TABLE chats CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


ALTER DATABASE ffgkp
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_unicode_ci;
