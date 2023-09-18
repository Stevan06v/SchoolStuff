-- 1. Anzahl der Neuzug�nge pro Jahr
select count(*),year_joined from demo_tennis.players group by year_joined; 

-- 2. Anzahl und durchschnittliche H�he der Strafen pro Spieler
select avg(amount) from demo_tennis.penalties group by playerno;

-- 3. Anzahl der Strafen f�r die Jahre vor 1983
select count(*) from demo_tennis.penalties where pen_date < to_date('YYYY',1983);

-- 4. In welchen St�dten leben mehr als 4 Spieler
select town from demo_tennis.players group by town having count(*) > 4;  

-- 5. PLAYERNO derjenigen Spieler, deren Strafensumme �ber 150 liegt
select playerno from demo_tennis.penalties group by playerno having sum(amount) > 150;

--6. NAME und INITIALS derjenigen Spieler, die mehr als eine Strafe erhalten haben
select name, initals from demo_tennis.players where playerno = any(select playerno from demo_tennis.penalties group by playerno having count(*) > 1);

--7. In welchen Jahren gab es genau 2 Strafen
select to_char(pen_date,'YYYY') from demo_tennis.penalties group by to_char(pen_date,'YYYY') having count(paymentno) = 2; 

--8. NAME und INITIALS der Spieler, die 2 oder mehr Strafen �ber $40 erhalten haben
select name, initials from demo_tennis.players where playerno in(select playerno from demo_tennis.penalties where amount > 40 group by playerno having count(*) > 1);

-- 9. NAME und INITIALS des Spielers mit der h�chsten Strafensumme
select name, initals from demo_tennis.players where playerno in(select playerno from demo_tennis.penalties group by playerno having sum(amount) >= all(select sum(amount) from demo_tennis.penalties group by playerno));

-- 10. In welchem Jahr gab es die meisten Strafen und wie viele waren es
select to_char(pen_date, 'YYYY'), count(paymentno) from demo_tennis.penalties group by to_char(pen_date, 'YYYY'), paymentno having max(paymentno) >= any(select max(paymentno) from demo_tennis.penalties);

--11. PLAYERNO, TEAMNO, WON - LOST sortiert nach letzterem
select playerno,teamno,won, lost from demo_tennis.matches order by lost asc;

-- 12. Ausgabe aller Mitarbeiter aus Abteilung 30 geordnet nach ihrem Gehalt beginnend mit dem h�chsten Gehalt
SELECT * FROM emp WHERE department_id = 30 ORDER BY salary DESC;

-- 13. Ausgabe aller Mitarbeiter geordnet nach Job und innerhalb des Jobs nach ihrem Gehalt
select * from emp order by job,sal;

-- 14. Ausgabe aller Mitarbeiter geordnet nach ihrem Anstellungsjahr absteigend und innerhalb des Jahres nach ihrem Namen
select *  from emp order by hiredate desc,ename; 

--5. Ausgabe aller Verk�ufer in absteigender Reihenfolge bez�glich dem Verh�ltnis Provision zu Gehalt
select * from emp where job = 'SALESMAN' order by comm/sal desc;

-- 16. Ausgabe des Durchschnittsgehalts zu jeder Abteilungsnummer
select avg(sal),deptno from emp group by deptno;

-- 17. Berechne die durchschnittlichen Jahresgeh�lter derjenigen Jobs, die von mehr als 2 Mitarbeitern ausgeführt werden

select avg(sal * 12),job from emp group by job having count(*) > 2;

-- 18. Ausgabe aller Abteilungsnummern mit mindestens 2 B�roangestellten
select deptno from emp where job = 'CLERK' group by deptno having count(job) >= 2;

 -- 19. Gesucht ist der durchschnittliche Wert f�r Gehalt und Provision aller Mitarbeiter aus Abteilung 3
select avg(nvl(sal,0)),avg(nvl(comm,0)) from emp where deptno = 3 ; 
