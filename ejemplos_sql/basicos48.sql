-- 48. Hallar los departamentos que tienen más de tres (3) empleados. Entregar el número de empleados de
-- esos departamentos.

select *
from departamentos d, (select codDepto, count(nDIEmp) as numero from empleados group by codDepto having count(nDIEmp) >= 3) n
where n.codDepto = d.codDepto;

select d.codDepto, d.nombreDpto, count(*) as numero
from empleados e, departamentos d
where e.codDepto = d.codDepto
group by d.codDepto
having numero >= 3;