'use strict';

//alert('Hola "colega"');
//alert("Yepa John O'Connor");

//PRE ES6
//var nombrecompleto = 'Javier Lete';
//ES6
let nombrecompleto = 'Javier Lete';

console.log(nombrecompleto);

//ES6
const IVA = 0.21;

//IVA = 0.26; //No se permite el cambio porque es una constante

const texto = 'Hola';

//texto += nombrecompleto; //No se puede porque es una constante

var $ = 'Soy un dolar';

console.log($);

var _ = 'Soy un guión bajo';

console.log(_);

const nombres = [ 'Javier', 'Pepe', 'Juan' ];

console.log(nombres[0]);

console.log(nombres);

nombres[3] = 'Pedro';

nombres[10] = 'Yepa';

nombres[7] = 10;

nombres.push('Al final');

nombres['profe'] = 'Javier Lete';

console.log(nombres);
console.log(nombres.length);

const datos = [];

datos.push(12);
datos.push(15);
datos.push(3);

console.log(datos);
console.log(datos.length);

const diccionario = [];

diccionario['casa'] = 'home';
diccionario['coche'] = 'car';

console.log(diccionario);

console.log(diccionario['coche']);
console.log(diccionario.casa);

console.log(Object.keys(diccionario).length);

//BOOLEANOS

console.log(!!true); //true

console.log(!!0); //false

console.log(!!5); //true

console.log(!!''); //false

console.log(!!'rellenado'); //true

var x = 5, y = 7;

console.log(!!(x == y)); //CORRECTO

console.log(!!(x = y)); //INCORRECTO por usar operador = en lugar de ==. NO FALLA EN JAVASCRIPT

var a = '5', b = 5;

console.log(a == b); //true (tolera comparaciones entre valores de diferentes tipos)
//complementario !=

console.log(a === b); //false (estrictamente igual: no tolera comparaciones entre diferentes tipos)
//complementario !==

console.log('Pepe' > 'pepe');

console.log('Javier' < 'Pepe');

console.log('Javier' == 'Javier');

