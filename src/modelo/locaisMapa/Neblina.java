package modelo.locaisMapa;

import java.io.Serializable;

import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoNeblina;
import excecoes.localidades.ExcecaoSemExperiencia;
import interfaces.Localizacao;
import modelo.personagem.Personagem;

@SuppressWarnings("serial")
public class Neblina implements Localizacao, Serializable {

	private static final String imagemLocal = "Neblina.png";
	private static final String nomeLocal = "Neblina";
	private static final int numLocal = 1;
	private static final String historiaLocal = "<html>_____Ap�s encontrar apenas vida selvagem na �rea tropical da ilha, "
			+ "Logan chegou a um local nebuloso, sendo que apesar de saber que a neblina era natural dali, a atmosfera "
			+ "lembrou-o da extrema polui��o que vira quando teve que apresentar seu doutorado em Hong Kong.<br>_____"
			+ "Dentro da imensa neblina, ele conseguia ver apenas 7 metros � frente. Os seres vivos encontrados neste "
			+ "local lembram muito lendas e mitos, seres que nunca se imaginou j� terem existido, mas que de certa "
			+ "forma conviviam em equil�brio no local. A �nica semelhan�a entre esses seres com os do local anterior"
			+ " era o fato de ambos quererem atac�-lo.";
	
	private Personagem personagem;
	
	public Neblina(Personagem personagem){
		this.personagem = personagem;
	}

	@Override
	public void zonaTropical() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Tropical(personagem));
	}

	@Override
	public void zonaBoss() throws ExcecaoLocalidade {
		throw new ExcecaoNeblina();	
	}
	
	@Override
	public void zonaComCavernas() throws ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 36) 
			this.personagem.alteraLocalizacao(new Cavernas(personagem));
		else
			throw new ExcecaoSemExperiencia();
	}

	@Override
	public void zonaComNeblina() {

	}

	@Override
	public void zonaComPantano() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 21) 
			this.personagem.alteraLocalizacao(new Pantano(personagem));
		else
			throw new ExcecaoSemExperiencia();
	}

	@Override
	public void zonaComCampos() throws ExcecaoLocalidade {
		throw new ExcecaoNeblina();
	}

	@Override
	public void zonaComPedras() throws ExcecaoLocalidade {
		throw new ExcecaoNeblina();
	}

	@Override
	public void zonaComFlorestas() throws ExcecaoLocalidade {
		throw new ExcecaoNeblina();
	}

	@Override
	public void zonaInicioMontanha() throws ExcecaoLocalidade {
		throw new ExcecaoNeblina();
	}

	@Override
	public void zonaPicoMontanha() throws ExcecaoLocalidade {
		throw new ExcecaoNeblina();
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