##Department Values-- 
INSERT INTO SPRINGTABLERELATIONS.DEPARTMENT(department_name) VALUES 
	("Infrastructure"),
    ("Banking"),
    ("Construction"),
    ("Information Technology");

##Address
INSERT INTO SPRINGTABLERELATIONS.ADDRESS(COUNTRY,STATE,CITY,PIN_CODE, ADDRESS_LINE_ONE ,ADDRESS_LINE_TWO) VALUES
	('INDIA','KARNATAKA','BANGALORE',560049,'1ST STREET , COOK TOWN',''),
    ('INDIA','ANDHAR','HYDERABAD', 542121,'MAIN CITY , MAHAL ROAD',''),
	('INDIA','KARNATAKA','MYSORE',567334,'K R NAGAR ',''),
	('INDIA','MAHARASTRA','MUBAI',435556,' RECLAMATION BUS DEPOT',''),
    ('INDIA','MAHARASTRA','MUMBAI','345566','POWER TOWER',''),
    ('INDIA','KERALA','THAJAWOR',121222,'TEMPLE ROAD ',''),
    ('INDIA','KERALA','BAZAR ROAD',134590,'KOZIKOD 1ST STREET ',''),
    ('INDIA','MADHYA PRADESH' , 'SIRIDI' , 256788 , 'SAI BABA TEMPLE ROAD ,TOWN STREET','');
    
## EMPLOYEE
INSERT INTO SPRINGTABLERELATIONS.EMPLOYEE (FIRST_NAME,LAST_NAME,MIDDLE_NAME,GENDER,EMAIL,DOB,DEPARTMENT_ID,ADDRESS_ID) VALUES
 ('JOHN','ROI','','M','ABCS@YXV.COM',19990101,1,1),
('MICHEAL','RYE','','F','ABD@YXV.COM',19890101,2,2),
 ('DARRY','','HOPE','M','ABF@YXV.COM',19990101,3,3),
  ('SHRUTI','PRU','','F','ABG@YXV.COM',19870911,4,4),
   ('RODJER','KRI','','M','ABE@YXV.COM',19790101,2,5),
    ('KATTY','PERRY','','F','ABH@YXV.COM',19990101,3,6);

    
## Projects
INSERT INTO SPRINGTABLERELATIONS.PROJECT (TASK_NAME,DUE_DATE,STATUS) VALUES 
	('PWD ROAD DEVELOPEMENT', 20240910,'PROGRESS'),
    ('BANKING APPLICATION' , 20030911, 'COMPLETED'),
    ('CONSTRUCTION IBM' , 20300101, 'NEW'),
    ('METRO' , 20341010 , 'NEW');

## EMPLOYEE_PROJECT : Should be created by REST API
INSERT INTO SPRINGTABLERELATIONS.EMPLOYEE_PROJECTS VALUES 
   (1,3),
   (2,3),
   (3,3),
   (4,2),
   (5,2);