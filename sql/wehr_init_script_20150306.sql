
CREATE DATABASE wehr DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE wehr;

CREATE TABLE wehr.wehr_company (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  code VARCHAR(10) NULL,
  name VARCHAR(100) NULL,
  PRIMARY KEY(id)
)
ENGINE=InnoDB;

CREATE TABLE wehr.wehr_department (
  id BIGINT NOT NULL AUTO_INCREMENT,
  wehr_department_id BIGINT NOT NULL,
  wehr_person_company_id BIGINT UNSIGNED NOT NULL,
  code VARCHAR(20) NULL,
  name VARCHAR(100) NULL,
  PRIMARY KEY(id),
  INDEX wehr_department_FKIndex1(wehr_person_company_id),
  INDEX wehr_department_FKIndex2(wehr_department_id)
)
ENGINE=InnoDB;

CREATE TABLE wehr.wehr_dept_has_emp (
  wehr_department_id BIGINT NOT NULL,
  wehr_employee_id BIGINT NOT NULL,
  INDEX Table_06_FKIndex1(wehr_employee_id),
  INDEX Table_06_FKIndex2(wehr_department_id)
)
ENGINE=InnoDB;

CREATE TABLE wehr.wehr_employee (
  id BIGINT NOT NULL AUTO_INCREMENT,
  wehr_person_company_id BIGINT UNSIGNED NOT NULL,
  wehr_person_id BIGINT UNSIGNED NOT NULL,
  code VARCHAR(20) NULL,
  PRIMARY KEY(id),
  INDEX wehr_employee_FKIndex1(wehr_person_company_id),
  INDEX wehr_employee_FKIndex2(wehr_person_id)
)
ENGINE=InnoDB;

CREATE TABLE wehr.wehr_person (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) NULL,
  tel VARCHAR(20) NULL,
  PRIMARY KEY(id)
)
ENGINE=InnoDB;

