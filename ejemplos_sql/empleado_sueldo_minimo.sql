CREATE 
VIEW `empleado_sueldo_minimo` AS
    SELECT 
        `empleados`.`nomEmp` AS `nomEmp`,
        `empleados`.`salEmp` AS `salEmp`
    FROM
        `empleados`
    ORDER BY `empleados`.`salEmp` ASC
    LIMIT 1