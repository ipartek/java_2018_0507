String.prototype.mayusculaLaPrimera = function() {
	return this[0].toUpperCase() + this.substr(1);
};

function Persona(id, nombre) { //"Constructor"
	this.id = id; //Aquí se genera la variable de instancia sin declararla previamente
	this.nombre = nombre.mayusculaLaPrimera();
}

Persona.prototype.toString = function () { //"Método de instancia"
	return this.id + ", " + this.nombre;
}

var persona = new Persona(1, 'javier');

console.log(persona.toString());