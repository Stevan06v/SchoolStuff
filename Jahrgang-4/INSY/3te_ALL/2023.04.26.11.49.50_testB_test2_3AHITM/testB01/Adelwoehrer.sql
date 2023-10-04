--Adelwöhrer Leonie
--3AHITM
--TEST
--01

ALTER SESSION SET NLS_DATE_LANGUAGE = 'ENGLISH';

--Drops
DROP TABLE BUECHER;
DROP TABLE LESER;
DROP TABLE VERLEIH;
DROP TABLE VORMERK;
DROP TABLE STRAFE;

--Creates
create table BUECHER (
    Buch_Nr number PRIMARY KEY,
    Autor varchar(40),
    Titel varchar(100),
    Gruppe varchar(40),
    Leihfrist number
);

create table LESER (
  Leser_Nr number PRIMARY KEY,
  Name varchar(100),
  Wohnort varchar(100),
  Eintrittsdatum date
);

create table VERLEIH (
    Leser_Nr number,
    Buch_Nr number,
    PRIMARY KEY (Leser_Nr,Buch_Nr),
    Ausleihdatum date,
    Rueckgabedatum date
);

create table VORMERK (
    Leser_Nr number,
    Buch_Nr number,
    PRIMARY KEY (Leser_Nr,Buch_Nr),
    ReservFuerDat date
);

create table STRAFE (
    Leser_Nr number,
    SperreBisDat date,
    PRIMARY KEY (Leser_Nr,SperreBisDat),
    Gebuehr number
);

--Inserts
insert into buecher values (1,'Goethe', 'Faust','A',30);
insert into buecher values (2,'Schiller', 'Die Räuber','A',30);
insert into buecher values (3,'Goethe', 'Wahlverwandtschaften','A',30);
insert into buecher values (4, null, 'Das Guinessbuch der Rekorde', 'B', 30);
insert into buecher values (5,'Lessing', 'Nathan der Weise','A', 30);
insert into buecher values (6,'Goethe','Die Leiden des jungen Werther', 'A',30);
insert into buecher values (7, null, 'Enzyklopädie der Klassik', 'C', 30);

insert into leser values (1,'Mayer', 'Linz','01-JUN-98');
insert into leser values (2,'Schmidt', 'Leonding', '21-AUG-96');
insert into leser values (3, 'Huber','Traun', '21-MAR-00');
insert into leser values (4,'Bauer','Marchtrenk','18-SEP-99');

insert into verleih values (1,3,'30-JAN-01','02-MAR-01');
insert into verleih values (3,1,'05-APR-01','05-MAY-01');
insert into verleih values (1,6,'18-JUL-01','17-AUG-01');
insert into verleih values (2,3,'25-MAR-99','07-OCT-99');

insert into vormerk values (3,3,'03-MAR-01');
insert into vormerk values (1,1,'06-MAY-01');
insert into vormerk values (3,6, '18-AUG-01');

insert into strafe values (1,'08-JUN-98', 50);
insert into strafe values (1,'15-DEC-00', 20);
insert into strafe values (2, '05-MAR-02', 15);
insert into strafe values (4,'07-MAY-02',50);


--SELECTS
--2)
SELECT B.BUCH_NR,AUTOR,TITEL,to_char(RESERVFUERDAT,'DD. MONTH YYYY') as VORMERKDATUM from BUECHER B
left join VORMERK V on B.Buch_Nr = V.Buch_Nr
where ReservFuerDat is not null;

--3)
SELECT L.LESER_NR,NAME,WOHNORT,count(B.BUCH_NR) as ANZAHLBÜCHER from LESER L
left join TESTB01.VERLEIH V on L.Leser_Nr = V.LESER_NR
left join BUECHER B on V.BUCH_NR = B.BUCH_NR
group by L.LESER_NR, NAME, WOHNORT;

--4)
SELECT L.LESER_NR,NAME,WOHNORT,TITEL,to_char(RUECKGABEDATUM,'DD-MON-YY') as RUECKGABE from LESER L
left join VERLEIH V on L.Leser_Nr = V.Leser_Nr
left join BUECHER B on V.Buch_Nr = B.Buch_Nr
where Autor LIKE 'Goe%';

--5)
SELECT B.BUCH_NR,AUTOR,TITEL,to_char(Rueckgabedatum, 'DD.MM.YYYY') as DATUM FROM BUECHER B
left join VERLEIH V on B.Buch_Nr = V.Buch_Nr
where Autor is not null and Rueckgabedatum is not null
UNION
SELECT B.BUCH_NR,AUTOR,TITEL,to_char(Reservfuerdat, 'DD.MM.YYYY') as DATUM FROM BUECHER B
left join VORMERK V on B.Buch_Nr = V.Buch_Nr
where Autor is not null and ReservFuerDat is not null;

--6)
SELECT L.LESER_NR,NAME,WOHNORT,SUM(GEBUEHR) FROM LESER L
left join STRAFE S on L.Leser_Nr = S.Leser_Nr
where Gebuehr is not null
group by L.LESER_NR, NAME, WOHNORT
order by SUM(Gebuehr) DESC
FETCH FIRST 1 ROWS ONLY;
