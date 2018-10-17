select p.nombre, p.apellido1, p.apellido2
from municipios m
inner join viviendas v on m.idmunicipios  = v.pertenece_municipio_id
inner join personas_propiedad_viviendas pv on v.idviviendas = pv.viviendas_idviviendas
inner join personas p on pv.personas_idpersonas = p.idpersonas
where m.codigo = 'BIL'