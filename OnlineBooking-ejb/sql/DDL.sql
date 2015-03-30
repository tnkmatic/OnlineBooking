-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema onlinebooking
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `onlinebooking` ;

-- -----------------------------------------------------
-- Schema onlinebooking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `onlinebooking` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `onlinebooking` ;

-- -----------------------------------------------------
-- Table `member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `member` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `member` (
  `MEMBER_ID` VARCHAR(20) NOT NULL COMMENT '会員ID',
  `PASSWORD` VARCHAR(256) NULL COMMENT 'パスワード',
  `FIRST_NAME` VARCHAR(20) NOT NULL COMMENT '氏名（名）',
  `LAST_NAME` VARCHAR(20) NOT NULL COMMENT '氏名（姓）',
  `FIRST_NAME_KANA` VARCHAR(20) NOT NULL COMMENT '氏名カナ（名）',
  `LAST_NAME_KANA` VARCHAR(20) NOT NULL COMMENT '氏名カナ（姓）',
  `BIRTHDAY` DATE NULL COMMENT '誕生日',
  `SKYPE_ID` VARCHAR(64) NULL DEFAULT NULL COMMENT 'スカイプID',
  `TEL` VARCHAR(13) NULL COMMENT '電話番号',
  `EMAIL` VARCHAR(256) NULL DEFAULT NULL COMMENT 'メールアドレス',
  `LINE_KBN` CHAR(1) NULL,
  `POSTAL_CD` VARCHAR(7) NULL DEFAULT NULL COMMENT '郵便番号',
  `PREF_NAME` VARCHAR(4) NULL DEFAULT NULL COMMENT '都道府県名',
  `CITY_NAME` VARCHAR(20) NULL DEFAULT NULL COMMENT '市区町村名',
  `CHOME_NAME` VARCHAR(100) NULL DEFAULT NULL COMMENT '大字・丁目名',
  `BUILDING_NAME` VARCHAR(100) NULL DEFAULT NULL COMMENT '建物名',
  PRIMARY KEY (`MEMBER_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '会員マスタ';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `member_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `member_group` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `member_group` (
  `MEMBER_GROUP_ID` VARCHAR(20) NOT NULL COMMENT '会員グループID',
  `MEMBER_GROUP_NAME` VARCHAR(20) NOT NULL COMMENT '会員グループ名',
  PRIMARY KEY (`MEMBER_GROUP_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '会員グループマスタ';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `r_member_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `r_member_group` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `r_member_group` (
  `MEMBER_ID` VARCHAR(20) NOT NULL COMMENT '会員ID',
  `MEMBER_GROUP_ID` VARCHAR(20) NOT NULL COMMENT '会員グループID',
  PRIMARY KEY (`MEMBER_ID`, `MEMBER_GROUP_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '会員グループ関連';

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
