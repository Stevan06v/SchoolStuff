insert into buecher values (1,'Goethe', 'Faust','A',30);
insert into buecher values (2,'Schiller', 'Die Räuber','A',30);
insert into buecher values (3,'Goethe', 'Wahlverwandtschaften','A',30);
insert into buecher values (4, null, 'Das Guinessbuch der Rekorde', 'B', 30);
insert into buecher values (5,'Lessing', 'Nathan der Weise','A', 30);
insert into buecher values (6,'Goethe','Die Leiden des jungen Werther', 'A',30);
insert into buecher values (7, null, 'Enzyklopädie der Klassik', 'C', 30);

insert into leser values (1,'Mayer', 'Linz','01-JUN-98');
insert into leser values (2,'Schmidt', 'Leonding', '21-AUG-96');
insert into leser values (3, 'Huber','Traun', '21-MAR-00');
insert into leser values (4,'Bauer','Marchtrenk','18-SEP-99');

insert into verleih values (1,3,'30-JAN-01','02-MAR-01');
insert into verleih values (3,1,'05-APR-01','05-MAY-01');
insert into verleih values (1,6,'18-JUL-01','17-AUG-01');
insert into verleih values (2,3,'25-MAR-99','07-OCT-99');

insert into vormerk values (3,3,'03-MAR-01');
insert into vormerk values (1,1,'06-MAY-01');
insert into vormerk values (3,6, '18-AUG-01');

insert into strafe values (1,'08-JUN-98', 50);
insert into strafe values (1,'15-DEC-00', 20);
insert into strafe values (2, '05-MAR-02', 15);
insert into strafe values (4,'07-MAY-02',50);