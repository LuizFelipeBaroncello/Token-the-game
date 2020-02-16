package modelo.locaisMapa;

import java.io.Serializable;

import excecoes.localidades.ExcecaoFloresta;
import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoSemExperiencia;
import interfaces.Localizacao;
import modelo.personagem.Personagem;

@SuppressWarnings("serial")
public class Floresta implements Localizacao, Serializable {

	private static final String imagemLocal = "Floresta.png";
	private static final String nomeLocal = "Floresta";
	private static final int numLocal = 6;
	private static final String historiaLocal = "<html>_____Finalmente havia saído das pedras, tendo sorte por não cair em nenhum d"
			+ "esfiladeiro. Ao chegar, lembrou-se de onde conhecia a floresta. Aquela era exatamente a mesma na qual seu irmão "
			+ "aparecia na foto que recebera tempos atrás, fato que o deixa com ainda mais vontade de procurar por seu irmão."
			+ "<br>_____Na Floresta, Logan encontra muitos seres vivos que se pareciam com plantas, além de um pequeno abrigo,"
			+ " que apesar de parecer muito bem feito, já estava abandonado há um bom tempo.";
	
	private Personagem personagem;
	
	public Floresta(Personagem personagem){
		this.personagem = personagem;
	}

	@Override
	public void zonaTropical() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Tropical(personagem));
	}

	@Override
	public void zonaComCavernas() throws ExcecaoLocalidade {
		throw new ExcecaoFloresta();
	}

	@Override
	public void zonaComNeblina() throws ExcecaoLocalidade {
		throw new ExcecaoFloresta();
	}

	@Override
	public void zonaComPantano() throws ExcecaoLocalidade {
		throw new ExcecaoFloresta();
	}

	@Override
	public void zonaComCampos() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Campo(personagem));
	}

	@Override
	public void zonaComPedras() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Pedras(personagem));
	}

	@Override
	public void zonaBoss() throws ExcecaoLocalidade {
		throw new ExcecaoFloresta();	
	}
	
	@Override
	public void zonaComFlorestas() {

	}

	@Override
	public void zonaInicioMontanha() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 126) 
			this.personagem.alteraLocalizacao(new InicioMontanhas(personagem));
		else
			throw new ExcecaoSemExperiencia();
	}

	@Override
	public void zonaPicoMontanha() throws ExcecaoLocalidade {
		throw new ExcecaoFloresta();
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