CREATE TABLE CATEGORY 
(
  ID NUMBER NOT NULL 
, NAME VARCHAR2(50) 
, DESCRIPTION VARCHAR2(50) 
, IMAGE_URL VARCHAR2(50) 
, IS_ACTIVE CHAR(1) 
, CONSTRAINT PK_CATEGORY_ID PRIMARY KEY 
  (
    ID 
  )
  ENABLE 
);