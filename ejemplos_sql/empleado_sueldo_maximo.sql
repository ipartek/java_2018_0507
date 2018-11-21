CREATE 
VIEW `empleado_sueldo_maximo` AS
    SELECT 
        `empleados`.`nomEmp` AS `nomEmp`,
        `empleados`.`salEmp` AS `salEmp`
    FROM
        `empleados`
    ORDER BY `empleados`.`salEmp` DESC
    LIMIT 1