-- nested query
select playerno, name from demo_tennis.players 
where year_of_birth < 
(select year_of_birth from demo_tennis.players where name 
like 'Parmenter%' and initials like 'R%');


--1. Ausgabe von PLAYERNO, NAME der Spieler, die nach 1960 geboren sind
select PLAYERNO, name from demo_tennis.players where (year_of_birth > 1960);

--2. Ausgabe von PLAYERNO, NAME und TOWN aller weiblichen Spieler, die nicht in Stratford wohnen
select  playerno, name, town from demo_tennis.players where (town != 'Stratford');

--3. Ausgabe der Spielernummern der Spieler, die zwischen 1970 und 1980 dem Club beigetreten sind.
select playerno from demo_tennis.players where YEAR_JOINED between 1970 and 1980;

--4. Ausgabe von SpielerId, Name, Geburtsjahr der Spieler, die in einem Schaltjahr geboren sind.
select playerno, name, year_of_birth from demo_tennis.players where (mod(year_of_birth, 4) = 0) or (mod(year_of_birth, 4)=0 and mod(year_of_birth,100) != 0);

--5. Ausgabe der Strafennummern der Strafen zwischen 50,- und 100,-.
select paymentno from demo_tennis.penalties where amount >= 50 and amount <= 100;

--6. Ausgabe von SpielerId, Name der Spieler, die nicht in Stratford oder Douglas leben.

select playerno, name from demo_tennis.penalties where (town not in('Stratford','Douglas'));

--7. Ausgabe von SpielerId und Name der Spieler, deren Name 'is' enthält.
select playerno, name from demo_tennis.players where name like('%is%');

--8. Ausgabe aller Hobbyspieler.#
select name from demo_tennis.players where leagno is null;

--9. Ausgabe derjenigen Mitarbeiter, die mehr Provision als Gehalt erhalten.
select ename from emp where comm > sal;

--10. Ausgabe aller Mitarbeiter aus Abteilung 30, deren Gehalt größer gleich 1500,- ist.
select * from emp where deptno = 30 and sal >= 1500;

--11. Ausgabe aller Manager, die nicht zu Abteilung 30 gehören
select * from emp where deptno != 30 and job = 'MANAGER';

--12. Ausgabe aller Mitarbeiter aus Abteilung 10, die weder Manager noch Büroangestellter 
--(CLERK) sind.
select * from emp where deptno != 10 and job not in('MANAGER', 'CLERK');

--13. Ausgabe aller Mitarbeiter, die zwischen 1200,- und 1300,- verdienen.
select * from emp where sal >= 1200 and sal <= 1300;

--14. Ausgabe aller Mitarbeiter, deren Name 5 Zeichen lang ist und mit ALL beginnt.
select * from emp where length(ename) = 5 and ename like('ALL%');

--15. Zu jedem Mitarbeiter soll das ges. Gehalt (Gehalt + Provision) ausgegeben werden.
select sal+nvl(comm,0) as Gehalt, ename from emp; 

--16. Ausgabe aller Mitarbeiter, deren Provision über 25% des Gehalts liegt.
select * from emp where comm * 1.25 > sal;

--17. Gesucht ist der durchschnittliche Gehalt aller Büroangestellten.
select avg(sal) from emp where job = 'SALESMAN';

--18. Gesucht ist die Anzahl der Mitarbeiter, die eine Provision erhalten haben.
select count(ename) from emp where comm is not null; 

--19. Gesucht ist der Anzahl der verschiedenen Jobs in Abteilung 30.
select count(distinct job) from emp where deptno = 30;

--20. Gesucht ist die Anzahl der Mitarbeiter in Abteilung 30.
select count(ename) from emp where deptno = 30; 

--21. Ausgabe der Mitarbeiter, die zwischen 4.1.81 und 15.4.81 angestellt worden sind.
SELECT * from EMP WHERE HIREDATE BETWEEN TO_DATE('4.1.81', 'DD.MM.RR') AND TO_DATE('15.5.81', 'DD.MM.RR');
    

-- Loesung 
SELECT playerno, name, year_of_birth FROM PLAYERS WHERE year_of_birth = (SELECT MIN(year_of_birth) FROM PLAYERS);


select playerno, name, year_of_birth from tennis_copy 
where year_of_birth <= ALL(select year_of_birth from tennis_copy);


