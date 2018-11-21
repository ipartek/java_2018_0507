-- 45. salario promedio por departamento.

select d.nombreDpto, avg(salEmp)
from departamentos d
inner join empleados e on e.codDepto = d.codDepto
group by d.nombreDpto

