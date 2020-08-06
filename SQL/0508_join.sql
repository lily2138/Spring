-- JOIN----------------

select * from emp;
select Distinct deptno from emp;
select * from dept;

-- 특정사원이 소속된 부서의 정보의 정보를 검색(사원의 정보 + 부서의 정보)
/*
Cartesian Product
단순 데이타의 곱으로 결과를 산출하는 방식 
14 X 4 = 56

Cartesian Product가 도출되는 경우 
1) 조인조건을 안줬거나 
2) 조인조건을 잘못줬거나 

JOIN 조건 부여하는 방법
1) WHERE 절을 이용해서 각각 테이블의 공통의 컬럼을 명시한다 
2) WHERE emp.deptno=dept.deptno 

*/

select * from emp, dept;

-- 1) 오류는 없지만 안좋은 코드다.  >>> 컬럼명을 일일히 명시해야한다... 불필요한 컬럼이 출력되는 것을 방지한다. 
select * from emp, dept
where emp.deptno = dept.deptno ;

-- 2) 에러난다 >>> deptno 칼럼이 어느 테이블에 있는지 모호... 컬럼명 앞에 table alias를 부여 한다 
select empno, ename, sal, deptno, dname, loc
from emp, dept 
where emp.deptno = dept.deptno; 

-- 3) 컬럼명 앞에 테이블을 일일히 붙이는 거이 넘 번거롭다.
select emp.empno, emp.ename, emp.sal, emp.deptno, dept.dname, dept.loc
from emp, dept 
where emp.deptno = dept.deptno; 

-- 4)
select e.empno, e.ename, e.sal, e.deptno, d.dname, d.loc
from emp e, dept d 
where e.deptno = d.deptno; 

-- 사원의 이름, 급여, 부서번호, 부서명을 검색. 단 급여가 2000 이상이고 30번 부서에 한해서만 검색 
-- where 절에서 조인조건과 함께 비조인 조건을 사용한다. 
select e.ename, e.sal, e.deptno, d.dname
from emp e, dept d 
where e.deptno = d.deptno
and
e.sal>=2000
and 
e.deptno = 30;

-- SELF JOIN
select empno, ename, mgr from emp where ename='BLAKE' ;
select empno, ename from emp where empno = 7839;

-- BLAKE라는 사원의 상사의 이름을 검색... 사원번호, 사원이름, 상사번호, 상사이름 

-- 특정사원의 상사의 이름을 검색
-- 1)
select empno, ename, mgr from emp; -- 해당 사원의 상사번호를 검색 
select empno, ename from emp; -- 위의 상사번호가 사원번호인 사원의 이름을 검색 

-- 2)
select * from (select empno, ename, mgr from emp) e,
(select empno, ename from emp) m;

-- 3)
select * from (select empno, ename, mgr from emp) e,
(select empno, ename from emp) m
where e.mgr = m.empno;

-- 4)
select e.empno 사원번호, e.ename 사원이름, m.ename 상사이름 
from (select empno, ename, mgr from emp) e,
(select empno, ename from emp) m
where e.mgr = m.empno;

-- 5)
select e.empno 사원번호, e.ename 사원이름, m.ename 상사이름 
from (select empno, ename, mgr from emp) e,
(select empno, ename from emp) m
where e.mgr = m.empno
and
e.ename='BLAKE';


-- OUTER JOIN
/*
	A,B 테이블을 조인할 경우, 조건에 맞지않는 데이타는 디스플레이 되지 않는데...
    이 경우도 디스플레이 하고 싶을때 outer join을 사용한다. 
    
    OUTER JOIN 종류
    1) LEFT OUTER JOIN  2) RIGHT OUTER JOIN   3) FULL OUTER JOIN
    (데이타가 어느쪽에 있는가에 따라서 종류의 이름이 정해짐)
    
*/

-- 사원의 이름, 부서번호, 부서이름을 검색 ...
select e.ename, e.deptno, d.dname
from emp e, dept d 
where e.deptno = d. deptno;

-- 1) 위 경우에 RIGHT OUTER JOIN을 사용 
-- 조인수행시 우측 테이블(DEPT)이 기준이 되어서 결과를 생산하도록 해준다 
select e.ename, e.deptno, d.dname
from emp e RIGHT OUTER JOIN dept d ON e.deptno = d.deptno; -- LEFT로도 변경해서 확인 

-- 특정사원의 상사의 이름을 검색... 13줄 검색 ... 
select concat(e.ename, '의 메니저는 ', m.ename, '입니다') Info
from emp e, emp m
where e.mgr = m.empno;

select concat(e.ename, '의 메니저는 ', m.ename, '입니다') Info
from emp e LEFT OUTER JOIN emp m
ON e.mgr = m.empno;

-- A 10, 20, 30 FULL OUTER JOIN B 10, 20, 40 ----> 10,20,30,40 도출됨
-- FULL OUTER JOIN 이 실행되지 않음으로 union 연산자를 mysql에서 사용해야 한다. 
/*
FULL OUTER JOIN을 실습할 수 있는 간단한 테이블을 만들고 예제를 풀어보도록 한다 
*/

create table outer1(sawonid int);
create table outer2(sawonid int);

insert into outer1 values(10);
insert into outer1 values(20);
insert into outer1 values(40);

insert into outer2 values(10);
insert into outer2 values(20);
insert into outer2 values(30);

select * from outer1;
select * from outer2;

-- FULL OUTER JOIN 사용
select sawonid from outer1
-- FULL OUTER JOIN  >>>> 에러남 
UNION 
select sawonid from outer2;




