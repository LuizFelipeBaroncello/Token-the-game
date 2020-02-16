package modelo.batalha;

import java.io.Serializable;
import java.util.Random;

@SuppressWarnings("serial")
public class FugaBatalha implements Serializable{

	private static final int numeroPortas = 6;
	
	private int numPortaQuePermiteFuga;
	private int escolhaPortaJogador;
	
	public FugaBatalha(){
		Random random = new Random();
		this.numPortaQuePermiteFuga = random.nextInt(numeroPortas) + 1;
	}

	public void setEscolhaPortaJogador(int caminhoEscolhido){
		this.escolhaPortaJogador = caminhoEscolhido;
	}
	
	public boolean heroiFugiuBatalha(){
		return numPortaQuePermiteFuga == escolhaPortaJogador;
	}

}