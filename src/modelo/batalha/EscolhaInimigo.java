package modelo.batalha;

import java.io.Serializable;
import java.util.Random;

import modelo.batalha.Jokenpo.EscolhaJokenpo;

@SuppressWarnings("serial")
public class EscolhaInimigo implements Serializable{

	private static final int numeroOpcoesJokenpo = 3;
	
	private EscolhaJokenpo escolhaInimigo;
	
	public EscolhaInimigo(){
		Random random = new Random();
		int numeroAleatorio = random.nextInt(numeroOpcoesJokenpo);
		defineEscolhaInimigo(numeroAleatorio);
	}

	private void defineEscolhaInimigo(int numeroAleatorio) {
		switch (numeroAleatorio) {
		case 0:
			this.escolhaInimigo = EscolhaJokenpo.Ataca;			
			break;
		case 1:
			this.escolhaInimigo = EscolhaJokenpo.FingeQueAtaca;			
			break;
		default:
			this.escolhaInimigo = EscolhaJokenpo.Desvia;			
			break;
		}
	}
	
	public EscolhaJokenpo getEscolhaInimigo(){
		return this.escolhaInimigo;
	}
}