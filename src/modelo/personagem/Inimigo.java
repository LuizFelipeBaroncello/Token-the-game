package modelo.personagem;

import interfaces.EstadosExperiencia;
import modelo.personagem.estadosInimigo.NuncaPerdeu;

@SuppressWarnings("serial")
public class Inimigo extends Personagem {

	private EstadosExperiencia estadoExperiencia;
	private int experienciaQueRetiraAoGanhar;

	public Inimigo(String nome, String historia, Ataque ataque, Defesa defesa, String imagemPersonagem, int experienciaAoDerrotar, int experienciaQueRetiraAoGanhar) {
		super(nome, historia, ataque, defesa, imagemPersonagem);
		this.estadoExperiencia = new NuncaPerdeu(this, experienciaAoDerrotar);
		this.experienciaQueRetiraAoGanhar = experienciaQueRetiraAoGanhar;
	}

	public int getExperienciaQueRetiraAoGanhar() {
		return experienciaQueRetiraAoGanhar;
	}

	public int getExperienciaAoDerrotar() {
		return estadoExperiencia.getExperienciaAoSerDerrotado();
	}

	public void setBatalhaPerdida(){
		this.estadoExperiencia.perdeu();
	}

	public void alteraEstadoExperiencia(EstadosExperiencia estadoExperiencia){
		this.estadoExperiencia = estadoExperiencia;
	}
	
	@Override
	public String toString(){
		return 	  "<html>Nome: " + this.getNome() + "<br>"
				+ "Descricao: " + this.getHistoria() + "<br>"
				+ "Vida: " + this.getVidaBatalha() + "<br>"
				+ "Dano Fisico: " + this.getAtaqueFisico() + "<br>"
				+ "Dano Magico: " + this.getAtaqueMagico() + "<br>"
				+ "Defesa Fisica: " + this.getResistenciaFisica() + "<br>"
				+ "Defesa Magica: " + this.getResistenciaMagica() + "<br>"
				+ "Experiencia ao derrotar: " + this.getExperienciaAoDerrotar() + "<br>";
	}
	
}