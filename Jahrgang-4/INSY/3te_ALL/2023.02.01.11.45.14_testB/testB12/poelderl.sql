--1
SELECT COUNT(sparte), sparte FROM vertrag WHERE vende IS NULL GROUP BY sparte;

--2
SELECT vsumme FROM vertragshistorie WHERE TO_CHAR(datum_von, 'YYYY') like 2000 AND TO_CHAR(datum_von, 'MM') = 6 AND vnr = 154;

--3
SELECT vnr, vbeginn FROM vertrag WHERE TO_CHAR(vbeginn, 'YYYY') like 1997 AND TO_CHAR(vbeginn, 'MM') > 9;

--4
SELECT vh.vnr FROM vertragshistorie vh, vertrag v
MINUS
SELECT vh.vnr FROM vertragshistorie vh, vertrag v WHERE TO_CHAR(vh.datum_von, 'YYYY') > 2002;

--5
SELECT v.vnr, sparte, vbeginn, vende FROM vertrag v, zahlung z WHERE vende IS NULL GROUP BY v.vnr, sparte, vbeginn, vende
MINUS
SELECT v.vnr, sparte, vbeginn, vende FROM vertrag v, zahlung z WHERE TO_CHAR(z.zdatum, 'YYYY') > 2022;

--6
SELECT vh.vnr, vh.vsumme FROM vertragshistorie vh, vertrag v WHERE v.vende IS NULL GROUP BY vh.vnr, vh.vsumme;
