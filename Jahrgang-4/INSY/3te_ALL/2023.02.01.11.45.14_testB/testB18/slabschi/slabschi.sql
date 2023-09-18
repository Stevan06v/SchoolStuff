-- 1.1
select count(vnr), SPARTE from Vertrag
                          where VENDE is null
                          group by SPARTE;


-- 1.2
select ve.VSUMME from VERTRAGSHISTORIE ve where VNR = 154 and to_date('03.06.2001', 'DD.MM.yyyy') > (select max(DATUM_VON) from VERTRAGSHISTORIE);

-- 1.3
select vnr, to_Char(VBEGINN,'DD.MM.yyyy') from VERTRAG where to_Char(VBEGINN,'DD.MM.yyyy') > to_date('01.08.1997', 'DD.MM.yyyy') and to_Char(VBEGINN,'yyyy') = '1997';

-- 1.4
select vnr from VERTRAGSHISTORIe where DATUM_VON > to_date('31.12.2002', 'DD.MM.yyyy')
minus
select v1.vnr from VERTRAGSHISTORIE v1 where VSUMME > any(select VSUMME from VERTRAGSHISTORIE v2 where v1.VNR = v2.VNR);

-- 1.5
select vnr, sparte, vbeginn, vende from VERTRAG
where to_number(to_Char(VBEGINN,'yyyy') -1) != any(select to_Char(ZDATUM,'yyyy') from ZAHLUNG);

-- 1.6
select distinct(ve.vnr), vh.VSUMME from Vertrag ve, VERTRAGSHISTORIE vh where VENDE is null;

select * from vertrag;
select * from VERTRAGSHISTORIE;