-- 46. Hallar el salario promedio por departamento, considerando aquellos empleados cuyo salario supera
-- $900.000, y aquellos con salarios inferiores a $575.000. Entregar el código y el nombre del
-- departamento.

select d.codDepto, d.nombreDpto, avg(salEmp)
from departamentos d
inner join empleados e on e.codDepto = d.codDepto
where e.salEmp > 900000 or e.salEmp < 575000
group by d.codDepto, d.nombreDpto