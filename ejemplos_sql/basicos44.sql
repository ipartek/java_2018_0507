-- 44. Hallar el número de empleados de sexo femenino y de sexo 
masculino, por departamento.

select d.nombreDpto, SUM(CASE WHEN e.sexEmp = 'M' THEN 1 ELSE 0 END) AS 'HOMBRES', SUM(IF(e.sexEmp = 'F', 1, 0)) AS 'MUJERES', COUNT(*) as 'PERSONAS'
from empleados e, departamentos d
where d.codDepto = e.codDepto
group by d.nombreDpto;

select d.nombreDpto, e.sexEmp, count(*)
from empleados e, departamentos d
where d.codDepto = e.codDepto
group by d.nombreDpto, e.sexEmp;
