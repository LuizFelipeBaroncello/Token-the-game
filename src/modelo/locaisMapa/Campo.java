package modelo.locaisMapa;

import java.io.Serializable;

import excecoes.localidades.ExcecaoCampo;
import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoSemExperiencia;
import interfaces.Localizacao;
import modelo.personagem.Personagem;

@SuppressWarnings("serial")
public class Campo implements Localizacao, Serializable {

	private static final String imagemLocal = "Campo.png";
	private static final String nomeLocal = "Campo";
	private static final int numLocal = 4;
	private static final String historiaLocal = "<html>_____Ao contrário do que se esperava, não encontrou nada pelas cavernas,"
			+ " e ainda por cima viu criaturas ainda mais estranhas do que as anteriores. Tudo isso o levou a duvidar se realmente"
			+ " havia visto uma câmera ou era uma espécie de miragem tecnológica. Pelo menos já não estava lá, e sim em um campo"
			+ " aberto aparentemente longe do oceano.<br>_____O local não aparenta ter tanta fauna quanto os últimos, mas ainda "
			+ "assim apresenta perigos, certamente é necessário passar rapidamente por lá.<br>";
	

	private Personagem personagem;

	public Campo(Personagem personagem) {
		this.personagem = personagem;
	}

	@Override
	public void zonaTropical() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Tropical(personagem));
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
		throw new ExcecaoCampo();
	}

	@Override
	public void zonaComPantano() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Pantano(personagem));
	}

	@Override
	public void zonaComCampos() {
		
	}

	@Override
	public void zonaComPedras() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 75)
			this.personagem.alteraLocalizacao(new Pedras(personagem));
		else
			throw new ExcecaoSemExperiencia();
	}

	@Override
	public void zonaComFlorestas() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 99)
			this.personagem.alteraLocalizacao(new Floresta(personagem));
		else
			throw new ExcecaoSemExperiencia();
	}

	@Override
	public void zonaInicioMontanha() throws ExcecaoLocalidade {
		throw new ExcecaoCampo();
	}

	@Override
	public void zonaPicoMontanha() throws ExcecaoLocalidade {
		throw new ExcecaoCampo();
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

	@Override
	public void zonaBoss() throws ExcecaoLocalidade {
		throw new ExcecaoCampo();	
	}

}