package modelo.personagem;

import interfaces.Localizacao;
import modelo.locaisMapa.Tropical;

@SuppressWarnings("serial")
public class Heroi extends Personagem {

	public Heroi(String nome, String historia, Ataque ataque, Defesa defesa, String imagemPersonagem) {
		super(nome, historia, ataque, defesa, imagemPersonagem);
		Localizacao localizacao = new Tropical(this);
		super.setLocalizacao(localizacao);

	}
	
	@Override
	public String toString(){
		return 	  "<html>Nome: " + this.getNome() + "<br>"
				+ "Vida: " + this.getVidaBatalha() + "<br>"
				+ "Dano Fisico: " + this.getAtaqueFisico() + "<br>"
				+ "Dano Magico: " + this.getAtaqueMagico() + "<br>"
				+ "Defesa Fisica: " + this.getResistenciaFisica() + "<br>"
				+ "Defesa Magica: " + this.getResistenciaMagica() + "<br>"
				+ "Experiencia: " + this.getExperiencia() + "<br>";
	}

}