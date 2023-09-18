-- 1. Ausgabe der Spielernamen, die sowohl für das Team 1 als auch für das Team 2 gespielt haben

select pl.playerno from demo_tennis.players pl, demo_tennis.teams tm
where tm.playerno = pl.playerno ;


--2. NAME und INITIALS der Spieler, die 1980 keine Strafe erhalten haben
select pl.name, pl.initials from demo_tennis.players pl,demo_tennis.penalties pe
where pl.playerno = pe.playerno 
and to_char(pe.pen_date, 'yyyy') = 1980 group by pl.name, pl.initials
having count(pe.playerno) = 0;

select name, initials from demo_tennis.players 
where playerno not in (select playerno from demo_tennis.penalties where to_char(pen_date, 'yyyy') = 1980);

select name, initials from demo_tennis.players
minus
select name, initials from demo_tennis.players pl, demo_tennis.penalties pe where pl.playerno=pe.playerno and to_char(pen_date, 'YYYY') = 1980;

--3. Ausgabe der Spieler, der mindestens eine Strafe über $80 erhalten haben
select name from demo_tennis.players 
where playerno in(select playerno from demo_tennis.penalties where amount > 80);

--4. Ausgabe der Spieler, bei denen jede Strafe über $80 lag
select name, initials from demo_tennis.players 
where playerno in (select playerno from demo_tennis.penalties );


--13. Ausgabe aller Mitarbeiter geordnet nach Job und innerhalb des Jobs nach ihrem Gehalt
select * from emp order by job, sal;

--1. NAME, INITIALS und Anzahl der gewonnenen Sätze für jeden Spieler (6)
select pl.name, pl.initials, count(m.won) from demo_tennis.players pl, demo_tennis.matches m
where pl.playerno = m.playerno
group by pl.name, pl.initials;


--5. PLAYERNO, NAME und Strafensumme für jeden Mannschaftsspieler. 
--Haet eine Spieler noch keine Strafe erhalten, so soll er trotzdem ausgegeben werden. Die Sortierung soll nach der Höhe der Strafe aufsteigend erfolgen (6)
select pl.playerno, pl.name, sum(pe.amount) from demo_tennis.players pl, demo_tennis.penalties pe
where pe.playerno(+) = pl.playerno and pl.leagno is not null group by pl.playerno, pl.name order by sum(pe.amount);


select * from demo_tennis.penalties;

--7. In welchen Jahren gab es genau 2 Strafen
select to_char(pen_date, 'yyyy') from demo_tennis.penalties group by to_char(pen_date, 'yyyy') having count(*) = 2;


select level, avg(sal+nvl(comm,0)) from emp 
group by level 
connect by prior empno = mgr;


select lpad('-', (level-1)*4) || ename from emp 
connect by prior  mgr = empno
start with ename = 'SMITH';



