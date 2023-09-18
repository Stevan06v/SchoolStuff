--1.1
select count(*), sparte from vertrag
where vende is null group by sparte;

--1.2
select vsumme from vertragshistorie
where vnr = 154 and datum_von <= '03.06.00';

--1.3
select vnr, datum_von from vertragshistorie
where to_char(datum_von, 'MM') >= '10';

--1.4
select vnr from vertrag
where sparte = 'P' and vnr = any(select vnr from vertragshistorie where '31.12.02' >= datum_von);

--1.5
select * from vertrag v where vende is null and v.sparte = 'P'
intersect
select * from vertrag v where vnr = any(select vnr from zahlung z where to_char(v.vbeginn, 'YYYY') < to_char(z.zdatum, 'YYYY'));

--1.6
select vh.vnr, sum(vsumme) from vertragshistorie vh
where vh.vnr = any(select vt.vnr from vertrag vt where vt.vende is null and vh.datum_von != vt.vbeginn)
group by vh.vnr;