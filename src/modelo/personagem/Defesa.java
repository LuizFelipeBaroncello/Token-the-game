package modelo.personagem;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Defesa implements Serializable{

	private int vidaTotal;
	private int vidaMaxima;
	private int resistenciaMagica;
	private int resistenciaFisica;
	
	public Defesa(int vida, int resistenciaFisica, int resistenciaMagica){
		this.vidaTotal = vida;
		this.vidaMaxima = vida;
		this.resistenciaFisica = resistenciaFisica;
		this.resistenciaMagica = resistenciaMagica;
	}
	
	public void adicionaResistenciaMagica(int resistenciaMagica) {
		this.resistenciaMagica += resistenciaMagica;
	}
	
	public void setResistenciaMagica(int resistenciaMagica) {
		this.resistenciaMagica = resistenciaMagica;
	}

	public void adicionaResistenciaFisica(int resistenciaFisica) {
		this.resistenciaFisica += resistenciaFisica;
	}
	
	public void setResistenciaFisica(int resistenciaFisica) {
		this.resistenciaFisica = resistenciaFisica;
	}

	public void adicionaVida(int vida){
		this.vidaMaxima += vida;
	}
	
	public void setVidaMaxima(int vida){
		this.vidaMaxima = vida;
	}
	
	public int getVidaMaxima(){
		return vidaMaxima;
	}
	
	public void atualizaVidaBatalha(){
		this.vidaTotal = vidaMaxima;
	}
	
	public void retiraVidaBatalha(int vida){
		this.vidaTotal -= vida;
	}
	
	public int getVidaBatalha(){
		return vidaTotal;
	}

	public int getResistenciaMagica() {
		return resistenciaMagica;
	}

	public int getResistenciaFisica() {
		return resistenciaFisica;
	}
	
}