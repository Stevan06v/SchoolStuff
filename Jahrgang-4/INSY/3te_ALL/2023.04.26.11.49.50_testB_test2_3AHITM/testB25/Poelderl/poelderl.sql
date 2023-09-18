--1
DROP TABLE strafe;
DROP TABLE vormerk;
DROP TABLE verleih;
DROP TABLE buecher;
DROP TABLE leser;

ALTER SESSION SET NLS_DATE_FORMAT = 'DD-Mon-YY';
ALTER SESSION SET NLS_LANGUAGE = 'ENGLISH';

CREATE TABLE buecher (
    buch_nr int,
    autor varchar2(25),
    titel varchar2(40),
    gruppe CHAR,
    leihfrist int,
    PRIMARY KEY (buch_nr)
);
CREATE TABLE leser (
    leser_nr int,
    name varchar2(20),
    wohnort varchar2(20),
    eintrittsdatum date,
    PRIMARY KEY (leser_nr)
);
CREATE TABLE verleih (
    leser_nr int,
    buch_nr int,
    ausleihdatum date,
    eintrittsdatum date,
    PRIMARY KEY (leser_nr, buch_nr),
    FOREIGN KEY (leser_nr) REFERENCES leser (leser_nr),
    FOREIGN KEY (buch_nr) REFERENCES buecher (buch_nr)
);
CREATE TABLE vormerk (
    leser_nr int,
    buch_nr int,
    reservfuerdat date,
    PRIMARY KEY (leser_nr, buch_nr),
    FOREIGN KEY (leser_nr) REFERENCES leser (leser_nr),
    FOREIGN KEY (buch_nr) REFERENCES buecher (buch_nr)
);
CREATE TABLE strafe (
    leser_nr int,
    sperrebisdat date,
    gebuehr int,
    PRIMARY KEY (leser_nr, sperrebisdat),
    FOREIGN KEY (leser_nr) REFERENCES leser (leser_nr)
);

--2
SELECT b.buch_nr, b.autor, b.titel, vo.reservfuerdat vormerkdatum
        FROM buecher b,vormerk vo
        WHERE b.buch_nr = vo.buch_nr;

--3
SELECT l.leser_nr, l.name, l.wohnort, count(v.leser_nr) Anzahlbücher
        FROM leser l
        LEFT JOIN verleih v on l.leser_nr = v.leser_nr
        GROUP BY (l.leser_nr, l.name, l.wohnort)
        ORDER BY count(v.leser_nr) desc;

--4
SELECT l.leser_nr, l.name, l.wohnort, b.titel, v.eintrittsdatum
        FROM leser l, buecher b, verleih v
        WHERE l.leser_nr = v.leser_nr
        AND v.buch_nr = b.buch_nr
        ORDER BY l.leser_nr;

--5
SELECT b.buch_nr, b.autor, b.titel, ve.eintrittsdatum, MAX(vo.reservfuerdat) vormerkdatum
        FROM buecher b, vormerk vo, verleih ve
        WHERE b.buch_nr = ve.buch_nr
        AND b.buch_nr = vo.buch_nr
        GROUP BY (b.buch_nr, b.autor, b.titel, ve.eintrittsdatum)
        ORDER BY b.buch_nr;

--6
SELECT l.leser_nr, l.name, l.wohnort, SUM(s.gebuehr)
        FROM leser l, strafe s
        WHERE l.leser_nr = s.leser_nr
        GROUP BY (l.leser_nr, l.name, l.wohnort)
MINUS
SELECT l.leser_nr, l.name, l.wohnort, s.gebuehr
        FROM leser l, strafe s
        WHERE l.leser_nr = s.leser_nr;
