CREATE TABLE users
(
  id       UUID PRIMARY KEY NOT NULL,
  username VARCHAR(255),
  password VARCHAR(255)
);

CREATE
UNIQUE
INDEX
users_username
ON
users
(
username
);

CREATE TABLE roles
(
  id   UUID PRIMARY KEY NOT NULL,
  name VARCHAR(255)
);

CREATE
UNIQUE
INDEX
roles_name
ON
roles
(
name
);

CREATE TABLE user_roles
(
  id      UUID PRIMARY KEY NOT NULL,
  user_id UUID,
  role_id UUID,
  CONSTRAINT user_id_id_fkey FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT role_id_id_fkey FOREIGN KEY (role_id) REFERENCES roles (id)
);
