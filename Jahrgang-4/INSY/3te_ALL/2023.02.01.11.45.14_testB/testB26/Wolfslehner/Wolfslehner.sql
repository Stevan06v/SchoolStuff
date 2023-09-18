--1.1
select count(*),sparte from vertrag where vende is null
group by sparte;

--1.2
select vsumme from vertrag v,vertragshistorie vh 
where v.vnr = vh.vnr and 
v.vnr=154 and
datum_von between '01.06.2000' and '03.06.2000';

--1.3
select vh.vnr,vbeginn from vertragshistorie vh,vertrag v where 
datum_von between '01.09.1997'and '31.12.1997' and 
v.vende is null and
v.vnr = vh.vnr
group by vh.vnr,vbeginn
order by vbeginn desc;

--1.4
select distinct v.vnr from vertrag v,vertragshistorie vh where v.vnr = vh.vnr and
sparte= 'P' and
datum_von not in(select datum_von from vertragshistorie where datum_von>'31.12.2002');


--1.5
select z.vnr,sparte,vbeginn,vende from zahlung z, vertrag where vende is null and
betrag != ANY(select betrag from zahlung where to_number(to_char(zdatum,'YYYY')) = to_number(to_char(zdatum,'YYYY'))-1);
 
--1.6
select v.vnr, vsumme from vertragshistorie vh, vertrag v where vh.vnr = v.vnr and
vende is null and datum_von >= ALL(select datum_von from vertragshistorie where vh.vnr = vnr)
order by vnr asc;
                            