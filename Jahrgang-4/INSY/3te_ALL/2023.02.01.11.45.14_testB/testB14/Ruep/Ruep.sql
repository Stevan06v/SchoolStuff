-- Ruep Michael test
select * from vertrag;
select * from vertragshistorie;
select * from zahlung;

--1.1
select count(vnr), sparte from vertrag
where vende is NULL
group by sparte;

--1.2
select vsumme from vertragshistorie vh
where vnr = 154 
and datum_von <= to_date('03.06.2006') -- vor oder am 03.06.06
and datum_von >= ALL -- das neueste vor oder am 03.06.06
(select datum_von from vertragshistorie where vnr=vh.vnr);

--1.3
select vnr, vbeginn from vertrag
where vbeginn between
to_date('1.07.1997') and to_date('31.12.1997');

--1.4
select vh.vnr from vertragshistorie vh, vertrag v
where vh.vnr = v.vnr and v.sparte like 'P' --personen 
and vh.datum_von < to_date('31.12.2002')
and vh.vnr not in
(select vnr from vertragshistorie where datum_von >= to_date('31.12.2002')) group by vh.vnr;

--1.5
select * from vertrag where vnr in
(select vnr from vertrag where vende is NULL
minus
select vnr from zahlung where to_number(to_char(zdatum,'YYYY')) = 2022);


--1.6
select v.vnr, vsumme from vertrag v, vertragshistorie vh
where v.vnr=vh.vnr
and v.vende is NULL 
and datum_von >= ALL 
(select datum_von from vertragshistorie where vnr=v.vnr);