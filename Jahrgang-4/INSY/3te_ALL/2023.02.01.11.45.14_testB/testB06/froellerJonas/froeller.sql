-- Personenversicherung
-- Sachversicherung

SELECT * FROM vertrag; 
SELECT * FROM vertragshistorie;
SELECT * FROM zahlung; 

-- 1.1)
SELECT * FROM vertrag WHERE vende IS NULL;

-- 1.2)
SELECT * FROM vertragshistorie WHERE vnr = 154 AND TO_CHAR(datum_von, 'dd.mm.YYYY') LIKE '03.06.2000'; -- 1.6. => 115000

-- 1.3)
SELECT * FROM vertragshistorie WHERE TO_CHAR(datum_von, 'YYYY') LIKE '1997' AND TO_NUMBER(TO_CHAR(datum_von, 'mm')) BETWEEN 9 AND 12; -- TO_NUMBER(TO_CHAR(datum_von, 'mm')/4) BETWEEN 1 AND 3;

-- 1.4)
SELECT vnr FROM vertragshistorie
WHERE TO_CHAR(datum_von, 'dd.mm.YY') < '31.12.02'
MINUS
SELECT vnr FROM vertrag
WHERE sparte LIKE 'S';

SELECT DISTINCT v.vnr FROM vertrag v
RIGHT JOIN vertragshistorie vh
ON v.vnr = vh.vnr
WHERE sparte LIKE 'P' AND TO_CHAR(datum_von, 'dd.mm.YY') < '31.12.02';

-- 1.5)
SELECT * FROM vertrag v WHERE vnr IN(SELECT vnr FROM vertragshistorie WHERE TO_NUMBER(zdatum, 'YY') != (TO_NUMBER(vbeginn, 'YY')-1)); -- (TO_NUMBER(vbeginn, 'YY')-1) as yearBefore

--SELECT * FROM vertrag v WHERE vnr IN(SELECT vnr FROM vertragshistorie) AND (vende IS NULL) MINUS ...;

-- 1.6)
SELECT vnr, SUM(vsumme) FROM vertragshistorie WHERE vnr IN(SELECT vnr FROM vertrag WHERE vende IS NULL) GROUP BY vnr;

SELECT vnr, vsumme FROM vertragshistorie WHERE vnr IN(SELECT vnr FROM vertrag WHERE vende IS NULL) GROUP BY vnr, vsumme;