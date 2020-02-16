package modelo.personagem.estadosInimigo;

import java.io.Serializable;

import interfaces.EstadosExperiencia;

@SuppressWarnings("serial")
public class PerdeuTresVezes implements EstadosExperiencia, Serializable {
	
	@Override
	public void perdeu() {
		
	}

	@Override
	public int getExperienciaAoSerDerrotado() {
		return 1;
	}
	
}