select p.nombre, p.apellido1, p.apellido2
from personas p
inner join viviendas v on p.empadronado_en_vivienda_id = v.idviviendas
where v.calle = 'Calle2' AND v.numero = 2