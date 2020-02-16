package modelo.personagem.estadosInimigo;

import java.io.Serializable;

import interfaces.EstadosExperiencia;
import modelo.personagem.Inimigo;

@SuppressWarnings("serial")
public class NuncaPerdeu implements EstadosExperiencia, Serializable {

	private Inimigo inimigo;
	private int experienciaAoSerDerrotado;
	
	public NuncaPerdeu(Inimigo inimigo, int experienciaAoDerrotar){
		this.inimigo = inimigo;
		this.experienciaAoSerDerrotado = experienciaAoDerrotar;
	}
	
	@Override
	public void perdeu() {
		this.inimigo.alteraEstadoExperiencia(new PerdeuUmaVez(inimigo, (this.experienciaAoSerDerrotado/2)+1));
	}

	@Override
	public int getExperienciaAoSerDerrotado() {
		return this.experienciaAoSerDerrotado;
	}

}