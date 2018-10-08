<html>
<body>
<h2>PARTE TEORICA</h2>
<p>
	MVC (Model Vista Controlador) es un patron que se utiliza para separar los datos, la parte visual de la aplicacion y el gestor de eventos.
	El modelo serian los pojos, la vista serian las jsp y el/los controladores serian los servlets.
	
	Ejemplo:
	En un login tendriamos la clase Usuario, una jsp con los campos nombre y contraseña y un servlet para administrar el funcionamiento del Login.
	En primer lugar en el servlet recogeriamos los campos introducidos en los imput de la jsp. Despues el servlet manda los datos que nos han introducido para comprobar si coinciden con los que tenemos en la BBDD. 
	Si esto es correcto, estos datos se devuelven como verdaderos y se redirecciona a la pagina especificada. De lo contrario, se mostraria un mensaje de error y se recarga la pagina. 
</p>
</body>
</html>
