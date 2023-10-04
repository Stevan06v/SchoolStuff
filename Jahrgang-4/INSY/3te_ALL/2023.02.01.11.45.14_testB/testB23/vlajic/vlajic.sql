/*tables*/
select * from vertrag;
select * from vertragshistorie;
select * from zahlung;

--1.1
select sparte,count(sparte) from vertrag where vende is null group by sparte; 

--1.2
-- 03.06.00 nicht vorhanden! 
select vsumme from vertragshistorie where vnr = 154 and to_char(datum_von, 'dd.mm.yy') = '01.06.00';

--1.3
select distinct v.vnr, v.vbeginn from vertrag v, vertragshistorie vh
where vh.vnr = v.vnr and mod(to_char(datum_von, 'yy'),4) = 0 ;

--1.4
-- select vnr from vertragshistorie where vsumme < ;
select vnr, sum(vsumme), datum_von from vertragshistorie group by vnr , datum_von;

--1.5
select v.vnr, v.sparte, v.vbeginn, v.vende from vertrag v, zahlung z
where v.vnr = z.vnr and to_number(to_char(z.zdatum, 'yy')) - 1 is null;

--1.6
select distinct v.vnr, vh.vsumme from vertragshistorie vh, vertrag v 
where v.vnr = vh.vnr and v.vende is null;




