--Sophie Binder


--1

Create Table Buecher(
    BuchNr Number(5) constraint pk_buecher Primary Key,
    Autor Varchar(32),
    Titel Varchar(100),
    Gruppe Varchar(10),
    Leihfrist Number(5)
);

Create Table Leser(
    LeserNr Number(5) constraint pk_leser Primary Key,
    Name Varchar(32),
    Wohnort Varchar(32),
    Eintrittsdatum DATE
);

Create Table Verleih(
    LeserNr Number(5) constraint fk_leser REFERENCES Leser,
    BuchNr Number(5) constraint fk_buech REFERENCES Buecher,
    Ausleihdatum DATE,
    Rueckgabedatum DATE,
    Constraint pk_verleih Primary Key (LeserNr, BuchNr)
);

Create Table Vormerk(
    LeserNr Number(5) constraint fk_leserV REFERENCES Leser,
    BuchNr Number(5) constraint fk_buechV REFERENCES Buecher,
    ReservFuerDat DATE,
    Constraint pk_vormerk Primary Key (LeserNr, BuchNr)
);

Create Table Strafe(
    LeserNr Number(5) constraint fk_leserS REFERENCES Leser,
    SperrebisDat DATE,
    Gebuehr Number(5),
    CONSTRAINT pk_strafe Primary Key (LeserNr, SperrebisDat)
);


Alter Session SET NLS_LANGUAGE = 'English';

--2
Select b.BuchNr, b.autor, b.titel, v.reservFuerDat from Buecher b, Vormerk v
where b.BuchNr = v.BuchNr;


--3
Select l.LeserNr, l.name, l.wohnort, count(v.buchNr) from verleih v, Leser l
where v.LeserNr (+)= l.LeserNr group by l.LeserNr, l.name, l.wohnort;

--4
Select l.LeserNr, l.name, l.wohnort, b.titel, v.Rueckgabedatum from leser l, buecher b, verleih v
where l.leserNr = v.leserNr and b.BuchNr = v.BuchNr and b.autor like 'Goe%';

--5
Select b.buchNr, b.autor, b.titel ,'verliehen bis' as status, v.Rueckgabedatum from Buecher b, verleih v
where b.BuchNr = v.BuchNr
UNION
Select b.buchNr, b.autor, b.titel,'vorgemerkt ab' as status, vo.ReservFuerDat from Buecher b, vormerk vo
where b.BuchNr = vo.BuchNr;


--6
Select l.LeserNr, l.name, l.wohnort, sum(s.gebuehr) from leser l, strafe s
where l.LeserNr = s.LeserNr group by l.LeserNr, l.name, l.wohnort having sum(s.gebuehr) = (Select Max(sum(gebuehr)) from strafe group by LeserNr);



--insert

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

