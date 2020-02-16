package modelo.locaisMapa;

import java.io.Serializable;

import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoSemExperiencia;
import excecoes.localidades.ExcecaoTropical;
import interfaces.Localizacao;
import modelo.personagem.Personagem;

@SuppressWarnings("serial")
public class Tropical implements Localizacao, Serializable {

	private static final String imagemLocal = "Tropical.png";
	private static final String nomeLocal = "Area Tropical";
	private static final int numLocal = 0;
	private static final String historiaLocal = "<html>_____Ao chegar nas coordenadas, seu jetPack começou"
			+ " a apresentar defeitos, o que era estranho, pois desde 2026 não ocorriam mais acidentes com"
			+ " jetPack. Ele começou a cair na direção do mar, porém quando estava quase chegando à água "
			+ "ele notou a presença de uma ilha, na qual pousara.<br>_____O cenário do local era tipicamente"
			+ " tropical, aspecto que lembrou muito sua visita ao Brasil antes do mesmo entrar em uma guerra"
			+ " civil. Logo percebeu animais desconhecidos ou considerados extintos que vagavam pelo local."
			+ "<br>_____Como seu jetPack já não funciona mais e seus suprimentos são limitados, Logan resolve"
			+ " explorar o local e tentar achar vida humana pela ilha, mas percebe que para isso terá que enfrentar"
			+ " certos animais pelo caminho.<br>";
			
	private Personagem personagem;

	public Tropical(Personagem personagem) {
		this.personagem = personagem;
	}

	@Override
	public void zonaTropical() {

	}
	
	@Override
	public void zonaBoss() throws ExcecaoLocalidade {
		throw new ExcecaoTropical();	
	}

	@Override
	public void zonaComCavernas() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 36)
			this.personagem.alteraLocalizacao(new Cavernas(personagem));
		else
			throw new ExcecaoSemExperiencia();

	}

	@Override
	public void zonaComNeblina() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 9)
			this.personagem.alteraLocalizacao(new Neblina(personagem));
		else
			throw new ExcecaoSemExperiencia();
	}

	@Override
	public void zonaComPantano() throws ExcecaoLocalidade {
		throw new ExcecaoTropical();
	}

	@Override
	public void zonaComCampos() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 54)
			this.personagem.alteraLocalizacao(new Campo(personagem));
		else
			throw new ExcecaoSemExperiencia();
	}

	@Override
	public void zonaComPedras() throws ExcecaoLocalidade {
		throw new ExcecaoTropical();
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
		throw new ExcecaoTropical();
	}

	@Override
	public void zonaPicoMontanha() throws ExcecaoLocalidade {
		throw new ExcecaoTropical();
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