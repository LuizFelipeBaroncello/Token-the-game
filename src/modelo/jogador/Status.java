package modelo.jogador;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Status implements Serializable{

	private int numeroBatalhasTotal;
	private int numeroBatalhasGanhas;
	private int numeroBatalhasPerdidas;
	private int numeroBatalhasIgnoradas;
	
	public Status(){
		this.numeroBatalhasGanhas = 0;
		this.numeroBatalhasPerdidas = 0;
		this.numeroBatalhasIgnoradas = 0;
		this.numeroBatalhasTotal = 0;
	}

	public void adicionaBatalha() {
		this.numeroBatalhasTotal++;
	}

	public void setBatalhaGanha() {
		this.numeroBatalhasGanhas++;
	}

	public void setBatalhaPerdida() {
		this.numeroBatalhasPerdidas++;
	}

	public void setBatalhaIgnorada() {
		this.numeroBatalhasIgnoradas++;
	}

	private double getTaxaVitoria() {
		try {
			return (((this.numeroBatalhasGanhas)*100)/numeroBatalhasTotal);			
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public String toString(){
		return	"Batalhas total: " + this.numeroBatalhasTotal + "\n" +
				"Batalhas ganhas: " + this.numeroBatalhasGanhas + "\n" +
				"Batalhas ignoradas: " + this.numeroBatalhasIgnoradas + "\n" +
				"Batalhas perdidas: " + this.numeroBatalhasPerdidas + "\n" +
				"Taxa de vitoria: " + getTaxaVitoria() + "%\n";
	}
	
}