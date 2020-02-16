package modelo.batalha;

import java.io.Serializable;

import excecoes.batalha.ExcecaoDanoBloqueado;
import modelo.personagem.Personagem;

@SuppressWarnings("serial")
abstract public class SimuladorDeGolpe implements Serializable{
	
	public void simulaGolpe(Personagem atacante, Personagem defensor) throws ExcecaoDanoBloqueado {
		int danoBruto = calculaDanoBruto(atacante, defensor);
		int vidaDefensor = defensor.getVidaBatalha();
		if (danoBruto < 1)
			throw new ExcecaoDanoBloqueado();
		else{
			if (danoBruto >= vidaDefensor)
				defensor.retiraVidaBatalha(vidaDefensor);
			else
				defensor.retiraVidaBatalha(danoBruto);
		}
	}
	
	abstract public int calculaDanoBruto(Personagem atacante, Personagem defensor) throws ExcecaoDanoBloqueado ;

}