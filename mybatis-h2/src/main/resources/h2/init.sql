DROP TABLE IF EXISTS bad_rent;
CREATE TABLE IF NOT EXISTS bad_rent (
	id serial PRIMARY KEY,
	address varchar(256) NOT NULL,
	rent_price double PRECISION NOT NULL,
	message varchar(1024) NOT NULL,
	longitude double PRECISION NOT NULL,
	latitude double PRECISION NOT NULL,
	submit_time bigint NOT NULL
);
CREATE INDEX IF NOT EXISTS idx_location ON bad_rent (longitude, latitude);

DROP TABLE IF EXISTS bad_rent_image;
CREATE TABLE IF NOT EXISTS bad_rent_image (
	id serial PRIMARY KEY,
	bad_rent_id integer NOT NULL,
	file_name varchar(128) NOT NULL,
	description varchar(256) NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_bad_rent_id ON bad_rent_image (bad_rent_id);
