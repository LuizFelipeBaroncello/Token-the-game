package modelo.personagem;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Ataque implements Serializable{

	private int ataqueMagico;
	private int ataqueFisico;
	
	public Ataque(int ataqueMagico, int ataqueFisico){
		this.ataqueFisico = ataqueFisico;
		this.ataqueMagico = ataqueMagico;
	}

	public int getAtaqueMagico() {
		return ataqueMagico;
	}

	public void adicionaAtaqueMagico(int ataqueMagico) {
		this.ataqueMagico += ataqueMagico;
	}
	
	public void setAtaqueMagico(int ataqueMagico) {
		this.ataqueMagico = ataqueMagico;
	}

	public int getAtaqueFisico() {
		return ataqueFisico;
	}

	public void adicionaAtaqueFisico(int ataqueFisico) {
		this.ataqueFisico += ataqueFisico;
	}
	
	public void setAtaqueFisico(int ataqueFisico) {
		this.ataqueFisico = ataqueFisico;
	}

}