
--1.1
select count(*) as P from vertrag
where sparte = 'P' and vnr != 454;
--bzw. null überprüfung
select count(*) as S from vertrag
where sparte = 'S';

--1.2
select h.vsumme from vertrag v, vertragshistorie h
where v.vnr = 154 and to_Char(h.datum_von, 'DD.MM.YY') between '01.02.00' and '03.06.00';

--1.3 
select vnr, vbeginn from vertrag
where vbeginn between '01.09.97' and '31.12.97';

--1.4 bekomme 3 raus, warum sollen auch nur 2 raus kommen?
select v.vnr from vertrag v, vertragshistorie h
where v.vnr = h.vnr and h.datum_von < '31.12.02' and sparte = 'P'
group by v.vnr;

--1.5
select v.vnr, v.sparte, v.vbeginn, v.vende from vertrag v, zahlung z
where z.zdatum < '01.01.22' and v.vnr != 454 and v.vnr != 387 and v.vnr != 453

--minus 
--select v.vnr, v.sparte, v.vbeginn, v.vende from vertrag v, zahlung z
--where z.zdatum >= '01.01.22'


group by v.vnr, v.sparte, v.vbeginn, v.vende
;
--1.6
select v.vnr, h.vsumme from vertrag v, vertragshistorie h
where v.vnr = h.vnr and v.vnr != 454
--and h.datum_von < (select datum_von from vertragshistorie)
;




