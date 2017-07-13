/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 postgres=# CREATE USER hibernate;
postgres=# ALTER ROLE hibernate WITH CREATEDB;
postgres=# CREATE DATABASE hibernatetest OWNER hibernate;
ALTER USER hibernate WITH ENCRYPTED PASSWORD 'hibernate';
psql -d hibernatetest -U hibernate
 */

