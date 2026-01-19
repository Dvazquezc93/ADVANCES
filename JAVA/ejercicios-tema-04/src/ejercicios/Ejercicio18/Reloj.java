package ejercicios.Ejercicio18;

import java.util.Objects;

public class Reloj {
	private Integer horas;
	private Integer minutos;
	private Integer segundos;
	private Boolean formato24Horas;

	public Reloj() {

		horas = 00;
		minutos = 00;
		segundos = 00;
		formato24Horas = true;
	}

	public Reloj(Integer horas, Integer minutos, Integer segundos) {
		super();
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
		formato24Horas = true;
	}

	public Integer getHoras() {
		return horas;
	}

	public Integer getMinutos() {
		return minutos;
	}

	public Integer getSegundos() {
		return segundos;
	}

	public Boolean getFormato24Horas() {
		return formato24Horas;
	}

	public void ponerEnHora(Integer horas, Integer minutos) {
		this.horas = horas;
		this.minutos = minutos;

	}

	public void ponerEnHora(Integer horas, Integer minutos, Integer segundos) {
		ponerEnHora(horas, minutos);
		this.segundos = segundos;

	}

	public void setFormato24Horas(Boolean formato24Horas) {
		this.formato24Horas = formato24Horas;
	}

	public Boolean check() {
		return ((horas >= 0 && horas < 24) && (minutos >= 0 && minutos < 60) && (segundos >= 0 && segundos < 60));
	}

	@Override
	public String toString() {
		if (check() == false) {
			return "HORA INCORRECTA";
		}
		if (formato24Horas == true) {

			return formatea(horas) + ":" + formatea(minutos) + ":" + formatea(segundos);

		}

		if (formato24Horas == false && horas > 12) {
			return formatea((horas - 12)) + ":" + formatea(minutos) + ":" + formatea(segundos) + " pm";

		}
		if (formato24Horas == false) {
			return formatea(horas) + ":" + formatea(minutos) + ":" + formatea(segundos) + " am";
		}
		return null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(formato24Horas, horas, minutos, segundos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reloj other = (Reloj) obj;
		return Objects.equals(horas, other.horas) && Objects.equals(minutos, other.minutos)
				&& Objects.equals(segundos, other.segundos);
	}

	public String formatea(Integer numero) {
		if (numero < 10) {
			return "0" + numero;
		}
		return numero.toString();
	}
}
