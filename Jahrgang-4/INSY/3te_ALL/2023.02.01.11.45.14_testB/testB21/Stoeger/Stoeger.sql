----- Stoeger Sophie -----

-- 1)
select count(vnr), sparte from vertrag where vende is null and sparte like 'P' group by sparte
union
select count(vnr), sparte from vertrag where vende is null and sparte like 'S' group by sparte;

-- 2)
select vsumme from vertragshistorie where vnr = 154 and to_char(datum_von, 'mm.YY') = '06.00';

-- 3)
select vnr, vbeginn from vertrag where vbeginn between to_date('01.10.1997') and to_date('31.12.1997');

-- 4)
select vnr from vertrag where sparte like 'P' and vnr = any(select vnr from vertragshistorie where datum_von < to_date('31.12.02'));

-- 5) 
select v.vnr, sparte, vbeginn, vende from vertrag v where vende is null
minus
select v.vnr, sparte, vbeginn, vende from zahlung z, vertrag v where  z.vnr = v.vnr and zdatum between to_date('01.01.2022') and to_date('31.12.2022');

-- 6)
select vh.vnr from vertragshistorie vh, vertrag v where vh.vnr = v.vnr and vende is null group by vh.vnr;


