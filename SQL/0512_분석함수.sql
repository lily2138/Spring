/*
MySQL 분석함수 
- 순위함수 : rank, dense_rank, row_number, ntile
- 집계함수(그룹함수) : sum, min, max, avg, count
- 기타함수 : lead, lag, first_value, last_value, ratio_to_report(mariadb 지원안됨)
*/

-- rank()
-- rank 함수는 order by 절을 포함한 쿼리문에서 특정한 항목에 대한 순위를 지정할 때 사용하는 함수 
SELECT empno, ename, deptno, sal,
rank() over(order by sal DESC) 급여순위
from emp;

-- dense_rank()
-- rank 함수와 흡사하지만, 동일한 순위를 하나의 건수로 취급하는 것이 차이점이다. 
SELECT empno, ename, deptno, sal,
dense_rank() over(order by sal DESC) 급여순위
from emp; 

-- ntile : 버킷단위로 나뉘어서 출력
SELECT empno, ename, deptno, sal,
ntile(5) over(order by sal DESC) 소득등급 
from emp;

-- row_number : 일련번호 출력
-- SELECT empno, ename, hiredate, row_number() from emp;  -- (X)
SELECT empno, ename, hiredate, row_number() over() from emp;  -- (O)
SELECT empno, ename, hiredate, row_number() over() Numbering from emp;  -- (O)
SELECT empno, ename, hiredate, row_number() over() Numbering from emp limit 2;  -- where numbering=2 안된다
SELECT empno, ename, hiredate, row_number() over(order by hiredate ASC) Numbering from emp;  -- 입사순으로 numbering된다 

-- sum()
select empno, ename, sal, hiredate, deptno, sum(sal) over() sumsal from emp;
select empno, ename, sal, hiredate, deptno, 
sum(sal) over() 총급여,
sum(sal) over(partition by deptno) 부서별총급여
from emp
order by 부서별총급여;

SELECT empno, ename, sal,
avg(sal) over(partition by job) 업무별평균급여, 
max(sal) over(partition by job) 업무별최대급여
from emp;





