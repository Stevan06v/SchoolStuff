--1.1
select SPARTE, count(*) from VERTRAG where VENDE is null group by SPARTE;


--1.2
select VSUMME from VERTRAGSHISTORIE where VNR = 154 and DATUM_VON < to_date('03.06.2000','DD.MM.YYYY') and DATUM_VON =
(select max(DATUM_VON) from VERTRAGSHISTORIE where VNR = 154 and DATUM_VON < to_date('03.06.2000','DD.MM.YYYY'));


--1.3
select vnr, vbeginn from  VERTRAG v where TO_CHAR(VBEGINN,'YYYY') = '1997' and
to_Number((TO_CHAR(VBEGINN,'MM'))) <= 12 and to_Number((TO_CHAR(VBEGINN,'MM'))) >= 8;

--1.4
select v.vnr from VERTRAG v, VERTRAGSHISTORIE vh where v.SPARTE like ('P')
intersect
select vnr from vertrag v where VBEGINN = (
    select min(DATUM_VON) from VERTRAGSHISTORIE where to_number(to_char(DATUM_VON,'YYYY')) >= 1997 and v.vnr = VERTRAGSHISTORIE.VNR group by VNR
);

--1.5
select v.vnr from VERTRAG v where VENDE is null
minus
select z.vnr from ZAHLUNG z where to_char(ZDATUM,'YYYY') = 2022;

--1.6
select v.vnr, vh.VSUMME from VERTRAGSHISTORIE vh, VERTRAG v where v.VNR = vh.VNR and VENDE is null and DATUM_VON =
(select max(DATUM_VON) from VERTRAGSHISTORIE where  v.VNR = VERTRAGSHISTORIE.vnr);
