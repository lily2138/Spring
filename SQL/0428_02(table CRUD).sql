create table test01(
	num int auto_increment primary key,
    name varchar(20),
    age tinyint,
    height decimal(5,1),
    birthday datetime,
    hiredate date);
    
desc test01;   -- 컬럼의 타입과 제약사항 확인

-- 데이터 추가하기
Insert into test01 values('홍길동', 24, 179.5, now(), now());   -- 컬럼명하고 들어가는 값하고 매치가 안되서 에러난다

Insert into test01 (name, age, height, birthday, hiredate) values('홍길동', 24, 179.5, now(), now());
select * from test01;

Insert into test01 (name, age, height, birthday, hiredate) values('강호동', 21, 179.5, now(), now());
Insert into test01 (name, age, height, birthday, hiredate) values('이영자', 36, 169.5, now(), now());
Insert into test01 (name, age, height, birthday, hiredate) values('김준현', 49, 189.5, now(), now());

select * from test01;

-- 컬럼명 변경 : ALTER
ALTER TABLE test01 change birthday birthdate datetime;
desc test01;

-- 컬럼 데이타 타입 변경하기 : ALTER
alter table test01 change birthdate birthdate date;
desc test01;

select * from test01;

-- num이 3번인 데이타를 삭제
delete from test01 where num=3;
select * from test01;

-- num이 2번인 데이타의 키와 나이를 수정
-- 기본키는 update의 대상이 아니다.... 기본키를 제외한 나머지 컬럼들이 수정의 대상.
update test01 set height=183, age=45 where num=2;
select * from test01;

/*
delete from test01;  -- 데이터는 다 지워지지만 테이블의 구조는 남겨진다. >>> 그래서 똑같은 이름 테이블 생성하려고 해도 안된다. 바로 인서트하면 됨. 
truncate table test01;    -- 데이터는 다 지워지지만 테이블의 구조는 남겨진다. 
>>>>>>>>>>>>>>>> delete는 한 줄씩 지우고, truncate은 한꺼번에 지운다. (속도의 차이가 있다)
>>>>>>>>>>>>>>>> 또한 delete는 id의 숫자가 이어서 나온다. 

drop table test01; 
*/

/*
SQL
::
DM(Manupulation)L	-	insert, update, delete
DD(Define)L			-	create, drop, alter
*/ 
