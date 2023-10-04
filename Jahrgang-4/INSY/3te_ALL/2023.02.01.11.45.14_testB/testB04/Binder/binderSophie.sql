-- Binder Sophie 04

--1.1 
Select count(*), sparte from vertrag
where vende is null group by sparte;

--1.2

Select vsumme from vertragshistorie
where vnr in 154 and datum_von < '03.06.00';

--1.3
Select distinct vnr, vbeginn from vertrag
where to_char(vbeginn,'YYYY') ='1997' and (to_char(vbeginn,'MM') = '11' OR to_char(vbeginn,'MM') = '10' or to_char(vbeginn,'MM') = '12');


--1.4
Select hi.vnr from vertragshistorie hi, vertrag ve
where hi.vnr = ve.vnr and ve.sparte = 'P'
minus
Select hi.vnr from vertragshistorie hi, vertrag ve
where hi.vnr = ve.vnr and hi.datum_von > '31.12.02';


--1.5
Select ve.vnr, sparte, vbeginn, vende from vertrag ve, zahlung za
where za.vnr(+) = ve.vnr and vende is null 
minus
Select ve.vnr, sparte, vbeginn, vende from vertrag ve, zahlung za
where za.vnr(+) = ve.vnr  and  za.zdatum > ALL(Select zdatum from zahlung where zdatum < '01.01.22') ; 

--1.6
Select hi.vnr ,vsumme from vertragshistorie hi, vertrag ve
where ve.vnr = hi.vnr and ve.vende is null and datum_von = (Select MAX(datum_von) from vertragshistorie where hi.vnr = vnr);










