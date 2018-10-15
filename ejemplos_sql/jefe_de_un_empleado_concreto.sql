SELECT es.nombre
FROM empleados es
WHERE es.id = 
	(SELECT e.id_empleado_superior
	FROM empleados e
	WHERE e.id=2)