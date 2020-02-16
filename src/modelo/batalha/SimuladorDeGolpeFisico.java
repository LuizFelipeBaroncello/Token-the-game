package modelo.batalha;

import modelo.personagem.Personagem;

@SuppressWarnings("serial")
public class SimuladorDeGolpeFisico extends SimuladorDeGolpe{

	@Override
	public int calculaDanoBruto(Personagem atacante, Personagem defensor) {
		return atacante.getAtaqueFisico() - defensor.getResistenciaFisica();
	}
	
}