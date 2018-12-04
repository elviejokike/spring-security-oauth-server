CREATE TABLE users (
  id       UUID PRIMARY KEY NOT NULL,
  username VARCHAR(255),
  password VARCHAR(255)
);

CREATE UNIQUE INDEX users_username ON users (username);

CREATE TABLE roles (
  id   UUID PRIMARY KEY NOT NULL,
  name VARCHAR(255)
);

CREATE UNIQUE INDEX roles_name ON roles (name);

CREATE TABLE user_roles (
  id      UUID PRIMARY KEY NOT NULL,
  user_id UUID,
  role_id UUID,
  CONSTRAINT user_id_id_fkey FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT role_id_id_fkey FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE client_details (
  id            UUID PRIMARY KEY NOT NULL,
  client_id     VARCHAR(255),
  client_secret VARCHAR(255),
  resource_ids  VARCHAR(255),
  scope         VARCHAR(255),
  grant_types   VARCHAR(255),
  redirect_url  VARCHAR(255),
  authorities   VARCHAR(255),
  access_token_validity  INTEGER,
  refresh_token_validity INTEGER,
  description   VARCHAR(4096)
);

CREATE UNIQUE INDEX client_details_client_id ON client_details (client_id);