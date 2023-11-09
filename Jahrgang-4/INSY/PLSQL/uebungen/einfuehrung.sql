declare
    v_name varchar2(30);
    v_firstname varchar2(30);
    c_pi constant number(3,2) := 3.14;
begin
    v_firstname:= 'Hallo Welt';

    -- selektieren von attribut aus tabellen
    select first_name, last_name into v_firstname,v_name from DEMO_HR.employees
                                                         where employee_id = 100;
    DBMS_Output.PUT_LINE ('Hello World');
    DBMS_OUTPUT.PUT_LINE(v_name);
    DBMS_OUTPUT.PUT_LINE(v_firstname);

end;
/ -- mehrere blöcke werden mit / getrennt



-- verzweigungen
declare
    v_value number(3) := 4;
    v_proz number(4,1) := 80.0;
    v_note varchar2(30):= 'unbekannt';
begin
    -- if
    if v_value < 5 then
        DBMS_OUTPUT.PUT_LINE('Du bist positiv!');
    else
        DBMS_OUTPUT.PUT_LINE('Du bist negativ!');
    end if;

    -- else if
    if v_value = 4 then
        DBMS_OUTPUT.PUT_LINE('genügend');
    elsif v_value = 5 then
        DBMS_OUTPUT.PUT_LINE('nicht genügend');
    end if;

    -- switch case
    v_note:= case
        when v_proz > 87.5 then 'Sehr Gut'
        when v_proz > 75 then 'Gut'
        when v_proz > 62.5 then 'Befriedigend'
        when v_proz >= 50 then 'Genügend'
        else 'Nicht Genügend'
    end;

    DBMS_OUTPUT.PUT_LINE(v_note);

end;
/




-- schleifen, schleifen, schleifen
declare
    v_anz number(3) := 1;
begin
    DBMS_OUTPUT.PUT_LINE('DO-WHILE: ');
    --do while
    loop
        DBMS_OUTPUT.PUT_LINE(v_anz);
        v_anz := v_anz + 1;

        exit when v_anz = 5;
    end loop;

    DBMS_OUTPUT.PUT_LINE('WHILE: ');

    -- while
    while v_anz < 15 loop
        DBMS_OUTPUT.PUT_LINE(v_anz);
        v_anz := v_anz + 1;
    end loop;

    -- FOR-LOOP
    DBMS_OUTPUT.PUT_LINE('FOR-LOOP: ');
    for v_anz in 1..10 loop
        DBMS_OUTPUT.PUT_LINE(v_anz);
        end loop;

    --  REVERSE FOR-LOOP
    DBMS_OUTPUT.PUT_LINE('REVERSE FOR-LOOP: ');
    for v_anz in reverse 1..10 loop
        DBMS_OUTPUT.PUT_LINE(v_anz);
        end loop;

    -- EVEN, NOT EVEN
    DBMS_OUTPUT.PUT_LINE('EVEN, NOT EVEN: ');
    for v_anz in 1..10 loop
        if v_anz mod 2 = 0 then
            DBMS_OUTPUT.PUT_LINE('gerade');
        end if;
        end loop;
end;
/
