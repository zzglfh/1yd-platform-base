DROP TABLE user IF EXISTS;

CREATE TABLE user (
  id         INTEGER IDENTITY PRIMARY KEY,
  account VARCHAR(30),
  password VARCHAR(30),
  mobile VARCHAR(30),
  email  VARCHAR(30),
  gender  VARCHAR(10),
  creation_time  DATE,
  modification_time  DATE,
  last_login_time  DATE,
);
CREATE INDEX user_account ON user (account);
