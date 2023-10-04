-- drop tables
drop table artikel cascade constraints;
drop table produktion cascade constraints;
drop table mitarbeiter cascade constraints;
drop table qualitaet cascade constraints;

-- creates 
create table artikel(
    artnr number(38),
    artbez varchar2(50),
    artgruppe char(1),
    constraint pk_artnr primary key(artnr)
);  
create table mitarbeiter(
    mitarbnr number(38),
    mitarbname varchar2(50),
    constraint pk_mitarbnr primary key(mitarbnr)
);  
create table produktion(
    mitarbnr number(38),
    tag date, 
    artnr number(38),
    anzahl number(38),
    constraint pk_mitarbnr_tag_artnr primary key(mitarbnr, tag, artnr),
    constraint fk_p_artnr foreign key(artnr) references artikel,
    constraint fk_p_mitarbnr foreign key(mitarbnr) references mitarbeiter
);
create table qualitaet(
    pruefnr number(38),
    pruefdat date, 
    mitarbnr number(38),
    artnr number(38),
    faktor number(3,2),
    constraint pk_pruefnr primary key(pruefnr),
    constraint fk_q_mitarbnr foreign key(mitarbnr) references mitarbeiter,
    constraint fk_q_artnr foreign key(artnr) references artikel
);
create table bonus(
    mitarbnr number(38),
    jahr date,
    betrag number(38),
    constraint pk_b_mitarbnr_jahr primary key(mitarbnr,jahr),
    constraint fk_b_mitarbnr foreign key(mitarbnr) references mitarbeiter
);
-- Insert into Artikel table
insert into ARTIKEL values ('1', 'SkateboardXL', 'E');
insert into ARTIKEL values ('2', 'SkateboardX', 'E');
insert into ARTIKEL values ('3', 'SkateboardM', 'E');
insert into ARTIKEL values ('4', 'Rollen', 'T');
insert into ARTIKEL values ('5', 'Lager', 'T');

insert into MITARBEITER values ('1', 'Huber');
insert into MITARBEITER values ('2', 'Maier');
insert into MITARBEITER values ('3', 'Bieber');

insert into PRODUKTION values ('1', '27.10.02', '1', '1');
insert into PRODUKTION values ('1', '28.10.02', '2', '2');
insert into PRODUKTION values ('1', '28.10.02', '3', '3');
insert into PRODUKTION values ('1', '29.10.02', '1', '10');
insert into PRODUKTION values ('2', '27.10.02', '2', '4');
insert into PRODUKTION values ('2', '27.10.02', '3', '2');
insert into PRODUKTION values ('2', '28.10.02', '3', '3');

insert into QUALITAET values ('1', '17.01.03', '1', '1', ',9');
insert into QUALITAET values ('2', '20.01.03', '1', '2', ',92');
insert into QUALITAET values ('3', '24.01.03', '1', '3', ',68');
insert into QUALITAET values ('4', '27.01.03', '1', '3', ',7');
insert into QUALITAET values ('5', '21.01.03', '2', '3', ',64');
insert into QUALITAET values ('6', '27.01.03', '2', '3', ',36');
insert into QUALITAET values ('7', '27.01.03', '2', '1', ',8');

-- select-statements
-- 2)
select p.tag as TAG, m.mitarbname as MITARBEITERNAME,a.artbez as ARTBEZEICHNUNG, 
ANZAHL from artikel a, produktion p, mitarbeiter m 
where a.artnr = p.artnr 
and p.mitarbnr = m.mitarbnr 
and p.anzahl > 3 
order by p.tag asc;

-- 3)
select m.mitarbname as NAME, avg(q.faktor) as DURCHSCHNITT 
from mitarbeiter m, qualitaet q
where m.mitarbnr = q.mitarbnr (+)
group by m.mitarbname;

--4)
select m.mitarbnr as MITARBEITERNR , m.mitarbname as NAME 
from mitarbeiter m, qualitaet q
where m.mitarbnr = q.mitarbnr 
and q.faktor < 0.5;

--5)
truncate table bonus;

insert into bonus (mitarbnr, jahr, betrag)
select m.mitarbnr, to_date('01.02.02', 'dd.mm.yy'), avg(q.faktor) * 10000 
from mitarbeiter m, qualitaet q
where m.mitarbnr = q.mitarbnr
group by m.mitarbnr;

select * from bonus;