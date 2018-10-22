select calle, numero
from viviendas v
inner join personas_propiedad_viviendas pv on v.idviviendas = pv.viviendas_idviviendas
inner join personas p on pv.personas_idpersonas = p.idpersonas
where dni = '12345678Z'