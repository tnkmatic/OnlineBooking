CREATE TABLE MEMERS (
    MEMBER_ID       varchar(20) NOT NULL,
    PASSWORD        varchar(256) DEFAULT NULL,
    FIRST_NAME      varchar(20) NOT NULL,
    LAST_NAME       varchar(20) NOT NULL,
    FIRST_NAME_KANA varchar(20) NOT NULL,
    LAST_NAME_KANA  varchar(20) NOT NULL,
    BIRTHDAY        date  DEFAULT NULL,
    SKYPE_ID        varchar(64) DEFAULT NULL,
    TEL             varchar(13) DEFAULT NULL,
    EMAIL           varchar(256) DEFAULT NULL,
    POSTAL_CD       varchar(7) DEFAULT NULL,
    ADDRESS1        varchar(4) DEFAULT NULL,
    ADDRESS2        varchar(20) DEFAULT NULL,
    ADDRESS3        varchar(100) DEFAULT NULL,
    ADDRESS4        varchar(100) DEFAULT NULL,
  PRIMARY KEY (MEMBER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;