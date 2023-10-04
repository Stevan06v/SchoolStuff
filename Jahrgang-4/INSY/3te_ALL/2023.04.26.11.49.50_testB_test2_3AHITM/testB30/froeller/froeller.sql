-- settings
ALTER SESSION SET NLS_LANGUAGE='ENGLISH';

-- drops
DROP TABLE BUECHER CASCADE CONSTRAINTS;
DROP TABLE LESER CASCADE CONSTRAINTS;
DROP TABLE VERLEIH CASCADE CONSTRAINTS;
DROP TABLE VORMERK CASCADE CONSTRAINTS;
DROP TABLE STRAFE CASCADE CONSTRAINTS;

-- creates
CREATE TABLE BUECHER (
    Buch_Nr NUMBER(10) PRIMARY KEY,
    Autor VARCHAR(255),
    Titel VARCHAR(255),
    Gruppe VARCHAR(255),
    Leihfrist NUMBER(10)
);

CREATE TABLE LESER (
    Leser_Nr NUMBER(10) PRIMARY KEY,
    Name VARCHAR(255),
    Wohnort VARCHAR(255),
    Eintrittsdatum VARCHAR(255)
);

CREATE TABLE VERLEIH (
    Leser_Nr NUMBER(10),
    Buch_Nr NUMBER(10),
    Ausleihdatum date,
    Rueckgabedatum date,
    CONSTRAINT fk_Buch_Nr_VERLEIH FOREIGN KEY(Buch_Nr) REFERENCES BUECHER(Buch_Nr),
    CONSTRAINT fk_Leser_Nr_VERLEIH FOREIGN KEY(Leser_Nr) REFERENCES LESER(Leser_Nr)
);

CREATE TABLE VORMERK (
    Leser_Nr NUMBER(10),
    Buch_Nr NUMBER(10),
    ReservFuerDat date,
    CONSTRAINT fk_Buch_Nr_VORMERK FOREIGN KEY(Buch_Nr) REFERENCES BUECHER(Buch_Nr),
    CONSTRAINT fk_Leser_Nr_VORMERK FOREIGN KEY(Leser_Nr) REFERENCES LESER(Leser_Nr)
);

CREATE TABLE STRAFE (
    Leser_Nr NUMBER(10),
    SperreBisDat date,
    Gebuehr NUMBER(10),
    CONSTRAINT pk_strafe PRIMARY KEY(Leser_Nr, SperreBisDat),
    CONSTRAINT fk_Leser_Nr_STRAFE FOREIGN KEY(Leser_Nr) REFERENCES LESER(Leser_Nr)
);

-- inserts
insert into buecher values (1,'Goethe', 'Faust','A',30);
insert into buecher values (2,'Schiller', 'Die Räuber','A',30);
insert into buecher values (3,'Goethe', 'Wahlverwandtschaften','A',30);
insert into buecher values (4, null, 'Das Guinessbuch der Rekorde', 'B', 30);
insert into buecher values (5,'Lessing', 'Nathan der Weise','A', 30);
insert into buecher values (6,'Goethe','Die Leiden des jungen Werther', 'A',30);
insert into buecher values (7, null, 'Enzyklopädie der Klassik', 'C', 30);

insert into leser values (1,'Mayer', 'Linz','01-JUN-98');
insert into leser values (2,'Schmidt', 'Leonding', '21-AUG-96');
insert into leser values (3, 'Huber','Traun', '21-MAR-00');
insert into leser values (4,'Bauer','Marchtrenk','18-SEP-99');

insert into verleih values (1,3,'30-JAN-01','02-MAR-01');
insert into verleih values (3,1,'05-APR-01','05-MAY-01');
insert into verleih values (1,6,'18-JUL-01','17-AUG-01');
insert into verleih values (2,3,'25-MAR-99','07-OCT-99');

insert into vormerk values (3,3,'03-MAR-01');
insert into vormerk values (1,1,'06-MAY-01');
insert into vormerk values (3,6, '18-AUG-01');

insert into strafe values (1,'08-JUN-98', 50);
insert into strafe values (1,'15-DEC-00', 20);
insert into strafe values (2, '05-MAR-02', 15);
insert into strafe values (4,'07-MAY-02',50);

-- test selects
SELECT * FROM BUECHER;
SELECT * FROM LESER;
SELECT * FROM VERLEIH;
SELECT * FROM VORMERK;
SELECT * FROM STRAFE;

-- selects
-- 2)
ALTER SESSION SET NLS_DATE_FORMAT='DD.MON.YYYY';
SELECT BUCH_NR, AUTOR, TITEL, ReservFuerDat FROM BUECHER
RIGHT JOIN VORMERK USING(BUCH_NR);

-- 3)
-- SELECT l.Leser_Nr, l.Name, l.Wohnort, COUNT(v.Leser_Nr) as anzahlderbuecher FROM LESER l
-- RIGHT JOIN VERLEIH v ON l.Leser_Nr = v.Leser_Nr
-- GROUP BY v.Leser_Nr, l.Name, l.Wohnort;

SELECT v.Leser_Nr, l.Name, l.Wohnort, COUNT(v.Leser_Nr) FROM LESER l, VERLEIH v GROUP BY v.Leser_Nr, l.Name, l.Wohnort;

-- 4)
-- test selects
SELECT l.Leser_Nr, l.Name, l.Wohnort FROM LESER l;
SELECT b.Titel FROM BUECHER b;
SELECT v.Rueckgabedatum FROM VERLEIH v;

-- aufgabe
ALTER SESSION SET NLS_DATE_FORMAT='DD-MON-YY';

SELECT l.Leser_Nr, l.Name, l.Wohnort, b.Titel, v.Rueckgabedatum FROM LESER l, BUECHER b,VERLEIH v WHERE b.Autor LIKE 'Goe%';

-- 5)
ALTER SESSION SET NLS_DATE_FORMAT='DD.MON.YYYY';

SELECT b.BUCH_NR, b.AUTOR, b.TITEL, 'vorgemerkt ab', vm.ReservFuerDat FROM BUECHER b, VORMERK vm
UNION
SELECT b.BUCH_NR, b.AUTOR, b.TITEL, 'verliehen bis', v.Rueckgabedatum FROM BUECHER b, VERLEIH v;

-- 6)
SELECT s.LESER_NR, l.NAME, l.WOHNORT, SUM(s.GEBUEHR) FROM LESER l, STRAFE s GROUP BY s.LESER_NR, l.NAME, l.WOHNORT; -- HAVING... MAX()
