package modelo.locaisMapa;

import java.io.Serializable;

import excecoes.localidades.ExcecaoInicioMontanhas;
import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoSemExperiencia;
import interfaces.Localizacao;
import modelo.personagem.Personagem;

@SuppressWarnings("serial")
public class InicioMontanhas implements Localizacao, Serializable {

	private static final String imagemLocal = "InicioMontanhas.png";
	private static final String nomeLocal = "Inicio da Montanha";
	private static final int numLocal = 7;
	private static final String historiaLocal = "<html>_____Como já havia encontrado pistas sobre seu irmão na floresta, já tendo constatado"
			+ " que todo o ambiente da ilha era muito selvagem, resolveu subir a montanha em busca do companheiro de sangue.<br>_____No "
			+ "início de sua subida, encontrou diversos pontos ingrimes, sendo que em vários momentos estes o fizeram andar horizontalmente"
			+ " para achar uma subida mais adequada. Mesmo longe das áreas selvagens, ainda encontrava algumas criaturas estranhas,"
			+ " além de certamente notar que a temperatura diminuía conforme subia a montanha.<br>_____Também notou que era possível"
			+ " observar uma construção em seu topo, a qual aparentava abrigar seres humanos.";

	private Personagem personagem;

	public InicioMontanhas(Personagem personagem) {
		this.personagem = personagem;
	}

	@Override
	public void zonaTropical() throws ExcecaoLocalidade {
		throw new ExcecaoInicioMontanhas();
	}
	
	@Override
	public void zonaBoss() throws ExcecaoLocalidade {
		throw new ExcecaoInicioMontanhas();	
	}

	@Override
	public void zonaComCavernas() throws ExcecaoLocalidade {
		throw new ExcecaoInicioMontanhas();
	}

	@Override
	public void zonaComNeblina() throws ExcecaoLocalidade {
		throw new ExcecaoInicioMontanhas();
	}

	@Override
	public void zonaComPantano() throws ExcecaoLocalidade {
		throw new ExcecaoInicioMontanhas();
	}

	@Override
	public void zonaComCampos() throws ExcecaoLocalidade {
		throw new ExcecaoInicioMontanhas();
	}

	@Override
	public void zonaComPedras() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Pedras(personagem));
	}

	@Override
	public void zonaComFlorestas() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Floresta(personagem));
	}

	@Override
	public void zonaInicioMontanha() {
		
	}

	@Override
	public void zonaPicoMontanha() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 156)
			this.personagem.alteraLocalizacao(new PicoMontanhas(personagem));
		else
			throw new ExcecaoSemExperiencia();
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