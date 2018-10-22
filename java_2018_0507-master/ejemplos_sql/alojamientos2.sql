-- 2. Nombre de los alojamientos que tienen habitaciones dobles y realiza: 
-- actividades de senderismo (el nombre de la actividad es senderismo).

select distinct al.nombre
from habitaciones h
inner join alojamientos al on h.pertenece_a_idalojamiento = al.idalojamiento
inner join alojamiento_has_actividades aa on al.idalojamiento = aa.alojamientos_idalojamiento
inner join actividades ac on aa.actividades_idactividades = ac.idactividades
where h.tipo = 'doble' AND ac.nombre = 'Senderismo'