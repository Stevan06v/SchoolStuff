ALTER SESSION SET NLS_LANGUAGE='ENGLISH';

DROP TABLE BUECHER CASCADE CONSTRAINTS;
DROP TABLE LESER CASCADE CONSTRAINTS;
DROP TABLE VERLEIH CASCADE CONSTRAINTS;
DROP TABLE VORMERK CASCADE CONSTRAINTS;
DROP TABLE STRAFE CASCADE CONSTRAINTS;

CREATE TABLE BUECHER (
    Buch_Nr NUMBER(6) PRIMARY KEY,
    Autor VARCHAR(255),
    Titel VARCHAR(255),
    Gruppe VARCHAR(1),
    Leihfrist NUMBER(3)
);

CREATE TABLE LESER (
    Leser_Nr NUMBER(6) PRIMARY KEY,
    Name VARCHAR(255),
    Wohnort VARCHAR(255),
    Eintrittsdatum DATE
);

CREATE TABLE VERLEIH (
    Leser_Nr NUMBER(6) REFERENCES LESER(Leser_Nr),
    Buch_Nr NUMBER(6) REFERENCES BUECHER(Buch_Nr),
    Ausleihdatum DATE,
    Rueckgabedatum DATE,
    PRIMARY KEY (Leser_Nr, Buch_Nr)
);

CREATE TABLE VORMERK (
    Leser_Nr NUMBER(6) REFERENCES LESER(Leser_Nr),
    Buch_Nr NUMBER(6) REFERENCES BUECHER(Buch_Nr),
    ReservFuerDat DATE,
    PRIMARY KEY (Leser_Nr, Buch_Nr)
);

CREATE TABLE STRAFE (
    Leser_Nr NUMBER(6) REFERENCES LESER(Leser_Nr),
    SperreBisDat DATE,
    Gebuehr NUMBER(3),
    PRIMARY KEY (Leser_Nr, SperreBisDat)
);

-- CUT: insert values into database here

-- DEBUG statements to check if the data was correctly inserted
-- SELECT Buch_Nr, Autor, Titel, Gruppe AS "G", Leihfrist FROM BUECHER;
-- SELECT Leser_Nr, Name, Wohnort, TO_CHAR(Eintrittsdatum, 'dd-MON-yy') AS "EINTRITTS" FROM LESER;
-- SELECT Leser_Nr, Buch_Nr, TO_CHAR(Ausleihdatum, 'dd-MON-yy') AS "AUSLEIHDA", TO_CHAR(Rueckgabedatum, 'dd-MON-yy') AS "RUECKGABE" FROM VERLEIH;
-- SELECT Leser_Nr, Buch_Nr, TO_CHAR(ReservFuerDat, 'dd-MON-yy') AS "RESERVFUE" FROM VORMERK;
-- SELECT Leser_Nr, TO_CHAR(SperreBisDat, 'dd-MON-yy') AS "SPERREBIS", Gebuehr FROM STRAFE;

-- 2.
SELECT B.Buch_Nr, Autor, Titel,
        TO_CHAR(ReservFuerDat, 'dd.')
        || ' '
        -- for some reason, "Month" is right padded...
        -- to circumvent this, the parts are concatenated and the month value trimmed
        || TRIM(TO_CHAR(ReservFuerDat, 'Month'))
        || ' '
        || TO_CHAR(ReservFuerDat, 'yyyy')
    AS "VORMERKDATUM"
FROM VORMERK
INNER JOIN BUECHER B on VORMERK.Buch_Nr = B.Buch_Nr;

-- same as above, but without concat & trim => ugly spaces in the month string
-- SELECT B.BUCH_NR, AUTOR, TITEL, TO_CHAR(RESERVFUERDAT, 'dd. Month yyyy') AS "VORMERKDATUM" FROM Vormerk
-- INNER JOIN BUECHER B on VORMERK.BUCH_NR = B.BUCH_NR;

-- 3.
SELECT LESER.Leser_Nr, Name, Wohnort, COUNT(Buch_Nr) AS "ANZAHLBÜCHER" FROM LESER
LEFT JOIN VERLEIH V on LESER.Leser_Nr = V.Leser_Nr
GROUP BY LESER.Leser_Nr, Name, Wohnort
ORDER BY COUNT(Buch_Nr) DESC;

-- 4.
SELECT L.Leser_Nr, Name, Wohnort, Titel, TO_CHAR(Rueckgabedatum, 'dd-MON-yy') AS "RUECKGABE" FROM VERLEIH
INNER JOIN BUECHER B on VERLEIH.Buch_Nr = B.Buch_Nr
INNER JOIN LESER L on VERLEIH.Leser_Nr = L.Leser_Nr
WHERE B.Autor LIKE 'Goe%'
ORDER BY L.Leser_Nr;

-- 5.
SELECT B.Buch_Nr, Autor, Titel, 'verliehen bis' AS "STATUS", TO_CHAR(Rueckgabedatum, 'dd.mm.yyyy') AS "DATUM" FROM VERLEIH
INNER JOIN BUECHER B on VERLEIH.Buch_Nr = B.Buch_Nr
UNION
SELECT B.Buch_Nr, Autor, Titel, 'vorgemerkt ab' AS "STATUS", TO_CHAR(ReservFuerDat, 'dd.mm.yyyy') AS "DATUM" FROM VORMERK
INNER JOIN BUECHER B on VORMERK.Buch_Nr = B.Buch_Nr
ORDER BY Buch_Nr, STATUS DESC;

-- 6.
SELECT L.Leser_Nr, Name, Wohnort, SUM(Gebuehr) FROM STRAFE
INNER JOIN LESER L on STRAFE.Leser_Nr = L.Leser_Nr
GROUP BY L.Leser_Nr, Name, Wohnort
HAVING SUM(Gebuehr) >= ALL(
    SELECT SUM(Gebuehr) FROM STRAFE
    GROUP BY Leser_Nr
);
