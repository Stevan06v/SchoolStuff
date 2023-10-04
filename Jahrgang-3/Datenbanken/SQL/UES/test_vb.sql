select * from vertrag;
select * from vertragshistorie;

--commit 
drop table test;
SET AUTOCOMMIT OFF;
select to_char(sysdate,'dd-mm-yyyy') from dual;
grant all on test to it200231;
create table test(
    message varchar(64)
);
insert into test (message) values('HALLO');
select * from test;
select * from it200231.ue09;
insert into it200231.ue09 (text)values('ok');
commit;

--deadlock
create table deadlock(
    message varchar2(64)
);


grant all on deadlock to it200231;

insert into deadlock (message) values('HALLO');

select * from deadlock;

lock table deadlock in exclusive mode; 

insert into deadlock (message) values('HALLO');

commit;

select * from deadlock;






