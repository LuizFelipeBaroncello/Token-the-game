package modelo.jogador;

import java.io.Serializable;

import modelo.personagem.Heroi;

@SuppressWarnings("serial")
public class Jogador implements Serializable{

	private Heroi heroi;
	private Status statusJogador;
	
	public Jogador(Heroi heroi){
		this.heroi = heroi;
		this.statusJogador = new Status();
	}

	public Heroi getHeroi() {
		return heroi;
	}

	public void adicionaBatalhaAoStatus(){
		this.statusJogador.adicionaBatalha();
	}
	
	public void setBatalhaGanha(){
		this.statusJogador.setBatalhaGanha();
	}
	
	public void setBatalhaPerdida(){
		this.statusJogador.setBatalhaPerdida();
	}
	
	public void setBatalhaIgnorada(){
		this.statusJogador.setBatalhaIgnorada();
	}
	
	public String getStatusJogador(){
		return this.statusJogador.toString();
	}
	
}