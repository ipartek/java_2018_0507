-- 39.Entregar el salario más alto de la empresa.

select nomEmp, salEmp
from empleados
order by salEmp desc
limit 1