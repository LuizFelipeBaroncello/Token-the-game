package modelo.personagem.estadosInimigo;

import java.io.Serializable;

import interfaces.EstadosExperiencia;
import modelo.personagem.Inimigo;

@SuppressWarnings("serial")
public class PerdeuDuasVezes implements EstadosExperiencia, Serializable{

	private Inimigo inimigo;
	private int experienciaAoSerDerrotado;
	
	public PerdeuDuasVezes(Inimigo inimigo, int experienciaAoDerrotar){
		this.inimigo = inimigo;
		this.experienciaAoSerDerrotado = experienciaAoDerrotar;
	}
	
	@Override
	public void perdeu() {
		this.inimigo.alteraEstadoExperiencia(new PerdeuTresVezes());
	}

	@Override
	public int getExperienciaAoSerDerrotado() {
		return this.experienciaAoSerDerrotado;
	}
	
}