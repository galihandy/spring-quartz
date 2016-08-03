CREATE TABLE users (
    id integer NOT NULL,
    email character varying(255)
);

CREATE TABLE profiles (
    id integer NOT NULL,
    name character varying(255),
    description character varying(255),
    user_id integer NOT NULL
);