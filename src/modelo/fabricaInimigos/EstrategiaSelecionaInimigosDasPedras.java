package modelo.fabricaInimigos;

import java.io.Serializable;
import java.util.List;

import interfaces.EstrategiaSelecionaInimigos;
import modelo.personagem.Inimigo;

@SuppressWarnings("serial")
public class EstrategiaSelecionaInimigosDasPedras implements EstrategiaSelecionaInimigos, Serializable {

	private InimigosParaJogo inimigos;
	
	public EstrategiaSelecionaInimigosDasPedras() {
		this.inimigos = InimigosParaJogo.getInimigosParaJogo();
	}
	
	@Override
	public List<Inimigo> retornaConjuntoInimigos() {
		return this.inimigos.retornaConjuntoInimigos("class modelo.locaisMapa.Pedras");
	}

}