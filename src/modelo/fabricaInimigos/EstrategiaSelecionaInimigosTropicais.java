package modelo.fabricaInimigos;

import java.io.Serializable;
import java.util.List;

import interfaces.EstrategiaSelecionaInimigos;
import modelo.personagem.Inimigo;

@SuppressWarnings("serial")
public class EstrategiaSelecionaInimigosTropicais implements EstrategiaSelecionaInimigos, Serializable {

	private InimigosParaJogo inimigos;
	
	public EstrategiaSelecionaInimigosTropicais() {
		this.inimigos = InimigosParaJogo.getInimigosParaJogo();
	}
	
	@Override
	public List<Inimigo> retornaConjuntoInimigos() {
		return this.inimigos.retornaConjuntoInimigos("class modelo.locaisMapa.Tropical");
	}

}