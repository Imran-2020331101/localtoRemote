create database GymWorld;

use GymWorld;

create table ADMIN(username varchar(10) primary key
                  ,password varchar(20) not null );

create table manager(Manager_Name varchar(20) PRIMARY KEY
                    ,Manager_NID varchar(20) not null
                    ,Address varchar(100)
                    ,JoiningDate DATE not null);

create table MEMBER(
    Member_ID int primary key auto_increment
                   ,Name varchar(20) not null
                   ,Phone varchar(11) not null
                   ,Address varchar(20)
                   ,Profession varchar(20)
                   ,DOB DATE not null
                   ,Active bool default FALSE
                   ,Membership varchar(10) not null
                   ,Photo varchar(500)
                   ,Due int default null
);

create table payments(
    Transaction_ID int primary key auto_increment
                        ,Member_ID int not null
                        ,MangerName varchar(20) not null
                        ,Date DATE not null
                        ,Amount int not null
                        ,Transaction_type varchar(10) not null
                        ,foreign key (MangerName) references manager(Manager_Name)
                        ,foreign key (Member_ID) references member(Member_ID)
);

insert into ADMIN(username,password) values ('GYM WORLD','12345');