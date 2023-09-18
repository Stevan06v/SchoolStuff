SELECT * from demo_tennis.players;

-- 1. Ausgabe von TEAMNO der Teams, in denen nicht der Spieler mit der Nummer 27 Kapiän
select teamno from demo_tennis.TEAMS where playerno != 27;

--2. Ausgabe von PLAYERNO, NAME und INITIALS der Spieler, die mindestens ein Match gewonnen haben
select playerno, name, initials from demo_tennis.PLAYERS where playerno = any(select playerno from demo_tennis.matches where won = 1);

--3. Ausgabe von SpielerNr und Name der Spieler, die mindestens eine Strafe erhalten haben
select playerno, name from demo_tennis.PLAYERS where playerno = any(select playerno from demo_tennis.PENALTIES where amount > 0);

--4. Ausgabe von SpielerNr und Name der Spieler, die mindestens eine Strafe über 50.- erhalten haben
select playerno, name from demo_tennis.PLAYERS where playerno = any(select playerno from demo_tennis.PENALTIES where amount > 50);

--5. Ausgabe von SpielerNr und Name der Spieler, die im selben Jahr wie R. Parmenter geboren sind
select playerno, name from DEMO_TENNIS.Players where year_of_birth = all(select year_of_birth from demo_tennis.PLAYERS where name like '%Parmenter' and initials like '%R');

--6. Ausgabe von SpielerNr und Name des ältesten Spielers aus Stratford
select playerno, name from demo_tennis.players where year_of_birth <= all(select year_of_birth from demo_tennis.players where town = 'Stratford');

--7. Gesucht sind alle Abteilungen, die keine Mitarbeiter beschäftigen
select * from dept where DEPTNO = all(select deptno from emp where ename is null);

--8. Gesucht sind alle Mitarbeiter, die den gleichen Job wie JONES haben
select * from emp where job = all(select job from emp where ename = 'JONES');

--9. Anzeigen aller Mitarbeiter, die mehr verdienen als irgendein Mitarbeiter aus Abteilung 30
select * from emp where sal > any(select sal from emp where deptno = 30);

--10. Anzeigen aller Mitarbeiter, die mehr verdienen als jeder Mitarbeiter aus Abteilung 30
select * from emp where sal > all(select sal from emp where deptno= 30);

--11. Anzeigen aller Mitarbeiter aus Abteilung 10, deren Job von keinem Mitarbeiter aus Abteilung 30 ausgeübt wird
select * from emp where deptno = 10 and job != any(select distinct job from emp where deptno = 30);

--12. Gesucht sind die Mitarbeiterdaten (EMPNO, ENAME, JOB, SAL) des Mitarbeiters mit dem höchsten Gehalt
select empno, ename, job, sal from emp where sal >= all(select sal from emp);