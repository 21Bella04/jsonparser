DROP SCHEMA IF EXISTS `REDDITOS`;
CREATE SCHEMA `REDDITOS`;

-- create SUBREDDIT
CREATE TABLE REDDITOS.SUBREDDIT
(
    ID   varchar(255) NOT NULL,
    NAME varchar(255),
    PRIMARY KEY (ID)
);

-- create LINK
CREATE TABLE REDDITOS.LINK
(
    ID           varchar(255) NOT NULL,
    NAME         varchar(255),
    SUBREDDIT_FK varchar(255),
    PRIMARY KEY (ID)
);

-- create COMMENT
CREATE TABLE REDDITOS.COMMENT
(
    ID           int          NOT NULL AUTO_INCREMENT,
    PARENT_ID    varchar(255),
    LINK_FK      varchar(255),
    NAME         varchar(255),
    AUTHOR       varchar(255),
    BODY         text,
    SUBREDDIT_FK varchar(255),
    SCORE        int,
    CREATED_UTC  datetime(6),
    PRIMARY KEY (ID)

);

