-- 43. Conocido el resultado anterior, entregar el nombre de los empleados que reciben el salario más alto y más bajo. 
-- Cuanto suman estos salarios?


select max.nomEmp as 'NOM MAX', max.salEmp as 'SAL MAX', min.nomEmp as 'NOM MIN', min.salEmp as 'SAL MIN', max.salEmp+min.salEmp as 'SUMA'
from 
	empleado_sueldo_maximo max,
    empleado_sueldo_minimo min
    
