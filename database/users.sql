
SET search_path to trueloveapp;

CREATE TABLE Users (
	user_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
	username VARCHAR(30) NOT NULL,
	fullname VARCHAR(100) NOT NULL,
	email_address VARCHAR(100) NOT NULL,
	mobile VARCHAR(20) NOT NULL,
	password VARCHAR(100) NOT NULL,
	dating_type VARCHAR(10) NOT NULL,
	last_session TIMESTAMP,
	language_code VARCHAR(10),
	birthday VARCHAR(10),
	gender VARCHAR(10),
	avatar VARCHAR(100),
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP,
)