package modelo.locaisMapa;

import java.io.Serializable;
import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoPedras;
import excecoes.localidades.ExcecaoSemExperiencia;
import interfaces.Localizacao;
import modelo.personagem.Personagem;

@SuppressWarnings("serial")
public class Pedras implements Localizacao, Serializable {

	private static final String imagemLocal = "Pedras.png";
	private static final String nomeLocal = "Pedras";
	private static final int numLocal = 5;
	private static final String historiaLocal = "<html>_____Logo após passar do campo, Logan encontra muitas pedras, "
			+ "distribuídas como que em um campo, porém com rochas por toda parte e seres esquisitos.<br>_____Neste"
			+ " ponto, nota que existe uma floresta por perto, a qual lhe parece conhecida. Ele então toma como meta chegar no local.";
	
	private Personagem personagem;
	
	public Pedras(Personagem personagem){
		this.personagem = personagem;
	}

	@Override
	public void zonaTropical() throws ExcecaoLocalidade {
		throw new ExcecaoPedras();
	}

	@Override
	public void zonaComCavernas() throws ExcecaoLocalidade {
		throw new ExcecaoPedras();
	}
	
	@Override
	public void zonaBoss() throws ExcecaoLocalidade {
		throw new ExcecaoPedras();	
	}

	@Override
	public void zonaComNeblina() throws ExcecaoLocalidade {
		throw new ExcecaoPedras();
	}

	@Override
	public void zonaComPantano() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Pantano(personagem));
	}

	@Override
	public void zonaComCampos() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Campo(personagem));
	}

	@Override
	public void zonaComPedras() {

	}

	@Override
	public void zonaComFlorestas() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 99) 
			this.personagem.alteraLocalizacao(new Floresta(personagem));
		else
			throw new ExcecaoSemExperiencia();
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
		throw new ExcecaoPedras();
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