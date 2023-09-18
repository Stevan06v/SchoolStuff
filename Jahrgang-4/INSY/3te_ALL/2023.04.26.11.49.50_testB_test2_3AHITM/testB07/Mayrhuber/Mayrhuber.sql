--1)

DROP TABLE VORMERK;
DROP TABLE VERLEIH;
DROP TABLE STRAFE;
DROP TABLE LESER;
DROP TABLE BUECHER;




CREATE TABLE BUECHER(
    Buch_Nr NUMBER(11) NOT NULL,
    Autor VARCHAR2(32),
    Titel VARCHAR2(64),
    Gruppe VARCHAR2(1),
    Leihfrist number(4),
    CONSTRAINT B_PK_BNR PRIMARY KEY ( Buch_Nr )
);

CREATE TABLE LESER(
    Leser_Nr NUMBER(11) NOT NULL,
    Name VARCHAR2(32),
    Wohnort VARCHAR2(64),
    Eintrittsdatum date,
    CONSTRAINT L_PK_LNR PRIMARY KEY ( Leser_Nr )
);

CREATE TABLE VERLEIH(
    Leser_Nr NUMBER(11) NOT NULL,
    Buch_Nr NUMBER(11) NOT NULL,
    Ausleihdatum date,
    Rueckgabedatum date,
    CONSTRAINT VE_PK_LNR_BNR PRIMARY KEY ( Leser_Nr, Buch_Nr ),
    CONSTRAINT VE_B_FK FOREIGN KEY (Buch_Nr) REFERENCES BUECHER (Buch_Nr),
    CONSTRAINT VE_L_FK FOREIGN KEY (Leser_Nr) REFERENCES LESER (Leser_Nr)
);

CREATE TABLE VORMERK(
    Leser_Nr NUMBER(11) NOT NULL,
    Buch_Nr NUMBER(11) NOT NULL,
    ReservFuerDat date,
    CONSTRAINT VO_PK_LNR_BNR PRIMARY KEY ( Leser_Nr, Buch_Nr ),
    CONSTRAINT VO_B_FK FOREIGN KEY (Buch_Nr) REFERENCES BUECHER (Buch_Nr),
    CONSTRAINT VO_L_FK FOREIGN KEY (Leser_Nr) REFERENCES LESER (Leser_Nr)
);

CREATE TABLE STRAFE(
    Leser_Nr NUMBER(11) NOT NULL,
    SperreBisDat date,
    Gebuehr number(4),
    CONSTRAINT S_PK_LNR_SBD PRIMARY KEY ( Leser_Nr, SperreBisDat ),
    CONSTRAINT S_L_FK FOREIGN KEY (Leser_Nr) REFERENCES LESER (Leser_Nr)
);

--2)
SELECT l.Leser_Nr, NAME,B.Titel, TO_CHAR(ReservFuerDat, 'dd. Month yyyy') as "VORMERKDATUM"
    from LESER l INNER JOIN VORMERK V
        on l.Leser_Nr = V.Leser_Nr
    inner join BUECHER B on B.Buch_Nr = V.Buch_Nr;
	
--3)
SELECT L.Leser_NR, NAME, WOHNORT, COUNT(V.Leser_Nr)
    from LESER l full join VERLEIH V
        on l.Leser_Nr = V.Leser_Nr
    group by L.Leser_NR, NAME, WOHNORT;
	
--4)
SELECT L.Leser_Nr, Name, Wohnort,Titel, Rueckgabedatum
    from LESER L INNER JOIN VERLEIH V
        on L.Leser_Nr = V.Leser_Nr
    INNER JOIN BUECHER B
        on B.Buch_Nr = V.Buch_Nr
    where Autor like '%Goe%';

--5)
SELECT b.BUCH_NR, AUTOR, (SELECT 'verliehen bis' from dual) as STATUS, Rueckgabedatum
    from VERLEIH V left join BUECHER B on V.BUCH_NR = B.BUCH_NR ;

	
--6)
SELECT S.Leser_Nr ,Name,Wohnort, SUM(Gebuehr) from LESER L, STRAFE S
WHERE L.Leser_Nr = S.Leser_Nr
GROUP BY S.Leser_Nr, Name, Wohnort
ORDER BY SUM(Gebuehr) DESC
fetch first row only;