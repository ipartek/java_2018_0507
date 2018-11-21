-- 49. Obtener la lista de empleados jefes, que tienen al menos un empleado a su cargo. Ordene el informe
-- inversamente por el nombre.

select nDIEmp, nomEmp
from empleados
where nDIEmp IN (
	select distinct jefeID
	from empleados
	where jefeID IS NOT NULL
	)
order by nomEmp desc