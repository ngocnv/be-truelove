 create schema trueloveapp;
SET search_path to trueloveapp;

CREATE TABLE trueloveapp.Users (
	user_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
	username VARCHAR(30) NOT NULL,
	fullname VARCHAR(100) NOT NULL,
	email_address VARCHAR(100) NOT NULL,
	mobile VARCHAR(20) NOT NULL,
	password VARCHAR(100) NOT NULL,
	dating_type VARCHAR(10) NOT NULL,
	last_session TIMESTAMP,
	language_code VARCHAR(10),
	birthdate VARCHAR(10),
	gender VARCHAR(10),
	avatar VARCHAR(100),
	keycloak_id VARCHAR(100),
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP
)

INSERT INTO "trueloveapp"."users" ("user_id", "username", "fullname", "email_address", "mobile", "password", "dating_type", "last_session", "language_code", "birthdate", "gender", "avatar", "created_date", "modified_date") VALUES
('0deacb4a-a8d9-11eb-bcbc-0242ac130002', 'ngocnguyen', 'Nguyễn Văn Ngọc', 'ngocnvtech@gmail.com', '0832648667', '7ff3dce7d43cfc96dd7e21b5a9a91688', 'provider', NULL, 'vn', '1991/01/31', 'male', NULL, '2021-04-29 11:02:18.880674', NULL);