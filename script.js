//Crear variables que representen a los selectores
const h1 = document.querySelector("h1");
const p = document.querySelector("p");
const parrafito = document.getElementsByClassName("parrafito");
const pid = document.getElementById("pid");
const input = document.querySelector("input");

console.log(input.value);

console.log({
	h1,
	p,
	parrafito,
	pid,
	input,
});

h1.innerText = "Levi <br> Huskey";
// h1.setAttribute("class", "rojo");
// console.log(h1.getAttribute("class"));

h1.classList.add("rojo");
h1.classList.remove("verde");
//h1.classList.toggle("morado");
//h1.classList.contains("verde");

input.value = "123";
