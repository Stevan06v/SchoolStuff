-- Aufgabe 1 --
alter session set nls_language = 'ENGLISH';

drop table STRAFE;
drop table VORMERK;
drop table VERLEIH;
drop table LESER;
drop table BUECHER;

create table BUECHER (Buch_Nr integer Constraint buecherpk_constraint primary key, Autor varchar2(10), Titel varchar2(50), Gruppe char, Leihfrist integer);

create table LESER (Leser_Nr integer Constraint leserpk_constraint primary key, Name varchar2(20), Wohnort varchar2(20), Eintrittsdatum date);

create table VERLEIH (Leser_Nr integer, Buch_Nr integer, Ausleihdatum date,
Rueckgabe date, Constraint verleihpk_constraint primary key (Leser_Nr, Buch_Nr),
Constraint verleihfk1_constraint foreign key (Leser_Nr) references LESER,
Constraint verleihfk2_constraint foreign key (Buch_Nr) references BUECHER);

create table VORMERK (Leser_Nr integer, Buch_Nr integer, ReservFuerDat date,
Constraint vormerkpk_constraint primary key (Leser_Nr, Buch_Nr),
Constraint vormerkfk1_constraint foreign key (Leser_Nr) references LESER,
Constraint vormerkfk2_constraint foreign key (Buch_Nr) references BUECHER);

create table STRAFE (Leser_Nr integer, SperreBisDat date, Gebuehr integer,
Constraint strafepk_constraint primary key (Leser_Nr, SperreBisDat),
Constraint strafefk_constraint foreign key (Leser_Nr) references LESER);

-- Aufgabe 2 --
select b.BUCH_NR, AUTOR, TITEL, to_Date(ReservFuerDat, 'dd. mm yyyy') VORMERKDATUM from BUECHER b, VORMERK v where b.BUCH_NR = v.BUCH_NR;

-- Aufgabe 3 --
select LESER_NR, NAME, WOHNORT, count(LESER_NR) ANZAHLBÜCHER from LESER left join VERLEIH using (LESER_NR) group by LESER_NR, NAME, WOHNORT;

--  Aufgabe 4 --
select l.LESER_NR, NAME, WOHNORT, TITEL, to_Date(RUECKGABE, 'dd-mm-yy') from LESER l, VERLEIH v, BUECHER b where l.LESER_NR = v.LESER_NR
and v.BUCH_NR = b.BUCH_NR
and b.AUTOR = 'Goethe';

-- Aufgabe 5 --
select b.BUCH_NR, AUTOR, TITEL from BUECHER b, VERLEIH v, VORMERK vo where b.BUCH_NR = v.BUCH_NR
and b.BUCH_NR = vo.BUCH_NR;

-- Aufgabe 6 --
select s.LESER_NR, l.NAME, l.WOHNORT, SUM(s.GEBUEHR) from LESER l, STRAFE s where l.LESER_NR = s.LESER_NR group by s.GEBUEHR, s.LESER_NR, l.WOHNORT, l.NAME;
 

