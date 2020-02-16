package modelo.locaisMapa;

import java.io.Serializable;

import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoPantano;
import excecoes.localidades.ExcecaoSemExperiencia;
import interfaces.Localizacao;
import modelo.personagem.Personagem;

@SuppressWarnings("serial")
public class Pantano implements Localizacao, Serializable {

	private static final String imagemLocal = "Pantano.png";
	private static final String nomeLocal = "Pantano";
	private static final int numLocal = 2;
	private static final String historiaLocal = "<html>_____Como não teve sucesso em encontrar nada dentro da névoa, além "
			+ "de dificuldades de encontrar comida naquele ambiente, Logan andou aleatoriamente, enfrentando criaturas e "
			+ "tentando achar uma saída do local. Ficou realmente aliviado ao perceber que não estava mais naquele breu, "
			+ "porém ainda estava longe de estar em um local apropriado para seus anseios. Se viu então no meio de um "
			+ "pântano.<br>_____Como de costume, sabia que teria que enfrentar o que encontrasse pelo caminho. Entretanto"
			+ ", havia notado que nesta ilha mesmo quando saia muito ferido de uma batalha, se recuperava 100% em questão"
			+ " de segundos. Achou interessante, de modo que resolveu enfrentar as criaturas sem medo.";
	
	private Personagem personagem;
	
	public Pantano(Personagem personagem){
		this.personagem = personagem;
	}

	@Override
	public void zonaTropical() throws ExcecaoLocalidade {
		throw new ExcecaoPantano();
	}
	
	@Override
	public void zonaBoss() throws ExcecaoLocalidade {
		throw new ExcecaoPantano();	
	}

	@Override
	public void zonaComCavernas() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 36) 
			this.personagem.alteraLocalizacao(new Cavernas(personagem));
		else
			throw new ExcecaoSemExperiencia();
	}

	@Override
	public void zonaComNeblina() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Neblina(personagem));
	}

	@Override
	public void zonaComPantano() {
	
	}

	@Override
	public void zonaComCampos() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 54) 
			this.personagem.alteraLocalizacao(new Campo(personagem));
		else
			throw new ExcecaoSemExperiencia();
	}

	@Override
	public void zonaComPedras() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 75) 
			this.personagem.alteraLocalizacao(new Pedras(personagem));
		else
			throw new ExcecaoSemExperiencia();
	}

	@Override
	public void zonaComFlorestas() throws ExcecaoLocalidade {
		throw new ExcecaoPantano();
	}

	@Override
	public void zonaInicioMontanha() throws ExcecaoLocalidade {
		throw new ExcecaoPantano();
	}

	@Override
	public void zonaPicoMontanha() throws ExcecaoLocalidade {
		throw new ExcecaoPantano();
	}

	@Override
	public String getImagemLocal() {
		return imagemLocal;
	}

	@Override
	public String getNomeLocal() {
		return nomeLocal;
	}

	@Override
	public String getHistoriaLocal() {
		return historiaLocal;
	}
	
	@Override
	public int getNumLocal() {
		return numLocal;
	}
	
}