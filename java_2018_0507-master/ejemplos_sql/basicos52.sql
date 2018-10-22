-- 52. Entregar el nombre del departamento cuya suma de salarios sea la más alta, indicando el valor de la
-- suma.

select d.nombreDpto, sum(e.salEmp) as suma
from departamentos d, empleados e
where d.codDepto = e.codDepto
group by d.nombreDpto
order by suma desc
limit 1