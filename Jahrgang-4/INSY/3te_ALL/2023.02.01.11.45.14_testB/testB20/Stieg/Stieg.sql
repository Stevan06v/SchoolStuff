DROP TABLE zahlung;
DROP TABLE vertragshistorie;
DROP TABLE vertrag;
Create table vertrag (
Vnr number(4),
sparte varchar2(1) check (sparte in ('P','S')),
vbeginn date,
vende date,
CONSTRAINT pk_vertrag PRIMARY KEY(Vnr));
Create table vertragshistorie (
Vnr number(4),
datum_von date,
vsumme number(10),
CONSTRAINT pk_vertragshistorie  PRIMARY KEY (Vnr,datum_von),
CONSTRAINT fk_pk_vertragshistorie_vertrag FOREIGN KEY (Vnr) REFERENCES vertrag(Vnr));
Create table zahlung (
Vnr number(4),
zdatum date,
betrag number(10),
CONSTRAINT pk_zahlung PRIMARY KEY (Vnr,zdatum),
CONSTRAINT fk_pk_zahlung_vertrag FOREIGN KEY (Vnr) REFERENCES vertrag(Vnr));


Insert into Vertrag values (154,'P','11.12.97',NULL);
Insert into Vertrag values (387,'P','06.06.02',NULL);
Insert into Vertrag values (453,'S','04.11.97',NULL);
Insert into Vertrag values (454,'P','05.02.97','01.06.01');
Insert into Vertrag values (500,'P','23.01.03',NULL);

insert into Vertragshistorie values (154,'11.12.97',100000);
insert into Vertragshistorie values (154,'01.06.00',115000);
insert into Vertragshistorie values (154,'01.01.00',130000);
insert into Vertragshistorie values (387,'06.06.03',220000);
insert into Vertragshistorie values (453,'04.11.97',110000);
insert into Vertragshistorie values (453,'01.01.00',120000);
insert into Vertragshistorie values (454,'05.02.97',90000);
insert into Vertragshistorie values (500,'12.03.03',220000);



insert into Zahlung values(154,'01.01.98',320);
insert into Zahlung values(154,'01.01.99',300);
insert into Zahlung values(154,'01.01.00',300);
insert into Zahlung values(154,'10.06.00',40);
insert into Zahlung values(154,'01.01.01',320);
insert into Zahlung values(154,'01.01.02',320);
insert into Zahlung values(387,'10.06.99',300);
insert into Zahlung values(387,'10.01.00',500);
insert into Zahlung values(387,'10.01.01',500);
insert into Zahlung values(387,'10.01.18',500);
insert into Zahlung values(387,'10.01.22',500);
insert into Zahlung values(453,'10.12.97',32);
insert into Zahlung values(453,'10.12.98',350);
insert into Zahlung values(453,'10.12.99',350);
insert into Zahlung values(453,'10.12.00',420);
insert into Zahlung values(453,'10.12.01',420);
insert into Zahlung values(453,'10.12.18',420);
insert into Zahlung values(453,'10.01.22',420);
insert into Zahlung values(454,'01.06.01',3250);
insert into Zahlung values(454,'02.06.18',3250);

commit;

--------------------------------------------------------------------------------

-- 1.1

SELECT count(*) as ANZAHL, sparte FROM VERTRAG
WHERE VENDE IS NULL group by sparte;

-- 1.2

SELECT vsumme FROM VERTRAGSHISTORIE vh
WHERE vnr = 154 AND to_date(to_char(datum_von, 'dd.mm.yyyy'), 'dd.mm.yyyy') <= to_date('03.06.2000', 'dd.mm.yyyy') AND datum_von >= ALL(SELECT datum_von FROM VERTRAGSHISTORIE WHERE vnr = vh.vnr);

-- 1.3

SELECT z.vnr, v.vbeginn FROM ZAHLUNG z, VERTRAG v
WHERE v.vnr = ANY(SELECT vnr FROM ZAHLUNG) AND to_date(to_char(z.zdatum, 'dd.mm.yyyy'), 'dd.mm.yyyy') BETWEEN to_date('01.08.1997', 'dd.mm.yyyy') AND to_date('01.01.1998', 'dd.mm.yyyy')
AND v.vbeginn = (SELECT vbeginn FROM VERTRAG WHERE vnr = z.vnr) group by z.vnr, v.vbeginn order by z.vnr;


-- 1.4

SELECT vh.vnr FROM VERTRAGSHISTORIE vh, VERTRAG ve
WHERE vh.vnr = ve.vnr AND ve.sparte = 'P' AND to_date(to_char(vh.datum_von, 'dd.mm.yyyy'), 'dd.mm.yyyy') < to_date('31.12.2002', 'dd.mm.yyyy') group by vh.vnr;

-- 1.5

SELECT * FROM VERTRAG v
WHERE VENDE IS NULL AND NOT EXISTS(SELECT * FROM ZAHLUNG WHERE vnr = v.vnr AND to_number(to_char(zdatum, 'YYYY')) <= to_number(to_char(v.vbeginn, 'YYYY')));

-- 1.6

SELECT vh.vnr, vh.vsumme FROM VERTRAG ve, VERTRAGSHISTORIE vh
WHERE ve.VENDE IS NULL AND vh.vsumme >= ALL(SELECT vsumme FROM VERTRAGSHISTORIE WHERE vnr = ve.vnr) group by vh.vnr, vh.vsumme order by vh.vnr;