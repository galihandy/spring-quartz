-- TABLE USERS
CREATE TABLE public.users
(
  id integer NOT NULL,
  email character varying(255),
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.users
  OWNER TO postgres;

-- TABLE PROFILES
CREATE TABLE public.profiles
(
  id integer NOT NULL,
  name character varying(255),
  description character varying(255),
  user_id integer NOT NULL,
  CONSTRAINT profiles_pkey PRIMARY KEY (id),
  CONSTRAINT profiles_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES public.users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.profiles
  OWNER TO postgres;

-- Index: public.fk_profiles_users_id

-- DROP INDEX public.fk_profiles_users_id;

CREATE INDEX fk_profiles_users_id
  ON public.profiles
  USING btree
  (user_id);