DROP TABLE STRAFE;
DROP TABLE VORMERK;
DROP TABLE VERLEIH;
DROP TABLE LESER;
DROP TABLE BUECHER;

ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YY';
ALTER SESSION SET NLS_DATE_LANGUAGE = 'ENGLISH';

CREATE TABLE BUECHER (
    Buch_Nr number(10) NOT NULL,
    Autor varchar2(50),
    Titel varchar2(100) NOT NULL,
    Gruppe varchar2(1) NOT NULL,
    Leihfrist number(10) NOT NULL,

    CONSTRAINT PK_BuchNr PRIMARY KEY (Buch_Nr)
);

CREATE TABLE LESER (
    Leser_Nr number(10) NOT NULL,
    Name varchar2(50) NOT NULL,
    Wohnort varchar2(100) NOT NULL,
    Eintritts DATE,

    CONSTRAINT PK_LeserNr PRIMARY KEY (Leser_Nr)
);

CREATE TABLE VERLEIH (
    Leser_Nr number(10) NOT NULL,
    Buch_Nr number(10) NOT NULL,
    Ausleihdatum date NOT NULL,
    Rueckgabedatum date NOT NULL,

    CONSTRAINT PK_VERLEIH_LeserNr_BuchNr PRIMARY KEY (Leser_Nr, Buch_Nr),
    CONSTRAINT FK_VERLEIH_LeserNr FOREIGN KEY (Leser_Nr) REFERENCES LESER(Leser_Nr),
    CONSTRAINT FK_VERLEIH_BuchNr FOREIGN KEY (Buch_Nr) REFERENCES BUECHER(Buch_Nr)
);

CREATE TABLE VORMERK (
    Leser_Nr number(10) NOT NULL,
    Buch_Nr number(10) NOT NULL,
    ReservFuerDat date Not Null,

    CONSTRAINT PK_VORMERK_LeserNr_BuchNr PRIMARY KEY (Leser_Nr, Buch_Nr),
    CONSTRAINT FK_VORMERK_LeserNr FOREIGN KEY (Leser_Nr) REFERENCES LESER(Leser_Nr),
    CONSTRAINT FK_VORMERK_BuchNr FOREIGN KEY (Buch_Nr) REFERENCES BUECHER(Buch_Nr)
);

CREATE TABLE STRAFE (
    Leser_Nr number(10) NOT NULL,
    SperreBisDat date NOT NULL,
    Gebuehr number(10) NOT NULL,

    CONSTRAINT PK_STRAFE_LeserNr_SperreBisDat PRIMARY KEY (Leser_Nr, SperreBisDat),
    CONSTRAINT FK_STRAFE_LeserNr FOREIGN KEY (Leser_Nr) REFERENCES LESER(Leser_Nr)
);


-- 2.
SELECT v.BUCH_NR, b.Autor, b.Titel, v.ReservFuerDat AS VORMERKDATUM FROM VORMERK v
    left join BUECHER B
        on B.Buch_Nr = v.Buch_Nr;


-- 3.
SELECT l.Leser_Nr, l.Name, l.Wohnort, COUNT(v.Ausleihdatum) FROM LESER l
    left join VERLEIH v
        on l.Leser_Nr = v.Leser_Nr
    group by l.Leser_Nr, l.Name, l.Wohnort
    order by l.Leser_Nr;

-- 4. not working correctly
SELECT  l.Leser_Nr, l.Name, l.Wohnort, b.Titel, v.Rueckgabedatum FROM LESER l, VERLEIH v
    left join BUECHER b
        on b.Autor = (SELECT Autor from BUECHER where Autor LIKE 'Goe%')
    order by l.NAME;





-- 5. not working
SELECT b.Buch_Nr, b.Autor, b.Titel,  FROM BUECHER b


-- 6.
SELECT l.Leser_Nr, l.Name, l.Wohnort, SUM(s.Gebuehr) AS SUM_GEBUEHR From LESER l
    left join STRAFE S
        on l.Leser_Nr = S.Leser_Nr
    where Gebuehr != 0
    group by l.Leser_Nr, l.Name, l.Wohnort
    order by SUM(s.Gebuehr) desc
    fetch first row only;