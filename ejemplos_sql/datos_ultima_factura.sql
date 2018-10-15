SELECT 
	SUBSTR(MAX(numero_factura),1,4) AS anio, 
	SUBSTR(MAX(numero_factura),6,4) AS numero 
FROM facturas
WHERE SUBSTR(numero_factura,1,4) = '2018';
