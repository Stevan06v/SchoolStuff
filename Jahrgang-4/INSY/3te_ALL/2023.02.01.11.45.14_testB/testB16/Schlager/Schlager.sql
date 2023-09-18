-- Bsp 1 
select count(*), sparte from Vertrag where vende is null group by sparte; 

-- Bsp 2 
select vsumme from vertragshistorie where to_Char(DATUM_VON, 'MM') = '06' and VNR = 154;

-- Bsp 3
select VNR, vbeginn from Vertrag where to_Char(vbeginn, 'MM.YY') between '09.97' and '12.97';

-- Bsp 4
select v.vnr from vertrag v
MINUS 
select v.vnr from Vertrag v inner JOIN Zahlung z on v.vnr = z.vnr where to_Char(zdatum, 'dd.MM.YY') >= '31.12.02';

-- Bsp 5
select v.vnr, v.sparte, v.vbeginn, v.vende from Vertrag v 
MINUS
select v.vnr, v.sparte, v.vbeginn, v.vende from Vertrag v inner JOIN Zahlung z on v.vnr = z.vnr where v.vende is null and to_Char(zdatum, 'YYYY') >= '22';

-- Bsp 6
select v.vnr, vh.vsumme from Vertrag v inner JOIN vertragshistorie vh on v.vnr = vh.vnr where v.vende is null; 