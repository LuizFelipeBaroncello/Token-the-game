package modelo.batalha;

import java.io.Serializable;

import excecoes.batalha.ExcecaoEmpateJokenpo;
import excecoes.batalha.ExcecaoJokenpoNaoLocalizado;

@SuppressWarnings("serial")
public class Jokenpo implements Serializable{

	public enum EscolhaJokenpo {
		Ataca,
		Desvia,
		FingeQueAtaca
	}
	
	private EscolhaJokenpo escolhaHeroi;
	private EscolhaJokenpo escolhaInimigo;	
	
	
	public void setEscolhas(EscolhaJokenpo escolhaHeroi, EscolhaJokenpo escolhaInimigo){
		this.escolhaHeroi = escolhaHeroi;
		this.escolhaInimigo = escolhaInimigo;
	}
	
	public boolean heroiVenceu() throws ExcecaoEmpateJokenpo, ExcecaoJokenpoNaoLocalizado{//case map
		switch (this.escolhaHeroi) {
		case Ataca:
			return casoHeroiAtaque();			
		case FingeQueAtaca:
			return casoHeroiFinjaAtacar();			
		case Desvia:
			return casoHeroiDesvie();
		default:
			throw new ExcecaoJokenpoNaoLocalizado();
		}
	}

	private boolean casoHeroiDesvie() throws ExcecaoEmpateJokenpo {
		switch (this.escolhaInimigo) {
		case Ataca:
			return true;			
		case FingeQueAtaca:
			return false;
		default:
			throw new ExcecaoEmpateJokenpo();
		}
	}

	private boolean casoHeroiFinjaAtacar() throws ExcecaoEmpateJokenpo {
		switch (this.escolhaInimigo) {
		case Desvia:
			return true;			
		case Ataca:
			return false;
		default:
			throw new ExcecaoEmpateJokenpo();
		}
	}

	private boolean casoHeroiAtaque() throws ExcecaoEmpateJokenpo {
		switch (this.escolhaInimigo) {
		case FingeQueAtaca:
			return true;
		case Desvia:
			return false;
		default:
			throw new ExcecaoEmpateJokenpo();
		}
	}
	
}