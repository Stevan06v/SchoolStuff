-- 1.
drop table verleih;
drop table vormerk;
drop table strafe;
drop table Buecher;
drop table leser;

Create table Buecher
(
    buch_nr   number primary key,
    autor     varchar(50),
    titel     varchar(255),
    gruppe    varchar(1),
    leihfrist number
);
alter session set nls_date_format = 'DD-MON-YY';
alter session set nls_language = 'ENGLISH';
create table leser
(
    leser_nr       number primary key,
    name           varchar(50),
    wohnort        varchar(50),
    eintrittsdatum date
);
Create table verleih
(
    leser_nr       number,
    buch_nr        number,
    ausleihdatum   date,
    rueckgabedatum date,
    primary key (leser_nr, buch_nr),
    foreign key (leser_nr) references leser (leser_nr),
    foreign key (buch_nr) references Buecher (buch_nr)
);
create table vormerk
(
    leser_nr      number,
    buch_nr       number,
    reservfuerdat date,
    primary key (leser_nr, buch_nr),
    foreign key (leser_nr) references leser (leser_nr),
    foreign key (buch_nr) references Buecher (buch_nr)
);
create table strafe
(
    leser_nr     number,
    sperrebisdat date,
    gebuehr      number,
    primary key (leser_nr, sperrebisdat),
    foreign key (leser_nr) references leser (leser_nr)
);


insert into buecher
values (1, 'Goethe', 'Faust', 'A', 30);
insert into buecher
values (2, 'Schiller', 'Die Räuber', 'A', 30);
insert into buecher
values (3, 'Goethe', 'Wahlverwandtschaften', 'A', 30);
insert into buecher
values (4, null, 'Das Guinessbuch der Rekorde', 'B', 30);
insert into buecher
values (5, 'Lessing', 'Nathan der Weise', 'A', 30);
insert into buecher
values (6, 'Goethe', 'Die Leiden des jungen Werther', 'A', 30);
insert into buecher
values (7, null, 'Enzyklopädie der Klassik', 'C', 30);

insert into leser
values (1, 'Mayer', 'Linz', '01-JUN-98');
insert into leser
values (2, 'Schmidt', 'Leonding', '21-AUG-96');
insert into leser
values (3, 'Huber', 'Traun', '21-MAR-00');
insert into leser
values (4, 'Bauer', 'Marchtrenk', '18-SEP-99');

insert into verleih
values (1, 3, '30-JAN-01', '02-MAR-01');
insert into verleih
values (3, 1, '05-APR-01', '05-MAY-01');
insert into verleih
values (1, 6, '18-JUL-01', '17-AUG-01');
insert into verleih
values (2, 3, '25-MAR-99', '07-OCT-99');

insert into vormerk
values (3, 3, '03-MAR-01');
insert into vormerk
values (1, 1, '06-MAY-01');
insert into vormerk
values (3, 6, '18-AUG-01');

insert into strafe
values (1, '08-JUN-98', 50);
insert into strafe
values (1, '15-DEC-00', 20);
insert into strafe
values (2, '05-MAR-02', 15);
insert into strafe
values (4, '07-MAY-02', 50);

-- 2.
SELECT b.buch_nr, b.autor, b.titel, to_char(v.reservfuerdat, 'D. Month YYYY') as vormerkdaum
from Buecher b,
     vormerk v
WHERE b.buch_nr = v.buch_nr
group by v.reservfuerdat, b.buch_nr, b.autor, b.titel;

--3.
SELECT l.leser_nr, l.name, l.wohnort, count(v.leser_nr) as ANZAHLBÜCHER
from leser l,
     verleih v
WHERE l.leser_nr = v.leser_nr
group by l.leser_nr, l.name, l.wohnort
UNION
SELECT leser_nr, name, wohnort, 0
from leser
where name = 'Bauer';

-- 4.
SELECT l.leser_nr, l.name, l.wohnort, b.titel, to_char(v.rueckgabedatum, 'DD-MON-YY') as rueckgabe
from leser l,
     verleih v,
     Buecher b
where v.leser_nr = l.leser_nr
  and v.buch_nr = b.buch_nr
  and b.autor like 'Goe%';

-- 6.
SELECT l.leser_nr, l.name, l.wohnort, sum(s.gebuehr)
from leser l,
     strafe s
WHERE l.leser_nr = s.leser_nr
group by s.leser_nr, l.leser_nr, l.name, l.wohnort
order by sum(s.GEBUEHR) desc;
