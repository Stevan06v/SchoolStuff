----------------- 1 -----------------
drop table STRAFE;
drop table VORMERK;
drop table VERLEIH;
drop table LESER;
drop table BUECHER;

create table BUECHER
(
    Buch_NR   number primary key,
    Autor     varchar(50),
    Titel     varchar(50),
    Gruppe    varchar(1) check (Gruppe in ('A', 'B', 'C')),
    Leihfrist number
);

create table LESER
(
    Leser_NR       number primary key,
    Name           varchar(50),
    Wohnort        varchar(50),
    Eintrittsdatum varchar(15)
);

create table VERLEIH
(
    Leser_NR       number references LESER (Leser_NR),
    Buch_NR        number references BUECHER (Buch_NR),
    Ausleihdatum   varchar(15),
    Rueckgabedatum varchar(15),
    primary key (Leser_NR, Buch_NR)
);

create table VORMERK
(
    Leser_NR      number references LESER (Leser_NR),
    Buch_NR       number references BUECHER (Buch_NR),
    ReservFuerDat varchar(15),
    primary key (Leser_NR, Buch_NR)
);

create table STRAFE
(
    Leser_NR     number references LESER (Leser_NR),
    SperreBisDat varchar(15),
    Gebuehr      number,
    primary key (Leser_NR, SperreBisDat)
);


alter session set NLS_LANGUAGE = 'ENGLISH';


----------------- 2 -----------------
select b.BUCH_NR, b.Autor, b.Titel, to_Char(TO_DATE(v.ReservFuerDat), 'DD. Month YYYY') as Vormerkdatum
from VORMERK v,
     BUECHER b
where v.BUCH_NR = b.BUCH_NR;

----------------- 3 -----------------
select l.Leser_NR, l.Name, l.Wohnort, count(v.Ausleihdatum)
from LESER l
         full outer join VERLEIH V on l.Leser_NR = V.Leser_NR
group by l.Leser_NR, l.Name, l.Wohnort;

----------------- 4 -----------------
select l.Leser_NR, l.Name, l.Wohnort, b.Titel, v.RUECKGABEDATUM
from LESER l,
     BUECHER b
         inner join VERLEIH v on b.Buch_NR = V.Buch_NR
where l.Leser_NR = v.Leser_NR;

----------------- 5 -----------------
select Buch_NR, AUTOR, Titel
from BUECHER;
--- nein

----------------- 6 -----------------
select l.Leser_NR, l.Name, l.Wohnort, sum(Gebuehr)
from LESER l
         inner join STRAFE S on l.Leser_NR = S.Leser_NR
group by l.Leser_NR, l.Name, l.Wohnort;




