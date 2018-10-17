SELECT c.nombre, f.numero_factura
FROM clientes c
INNER JOIN facturas f ON c.id = f.id_cliente
WHERE LOWER(c.nombre) LIKE '%javier%';
