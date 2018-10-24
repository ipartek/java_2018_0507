select p.nombre, p.apellido1, p.apellido2
from viviendas v
inner join personas_propiedad_viviendas pv on v.idviviendas = pv.viviendas_idviviendas
inner join personas p on pv.personas_idpersonas = p.idpersonas
where calle = 'Calle1' and numero = 1
