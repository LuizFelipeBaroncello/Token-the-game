package modelo.melhorias;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pontos implements Serializable{

	private int pontosDeVida;
	private int pontosDeAtaque;
	private int pontosDeDefesa;
	
	public Pontos(){
		this.pontosDeAtaque = 0;
		this.pontosDeDefesa = 0;
		this.pontosDeVida = 0;
	}

	public int getPontosDeVida() {
		return pontosDeVida;
	}

	public void setPontoDeVida() {
		this.pontosDeVida++;
	}
	
	public void descontaPontoDeVida() {
		this.pontosDeVida--;
	}

	public int getPontosDeAtaque() {
		return pontosDeAtaque;
	}

	public void setPontoDeAtaque() {
		this.pontosDeAtaque++;
	}
	
	public void descontaPontoDeAtaque() {
		this.pontosDeAtaque--;
	}

	public int getPontosDeDefesa() {
		return pontosDeDefesa;
	}

	public void setPontoDeDefesa() {
		this.pontosDeDefesa++;
	}
	
	public void descontaPontoDeDefesa() {
		this.pontosDeDefesa--;
	}
	
	public void setPontos(int pontosDeVida, int pontosDeAtaque, int pontosDeDefesa){
		this.pontosDeVida = pontosDeVida;
		this.pontosDeAtaque = pontosDeAtaque;
		this.pontosDeDefesa = pontosDeDefesa;
	}
	
}