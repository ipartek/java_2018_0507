SELECT c.nombre AS cliente, SUM(fp.cantidad * p.precio) AS total
FROM clientes c
JOIN facturas f ON c.id = f.id_cliente
JOIN facturas_productos fp ON f.id = fp.id_factura
JOIN productos p ON fp.id_producto = p.id
GROUP BY c.id;
