/**
 * 
 */

document.addEventListener('DOMContentLoaded', function() {
	let hora = document.getElementById('hora');

	function reloj() {
		let horario = new Date();
		let anio = horario.getFullYear();
		let horas = horario.getHours();
		let minutos = horario.getMinutes();
		let segundos = horario.getSeconds();

		hora.innerHTML = anio + " | " + horas + ":" + minutos + ":"
			+ segundos;
	}

	reloj();
	setInterval(reloj, 1000);
});