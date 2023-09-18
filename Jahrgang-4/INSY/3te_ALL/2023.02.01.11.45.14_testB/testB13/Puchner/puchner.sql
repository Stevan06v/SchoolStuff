-- 1.1
select count(*) as ANZAHL, SPARTE from VERTRAG where VENDE is null group by SPARTE;

-- 1.2
select VSUMME from VERTRAGSHISTORIE
              where VNR=154
                and DATUM_VON<to_date('03.06.2000','dd.MM.yyyy')
              order by DATUM_VON desc
              fetch first row only;

-- 1.3
select VNR, VBEGINN from VERTRAG
                    where extract(year from VBEGINN) = 1997
                      and extract(month from VBEGINN)>=9
                      and extract(month from VBEGINN)<=12;

-- 1.4
select * from VERTRAG where
       (select BETRAG from ZAHLUNG where VERTRAG.VNR=ZAHLUNG.VNR and ZDATUM>to_date('31.12.2002', 'dd.MM.yyyy') order by ZDATUM fetch first row only)>=any(select BETRAG from ZAHLUNG where VERTRAG.VNR=ZAHLUNG.VNR)
;

select * from VERTRAG V
         where (select ZDATUM from ZAHLUNG Z where V.VNR=Z.VNR order by ZDATUM desc fetch first row only)>TO_date('31.12.2002','dd.Mm.yyy') ;


-- 1.5
select * from VERTRAG V
         where VENDE is null
         and 2022 not in (select extract(year from ZDATUM) from ZAHLUNG Z where V.VNR = Z.VNR);

-- 1.6
select VERTRAG.VNR, VSUMME from VERTRAG
    inner join VERTRAGSHISTORIE V
        on VERTRAG.VNR = V.VNR
                           where VENDE is null and DATUM_VON>=all(select DATUM_VON from VERTRAGSHISTORIE where VERTRAG.VNR=VERTRAGSHISTORIE.VNR);