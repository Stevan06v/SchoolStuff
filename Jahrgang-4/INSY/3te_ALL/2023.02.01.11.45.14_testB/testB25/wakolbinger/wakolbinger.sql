--1.1
select count(*), SPARTE from VERTRAG
group by SPARTE;

--1.2
select VSUMME from VERTRAGSHISTORIE where VNR=154 and to_char(DATUM_VON, 'DD-MM-YYYY') = '01-06-2000';

--1.3
select  v.VNR, v.VBEGINN from VERTRAG v where to_char(v.VBEGINN, 'YYYY-MM-DD') >= '1997-09-01' AND to_char(v.VBEGINN, 'YYYY-MM-DD') <= '1997-12-31';

--1.4
select DISTINCT vh.VNR from VERTRAGSHISTORIE vh, VERTRAG v where to_char(vh.DATUM_VON, 'YYYY-MM-DD') <= '2002-12-31' and v.sparte = 'P';

select vnr from VERTRAGSHISTORIE where (select max(VSUMME) from VERTRAGSHISTORIE) < (select VSUMME from VERTRAGSHISTORIE where );

--1.5
select v.VNR, v.SPARTE, v.VBEGINN, v.VENDE from VERTRAG v, ZAHLUNG z
where VENDE is NULL
AND z.ZDATUM 
;

--1.6
select MAX(vh.VSUMME), vh.VNR from VERTRAGSHISTORIE vh, VERTRAG v where v.VNR = vh.VNR and v.VENDE is NULL group by vh.VNR;
