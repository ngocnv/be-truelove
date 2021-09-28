
SET search_path to trueloveapp;


create table sequence_define (
  sequence_define_id uuid default gen_random_uuid() not null
  , seq_code character varying(20)
  , seq_description character varying(200)
  , seq_init_value bigint
  , seq_cache_size bigint
  , seq_length bigint
  , seq_max_value bigint
  , seq_build_ind character varying(1)
  , primary key (sequence_define_id)
);

create table sequence_make (
  sequence_make_id uuid default gen_random_uuid() not null
  , sort_order integer
  , begin_index bigint
  , fill_mode character varying(20)
  , fill_value character varying(100)
  , seq_category character varying(100)
  , trim_length integer
  , data_create_time timestamp(6) without time zone
  , data_create_user character varying(100)
  , data_update_time timestamp(6) without time zone
  , data_update_user character varying(100)
  , seq_code character varying(30)
  , recognition character varying(10)
  , primary key (sequence_make_id)
);

create table sequence_track (
  sequence_track_id uuid default gen_random_uuid() not null
  , seq_code character varying(20)
  , seq_segment character varying(20)
  , seq_description character varying(200)
  , seq_no bigint
  , primary key (sequence_track_id)
);


insert into sequence_define(sequence_define_id,seq_code,seq_description,seq_init_value,seq_cache_size,seq_length,seq_max_value,seq_build_ind) values ('{436691e0-a809-4ccb-9239-caebd24343a8}','USERCODE','USER CODE',1,10,10,999999,'Y');
insert into sequence_make(sequence_make_id,sort_order,begin_index,fill_mode,fill_value,seq_category,trim_length,data_create_time,data_create_user,data_update_time,data_update_user,seq_code,recognition) values ('{436691e0-a809-4ccb-9239-caebd2434123}',1,1,'R','0','A',4,null,null,null,null,'USERCODE','USR');
insert into sequence_make(sequence_make_id,sort_order,begin_index,fill_mode,fill_value,seq_category,trim_length,data_create_time,data_create_user,data_update_time,data_update_user,seq_code,recognition) values ('{436691e0-a809-4ccb-9239-caebd24343a8}',2,1,'L','0','B',6,null,null,null,null,'USERCODE',null);