DROP TABLE buecher CASCADE CONSTRAINTS;
DROP TABLE leser CASCADE CONSTRAINTS;
DROP TABLE verleih CASCADE CONSTRAINTS;
DROP TABLE vormerk CASCADE CONSTRAINTS;
DROP TABLE strafe CASCADE CONSTRAINTS;




CREATE TABLE buecher (
    Buch_Nr NUMBER PRIMARY KEY ,
    Autor VARCHAR(255),
    Titel VARCHAR(255),
    Gruppe CHAR,
    Leihfrist NUMBER
);

CREATE TABLE leser (
    Leser_Nr NUMBER PRIMARY KEY ,
    Name VARCHAR(255),
    Wohnort VARCHAR(255),
    Eintrittsdatum DATE
);

CREATE TABLE verleih (
    Leser_Nr NUMBER REFERENCES leser,
    Buch_Nr NUMBER REFERENCES buecher,
    Ausleihdatum DATE,
    Rueckgabedatum DATE,
    PRIMARY KEY (Leser_Nr, Buch_Nr)
);

CREATE TABLE vormerk (
    Leser_Nr NUMBER REFERENCES leser,
    Buch_Nr NUMBER REFERENCES buecher,
    reservFuerDat DATE,
    PRIMARY KEY (Leser_Nr, Buch_Nr)
);

CREATE TABLE strafe (
    Leser_Nr NUMBER REFERENCES leser,
    SperreBisDat DATE,
    Gebuehr NUMBER,
    PRIMARY KEY (Leser_Nr, SperreBisDat)
);

ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YY';
ALTER SESSION SET NLS_LANGUAGE = 'ENGLISH';




-- 2)
select buecher.Buch_Nr, Autor, Titel, reservFuerDat from vormerk, buecher where vormerk.Buch_Nr = buecher.Buch_Nr;
-- select * from vormerk;


--3)
-- SELECT verleih.Leser_Nr, Name, count(verleih.Buch_Nr) AS AnzahlBuecher from leser, verleih group by verleih.Leser_Nr having Name = 'Mayer';
select Leser_Nr, count(Buch_Nr) AS AnzahlBuecher from verleih group by Leser_Nr;
--select count(*) from verleih group by Leser_Nr

--4)
-- select * from leser, buecher join BUECHER B on buecher.Autor = B.AUTOR where B.Autor = 'Goethe';
select leser.*, buecher.Titel from leser, buecher where Autor LIKE 'Goe%';


--5)




--6)
select * from leser where (select max(sum(Gebuehr)) from strafe group by Leser_Nr) = 70;
