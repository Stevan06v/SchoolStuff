--1)
select count(*), sparte from Vertrag where vende is NULL group by sparte;

--2)
select vsumme from vertragshistorie where vnr = 154 and to_char(datum_von, 'MM.YYYY') = '06.2000';

--3)
select vnr, vbeginn from Vertrag where to_char(vbeginn, 'MM.YYYY') > '09.1997';

--4)
select vh.vnr from vertragshistorie vh, vertrag where sparte = 'P' and to_char(datum_von, 'DD.MM.YY') < '31.12.02' group by vh.vnr;

select vnr from vertragshistorie where vnr = 154 or vnr = 500 group by vnr;

--5)
select * from Vertrag where '22' != any(select to_char(zdatum, 'YY') from Zahlung group by to_char(zdatum, 'YY'));

--6)
select vh.vnr, vsumme from vertragshistorie vh
left join vertrag ve on vh.vnr = ve.vnr where vende is NULL and to_char(datum_von, 'MM.YYYY') = '06.2000' or to_char(datum_von, 'MM.YYYY') = '06.2003' or vsumme = 120000 or to_char(datum_von, 'MM.YYYY') = '03.2003';



