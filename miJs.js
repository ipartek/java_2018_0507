window.onload = function () {
    'use strict';
    var form = document.getElementsByTagName("form")[0];
    cadenaReves();
   // contarVocales();
   // hacerGuiones();
    //convertirMayus();
   // crearQuiniela();
   // compruebaEdades();
   // tablaMult();
    //deluno();
  //do{
    //   var numrep = prompt("Introduce numero de repeticiones");
     // numRepetidos(numrep);
  //}while(numrep>50)
   
   //miArbolInverso(numrep);
};
function cadenaReves(){
 var frase=prompt("dime una frase");
    for(var i=frase.length;i>=0;i--)
        document.write(frase.charAt(i));

}
function contarVocales()
{
    var cont=0;
     var frase=prompt("dime una frase");
    for(var i=0; i<=frase.length;i++){
        
        if(frase.charAt(i)=="a" || frase.charAt(i)=="e" || frase.charAt(i)=="i" || frase.charAt(i)=="o" || frase.charAt(i)=="u"){
            cont++;
        }
        
    }
    document.write(cont + " vocales");
}
function hacerGuiones(){
    var frase=prompt("dime una frase");
    var crearFras
    for(var i=1;i<=frase.length;i++){
       document.write(frase.charAt(i-1));
           document.write("-")
    }
}
function compruebaEdades(){
    var nombre1 = prompt("Nombre 1:");
    var edad1 = Number(prompt("Edad 1:"));
     var nombre2 = prompt("Nombre 2:");
    var edad2 = Number(prompt("Edad 2:"));
     var nombre3 = prompt("Nombre 3:");
    var edad3 = Number(prompt("Edad 3:"));
    var maximo=Math.max(edad1,edad2,edad3);
    if(maximo==edad1){
        document.write(nombre1+ " es el mas mayor de todos con "+ edad1);
    }
    else if(maximo==edad2){
         document.write(nombre2+ " es el mas mayor de todos con "+ edad2);
    }
    else  document.write(nombre3+ " es el mas mayor de todos con "+ edad3);
    
    
}
  function deluno(){
    for(var i=1;i<501;i++){
        document.write(i);
        if(i%5==0){
            document.write("<br>");
            document.write ("------------------------");
            document.write("<br>");
         }
        else{
        if(i%4==0)
            document.write ("(multiplo de 4)");
         if(i%9==0)
            document.write ("(multiplo de 9)");
         document.write("<br>");
        }
        
    }
}  
function tablaMult(){
    
     var fil = prompt("dime filas");
     var col = prompt("ahra columnas");
    var multiplicado=fil*col;
    document.write("<table border");
    for(var i=1;i<=fil;i++){
         document.write("<tr>");
        for(var h=1;h<=col;h++,multiplicado--){
            document.write("<td>");
            document.write(multiplicado);
        }
        
    }
}
function convertirMayus(){
    var frase = prompt("frase");
    var mayus=frase.toUpperCase();
    document.write(mayus);
}
function crearQuiniela(){
    var resultad;
    for(var i=1;i<15;i++){
         num = Math.floor((Math.random() * 99) + 1);
        if(num>0 && num<50){
            document.write("resultado "+ i +" gana el 1" );
        }
        if(num>50&&num<70){
            document.write("empate en el partido "+i);
        }
        if(num>70&&num<101){
            document.write("resultado  en el partido "+i +" gana el equipo 2");
        }
        
        document.write("<br>");
    }
}
function numRepetidos(numRe){
    var auxiliar;
    
    if(numRe>50){
        alert("numero demasiado grande")
    }
    else{
       for(var i=0;i<=numRe;i++){
           for(auxiliar=1;auxiliar<=i;auxiliar++)
               document.write(auxiliar);
           document.write("<br>");
       } 
    }
}
function miArbol(){
    var i,aux;
    
    for(i=1;i<31;i++){
        for(aux=0;aux<i;aux++)
            document.write(i);
        document.write("<br>");
    }
}
function miArbolInverso(numRe){
    var i,aux;
    
    for(i=1;numRe>=i;numRe--){
        for(aux=0;aux<numRe;aux++)
            document.write(numRe);
     document.write("<br>");
    }
}