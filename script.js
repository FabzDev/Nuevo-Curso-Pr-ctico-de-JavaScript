//Crear variables que representen a los selectores
const h1 = document.querySelector("h1");
const input1 = document.querySelector("#calculo1");
const input2 = document.querySelector("#calculo2");
const btn = document.querySelector("#btnCalcular");
let pRes = document.querySelector("#resultado");

function onClickBtn() {
	//console.log(Number(input1.value) + Number(input2.value));
	res = Number(input1.value) + Number(input2.value);
	pRes.innerText = "El resultado es: " + res;
}

// btn.addEventListener("click", onClickBtn());
