select * from customer;
select * from attraction;
select * from uselist;

drop database encoreland;


ALTER TABLE customer
RENAME COLUMN no TO customer_no;

ALTER TABLE attraction
RENAME COLUMN no TO attraction_no;

ALTER TABLE uselist
RENAME COLUMN no TO uselist_no;

select count(status) curr_person from uselist
where attraction_no = 1003
and status = 0;

SELECT count(age) FROM customer where age=19;

select l.attraction_no, a.name, a.limitage, a.maxperson, a.info  
from attraction a, (select u.attraction_no, count(u.attraction_no) Count from uselist u, customer c 
where u.customer_no = c.customer_no and c.sex= 'F' group by attraction_no order by Count desc) l
where l.attraction_no = a.attraction_no;

SELECT B.*, COUNT(*) cnt 
FROM uselist A INNER JOIN customer C ON A.customer_no = C.customer_no 
INNER JOIN Attraction B ON A.attraction_no =B.attraction_no 
WHERE C.age >= 10 and C.age < 20 GROUP BY A.customer_no ORDER BY cnt desc;



SELECT B.*, COUNT(*) cnt 
FROM uselist A INNER JOIN customer C ON A.customer_no = C.customer_no 
INNER JOIN Attraction B ON A.attraction_no =B.attraction_no 
WHERE C.age >= 10 and C.age < 20 GROUP BY A.customer_no ORDER BY cnt desc;












