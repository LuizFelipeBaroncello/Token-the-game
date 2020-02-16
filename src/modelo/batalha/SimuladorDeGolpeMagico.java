package modelo.batalha;

import modelo.personagem.Personagem;

@SuppressWarnings("serial")
public class SimuladorDeGolpeMagico extends SimuladorDeGolpe{

	@Override
	public int calculaDanoBruto(Personagem atacante, Personagem defensor) {
		return atacante.getAtaqueMagico() - defensor.getResistenciaMagica();
	}

}