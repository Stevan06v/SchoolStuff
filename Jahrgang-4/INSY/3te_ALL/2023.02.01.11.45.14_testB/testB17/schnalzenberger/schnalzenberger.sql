--1.1
select count(sparte), sparte from vertrag where vende is null group by sparte;

--1.2
select vsumme from vertragshistorie where vnr=154 and to_char(datum_von, 'YYYY')='2000' and to_char(datum_von, 'MM')>any(select to_char(datum_von, 'MM') from vertragshistorie);

--1.3
select vnr,vbeginn from vertrag where to_char(vbeginn, 'YYYY')='1997' and vende is null;

--1.4c
select vnr from vertragshistorie where to_char(datum_von, 'YYYY')<'2002' group by vnr
minus
select vnr from vertragshistorie where to_char(datum_von, 'YYYY')>'2002' group by vnr;

--1.5
select v.vnr,v.sparte,v.vbeginn,v.vende from vertrag v inner join zahlung z on v.vnr=z.vnr;

--1.6
select v.vnr, vh.vsumme from vertrag v inner join vertragshistorie vh on v.vnr=vh.vnr where v.vende is null;


