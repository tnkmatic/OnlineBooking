-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema onlinebooking
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema onlinebooking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `onlinebooking` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `MEMBER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MEMBER` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `MEMBER` (
  `MEMBER_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'メンバーID',
  `LOGIN_ID` VARCHAR(20) NOT NULL COMMENT 'ログインID',
  `LOGIN_PASSWORD` VARCHAR(256) NOT NULL COMMENT 'ログインパスワード',
  `LAST_NAME` VARCHAR(20) NOT NULL COMMENT '氏名（姓）',
  `FIRST_NAME` VARCHAR(20) NOT NULL COMMENT '氏名（名）',
  `LAST_NAME_KANA` VARCHAR(40) NOT NULL COMMENT '氏名カナ（姓）',
  `FIRST_NAME_KANA` VARCHAR(40) NOT NULL COMMENT '氏名カナ（名）',
  `GENDER` CHAR(1) NULL COMMENT '性別（将来用）',
  `BIRTHDAY` DATE NOT NULL COMMENT '誕生日',
  `SKYPE_ID` VARCHAR(64) NOT NULL COMMENT 'スカイプID',
  `CONTACT_WAY_KBN` CHAR(1) NOT NULL COMMENT '連絡方法区分',
  `TEL` VARCHAR(13) NULL COMMENT '電話番号',
  `EMAIL` VARCHAR(256) NULL COMMENT 'メールアドレス',
  `POSTAL_CD` VARCHAR(7) NOT NULL COMMENT '郵便番号',
  `PREF_NAME` VARCHAR(4) NOT NULL COMMENT '都道府県名',
  `CITY_NAME` VARCHAR(20) NOT NULL,
  `ADDRESS_DETAIL_NAME` VARCHAR(100) NOT NULL COMMENT '住所詳細名',
  `BUILDING_NAME` VARCHAR(100) NULL COMMENT '建物名',
  PRIMARY KEY (`MEMBER_ID`))
ENGINE = InnoDB
COMMENT = 'メンバー';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `MEMBER_STUDENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MEMBER_STUDENT` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `MEMBER_STUDENT` (
  `MEMBER_ID` INT NOT NULL COMMENT 'メンバーID',
  PRIMARY KEY (`MEMBER_ID`))
ENGINE = InnoDB
COMMENT = '生徒';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `MST_EMPLOY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MST_EMPLOY` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `MST_EMPLOY` (
  `EMPLOY_KBN` CHAR(1) NOT NULL COMMENT '雇用形態区分',
  `EMPLOY_NAME` VARCHAR(20) NULL COMMENT '雇用形態名',
  PRIMARY KEY (`EMPLOY_KBN`))
ENGINE = InnoDB
COMMENT = '雇用形態マスタ';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `MEMBER_TEACHER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MEMBER_TEACHER` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `MEMBER_TEACHER` (
  `MEMBER_ID` INT NOT NULL COMMENT 'メンバーID',
  `EMPLOY_KBN` CHAR(1) NOT NULL COMMENT '雇用形態区分',
  `EMPLOY_YMD_FROM` DATE NOT NULL COMMENT '雇用期間FROM',
  `EMPLOY_YMD_TO` DATE NOT NULL COMMENT '雇用期間TO',
  PRIMARY KEY (`MEMBER_ID`))
ENGINE = InnoDB
COMMENT = '講師';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `MST_COURSE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MST_COURSE` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `MST_COURSE` (
  `COURSE_ID` SMALLINT NOT NULL COMMENT 'コースID',
  `COURSE_NAME` VARCHAR(45) NULL COMMENT 'コース名',
  PRIMARY KEY (`COURSE_ID`))
ENGINE = InnoDB
COMMENT = 'コースマスタ';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `R_MEMBER_STUDENT_COURSE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `R_MEMBER_STUDENT_COURSE` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `R_MEMBER_STUDENT_COURSE` (
  `MEMBER_ID` INT NOT NULL COMMENT 'メンバーID',
  `COURSE_ID` SMALLINT NOT NULL COMMENT 'コースID',
  `PRICE_PER_HOUR` INT NOT NULL COMMENT '単価（時間単位）',
  PRIMARY KEY (`MEMBER_ID`, `COURSE_ID`, `PRICE_PER_HOUR`))
ENGINE = InnoDB
COMMENT = '生徒コース関連';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `R_MEMBER_TEACHER_COURSE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `R_MEMBER_TEACHER_COURSE` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `R_MEMBER_TEACHER_COURSE` (
  `MEMBER_ID` INT NOT NULL COMMENT 'メンバーID',
  `COURSE_ID` SMALLINT NOT NULL COMMENT 'コースID',
  `SALARY_PER_HOUR` INT NOT NULL COMMENT '報酬（時間単位）',
  PRIMARY KEY (`MEMBER_ID`, `COURSE_ID`))
ENGINE = InnoDB
COMMENT = '講師スケジュール関連';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `MEMBER_TEACHER_SCHEDULE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MEMBER_TEACHER_SCHEDULE` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `MEMBER_TEACHER_SCHEDULE` (
  `MEMBER_ID` INT NOT NULL COMMENT 'メンバーID',
  `SCHEDULE_SEQ` INT NOT NULL COMMENT 'スケジュール連番',
  `DAY_OF_WEEK_KBN` CHAR(1) NOT NULL COMMENT '曜日区分',
  `LESSON_TIME_FROM` CHAR(4) NOT NULL COMMENT '授業可能時刻FROM',
  `LESSON_TIME_TO` CHAR(4) NOT NULL COMMENT '授業可能時刻TO',
  PRIMARY KEY (`SCHEDULE_SEQ`))
ENGINE = InnoDB
COMMENT = '講師スケジュール';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `MST_BUSINESS_HOURS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MST_BUSINESS_HOURS` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `MST_BUSINESS_HOURS` (
  `BUSINESS_HOURS_FROM` CHAR(4) NOT NULL COMMENT '営業時間FROM',
  `BUSINESS_HOURS_TO` CHAR(4) NOT NULL COMMENT '営業時間TO',
  PRIMARY KEY (`BUSINESS_HOURS_FROM`, `BUSINESS_HOURS_TO`))
ENGINE = InnoDB
COMMENT = '営業時間マスタ';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `MST_LESSON_TIMESPACE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MST_LESSON_TIMESPACE` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `MST_LESSON_TIMESPACE` (
  `LESSON_TIMESPACE` SMALLINT NOT NULL COMMENT '授業時間間隔',
  PRIMARY KEY (`LESSON_TIMESPACE`))
ENGINE = InnoDB
COMMENT = '授業時間間隔マスタ';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `TRN_RESERVE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TRN_RESERVE` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `TRN_RESERVE` (
  `RESERVE_ID` INT NOT NULL COMMENT '予約ID',
  `TEACHER_MEMBER_ID` INT NOT NULL COMMENT 'メンバーID（講師）',
  `COURSE_ID` INT NOT NULL COMMENT 'コースID',
  `STUDENT_MEMBER_ID` INT NULL COMMENT 'メンバーID（生徒）',
  `RESERVE_DATE` DATE NULL COMMENT '予約日時',
  `INS_DATE` DATE NOT NULL COMMENT 'レコード作成日時',
  PRIMARY KEY (`RESERVE_ID`, `TEACHER_MEMBER_ID`, `COURSE_ID`))
ENGINE = InnoDB
COMMENT = '予約トラン';

SHOW WARNINGS;
USE `onlinebooking` ;

-- -----------------------------------------------------
-- Table `MEMBER_GROUP`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MEMBER_GROUP` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `MEMBER_GROUP` (
  `MEMBER_KBN` CHAR(1) NOT NULL COMMENT '会員グループID',
  `MEMBER_KBN_NAME` VARCHAR(20) NOT NULL COMMENT '会員グループ名',
  PRIMARY KEY (`MEMBER_KBN`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'メンバーグループマスタ';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `R_MEMBER_GROUP`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `R_MEMBER_GROUP` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `R_MEMBER_GROUP` (
  `MEMBER_MEMBER_ID` INT NOT NULL,
  `MEMBER_KBN` CHAR(1) NOT NULL,
  PRIMARY KEY (`MEMBER_MEMBER_ID`, `MEMBER_KBN`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'メンバーグループ関連';

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
