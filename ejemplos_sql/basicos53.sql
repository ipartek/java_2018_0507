-- 53. Reporte con el código y nombre de cada jefe, junto al número de empleados que dirige.
-- 53. Puede haber empleados que no tengan supervisores, para esto se indicará solamente el numero de
-- ellos dejando los valores restantes en NULL.

select j.nDIEmp, j.nomEmp, count(e.nDIEmp)
from empleados j
right join empleados e on j.nDIEmp = e.jefeID
group by j.nDIEmp
