alter session set nls_date_language = 'ENGLISH';

--drops
drop table strafe;
drop table vormerk;
drop table verleih;
drop table leser;
drop table buecher;


--creates
create table buecher (
    buch_nr number(10) PRIMARY KEY,
    Autor varchar2(50),
    Titel varchar2(50),
    Gruppe char check ( Gruppe in ('A','B','C') ),
    Leihfrist number(10)
);

create table leser (
    leser_nr number(10) PRIMARY KEY,
    Name varchar2(50),
    Wohnort varchar2(50),
    Eintrittsdatum DATE
);

create table verleih (
    leser_nr number(10),
    buch_nr number(10),
    Ausleihdatum DATE,
    Rueckgabedatum DATE,
    CONSTRAINT FK_verleih_lesernr FOREIGN KEY (leser_nr) references LESER(leser_nr),
    CONSTRAINT FK_verleih_buchnr FOREIGN KEY (buch_nr) references BUECHER(buch_nr)
);

create table vormerk (
   leser_nr number(10),
   buch_nr number(10),
   ReservFuerDat DATE,
   CONSTRAINT FK_vormerk_lesernr FOREIGN KEY (leser_nr) references LESER(leser_nr),
   CONSTRAINT FK_vormerk_buchnr FOREIGN KEY (buch_nr) references BUECHER(buch_nr)
);

create table strafe (
    leser_nr number(10),
    Sperrebisdat DATE PRIMARY KEY,
    gebuehr number(10),
    CONSTRAINT FK_strafe_lesernr FOREIGN KEY (leser_nr) references LESER(leser_nr)
);


--selects
select * from buecher;
select * from leser;
select * from verleih;
select * from vormerk;
select * from strafe;

--02
select b.buch_nr, b.autor, b.titel, to_char(v.ReservFuerDat, 'fmDD. Month YYYY') vormerkdatum
from buecher b, vormerk v
where b.buch_nr = v.buch_nr;

--03
select l.leser_nr, l.name, l.wohnort, count(v.buch_nr) anzahlbuecher
from leser l, verleih v
where l.leser_nr = v.leser_nr(+)
group by l.leser_nr, l.name, l.wohnort;

--04
select l.leser_nr, l.name, l.wohnort, b.titel, to_char(v.Rueckgabedatum, 'DD-MON-YYYY') rueckgabe
from leser l, buecher b, verleih v
where l.leser_nr = v.leser_nr
  and v.buch_nr = b.buch_nr
  and b.AUTOR LIKE 'Goe%';

--05
select b.buch_nr, b.Autor, b.Titel,

       (CASE WHEN b.buch_nr = vor.buch_nr
                 THEN 'vorgemerkt ab'
             ELSE 'verliehen bis' end) status,

        (CASE WHEN b.buch_nr = vor.buch_nr
                THEN to_Char(vor.ReservFuerDat, 'DD.MM.YYYY')
            ELSE to_Char(ver.Rueckgabedatum, 'DD.MM.YYYY') end) datum

from buecher b, verleih ver, vormerk vor
where b.buch_nr = ver.buch_nr or b.buch_nr = vor.buch_nr
group by b.buch_nr, b.Autor, b.Titel,
       (CASE WHEN b.buch_nr = vor.buch_nr
                  THEN 'vorgemerkt ab'
              ELSE 'verliehen bis' end),
          (CASE WHEN b.buch_nr = vor.buch_nr
          THEN to_Char(vor.ReservFuerDat, 'DD.MM.YYYY')
          ELSE to_Char(ver.Rueckgabedatum, 'DD.MM.YYYY') end);

--06
select l.leser_nr, l.Name, l.Wohnort, sum(s.gebuehr)
from leser l, strafe s
where l.leser_nr = s.leser_nr
group by l.leser_nr, l.Name, l.Wohnort
having sum(gebuehr) >= ALL
(select sum(gebuehr) from strafe group by leser_nr);