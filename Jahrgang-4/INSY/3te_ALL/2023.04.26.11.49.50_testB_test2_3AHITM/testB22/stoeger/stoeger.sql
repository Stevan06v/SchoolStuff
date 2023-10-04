-- Sophie Stöger 

-- 1)
alter session set nls_language = 'English';
alter session set nls_date_format = 'dd-Mon-yy';

drop table vormerk;
drop table verleih;
drop table strafe;
drop table leser;
drop table buecher;

create table buecher (
buch_nr number constraint pk_buch primary key,
autor VARCHAR2(64),
titel VARCHAR2(255),
g VARCHAR2(1),
leihfrist number
);

create table leser(
leser_nr number constraint pk_leser primary key,
name VARCHAR2(64),
wohnort VARCHAR2(64),
eintritsdatum date
);

create table verleih(
leser_nr number constraint fk_leser references leser (leser_nr),
buch_nr number constraint fk_buch references buecher (buch_nr),
ausleihdatum date,
rueckgabedatum date,
constraint pk_leser_buch primary key (leser_nr, buch_nr)
);

create table vormerk(
leser_nr number constraint fk_leser_vormerk references leser (leser_nr),
buch_nr number constraint fk_buch_vormerk references buecher (buch_nr),
reserveFuerDat date,
constraint pk_vormerk primary key (leser_nr,buch_nr)
);

create table strafe(
leser_nr number constraint fk_leser_strafe references leser (leser_nr),
sperreBisDat date,
gebuehr number,
constraint pk_strafe primary key (leser_nr, sperreBisDat)
);

-- 2)
select v.buch_nr, b.autor, b.titel, to_char(v.reservefuerdat, 'dd. Month YYYY') as vormerkdatum from vormerk v join buecher b on v.buch_nr = b.buch_nr order by vormerkdatum;


-- 3)
select l.leser_nr, l.name, l.wohnort, count(v.leser_nr) from leser l full outer join verleih v on l.leser_nr = v.leser_nr group by l.leser_nr, l.name, l.wohnort;


-- 4)
select l.leser_nr, l.name, l.wohnort, b.titel, v.rueckgabedatum from leser l join verleih v on l.leser_nr = v.leser_nr join buecher b on v.buch_nr = b.buch_nr where b.autor like ('Goe%');


-- 5) :(
select b.buch_nr, b.autor, b.titel, vh.rueckgabedatum, vm.reservefuerdat from buecher b join verleih vh on b.buch_nr = vh.buch_nr join vormerk vm on b.buch_nr = vm.buch_nr;


-- 6) :(
select max(sum(s.gebuehr)) from strafe s group by s.leser_nr;

select l.leser_nr, l.name, l.wohnort, sum(s.gebuehr) from leser l join strafe s on l.leser_nr = s.leser_nr where l.leser_nr in (select leser_nr from strafe) group by l.leser_nr, l.name, l.wohnort;





