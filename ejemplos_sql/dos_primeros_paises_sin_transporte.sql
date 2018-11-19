SELECT Country, COUNT(*) AS Cuantos FROM Customers
WHERE Country NOT IN (SELECT Country FROM Suppliers)
GROUP BY Country
ORDER BY Cuantos DESC
LIMIT 0,2;
