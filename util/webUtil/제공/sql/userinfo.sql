
CREATE TABLE USERINFO ( 
	userId			varchar(30)		primary key, 
	password		varchar(30)		NOT NULL,
	name			varchar(30)		NOT NULL,
	email			varchar(100)
);

INSERT INTO USERINFO VALUES('admin', 'admin', '������', 'admin@encore.com');
INSERT INTO USERINFO VALUES('java', 'java', '�ڹ�����', 'java@encore.com');

commit;