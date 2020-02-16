package modelo.melhorias;

import java.io.Serializable;

@SuppressWarnings("serial")
abstract public class Melhora implements Serializable{

	private boolean melhoraDisponivel;
	private int melhora;
	
	public Melhora(int valorMelhora){
		this.melhora = valorMelhora;
		this.melhoraDisponivel = false;
	}

	public boolean isMelhoraDisponivel() {
		return melhoraDisponivel;
	}

	public void setMelhoraDisponivel(boolean melhoraDisponivel) {
		this.melhoraDisponivel = melhoraDisponivel;
	}

	public int getMelhora() {
		return melhora;
	}
	
}