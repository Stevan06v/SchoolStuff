alter session set current_schema=DEMO_HR;

-- 1)
select * from employees
         where manager_id = all(
             select employee_id from employees
                                where first_name = 'John'
                                and last_name = 'Russell'
             );

-- 2)
select first_name, last_name, employee_id from employees
    where hire_date >= all(
            select hire_date from employees
        );

-- 3)

-- b) Ermitteln Sie den neuesten Mitarbeiter aller
-- Abteilungen, deren Bezeichnungen mit IT beginnen.

select first_name, last_name, employee_id, max(hire_date) from employees
    where department_id in (
        select department_id from departments
                     where department_id = any(
                        select department_id from departments
                                  where department_name like 'IT%'

                    )
        ) group by first_name, last_name, employee_id;

SELECT *
FROM employees
WHERE department_id = ANY (SELECT department_id
           FROM departments
           WHERE hire_date >= ALL
                 (SELECT hire_date FROM employees e
        WHERE e.department_id = departments.department_id)
             AND departments.department_name LIKE 'IT%');


--Ermitteln Sie alle Departments,
-- die im Country 'Germany' angesiedelt sind.
select department_id, department_name from departments
where location_id = any (
    select location_id from locations
            where country_id = any(
                select country_id from countries
                     where country_name = 'Germany'
                )
    );

-- Prüfen Sie, welche Mitarbeiter bereits den Job im Unternehmen gewechselt hat.
-- Für jeden Job-Wechsel wird ein Eintrag in der Tabelle JOB_HISTORY angelegt.

-- 5
select employee_id, first_name from employees
where employee_id in(
    select employee_id from job_history
                where job_id in (
                    select job_id from jobs
                )
    );

-- 6
select count(*) as ANZAHL from employees
where department_id in (
    select department_id from departments
         where location_id in (
             select location_id from locations
                where country_id in(
                    select country_id from countries
                        where region_id in (
                                select region_id from regions
                                    where region_name = 'Americas'
                    )
                )
             )
        );

select count(*) as ANZAHL from employees e,
                               departments d,
                               locations l,
                               countries c,
                               regions r
where e.department_id = d.department_id
and d.location_id = l.location_id
and l.country_id = c.country_id
and c.region_id = r.region_id
and region_name = 'Americas';