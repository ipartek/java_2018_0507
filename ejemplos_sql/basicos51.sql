-- 51. Entregar un reporte con el numero de cargos en cada departamento y cual es el promedio de salario
-- de cada uno. Indique el nombre del departamento en el resultado.

select d.nombreDpto, e.cargoE, avg(e.salEmp) as promedio
from departamentos d
inner join empleados e on d.codDepto = e.codDepto
group by d.nombreDpto, e.cargoE;

select d.nombreDpto, count(e.cargoE) as 'numero de cargos', avg(e.salEmp) as promedio
from departamentos d
inner join empleados e on d.codDepto = e.codDepto
group by d.nombreDpto;
