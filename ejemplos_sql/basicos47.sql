-- 47. Entregar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa.
-- Ordenarlo por departamento.

select d.nombreDpto, e.nomEmp
from departamentos d
inner join empleados e on e.codDepto = d.codDepto
where e.salEmp > (select avg(salEmp) from empleados)
order by d.nombreDpto