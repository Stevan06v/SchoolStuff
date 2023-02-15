
create table personen(
    personen_id number(4) not null,
    nname varchar2(25),
    vname varchar2(20)
); 
create table matches_copy(
    matchno,
    teamno,
    playerno, 
    won,
    lost
)as select matchno, teamno, playerno, won, lost from DEMO_TENNIS.MATCHES;


insert into personen values(19999, 'Mustermann', 'Max');
insert into PERSONEN values(2, 'Musterfrau', 'Mimi');



ALTER TABLE personen DROP COLUMN vname;

alter table personen modify(
    personen_id number(4),
    nname varchar2(22)
);
alter table personen add (
    gehalt number(4,2)
);

alter table personen modify (
    personen_id varchar2(100)
);


alter table personen add(
    money number(4, 2)
);


alter table personen drop COLUMN money; 

select * from PERSONEN;
select * from matches_copy;