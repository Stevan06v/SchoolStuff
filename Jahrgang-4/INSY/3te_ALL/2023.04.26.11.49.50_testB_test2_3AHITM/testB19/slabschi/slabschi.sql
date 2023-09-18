------------------------------------- 1 ------------------------------------------
alter session set NLS_LANGUAGE  = 'ENGLISH';

drop table STRAFE;
drop table VORMERK;
drop table VERLEIH;
drop table LESER;
drop table BUECHER;

create table BUECHER (
                         BUCH_NR number primary key,
                         AUTOR varchar2(100),
                         TITEL varchar2(100),
                         GRUPPE varchar2(1),
                         LEIHFRIST number
);
create table LESER (
                       LESER_NR number primary key,
                       NAME varchar2(100),
                       WOHNORT varchar2(100),
                       EINTRITTSDATUM DATE
);
create table VERLEIH (
                         LESER_NR number references LESER(LESER_NR),
                         BUCH_NR number references BUECHER(BUCH_NR),
                         AUSLEIHDATUM DATE,
                         RUECKGABEDATUM DATE,
                         primary key (LESER_NR, BUCH_NR)
);
create table VORMERK(
                        LESER_NR number references LESER(LESER_NR),
                        BUCH_NR number references BUECHER(BUCH_NR),
                        RESERVFUERDAT DATE,
                        primary key (LESER_NR, BUCH_NR)
);
create table STRAFE(
                       LESER_NR number references LESER(LESER_NR),
                       SPERREBISDAT DATE,
                       GEBUEHR number,
                       primary key (LESER_NR, SPERREBISDAT)
);


-------------------------------------- 2 -------------------------------------------
select bu.BUCH_NR, AUTOR, TITEL, TO_CHAR(RESERVFUERDAT, 'DD.Month YYYY') VORMERKDATUM from BUECHER bu, VORMERK vo
where bu.BUCH_NR = vo.BUCH_NR;


------------------------------------- 3 ------------------------------------------------
select le.LESER_NR, NAME, WOHNORT, count(BUCH_NR) ANZAHLBÜCHER FROM LESER le
                                                                        full join VERLEIH V on le.LESER_NR = V.LESER_NR
group by EINTRITTSDATUM, le.LESER_NR, NAME, WOHNORT order by count(BUCH_NR) desc;


---------------------------------------- 4 -------------------------------------------
select le.LESER_NR, NAME, WOHNORT, TITEL,TO_CHAR(RUECKGABEDATUM, 'DD-MON-YY') RUECKGABE from LESER le, VERLEIH ve, BUECHER bu
where le.LESER_NR = ve.LESER_NR and bu.BUCH_NR = ve.BUCH_NR and AUTOR like 'Goe%';


----------------------------------- 5 -----------------------------------------
select ve.BUCH_NR, AUTOR, TITEL, 'verliehen bis' STATUS, TO_CHAR(RUECKGABEDATUM, 'DD.MM.YYYY') DATUM from VERLEIH ve, BUECHER bu
where ve.BUCH_NR = bu.BUCH_NR
UNION
select vo.BUCH_NR, AUTOR, TITEL, 'vorgemerkt ab' STATUS,TO_CHAR(RESERVFUERDAT, 'DD.MM.YYYY') DATUM from VORMERK vo, BUECHER bu
where vo.BUCH_NR = bu.BUCH_NR;


-------------------------------------- 6 ----------------------------------------
select st.LESER_NR, NAME, WOHNORT, SUM(GEBUEHR)from STRAFE st, LESER le
where st.LESER_NR = le.LESER_NR group by st.LESER_NR, NAME, WOHNORT;