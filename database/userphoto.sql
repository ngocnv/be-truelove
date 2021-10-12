
SET search_path to trueloveapp;
	
CREATE TABLE trueloveapp.user_photo (
	photo_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
	user_id UUID NOT NULL,
	photo_uri VARCHAR(1000) NOT NULL,
	description VARCHAR(1000),
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP
)
