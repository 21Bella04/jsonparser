DROP SCHEMA IF EXISTS `REDDITOS`;
CREATE SCHEMA `REDDITOS`;

-- create SUBREDDIT
CREATE TABLE REDDITOS.SUBREDDIT
(
    ID   varchar(255) NOT NULL UNIQUE,
    NAME varchar(255),
    PRIMARY KEY (ID)
);

-- create LINK
CREATE TABLE REDDITOS.LINK
(
    ID           varchar(255) NOT NULL UNIQUE,
    NAME         varchar(255),
    SUBREDDIT_FK varchar(255),
    PRIMARY KEY (ID),
    FOREIGN KEY (SUBREDDIT_FK) REFERENCES SUBREDDIT (ID)
);

-- create COMMENT
CREATE TABLE REDDITOS.COMMENT
(
    ID           int          NOT NULL AUTO_INCREMENT,
    PARENT_ID    varchar(255) NOT NULL,
    LINK_FK      varchar(255) NOT NULL,
    NAME         varchar(255) NOT NULL,
    AUTHOR       varchar(255) NOT NULL,
    BODY         text         NOT NULL,
    SUBREDDIT_FK varchar(255),
    SCORE        int          NOT NULL DEFAULT 0,
    CREATED_UTC  datetime(6)  NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (LINK_FK) REFERENCES LINK (ID),
    FOREIGN KEY (SUBREDDIT_FK) REFERENCES SUBREDDIT (ID)

);



SET FOREIGN_KEY_CHECKS = 0;
