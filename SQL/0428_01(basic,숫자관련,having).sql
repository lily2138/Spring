-- 1. 문자관련 함수 : concat(), substr()
select concat(ename,' is a ', job) Message
FROM emp;

select ename, substr(hiredate, 1,4) 년도
from emp;
select ename, substr(hiredate, 6,2) 입사월
from emp;
select ename, substr(hiredate, 9,2) 입사일
from emp;

select ename, year(hiredate)년도, month(hiredate)
from emp;

-- 2. 숫자관련함수 : abs(), mod(분자, 분모), round(), ceiling(), floor(), truncate()
-- BLAKE 와 SMITH의 월급의 차이를 검색
select distinct abs((select sal from emp where ename="SMITH") - (select sal from emp where ename="BLAKE")) 월급차이
from emp;

-- 사원번호가 홀수인 사원의 정보를 검색... mod()
select empno, ename
from emp
where mod(empno,2)=1;

-- 업무가 salesman인 모든 사원에 대해서 comm에 대한 급여 비율의 나머지를 검색하세요
select ename, sal, comm, mod(sal, comm)
from emp
where job = 'salesman';

-- round(), ceiling(), floor(), truncate()
select round(45.923,2);  -- 소수점 세번째자리에서 반올림해서 두번째자리까지 나타낸다.
select round(45.923); -- 자리수 지정안하며 소수 첫쨰자리에서 반올림해서 정수만 나온다. 
select round(45.923,-1); -- .을 중심으로 일의자리에서 반올림한다 그래서 50이 된다. 

select floor(45.923,2); -- 에러가난다 floor는 자리수 지정할 수 없음
select floor(45.923); -- 정수까지 나타남. 버림. 

select truncate(45.923,2); -- 두번쨰짜리까지 나타낸다. 버림
select truncate(45.923); -- 자릿수를 지정안하면 에러난다. 

-- 3. 날짜관련함수 : NOW, SYSDATE, CURDATE, current_time
select NOW();
select SYSDATE();
select CURDATE();
select current_time();

-- 막내 오세훈이 오늘까지 살아온 일수를 구하세요. (안되는 코드)
-- select (curdate() - date('1997-06-19')) 살아온날;
-- select (curdate() - str_to_date('1997-06-19','%Y-%m-%d')) 살아온날;

-- 막내 오세훈이 오늘까지 살아온 일수를 구하세요.
select datediff(curdate(),'1997-06-19') 살아온날;


-- emp테이블에서 모든 사원들이 지금까지 근무한 일수 
select ename, hiredate, datediff(curdate(),hiredate) 근무일수
from emp;

-- emp테이블에서 모든 사원들이 지금까지 근무한 weeks
select ename, hiredate, floor(datediff(curdate(),hiredate)/7) Weeks
from emp;

-- 오늘부터 그이를 만난지 100일 째 되는 날을 검색 
select DATE_ADD(curdate(),INTERVAL 100 DAY);

-- 날짜 - 날짜 = 일수
-- 날짜 + 숫자 = 날짜 | 날짜 - 숫자 = 날짜 


-- 4. 그룹함수 : COUNT(), SUM(), AVG(), MAX(), MIN()
select COUNT(*) From emp; -- 14
select COUNT(-1) From emp; -- 14

select COUNT(empno) From emp;  -- 14
select COUNT(MGR) From emp;  -- 13 --->그룹함수에서 NULL값은 계산안된다

select min(hiredate) 가장빠른입사일, max(hiredate) 가장최근입사일
from emp;

select sum(sal) 사원총급여 from emp;
select round(avg(sal)) 사원총평균급여 from emp;

-- 업무가 manager 인 사원의 평균급여를 검색
-- 모든 사원의 보너스의 평균을 검색
-- 사원 테이블에서 모든 부서의 갯수를 출력

select round(avg(sal)) manager평균급여 
from emp
where job='manager';

select round(avg(ifnull(comm,0))) 보너스평균
from emp;

select count(distinct(deptno)) 부서갯수
from emp;

-- 부서번호가 10번이거나 20번인 사원의 인원수를 검색하세요 
select count(deptno)
from emp
where deptno=10 or deptno=20; 

-- 부서번호가 10번이 아니고 20번이 아닌 사원의 인원수를 검색하세요 
select count(deptno)
from emp
where deptno != 10 and deptno !=20;

-- 사원번호가 7369번이거나 7521이거나 7876인 사람을검색하세요
select * from emp
where empno= 7369 or empno = 7521 or empno = 7876; 

select counT(DEPTNO) from emp where deptno in(10,20);
select * from emp where deptno in(7369, 7521, 7876);

select counT(DEPTNO) from emp where deptno != 10 and deptno !=20;
select * from emp where deptno not in(10,20);

-- 각 부서의 평균급여를 검색 ... avg()
-- 그룹함수에 적용되지 않은 컬럼이 select 절에 나열되면 반드시 group by 절 뒤에 명시해줘야한다. 
select deptno, avg(sal) from emp;

select deptno, avg(sal) from emp group by deptno ;
select deptno, sum(sal) from emp group by deptno ;


-- 입사년도별 사람의 인원수를 출럭 .... count()
select Year(hiredate) 입사년도, count(*) 인원수 from emp group by year(HIREDATE);
select Year(hiredate) 입사년도, count(*) 인원수 from emp group by 입사년도;


-- 부서별 평균급여를 구하는데 20번 부서는 제외하고 구하세요
select deptno, round(avg(sal)) 평균급여
from emp
where deptno != 20 
group by deptno
order by deptno;


-- 부서별 평균급여가 2000달러 이상인 부서의 부서번호와 평균급여를 구하세요.
-- where 절에 group 함수 못쓴다. 
-- 아래 함수는 못쓴다. having절로 해야한다.
select deptno, round(avg(sal)) 평균급여
from emp
where round(avg(sal))>=2000
group by deptno
order by deptno;

-- having절 ===> where 절이랑 순서도 다르다. 
select deptno, round(avg(sal)) 평균급여
from emp
group by deptno
having round(avg(sal))>=2000
order by deptno;

-- 부서별 평균급여가 2000달러 이상인 부서의 부서번호와 평균급여를 구하세요.
-- 이 때, 단 10번 부서는 제외하세요
select deptno, round(avg(sal)) 평균급여
from emp
where deptno != 10
group by deptno
having round(avg(sal))>=2000
order by deptno;


