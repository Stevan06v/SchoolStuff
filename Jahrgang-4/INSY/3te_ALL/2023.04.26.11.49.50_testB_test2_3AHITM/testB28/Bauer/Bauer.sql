ALTER SESSION SET nls_language = 'english';
ALTER SESSION SET nls_date_format = 'DD-Mon-YY';

-- task 1
--drop tables
DROP TABLE buecher CASCADE CONSTRAINTS;
DROP TABLE leser CASCADE CONSTRAINTS;
DROP TABLE verleih;
DROP TABLE vormerk;
drop table strafe;

--create tables
CREATE TABLE buecher (
    buch_nr NUMBER PRIMARY KEY,
    autor varchar(30),
    titel varchar(250) not null,
    gruppe varchar(1) not null,
    leihfrist number not null 
);

CREATE TABLE leser (
    leser_nr  number primary key,
    nameL varchar(20),
    wohnort varchar(30),
    eintrittsdatum date
);

CREATE Table verleih (
    leser_Nr number REFERENCES leser(leser_nr),
    buch_nr number REFERENCES buecher(buch_nr),
    ausleihdatum date,
    rueckgabedatum date
);

CREATE TABLE vormerk (
    leser_nr number references leser(leser_nr),
    buch_nr number REFERENCES buecher(buch_nr),
    reservfuerDat date
);

CREATE TABLE strafe (
    leser_nr number references leser(leser_nr),
    sperreBisDat date primary key,
    gebuehr number
);


--task 2 
SELECT v.buch_nr, b.autor, b.titel, to_char(v.reservFuerDat, 'DD. Month YYYY') AS Vormerkdatum from vormerk v, buecher b
where v.buch_nr = b.buch_nr;

--task 3 
SELECT l.leser_nr, l.nameL , l.wohnort, count(v.leser_nr) AS ANZAHLBücher from leser L 
left join verleih v ON l.leser_nr = v.leser_nr
group by l.leser_nr, l.nameL , l.wohnort;

--task 4 
SELECT l.leser_Nr, l.nameL, l.wohnort, b.titel, v.rueckgabedatum from leser l 
left join verleih v ON l.leser_nr = v.leser_nr
left join buecher b ON v.buch_nr = b.buch_Nr
where Autor = 'Goethe';

--task 5    funktioniert jetzt ned so prächtig

SELECT vl.buch_nr, b.autor, b.titel from buecher b, verleih vl
FULL OUTER JOIN vormerk vo ON vl.buch_nr = vo.buch_nr
--where vo.buch_nr not null
order by vl.buch_nr;

-- task 6
SELECT l.leser_nr, l.nameL, l.wohnort, SUM(s.gebuehr) from leser l 
inner join strafe s ON l.leser_nr = s.leser_nr 
where (SELECT MAX(gebuehr) FROM leser le 
inner join strafe st ON le.leser_nr = st.leser_nr) > 0
group by l.leser_nr, l.nameL, l.wohnort;

--SELECT l.leser_nr, l.nameL, l.wohnort, SUM(s.gebuehr) from leser l 
--inner join strafe s ON l.leser_nr = s.leser_nr
--group by l.leser_nr, l.nameL, l.wohnort;









