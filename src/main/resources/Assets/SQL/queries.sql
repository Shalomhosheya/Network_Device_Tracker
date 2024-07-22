create database DNS_Database;
       use DNS_Database;
           create table Registeration(
               username varchar(100),
               passowrd varchar(100),
               email varchar(200),
               date date,
               Nic varchar(100)primary key
           );