-- 1.1
select count(*) anzahl, sparte from vertrag where vende is null group by sparte;

-- 1.2
select vsumme from vertragshistorie where to_char(datum_von, 'DD.MM.YYYY') < '03.06.2000' and datum_von = (select max(datum_von) from vertragshistorie where vnr = 154);

-- 1.3
select vnr, vbeginn from vertrag where to_char(vbeginn, 'YYYY') = 1997 and to_char(vbeginn, 'MM') > 7 group by vnr, vbeginn order by vnr asc;

-- 1.4
select ve.vnr from vertragshistorie ve, vertrag ver where ve.vnr = ver.vnr and ver.sparte like 'P' and ve.datum_von < '31.12.02' group by ve.vnr;

-- 1.5
select ve.vnr, sparte, vbeginn, vende from vertrag ve, zahlung za where ve.vnr = za.vnr and to_number(to_char(vbeginn, 'yyyy')) = (to_number(to_char(zdatum, 'yyyy'))-1);

-- 1.6
select vnr, vsumme from vertragshistorie group by vnr, vsumme order by vnr asc;