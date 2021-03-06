----SEQUENCES----

CREATE SEQUENCE SQ_USER;
CREATE SEQUENCE SQ_PARTICIPANT;
CREATE SEQUENCE SQ_TEST;
CREATE SEQUENCE SQ_TEST_RESULT;
CREATE SEQUENCE SQ_OVERALL_MARKS;
SELECT setval('SQ_USER', COALESCE((SELECT MAX(U_ID)+1 FROM U_USER), 1), false);
SELECT setval('SQ_PARTICIPANT', COALESCE((SELECT MAX(P_ID)+1 FROM PARTICIPANT), 1), false);
SELECT setval('SQ_TEST', COALESCE((SELECT MAX(TEST_ID)+1 FROM TEST), 1), false);
SELECT setval('SQ_OVERALL_MARKS', COALESCE((SELECT MAX(OM_ID)+1 FROM OVERALL_MARKS), 1), false);
SELECT setval('SQ_TEST_RESULT', COALESCE((SELECT MAX(TR_ID)+1 FROM TEST_RESULT), 1), false);

----TABLES----

CREATE TABLE U_USER (

U_ID          BIGINT PRIMARY KEY NOT NULL,
IDENTITY_NO   VARCHAR(100)  NOT NULL,
U_FULLNAME    VARCHAR(200) NOT NULL,
U_PASSWORD    VARCHAR(200) NOT NULL,
U_EMAIL       VARCHAR(200) NULL,
U_PHONE       VARCHAR(200) NULL,
U_TYPE        INT DEFAULT 0 NOT NULL

);

CREATE TABLE PARTICIPANT (

P_ID BIGINT PRIMARY KEY NOT NULL ,
P_BODY_NO BIGINT NULL,
P_FULLNAME VARCHAR(200) NOT NULL,
P_TURN_NO BIGINT NOT NULL,
P_NRIC_NO VARCHAR(14),
P_AGE INT NOT NULL,
P_GENDER CHAR(1) NOT NULL,
P_HEIGHT DECIMAL NOT NULL,
P_WEIGHT DECIMAL NOT NULL

);

-- ALTER  TABLE PARTICIPANT
-- ALTER COLUMN P_NRIC_NO TYPE VARCHAR(14);

CREATE TABLE TEST (

TEST_ID BIGINT PRIMARY KEY NOT NULL ,
TEST_NAME VARCHAR(120) NOT NULL

);

CREATE TABLE TEST_RESULT (

TR_ID BIGINT PRIMARY KEY NOT NULL,
P_ID BIGINT REFERENCES PARTICIPANT(P_ID),
TEST_ID BIGINT REFERENCES TEST(TEST_ID),
MARK VARCHAR (10) NOT NULL,
SCORE INT NOT NULL

);

CREATE TABLE OVERALL_MARKS (

OM_ID BIGINT PRIMARY KEY NOT NULL,
P_ID BIGINT REFERENCES PARTICIPANT(P_ID),
AWARD_TYPE VARCHAR(120) NOT NULL,
TOTAL_MARK BIGINT NOT NULL

);