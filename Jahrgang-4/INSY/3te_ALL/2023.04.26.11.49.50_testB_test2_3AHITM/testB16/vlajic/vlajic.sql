alter session set nls_date_format ='dd-MON-yy';
alter table session set nls_language = 'ENGLISH';

drop table buecher cascade constraints;
drop table leser cascade constraints; 
drop table verleih cascade constraints;
drop table vormerk cascade constraints;
drop table strafe cascade constraints;

-- creates
create table buecher(
    buch_nr number(30),
    autor varchar2(30),
    titel varchar2(30),
    gruppe varchar2(20),
    leihfrist varchar(30),
    constraint pk_buch_nr primary key(buch_nr)
);
create table leser(
    leser_nr number(30),
    name varchar2(30),
    wohnort varchar2(30),
    eintrittsdatum date,
    constraint pk_leser_nr primary key(leser_nr)
);
create table verleih(
    leser_nr number(30),
    buch_nr number(30),
    ausleihdatum date,
    rueckgabedatum date,
    constraint fk_leser_nr foreign key(leser_nr) references leser,
    constraint fk_buch_nr foreign key(buch_nr) references buecher
);
create table vormerk(
    leser_nr number(30),
    buch_nr number(30),
    reservFuerDat date,
    constraint fk_leser_nr1 foreign key(leser_nr) references leser,
    constraint fk_buch_nr1 foreign key(buch_nr) references buecher
);
create table strafe(
    leser_nr number(30),
    sperreBisDat date,
    gebuehr number(30),
    constraint fk_leser_nr2 foreign key(leser_nr) REFERENCES leser,
    constraint pk_sperrebisdat primary key(sperreBisDat)
);


--inserts go below me


--selects
-- 2
select b.buch_nr, b.titel, v.reservFuerDat
from buecher b, vormerk v 
where b.buch_nr = v.buch_nr;

-- 3
select l.leser_nr, l.name, l.wohnort, count(b.buch_nr) as ANAZHLBUECHER
from leser l, verleih v, buecher b
where l.leser_nr = v.leser_nr (+)
and v.buch_nr = b.buch_nr (+)
group by l.leser_nr, 
l.name, 
l.wohnort;

-- 4 
select l.leser_nr, l.name, l.wohnort, b.titel,v.rueckgabedatum
from leser l, buecher b, verleih v 
where l.leser_nr = v.leser_nr 
and v.buch_nr = b.buch_nr 
and b.autor like '%Goe%';

-- 5
-- n icht geschafft
select b.buch_nr, b.autor, b.titel, b.leihfrist as STATUS 
from buecher b, vormerk v, verleih vl; 

-- 6
select l.leser_nr, l.name, l.wohnort,sum(s.gebuehr) 
from leser l, strafe s
where l.leser_nr = s.leser_nr 
group by  l.leser_nr, l.name, l.wohnort 
having sum(s.gebuehr) >= all(select sum(s.gebuehr)
from leser l, strafe s
where l.leser_nr = s.leser_nr 
group by l.leser_nr, l.name, l.wohnort);
