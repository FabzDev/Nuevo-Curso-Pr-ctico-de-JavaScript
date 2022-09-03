//Crear variables que representen a los selectores
const h1 = document.querySelector("h1");
const form = document.querySelector("#form");
const input1 = document.querySelector("#calculo1");
const input2 = document.querySelector("#calculo2");
const btn = document.querySelector("#btnCalcular");
const pRes = document.querySelector("#resultado");

function onClickBtn(event) {
	// console.log({ event });
	// event.preventDefault();
	const res = Number(input1.value) + Number(input2.value);
	pRes.innerText = "El resultado es: " + res;
}

form.addEventListener("click", onClickBtn);
