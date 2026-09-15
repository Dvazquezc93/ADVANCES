package ejercicios.Ejercicio30;

import java.util.ArrayList;
import java.util.List;

public class AppVideojuego {

	public static void main(String[] args) {
		Jugador j1= new Jugador();
		Asesino a1= new Asesino("Altair","as1");
		Asesino a2= new Asesino("ezzio","as2");
		Asesino a3= new Asesino("Connor","as3");
		j1.setEquipoCombate(new EquipoCombate());
		j1.getEquipoCombate().añadirPersonaje(a1);
		j1.getEquipoCombate().añadirPersonaje(a2);
		j1.getEquipoCombate().añadirPersonaje(a3);
		System.out.println(j1.getEquipoCombate());
		Parasito p1 = new Parasito("blas","B69");
		System.out.println("Su parasito  quita "+p1.getDaño()+ " puntos de daño y su velocidad es "+p1.getVelocidadAtaque());
		j1.getEquipoCombate().añadirPersonaje(p1);
		System.out.println(j1.getEquipoCombate());
		System.out.println(j1.getEquipoCombate().getVidaEquipo());
		j1.getEquipoCombate().añadirPersonaje(p1);
		System.out.println(j1.getEquipoCombate());
		Parasito p2 = new Parasito("Vecna","ST05");
		Parasito p3 = new Parasito("paras","#0046");
		j1.getEquipoCombate().añadirPersonaje(p2);
		j1.getEquipoCombate().añadirPersonaje(p3);
		System.out.println(j1.getEquipoCombate());
		System.out.println(j1.getEquipoCombate().getVidaEquipo());
		
		

	}

}
