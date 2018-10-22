-- 50. Hallar los departamentos que no tienen empleados

select d.codDepto, d.nombreDpto, count(nDIEmp) as numero
from empleados e
right join departamentos d on e.codDepto = d.codDepto
group by d.codDepto
having numero = 0;

select *
from departamentos d
where codDepto NOT IN (select codDepto from empleados);
