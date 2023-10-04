--alter session set nls_datum_format = 'YYYY-MM-DD'
alter session set nls_language ='ENGLISH';

--drop 
drop table verleih;
drop table vormerk;
drop table strafe;
drop table buecher;
drop table leser;


--create
create table buecher(
buch_nr number(20),
autor varchar2(80),
titel varchar2(200),
gruppe varchar2(2),
Leihfrist number(20),
Constraint pk_buchnr Primary Key (buch_nr)
);

create table leser(
leser_nr number(20),
name varchar(100),
wohnort varchar(100),
eintrittsdatum date,
Constraint pk_leser_nr Primary Key (leser_nr)
);


create table verleih(
leser_nr number(20),
buch_nr number(20),
ausleihdatum date,
rueckgabedatum date,
Constraint pk_leser_nr_buch_nr Primary Key (leser_nr,buch_nr),
Constraint fk_leser_nr Foreign Key (leser_nr) references leser(leser_nr),
Constraint fk_buch_nr Foreign Key (buch_nr) references buecher(buch_nr)
);

create table vormerk(
leser_nr number(20),
buch_nr number(20),
reservfuerdat date,
Constraint pk_leser_nr_buch_nr_vormerk Primary Key (leser_nr,buch_nr),
Constraint fk_leser_nr_vormerk Foreign Key (leser_nr) references leser(leser_nr),
Constraint fk_buch_nr_vormerk Foreign Key (buch_nr) references buecher(buch_nr)
);

create table strafe(
leser_nr number(20),
sperrebisdat date,
gebuehr number(30),
Constraint pk_leser_nr_sperrebisdat Primary Key (leser_nr,sperrebisdat),
Constraint fk_leser_nr_strafe Foreign Key (leser_nr) references leser(leser_nr)
);

--select
--2
select b.buch_nr,autor,titel,v.reservfuerdat from buecher b,vormerk v where b.buch_nr = v.buch_nr;

--3
select l.leser_nr,name,wohnort,(select count(*) from verleih vh where l.leser_nr = vh.leser_nr) ANZAHLBÜCHER 
from leser l 
order by ANZAHLBÜCHER desc;

--4
select l.leser_nr,l.name,l.wohnort,b.titel,v.rueckgabedatum
from leser l,verleih v,buecher b 
where l.leser_nr = v.leser_nr and v.buch_nr = b.buch_nr and b.autor  like 'Goe%';

--5
select b.buch_nr,b.autor,b.titel 
from verleih vl,buecher b,vormerk vm 
where vl.buch_nr = b.buch_nr and vm.buch_nr = b.buch_nr;




