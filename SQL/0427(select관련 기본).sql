select * FROM emp;
select * From dept;
/* 			[간단한 데이타 타입 정리]
--------------정수
tinyint		아주작은 범위의 정수			-128 ~ 127(0~255)
smallint	작은 범위의 정수			-32768 ~ 32768(0~65535)
int									40억사이의 범위 
decimal		고정소수 					전체자리수와 소수점 자리를 가진다.
			decimal(5,1)
--------------문자
char(3)		고정형
varchar(20)	문자수가 최대 n개인 문자열
text		문자수가 최대 65535개인 문자열alter

--------------날짜
date		년, 월, 일 
datetime	년, 월, 일, 시, 분, 초

*/

-- [1. Projection | Selection ]
-- Projection : 컬럼명을 지정해서 데이타를 가져오는 쿼리문

SELECT * FROM emp; 
SELECT empno, ename, job, deptno FROM emp; 

-- emp 테이블에서 모든 사원의 이름과 입사일을 검색
SELECT ename, hiredate FROM emp;

 -- emp 테이블에서 부서번호만 검색, 중복을 제외시키는 키워드... DISTINCT 사용... SELECT바로 다음에 온다
 SELECT deptno FROM emp;
 SELECT distinct deptno FROM emp;
 SELECT distinct(deptno) FROM emp;   -- 정렬이 안되서 출력 --  
 
 
-- 정렬은 오름차순(ASC, 기본) | 내림차순(DESC)
SELECT distinct(deptno) from emp ORDER BY deptno ASC;
SELECT distinct(deptno) from emp ORDER BY deptno;  -- 기본으로 오름차순으로 정렬된다 -- 


-- 사원중에서 입사일이 가장 빠른 사원순으로 출력...(가장 빠른 사원이 가장 먼저 검색...) -- 
SELECT ename,hiredate,job from emp ORDER BY hiredate;

-- 사원중에서 월급을 가장 많이 받는 사원순으로 검색되도록... --
SELECT ename, job, sal from emp order by sal DESC;

SELECT ename, hiredate, job from emp order by hiredate desc limit 0,2;
SELECT ename, hiredate, job from emp order by hiredate desc limit 3;
/*
limit
:: 
출력하는 갯수를 제한
시작은 0부터 2개만 출력  limit 0,2
limit 3
시작은 0부터 3개만 출력 
*/ 

SELECT ename, job, sal from emp order by sal DESC limit 1,2;
-- 1부터 2개만 출력 --

-- [1. Projection | Selection ]
-- Selection : 해당하는 조건을 만족하는 행을 검색

SELECT * FROM emp WHERE deptno=10;

-- emp테이블에서 업무가 SALESMAN 인 사원의 이름, 급여, 연봉을 검색 
SELECT ename, sal, sal*12+comm from emp where job='salesman';

-- Alias (별칭) 지정하는 방법 -컬럼명 as Alias , 1)컬럼명 Alias , 3) 컬럼명 "Alias" 
SELECT ename, sal, sal*12+comm AS AnnualSalary from emp where job='salesman';
SELECT ename, sal, sal*12+comm AnnualSalary from emp where job='salesman';
SELECT ename, sal, sal*12+comm "일년 총급여" from emp where job='salesman';
SELECT ename, sal, sal*12+comm "일년 총급여" from emp where job='salesman' ORDER BY "일년 총급여" desc; -- ""는 정렬 안먹힘
SELECT ename, sal, sal*12+comm AS AnnualSalary from emp where job='salesman' ORDER BY AnnualSalary desc; -- as는 정렬 먹힘

SELECT ename, sal, sal*12+comm AS AnnualSalary
from emp
where job='salesman'
ORDER BY AnnualSalary desc; -- as는 정렬 먹힘


-- emp 테이블에서 모든 사원의 이름, 급여, 연봉을 검색
SELECT ename, sal, sal*12+comm AS AnnualSalary
from emp
ORDER BY AnnualSalary desc; 
-- salesman 이 아닌 사람들은 comm 값이 null이어서 연봉에 null이 나온다. 
-- null은 연산이 안된다. 사칙연산도 안되고 비교연산(==, !=)도 안된다.
-- comm이 null일 때는 0으로 치환시켜야한다. 
/*
ifnull(comm,0)
: 
comm이 null이면 0으로, null이 아니면 comm으로alter
*/
SELECT ename, sal, sal*12+ifnull(comm,0) as AnnualSalary
from emp
ORDER BY AnnualSalary desc; 

-- comm이 null인 사원들의 이름, 업무, 급여, comm을 검색 
SELECT ename, job, sal, comm
from emp
where comm is null;


SELECT distinct(mgr) AS 상사번호
from emp
ORDER BY mgr desc; 
/*
NULL 값에 대하여 
::
1)자격없음
2)미학정 
::
1) 사칙연산 적용 안됨 .... IFNULL()을 통해서 NULL값을 다른 값으로 치환해야한다. 
2) 비교연산 적용 안됨 .... IS 혹은 IS NOT으로 비교해야한다.
3) mysql에서는 가장 작은 값으로 지정(oracle에서는 정반대임)
*/

-- [2. 함수 - 날짜관련 함수 - YEAR(날짜) | MONTH(날짜) ]
-- 사원중에서 81년도에 입사한 사원들의 정보를 디스플레이
SELECT * FROM emp;
Select ename, hiredate, year(hiredate) 입사년도 from emp;
select ename, hiredate, month(hiredate) 
from emp
where month(hiredate)=5;

-- [3. LIKE 연산자와 와일드 카드 %, _ ]
-- 사원의 이름중에서 A라는 이름이 들어가 있는 사원을 검색... LIKE연산자 + 와일드카드 
SELECT ename, job, deptno
from emp
where ename like '%A%';

SELECT ename, job, deptno
from emp
where ename like '_A%'; -- 두번째자리가 A

-- 사원중에서 마지막 철자가 G로 끝나는 사원을 검색
select ename, job,deptno
from emp
where ename like '%G';

