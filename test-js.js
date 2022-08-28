//VARIABLES Y OPERADORES

var nombre = "Fabio";
var apellido = "Escobar";
var usuario = "fescobar";
var edad = "32";
var email = "fabio@hotmail.com";
var adulto = true;
var ahorro = 30000;
var deuda = 0;

console.log(nombre + " " + apellido);
console.log("Dinero real: $" + (ahorro - deuda));

//FUNCIONES

const name = "Juan David";
const lastname = "Castro Gallego";
const completeName = name + lastname;
const nickname = "juandc";

function name(completeName, nickname) {
	console.log(
		"Mi nombre es " +
			completeName +
			", pero prefiero que me digas " +
			nickname +
			"."
	);
}

name("Fabio Escobar", "MrBurifarra");

//CONDICIONALES

//SWITCH
var tipoDeSuscripcion = "Basic";

switch (tipoDeSuscripcion) {
	case "Free":
		console.log(
			"Solo puedes tomar los cursos gratis"
		);
		break;
	case "Basic":
		console.log(
			"Puedes tomar casi todos los cursos de Platzi durante un mes"
		);
		break;
	case "Expert":
		console.log(
			"Puedes tomar casi todos los cursos de Platzi durante un año"
		);
		break;
	case "ExpertPlus":
		console.log(
			"Tú y alguien más pueden tomar TODOS los cursos de Platzi durante un año"
		);
		break;
}
// A IF / ELSE

var tipoDeSuscripcion = "Basic";

if (tipoDeSuscripcion == "Basic") {
	console.log(
		"Puedes tomar casi todos los cursos de Platzi durante un mes"
	);
} else if (tipoDeSuscripcion == "Free") {
	console.log(
		"Solo puedes tomar los cursos gratis"
	);
} else if (tipoDeSuscripcion == "Expert") {
	console.log(
		"Puedes tomar casi todos los cursos de Platzi durante un año"
	);
} else if (tipoDeSuscripcion == "ExpertPlus") {
	console.log(
		"Tú y alguien más pueden tomar TODOS los cursos de Platzi durante un año"
	);
} else {
	console.log("Suscripcion invalida");
}

var fabio = {
	nombre: "Fabio Escobar",
	suscripcion: "Expert",
	ruta: "Programacion",
};

// CICLOS

//FOR

for (let i = 0; i < 5; i++) {
	console.log("El valor de i es: " + i);
}

for (let i = 10; i >= 2; i--) {
	console.log("El valor de i es: " + i);
}

// TO WHILE
var i = 0;
while (i < 5) {
	console.log("El valor de i es: " + i);
	i += 1;
}

var i = 10;
while (i >= 2) {
	console.log("El valor de i es: " + i);
	i -= 1;
}

while (resp != 4) {
	var resp = prompt("Cuanto es 2 + 2?");
	if (resp != 4) {
		alert("Incorrecto, vuelve a intentarlo");
	} else {
		alert("Correcto, eres una genio bebe");
	}
}

// LISTAS

// 2. Crea una función que pueda recibir cualquier
// array como parámetro e imprima su primer elemento.

function ar(matriz) {
	console.log(matriz);
}

tuberculos = ["papa", "yuca", "name"];

ar(tuberculos[0]);

// 3. Crea una función que pueda recibir cualquier array
// como parámetro e imprima todos sus elementos uno por uno
// (no se vale imprimir el array completo).

function ar(matriz) {
	for (let i = 0; i < matriz.length; i++) {
		console.log(matriz[i]);
	}
}

var tuberculos = ["papa", "yuca", "name"];

ar(tuberculos);

// ALTERNATIVA RECORRIENDO ARRAY

function ar(matriz) {
	for (tub of matriz) {
		console.log(tub);
	}
}

var tuberculos = ["papa", "yuca", "name"];

ar(tuberculos);

// 4. Crea una función que pueda recibir cualquier objeto como
//parámetro e imprima todos sus elementos uno por uno
//(no se vale imprimir el objeto completo).

function ar(obj) {
	console.log(obj.nombre);
	console.log(obj.apellido);
	console.log(obj.usuario);
	console.log(obj.edad);
}

var fabio = {
	nombre: "Fabio",
	apellido: "Escobar",
	usuario: "fescobar",
	edad: "32",
};

ar(fabio);

// Metodo alternativo con Object.values()

function ar(obj) {
	newAr = Object.values(obj);
	for (ele of newAr) {
		console.log(ele);
	}
}

var fabio = {
	nombre: "Fabio",
	apellido: "Escobar",
	usuario: "fescobar",
	edad: "32",
};

ar(fabio);
