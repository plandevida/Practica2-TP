package entidades.tiempo;

import interfaces.ObjetosQueSeEjecutan;

public class Contador implements ObjetosQueSeEjecutan {
	//el numero de impulsos que lleva 
	protected int impulsos;
	
	public Contador() {
		impulsos = 0;
	}
	/**
	 * Metodo que ejecuta.
	 * 
	 * 
	 */
	public boolean ejecutar() { 
		nuevoImpulso();
		
		return true;
	}
	/**
	 * MÃ©todo que añade un nuevo impulso al actual.
	 * 
	 * 
	 */
	public void nuevoImpulso() {
		impulsos++;
	}
	/**
	 * Metodo para obtener los impulsos.
	 * 
	 * @return Los impulsos.
	 */
	public int getImpulsos() {
		return impulsos;
	}
}
