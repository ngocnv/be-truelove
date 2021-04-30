#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER trueloveadmin WITH CREATEDB REPLICATION PASSWORD 'truelove@M1e0X210A221N';
    CREATE DATABASE "truelove" WITH OWNER = trueloveadmin ENCODING='UTF8' TABLESPACE = pg_default CONNECTION LIMIT = -1 ;
    GRANT ALL PRIVILEGES ON DATABASE truelove TO trueloveadmin;
    create extension pgcrypto schema pg_catalog;
    create schema trueloveapp;
EOSQL
