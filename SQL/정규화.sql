create table companysawon (company varchar(20),address varchar(50),
phone varchar(35),sawon_name varchar(30),position varchar(30),
email varchar(50),hp varchar(20));

desc companysawon;

Insert Into companysawon VALUES('LG', '서울 강남구', '02-146-1994', '강호동', '부장', 'aaa@naver.com', '010-1469-9416');
Insert Into companysawon VALUES('KT', '경기도 분당', '031-146-1994', '이수근', '사원', 'bbb@naver.com', '010-9863-4356');
Insert Into companysawon VALUES('SKT', '부산 해운대', '051-146-1994', '이영자', '과장', 'ccc@naver.com', '010-1356-6348');

select * from companysawon;



create table company (company_id int primary key,
company varchar(20),address varchar(50),phone varchar(35));

desc company;

Insert into company VALUES(10, 'LG', '서울 강남구', '02-146-1994');
Insert into company VALUES(20, 'KT', '경기도 분당', '031-146-1994');
Insert into company VALUES(30, 'SKT', '부산 해운대', '051-146-1994');


select * from company;

create table sawon(company_id int(10),
		sawon_name varchar(20),
		position varchar(30),
		email varchar(30),
		hp varchar(30),
		foreign key(company_id) references company(company_id));
        
desc sawon;

INSERT INTO sawon (company_id, sawon_name, position,email,hp)VALUES (10, '피준범','과장','junbumpi@ssafy@com','010-2345-1122');
INSERT INTO sawon (company_id, sawon_name, position,email,hp)VALUES (10, '이새봄','대리','bom@ssafy@com','010-4329-3355');
INSERT INTO sawon (company_id, sawon_name, position,email,hp)VALUES (30, '김아름','대리','beauty@ssafy@com','010-9901-8232');

select * from sawon;

delete from sawon where sawon_name='피준범';

delete from company where company_id=10;  -- 자식을 가지는 부모테이블은 삭젝 안됨

DROP TABLE sawon;
create table sawon(company_id int(10),
		sawon_name varchar(20),
		position varchar(30),
		email varchar(30),
		hp varchar(30),
		foreign key(company_id) references company(company_id)
        on delete cascade);






create table shop(num int(5), sangpum varchar(30), color varchar(10), price int(10), ipgoday date);
create table client(num int(5), name varchar(10), age int(5), address varchar(20)); 

alter table shop add constraint pk_shop primary key(num);
alter table client add constraint pk_client primary key(num);

insert into shop values(111, '이어폰', '흰색', 12000, '2020-06-17');
insert into shop values(222, '마스크', '회색', 3000, '2020-06-18');

insert into client values(01, '강호동', 44, '여의도');
insert into client values(02, '이영자', 46, '서초동');


create table cart (shop_num int(5) not null,
		client_num int(5) not null,
		guipday date not null,
		cnt int(5) not null,
		constraint fk_shop foreign key(shop_num) references shop(num) on delete cascade,
		constraint fk_client foreign key(client_num) references client(num) on delete cascade);

insert into cart values(111, 01, '2020_06-16',3);

insert into cart values(222, 02, '2020_06-14',50);

select * from cart;
select * from shop;
select * from client;

delete from shop where num = 111;


-- join 사용해서 쿼리문 조회하기

-- 고객명 상품명 색상 갯수 가격 총금액 나이 주소
select ci.name "고객명", sh.sangpum "상품명", sh.color "색상", ca.cnt "갯수", sh.price "가격", sh.price*ca.cnt "총금액", ci.age "나이", ci.address "주소"
from shop sh, cart ca, client ci
where sh.num = ca.shop_num and ca.client_num = ci.num;

