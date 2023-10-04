alter session SET NLS_LANGUAGE = 'ENGLISH';

drop table BUECHER cascade constraints;
drop table LESER cascade constraints;
drop table VERLEIH cascade constraints;
drop table VORMERK cascade constraints;
drop table STRAFE cascade constraints;

create table BUECHER (
    Buch_Nr number,
    Author varchar(200),
    Titel varchar(200),
    Gruppe varchar(1),
    Leihfrist number,
    constraint pk_buecher primary key (Buch_Nr)
);

create table LESER(
    Leser_Nr number,
    Name varchar(200),
    Wohnort varchar(200),
    Einstrittsdatum date,
    constraint pk_leser primary key (Leser_Nr)
);

create table VERLEIH(
    Leser_Nr number,
    Buch_Nr number,
    Ausleihdatum date,
    Rueckgabedatum date,
    constraint pk_verleih primary key (Leser_Nr,Buch_Nr),
    constraint fk_verleig_buchnr foreign key (Buch_Nr) references BUECHER,
    constraint fk_verleig_lesernr foreign key (Leser_Nr) references LESER
);

create table VORMERK(
    Leser_Nr number,
    Buch_Nr number,
    ReservFuerDat date,
    constraint pk_vormerk primary key (Leser_Nr,Buch_Nr),
    constraint fk_vormerk_buchnr foreign key (Buch_Nr) references BUECHER,
    constraint fk_vormerk_lesernr foreign key (Leser_Nr) references LESER
);

create table STRAFE(
    Leser_Nr number,
    SperrBisDat date,
    Gebuehr number,
    constraint pk_strafe primary key (Leser_Nr, SperrBisDat),
    constraint fk_strafe_lesernr foreign key (Leser_Nr) references LESER

);

---INSERT SCRIPT HERE

--- Select
--2
select bu.Buch_Nr, bu.Author, bu.Titel, vo.ReservFuerDat from VORMERK vo, BUECHER bu where vo.Buch_Nr = bu.Buch_Nr;

--3
select ls.Leser_Nr, count(*) from LESER ls, VERLEIH ve where ls.Leser_Nr = ve.Leser_Nr group by ls.Leser_Nr
union
select Leser_Nr,0 from LESER where (select count(*) from VERLEIH where LESER.Leser_Nr = VERLEIH.Leser_Nr) = 0;

--4
select ls.Leser_Nr,ls.Name, BUECHER.Buch_Nr, BUECHER.Titel from LESER ls, BUECHER, VERLEIH where VERLEIH.Leser_Nr = any(select Leser_Nr from VERLEIH, BUECHER where BUECHER.Buch_Nr = VERLEIH.Buch_Nr and BUECHER.Author like ('Goe%'))
 and ls.Leser_Nr = VERLEIH.Leser_Nr and BUECHER.Buch_Nr = VERLEIH.Buch_Nr;

--5
select buch_nr, 'verliehen ab' as STATUS, ausleihdatum from VERLEIH
union
select buch_nr, 'verliehen bis' as STATUS, Rueckgabedatum from VERLEIH
union
select Buch_Nr, 'vorgemerkt ab' as STATUS, ReservFuerDat from VORMERK;

--6
select Leser_Nr, sum(GEBUEHR) from STRAFE group by Leser_Nr having sum(Gebuehr) = (select max(sum(GEBUEHR)) from STRAFE group by Leser_Nr );