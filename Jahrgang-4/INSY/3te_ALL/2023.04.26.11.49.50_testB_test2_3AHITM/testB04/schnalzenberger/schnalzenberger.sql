--1.
--drop table
drop table strafe;
drop table vormerk;
drop table verleih;
drop table leser;
drop table buecher;

--create table
create table buecher (
    buch_nr number(10) constraint buchnr_pk primary key,
    autor varchar2(120),
    titel varchar2(120),
    g varchar2(1),
    leihfrist number(30)
);

create table leser (
    leser_nr number(10) constraint lesrnr_pk primary key,
    name varchar2(120),
    wohnort varchar2(120),
    eintritts date
);

create table verleih (
    leser_nr number(10) constraint verleih_lesernr_fk REFERENCES leser(leser_nr),
    buch_nr number(10) constraint verleih_buchnr_fk REFERENCES buecher(buch_nr),
    ausleihdatum date,
    rueckgabedatum date
);

create table vormerk (
    leser_nr number(10) constraint vormerk_lesernr_fk REFERENCES leser(leser_nr),
    buch_nr number(10) constraint vormerk_buchnr_fk REFERENCES buecher(buch_nr),
    reservfuerdat date
);

create table strafe (
    leser_nr number(10) constraint strafe_lesernr_fk REFERENCES leser(leser_nr),
    sperrebisdat date constraint sperrebisdat_pk primary key,
    gebuehr number(30)
);


alter session set nls_language='ENGLISH';

--select aufgaben
--2.
select b.buch_nr, b.autor, b.titel, v.reservfuerdat vormerkdatum
from vormerk v left join buecher b
on v.buch_nr=b.buch_nr;

--3.
select l.leser_nr, l.name, l.wohnort, count(v.leser_nr) anzahlbuecher
from verleih v right join leser l
on v.leser_nr=l.leser_nr
group by l.leser_nr, l.name, l.wohnort
order by count(v.leser_nr) desc;

--4.
select l.leser_nr, name, wohnort, rueckgabedatum rueckgabe
from leser l join verleih v 
on v.leser_nr=l.leser_nr
where v.buch_nr=any(select buch_nr
from buecher
where autor like 'Goe%');

--5.
select b1.buch_nr, autor, titel, reservfuerdat datum
from buecher b1 join vormerk vm
on b1.buch_nr=vm.buch_nr;
select b2.buch_nr, autor, titel, rueckgabedatum datum
from buecher b2 join verleih vl
on b2.buch_nr=vl.buch_nr
order by b2.buch_nr;

--6.
select l.leser_nr, name, wohnort, sum(gebuehr)
from strafe s1 join leser l
on s1.leser_nr=l.leser_nr
group by  l.leser_nr, name, wohnort;


