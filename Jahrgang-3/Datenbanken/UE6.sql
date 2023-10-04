-- 1. NAME, INITIALS und Anzahl der gewonnenen Sätze für jeden Spiel
select sum(nvl(won,0)), name, initials from demo_tennis.players pl, demo_tennis.matches m 
where pl.playerno = m.playerno(+) group by pl.playerno,pl.name,pl.initials;

-- 2. NAME, PEN_DATE und AMOUNT absteigend sortiert nach AMOUNT
select name, pen_date, amount from demo_tennis.players pl, demo_tennis.penalties pt 
where pl.playerno = pt.playerno order by amount desc;

-- 3. TEAMNO, NAME (des Kapitäns) pro Team 
select teamno, name from demo_tennis.teams t  
join demo_tennis.players pl on t.playerno = pl.playerno;


--4. NAME (Spielername), WON, LOST aller gewonnenen Matches
-- 1)
select name, won, lost from demo_tennis.players pl, demo_tennis.matches ma where ma.playerno = pl.playerno and won > lost;
--2) falsch
select name, count(won), lost from demo_tennis.matches m join demo_tennis.players pl 
on pl.playerno = m.playerno where m.won  > 0;

-- 5. PLAYERNO, NAME und Strafensumme für jeden Mannschaftsspieler. Hat eine Spieler noch keine Strafe erhalten,
-- so soll er trotzdem ausgegeben werden. Die Sortierung soll nach der Höhe der Strafe aufsteigend erfolgen
select pl.playerno, pl.name, pe.amount from DEMO_TENNIS.players pl, DEMO_TENNIS.penalties pe
where pl.playerno = pe.playerno(+) order by pe.amount ASC;

-- richitg
select pl.playerno, pl.name, nvl(sum(pe.amount),0) from DEMO_TENNIS.players pl left join DEMO_TENNIS.penalties pe on pl.playerno = pe.playerno where pl.leagno IS NOT NULL
group by pl.playerno, pl.name order by nvl(sum(amount),0);

-- 6. In welcher Stadt arbeitet der Mitarbeiter Allen?
select loc from dept d join emp e on d.deptno = e.deptno where e.ename = 'ALLEN';

-- 7. Gesucht sind alle Mitarbeiter, die mehr verdienen als ihr Vorgesetzter
-- Vorgesetzer?
select * from emp e where sal > (select sal from emp where e.empno = e.mgr);
-- geht
SELECT ename, sal from emp e where sal >  (SELECT sal from emp where emp.empno = e.mgr);
-- andere aufgabe
select e.ename, e.sal + nvl(e.comm,0) as earn, m.ename as mname, m.sal + nvl(m.comm,0) as mearn from emp e, emp m where e.mgr=m.empno and e.sal > m.sal;

-- 8. Ausgabe der Anzahl der Anstellungen in jedem Jahr
select distinct to_char(hiredate,'YYYY'), count(*)from emp group by to_char(hiredate,'YYYY');

-- 9. Ausgabe aller Mitarbeiter, die einen Job haben wie ein Mitarbeiter aus CHICAGO
-- select * from emp e join emp e2 on e.job = e2.job join dept d on e.deptno = d.deptno where d.loc = 'Chicago';
select * from emp where job in (select job from emp where deptno = 30);
select count(*) from emp where sal > 500 group by empno, ename, sal, deptno;

select name, initials, amount,'select 1' from demo_tennis.players pl, demo_tennis.penalties pe 
where pl.playerno = pe.playerno
union 
select name, initials, 0, 'select 2' from demo_tennis.players pl where not exists (select * from demo_tennis.penalties pe where pe.playerno = pl.playerno);













