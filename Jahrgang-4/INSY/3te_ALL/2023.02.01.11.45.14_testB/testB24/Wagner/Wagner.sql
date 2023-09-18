select * from VERTRAG;
select * from VERTRAGSHISTORIE;
select * from ZAHLUNG;

-- 1.1
select count(SPARTE) as ANZAHL, SPARTE from VERTRAG where VENDE is null group by SPARTE;

-- 1.2
select VSUMME from VERTRAGSHISTORIE where vnr = 154 and to_char(DATUM_VON, 'MM') = to_char(to_date('2000-06-03', 'YYYY-MM-DD'), 'MM');

-- 1.3
select vnr, to_char(VBEGINN, 'DD.MM.YY') as VBEGINN from VERTRAG where to_char(VBEGINN, 'MM') > 9;

-- 1.4
select vnr from ZAHLUNG where to_date('31.12.2000', 'DD.MM.YYYY') < (select max(ZDATUM) from ZAHLUNG);
-- select max(ZDATUM) from ZAHLUNG group by vnr;

-- 1.5
select vnr, SPARTE, VBEGINN, vende from VERTRAG ;

-- 1.6
select vh.vnr, max(VSUMME) from VERTRAGSHISTORIE vh inner join VERTRAG V on vh.VNR = V.VNR where VENDE is null group by vh.vnr;