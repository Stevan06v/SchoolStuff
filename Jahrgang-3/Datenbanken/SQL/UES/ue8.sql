select * from parts;
select * from emp;


select super from parts where sub = 'P3' or sub = 'P9'
connect by sub = super start with super;

--4. Wieviele Teile zu P1 kosten mehr als $20
select count(*) from parts where price > 20
connect by prior sub=super   
start with super = 'P1';

--5. Ausgabe aller direkt und indirekt zu JONES gehörenden Mitarbeiter (ohne JONES selbst, mit entsprechender Einrückung pro Hierarchie
select ename from emp 
connect by prior empno = mgr
start with ename ='JONES';


--6. Ausgabe aller direkten und indirekten Vorgesetzten von SMITH (inklusive SMITH)
select ename from emp 
connect by prior mgr = empno
start with ename ='SMITH';

--7. Ausgabe des durchschnittlichen Gehalts für jede Hierarchiestufe
select level,avg(sal) from emp 
connect by prior mgr=empno
group by level;


