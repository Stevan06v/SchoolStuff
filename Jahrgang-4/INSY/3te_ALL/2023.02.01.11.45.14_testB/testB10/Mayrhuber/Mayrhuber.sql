
--1)
SELECT COUNT(sparte) as Anzahl, Sparte from vertrag where vende IS NULL group by Sparte;

--2)
SELECT vh.vsumme from vertrag ver, vertragshistorie vh
        where ver.VNR = vh.VNR
          and vh.Vnr = 154
          and TO_CHAR(datum_von, 'YYYY') = 2000
          and TO_CHAR(datum_von, 'MM') = 6;

--3)
SELECT Vnr, TO_CHAR(vbeginn, 'DD.MM.YY') from vertrag
        where TO_CHAR(vbeginn, 'YYYY') IN(1997)
          and TO_CHAR(vbeginn, 'mm') > 9;

--4)


--5
SELECT v.Vnr, v.sparte, v.vbeginn, v.vende from vertrag v join ZAHLUNG z
    on v.Vnr = z.Vnr where
        TO_CHAR(z.zdatum, 'YYYY') = 2022 ;

--6
SELECT vh.VNR, SUM(vsumme) from VERTRAG ver, vertragshistorie vh 
                where vh.VNR = ver.VNR 
                  and ver.vende IS NULL 
                group by vh.VNR;