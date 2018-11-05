-- 1. Nombre y descripcion de las actividades que se realizan en el alojamiento denominado "La Huerta". 

select ac.nombre, ac.descripcion
from alojamientos al
inner join alojamiento_has_actividades aa on al.idalojamiento = aa.alojamientos_idalojamiento
inner join actividades ac on aa.actividades_idactividades = ac.idactividades
where al.nombre LIKE '%La Huerta%';
