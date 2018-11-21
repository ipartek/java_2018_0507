SELECT f.numero_factura, c.nombre AS cliente, p.nombre AS producto, fp.cantidad, p.precio, fp.cantidad * p.precio AS total
FROM clientes c, facturas f, facturas_productos fp, productos p
WHERE c.id = f.id_cliente AND f.id = fp.id_factura AND fp.id_producto = p.id
AND f.numero_factura = '2018/0002'