ALTER SESSION SET nls_date_language = 'ENGLISH';

DROP TABLE STRAFE;
DROP TABLE VORMERK;
DROP TABLE VERLEIH;
DROP TABLE LESER;
DROP TABLE BUECHER;


CREATE TABLE BUECHER (
    Buch_Nr NUMBER CONSTRAINT pk_buecher PRIMARY KEY,
    Autor VARCHAR2(32),
    Titel VARCHAR2(64) NOT NULL,
    Gruppe CHAR(1) NOT NULL,
    Leihfrist NUMBER NOT NULL
);

CREATE TABLE LESER(
    Leser_Nr NUMBER CONSTRAINT pk_leser PRIMARY KEY,
    Name VARCHAR2(32) NOT NULL,
    Wohnort VARCHAR2(32) NOT NULL,
    Eintrittsdatum DATE NOT NULL
);

CREATE TABLE VERLEIH(
    Leser_Nr NUMBER CONSTRAINT fk_leser REFERENCES LESER,
    Buch_NR NUMBER CONSTRAINT fk_buecher REFERENCES BUECHER,
    Ausleihdatum DATE NOT NULL,
    Rueckgabedatum DATE NOT NULL,
    CONSTRAINT pk_verleih PRIMARY KEY (Leser_Nr, Buch_Nr)
);

CREATE TABLE VORMERK(
    Leser_Nr NUMBER CONSTRAINT fk_leser1 REFERENCES LESER,
    Buch_NR NUMBER CONSTRAINT fk_buecher1 REFERENCES BUECHER,
    ReservFuerDat DATE NOT NULL,
    CONSTRAINT pk_vormerk PRIMARY KEY (Leser_Nr, Buch_Nr)
);

CREATE TABLE STRAFE(
    Leser_Nr NUMBER CONSTRAINT fk_leser2 REFERENCES LESER,
    SperreBisDat DATE NOT NULL,
    Gebuehr NUMBER NOT NULL,
    CONSTRAINT pk_strafe PRIMARY KEY(Leser_Nr, SperreBisDat)
);

-- 2.

SELECT bu.Buch_Nr, bu.Autor, bu.Titel, to_char(vo.ReservFuerDat, 'DD. Month YYYY') as Vormerkdatum FROM BUECHER bu, VORMERK vo
WHERE bu.Buch_Nr = vo.Buch_Nr;

-- 3.

SELECT le.Leser_Nr, le.Name, le.Wohnort, count(ve.Leser_Nr) as Anzahlbücher FROM LESER le, VERLEIH ve
WHERE le.Leser_Nr = ve.Leser_Nr GROUP BY le.Leser_Nr, le.Name, le.Wohnort
UNION
SELECT le.Leser_Nr, le.Name, le.Wohnort, 0 FROM LESER le
WHERE le.Leser_Nr != ALL(SELECT Leser_Nr FROM VERLEIH);

-- 4.

SELECT le.Leser_Nr, le.Name, le.Wohnort, bu.Titel, ve.Rueckgabedatum as Rueckgabe FROM LESER le, BUECHER bu, VERLEIH ve
WHERE ve.Leser_Nr = le.Leser_Nr AND ve.Buch_Nr = bu.Buch_Nr AND bu.Autor = 'Goethe';

-- 5.

SELECT bu.Buch_Nr, bu.Autor, bu.Titel, 'vorgemerkt ab' as Status, vo.ReservFuerDat Datum FROM BUECHER bu, VORMERK vo, VERLEIH ve
WHERE bu.Buch_Nr = vo.Buch_Nr 
UNION
SELECT bu.Buch_Nr, bu.Autor, bu.Titel, 'verliehen bis' as Status, ve.Rueckgabedatum FROM BUECHER bu, VORMERK vo, VERLEIH ve
WHERE bu.Buch_Nr = ve.Buch_Nr;

-- 6.

SELECT le.Leser_Nr, le.Name, le.Wohnort, sum(st.gebuehr) FROM LESER le, STRAFE st
WHERE le.Leser_Nr = st.Leser_Nr GROUP BY le.Leser_Nr, le.Name, le.Wohnort
HAVING sum(st.gebuehr) >= ALL(SELECT sum(gebuehr) FROM STRAFE GROUP BY Leser_Nr);
