select * from emp;
select * from dept;

-- 1. 'ACCOUNTING‘ 부서에서 근무하는 직원들의 이름, 급여, 입사일을 조회하시오.
-- 1)
select deptno from dept
where dname='ACCOUNTING';
-- 2)
select ename, sal, hiredate
from emp
where deptno = (select deptno from dept where dname='ACCOUNTING');

-- 2. 'TURNER' 와 같은 부서에서 근무하는 직원의 이름과 부서번호를 조회하시오.
-- 1)
select deptno,ename from emp
where ename='TURNER';
-- 2)
select ename, deptno from emp
where deptno = (select deptno from emp where ename='TURNER');

-- 3. 10번 부서의 평균급여보다 많은 급여를 받는 직원의 이름, 부서번호, 급여를 조회하시오.
-- 1)
select deptno, avg(sal) from emp
where deptno=10;
-- 2)
select ename, deptno, sal from emp
where sal > (select avg(sal) from emp where deptno=10);

-- 4. King에게 보고하는 모든 사원의 이름과 급여를 표시하시오. 사원의 이름은 직원으로 Alias를 부여하시오
-- 1) 
select empno from emp
where ename = 'King';
-- 2)
select ename 직원, mgr, sal from emp
where mgr = (select empno from emp where ename = 'King');

-- 5. 평균 급여보다 많은 급여를 받고 이름에 u가 포함된 사원과 같은 부서에서 근무하는 모든 사원의 사원 번호, 이름 및 급여를 표시하시오
-- 1)
select avg(sal) from emp;
select deptno from emp
where ename like '%u%';

-- 2)
select empno, ename, sal, deptno from emp
where deptno = (select deptno from emp where ename like '%u%')
and
sal > (select avg(sal) from emp);

-- 6. 평균 급여보다 높고 최대 급여보다 낮은 월급을 받는 사원의 정보를 조회하시오.
-- 1)
select avg(sal) from emp;
select max(sal) from emp;
-- 2)
select * from emp
where sal > (select avg(sal) from emp)
and
sal < (select max(sal) from emp);

