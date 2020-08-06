
select * from emp;
select Distinct deptno from emp;
select * from dept;

-- 1. 'ACCOUNTING‘ 부서에서 근무하는 직원들의 이름, 급여, 입사일을 조회하시오. ( 조건  join 사용 )
select e.ename, e.sal, e.hiredate, d.dname
from emp e, dept d 
where e.deptno = d.deptno
and
d.dname='ACCOUNTING';

-- 2. 직원의 이름과 관리자 이름을 조회하시오. 
select e.ename 직원이름, m.ename 관리자이름
from (select empno, ename, mgr from emp) e,
(select empno, ename from emp) m
where e.mgr = m.empno;

-- 3. 관리자 이름과 관리자가 관리하는 직원의 수를 조회하시오. 단, 관리직원수가 3명 이상인 관리자만 출력되도록 하시오.
select m.ename 관리자이름, count(m.ename) 관리직원수 
from (select empno, ename, mgr from emp) e,
(select empno, ename from emp) m
where e.mgr = m.empno
group by m.ename
having count(m.ename) >=3;







