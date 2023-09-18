create table produkt(
prodnr number(5),
prodebz varchar2(20),
constraint pk_prodnr primary key(prodnr)
);

create table produktpreis(
prodnr number(5) references produkt(prodnr),
vondatum date, 
prodpreis number(2,7),
constraint pk1_prodnr_vondatum primary key(prodnr, vondatum)
);

create table fahrauftrag(
fauftrnr number(5) constraint pk_fauftrnr primary key, 
fauftrdatum date,
lkwkz varchar2(10)
);

create table kunde(
    knr number(5) constraint pk_knr primary key,
    kname varchar(30),
    kplz varchar2(6),
    kort varchar(20),
    kstr varchar2(20)
);
create table lieferung(
fauftrag number(5), 
folgenr number(5) ,
knr number(5) references kunde(knr),
constraint pk2_fauftrag_folgenr primary key(fauftrag,folgenr)
);
create table lieferposition(
fauftrnr number(5),
folgenr number(5) references lieferung(fauftrag, folgenr),
prodnr number(5) references produkt(prodnr),
liefanz number(5),
constraint pk_fauftrnr_folgenr_prodnr primary key(fauftrnr,folgenr,prodnr)
);
drop table lieferung;
drop table lieferposition;
drop table kunde; 
drop table produkt;
drop table produktpreis;

select * from produkt;

-- Beispiel 
create table players(
    playerno number(10) constraint pk_playerno primary key
);
create table players(
    playerno number(10),
    constraint pk_playerno primary key(playerno)
    );

 --   Teams(teamno, playerno, ….)
    create table teams(
        teamno number(10) constraint pk_teamno primary key,
        playerno number(10) REFERENCES playeers(playerno)
    );
    
    
    create table teams(
        teamno number(10),
        playerno number(10) references players(playerno),
        constraint pk_teamno primary key(teamno)

    );






