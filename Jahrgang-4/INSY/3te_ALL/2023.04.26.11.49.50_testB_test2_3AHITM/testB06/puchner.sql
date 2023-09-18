alter session set NLS_LANGUAGE = 'ENGLISH';

-- 1.
drop table STRAFE;
drop table VORMERK;
drop table VERLEIH;
drop table LESER;
drop table BUECHER;

create table BUECHER (
    Buch_Nr number(16) primary key,
    Autor varchar2(50),
    Titel varchar2(50),
    Gruppe char,
    Leihfrist number(10)
);

create table LESER (
    Leser_Nr number(16) primary key,
    Name varchar2(50),
    Wohnort varchar2(50),
    Eintrittsdatum date
);

create table VERLEIH (
    Leser_Nr number(16) not null ,
    Buch_Nr number(16) not null ,
    Ausleihdatum date,
    Rueckgabedatum date,
    CONSTRAINT VERLEIH_PK primary key (Leser_Nr, Buch_Nr)
);

create table VORMERK (
    Leser_Nr number(16) not null ,
    Buch_Nr number(16) not null ,
    ReservFuerDat date,
    CONSTRAINT VORMERK_PK primary key (Leser_Nr, Buch_Nr)
);

create table STRAFE (
    Leser_Nr number(16) not null,
    SperreBisDat date not null,
    Gebuehr number(10),
    CONSTRAINT STRAFE_PK primary key (Leser_Nr, SperreBisDat)
);

-- 2.
select Leser_Nr, Autor, TITEL, to_char(VORMERK.ReservFuerDat, 'dd. MONTH YYYY') as VORMERKDATUM
from VORMERK
    inner join BUECHER B
        on VORMERK.Buch_Nr = B.Buch_Nr;

-- 3.
select Leser_Nr, Name, Wohnort, (
    select NVL(count(L.Leser_Nr), 0) from VERLEIH V
        where L.Leser_Nr = V.Leser_Nr
) as Anzahlbuecher from LESER L
    order by Anzahlbuecher desc;

-- 4.
select L.Leser_Nr, Name, Wohnort, Titel, to_char(Rueckgabedatum, 'dd-MON-YY') as RUECKGABE from LESER L
    inner join VERLEIH V on L.Leser_Nr = V.Leser_Nr
    inner join BUECHER B on V.Buch_Nr = B.Buch_Nr where Autor like 'Goe%';

-- 5.
select V.Buch_Nr, Autor, Titel, 'verliehen bis' as STATUS, to_char(V.Rueckgabedatum) as DATUM from BUECHER
    inner join VERLEIH V
        on BUECHER.Buch_Nr = V.Buch_Nr
union
select V.Buch_Nr, Autor, Titel, 'vorgemerkt ab' as STATUS, to_char(V.ReservFuerDat) as DATUM from BUECHER
   inner join VORMERK V
       on BUECHER.Buch_Nr = V.Buch_Nr;

-- 6.
select Leser_Nr, Name, Wohnort, nvl((
    select sum(GEBUEHR) from STRAFE S where S.Leser_Nr=L.Leser_Nr
),0) as "SUM(GEBUEHR)" from LESER L
    order by "SUM(GEBUEHR)" desc
    fetch first row only;