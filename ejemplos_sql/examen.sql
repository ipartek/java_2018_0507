-- Listado de todas las casas de Howards   
select nombre from casa;

-- Tres primeros Alumnos con mejor nota en el año 2017
select alumno_id, nombre, apellidos, avg(nota) as 'nota media'
from alumno_has_asignatura
inner join alumno a on a.id = alumno_id
where anio = 2017 
group by alumno_id 
order by avg(nota) desc
limit 3;

-- Listado de profesores y materias impartidas ordenado por materias alfabéticamente para un año concreto
select p.nombre, a.nombre
from profesor p
inner join profesor_has_asignatura pa on p.id = pa.profesor_id
inner join asignatura a on pa.asignatura_id = a.id
where anio = 2017
order by a.nombre;

-- Listado de habitaciones y alumnos que hay en cada una
select anio, ubicacion, nombre, apellidos
from habitacion h
inner join alumno_has_habitacion ah on ah.habitacion_id = h.id
inner join alumno a on ah.alumno_id = a.id
order by anio;

-- Listado Partidos jugados año 2017 ordenados por fecha
select pq.fecha, p.nombre, p.apellidos, a.nombre, a.apellidos
from partido_quidditch pq
inner join profesor p on p.id = pq.arbitro
inner join alumno a on a.id = pq.MVP
where year(fecha) = 2017
order by fecha;

-- Nota media de los alumnos para una materia y un año
select asig.nombre, anio, avg(aa.nota) as 'nota media'
from alumno a
inner join alumno_has_asignatura aa on a.id = aa.alumno_id
inner join asignatura asig on asig.id = aa.asignatura_id
group by asig.id, anio
order by asig.id, anio;

-- Nota media de los alumnos de cada una de las casas por materia
select c.nombre, asig.nombre, avg(aa.nota) as 'nota media'
from alumno a
inner join alumno_has_asignatura aa on a.id = aa.alumno_id
inner join asignatura asig on asig.id = aa.asignatura_id
inner join casa c on c.id = a.casa_id
group by c.id, asig.id
order by c.nombre, asig.nombre;
