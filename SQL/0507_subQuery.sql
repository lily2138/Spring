-- Sub Query 
/*
1. 서브쿼리는 반드시 ()로 싸여져야한다.
2. 서브쿼리가 먼저 돌아간 결과값을 가지고 메인쿼리가 실행된다.
3. 서브쿼리는 ?에 해당하는 것을 먼저 해결할 때 사용한다.
4. 서브쿼리는 from절 뒤 | where절 뒤 | having 절 뒤... 이렇게 3가지 유형으로 나뉜다. 
5. 단일행 서브쿼리 + 단일행 연산자 | 다중행 서브쿼리 + 다중행 연산자(IN, ANY)
	스칼라 서브쿼리 - 1row + 1colum
*/
-- CLARK의 급여보다 더 많은 급여를 받는 사원을 검색하세요.... >>>여기서 ? 는 'clark의 급여'
select sal from emp WHERE ename='CLARK';
select ename, sal from emp where sal>2450;

select ename, sal from emp where sal>(select sal from emp WHERE ename='CLARK');


-- 급여를 가장 많이 받는 사원 5명을 검색 
select * from emp
order by sal DESC limit 5;

-- ename이 KING인 사원과 같은 부서에서 근무하는 사원을 검색
select deptno from emp
where ename='KING';

select * from emp where deptNO=(select deptno from emp where ename='KING');

-- 10번 부서에서 근무하는 사원중에서 사원전체의 평균급여보다 더 많은 급여를 받는 사원을 검색
select * from emp where deptno=10;
select avg(sal) from emp;

select * from emp where deptno=10 and sal>(select avg(sal) from emp);

-- job별 가장 적은 평균급여를 검색 
select job, avg(sal) from emp
group by job;

select job, MIN(AVG(sal)) from emp group by job;   -- >>>> mysql에서는 함수중첩이 안된다

select job, avg(sal) from emp
group by job
having avg(sal)=(select job, MIN(AVG(sal)) from emp group by job); -- >>>> 함수 중첩 안됨 

select job, avg(sal) from emp
group by job
order by sal limit 1;

-- SCOTT의 급여보다 더 많은 급여를 받는 사원을 검색 (데이터 알리아스를 사용하는 방법 추가)
-- 1)
select * from emp where sal>(select sal from emp where ename='SCOTT');
-- 2)
select * from emp a, (select sal from emp where ename='SCOTT') b
where a.sal > b.sal;

-- 직속상관이 KING인 사원의 이름과 급여를 검색 
select empno
from emp
where ename='KING';

select ename, sal from emp where mgr = (select empno from emp where ename ='KING');

-- job이 사원 7369번과 업무와 같고, 급여가 사원 7876번 보다 많은 사원을 검색
select * from emp
where job=(select job from emp where EMPNO=7369)
and
sal>(select sal from emp where empno=7876);

-- 부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여를 검색(?... 는 20번 부서의 최소급여)
select deptno, min(sal) from emp
group by deptno
having min(sal) > (select min(sal) from emp where deptno=20);

-- 부서별 최소급여와 같은 급여를 가지는 사원을 검색(?...에 해당하는 것은 부서별 최소급여)
select empno, ename, sal from emp
where sal = (select MIN(sal) from emp group by DEPTNO); -- X 

select MIN(sal) from emp group by DEPTNO; -- 다중행 서브쿼리는 다중행 연산자와 함께 사용

select empno, ename, sal from emp
where sal IN(select MIN(sal) from emp group by DEPTNO);	 -- 다중행 연산자 IN을 사용 

-- 급여를 3000 이상 받는 사원이 소속된 부서와 동일한 부서에 근무하는 사원을 검색...(?에 해당하는 것은 급여를 3000이상 받는 사원)
select distinct deptno from emp where sal>=3000;

select * from emp
where deptno in(select distinct deptno from emp where sal>=3000);

-- 다중행 연산자 
/*
IN - (A OR B OR C) 여러개 중에서 같은 값을 찾음  
ANY - 메인쿼리의 비교조건이 서브쿼리 검색결과와 하나이상만 일치하면 참이됨 
ALL - 메인쿼리의 비교조건이 서브쿼리 검색결과와 모든 값이 일치하면 참이됨 

>ANY - 최소값 보다 많은 
<ANY - 최대값 보다 작은
<ALL - 최소값 보다 작은
>ALL - 최대값 보다 많은 
*/

-- < ANY ----> 최대값 보다 작다 
-- 급여가 어떤 점원(CLERK)보다도 작으면서 CLERK이 아닌 사원을 검색 
-- 1)
select sal from emp where job='CLERK'; -- 800, 1100, 950, 1300 (이중 하나만 일치)
-- 2) 
select * from emp
where sal < ANY(select sal from emp where job='CLERK')
AND
job <> 'CLERK' ;

-- >ALL 최대값보다 더 많은 급여 
-- 급여가 모든 부서의 평균보다 많은 사원을 검색(?에 해당하는... 부서별 평균급여) 
-- 1)
select AVG(sal) from emp group by deptno; -- 2175, 1566, 2916 
-- 2)
select * from emp
where sal > ALL(select avg(sal) from emp group by deptno);

-- 급여가 10번부서에 속한 어떤 사원의 급여보다 더 많은 급여를 받는 사원을 검색. 이때 10번 부서에 속한 사원은 제외 
-- 정렬은 사원번호 순으로 한다. 

select sal from emp where deptno=10; -- 2450, 5000, 1300   >ANY  
select empno, ename, sal, deptno from emp
where sal > ANY(select sal from emp where deptno=10)
and
deptno !=10			-- 10번 부서 제외
order by EMPNO;

-- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 검색 

select max(sal) from emp where deptno=30;

select ename, sal, deptno from emp
where sal > ALL(select sal from emp where deptno=30);

-- 부하직원을 거느린 사원을 검색 (== empno가 mgr에 있는 사원) 
-- 1)
select distinct mgr from emp;
select * from emp where empno in (select mgr from emp);

-- 2)
select e.ename 상사이름, e.empno 상사의사원번호 from emp e
where e.empno in (select m.mgr from emp m);

-- 부하직원을 거느리지 않는 사원을 검색(== empno가 mgr에 없는 사원, not in을 사용)
select distinct mgr from emp;  -- 이 사원들을 제외하고 다 나와야함 
select * from emp where empno not in (select mgr from emp);   -- 에러남(값이 안나옴) null 값 때문에 ! 

select * from emp where empno not in (select ifnull(mgr,0) from emp);

