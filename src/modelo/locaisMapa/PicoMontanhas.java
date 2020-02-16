package modelo.locaisMapa;

import java.io.Serializable;

import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoPicoMontanhas;
import excecoes.localidades.ExcecaoSemExperiencia;
import interfaces.Localizacao;
import modelo.personagem.Personagem;

@SuppressWarnings("serial")
public class PicoMontanhas implements Localizacao, Serializable {

	private static final String imagemLocal = "PicoMontanhas.png";
	private static final String nomeLocal = "Pico Montanha";
	private static final int numLocal = 8;
	private static final String historiaLocal = "<html>_____Finalmente chegou ao topo da montanha. Não havia criatura nenhuma por ali,"
			+ " apenas neve e uma grande construção esquisita. Ao tentar adentrar na construção, percebeu que a porta se abriu sozinha,"
			+ " sendo que sem hesitar entrou na mesma.<br>_____Logo que entrou, viu um vulto humano ao final do corredor, sendo que ao "
			+ "se aproximar percebeu que se tratava de seu irmão. Ao tentar falar com o mesmo sobre como sair daquela ilha, notou que"
			+ " ele não estava interessado. Na verdade, Dimitri estava aparentando raiva.<br>_____Ao questioná-lo sobre o motivo, ele"
			+ " disse que não estava perdido, e que todas as criaturas na ilha eram suas criações, ainda complementou dizendo que"
			+ " achava inadmissível alguém derrotá-las desta maneira, começando então a soltar criaturas na direção de Logan.<br>"
			+ "_____Ao ver seu irmão fazendo isso, notou que aquele já não era o Dimitri que conhecera na infância, e sim apenas "
			+ "alguém que algum dia já foi seu irmão. Assim sendo, precisava derrotar aquelas criaturas para que levasse o companheiro"
			+ " de sangue a uma central de reabilitação mental em seu continente.";
	
	private Personagem personagem;
	
	public PicoMontanhas(Personagem personagem){
		this.personagem = personagem;
	}

	@Override
	public void zonaTropical() throws ExcecaoLocalidade {
		throw new ExcecaoPicoMontanhas();
	}

	@Override
	public void zonaComCavernas() throws ExcecaoLocalidade {
		throw new ExcecaoPicoMontanhas();
	}

	@Override
	public void zonaComNeblina() throws ExcecaoLocalidade {
		throw new ExcecaoPicoMontanhas();
	}

	@Override
	public void zonaComPantano() throws ExcecaoLocalidade {
		throw new ExcecaoPicoMontanhas();
	}

	@Override
	public void zonaComCampos() throws ExcecaoLocalidade {
		throw new ExcecaoPicoMontanhas();	
	}

	@Override
	public void zonaComPedras() throws ExcecaoLocalidade {
		throw new ExcecaoPicoMontanhas();}

	@Override
	public void zonaComFlorestas() throws ExcecaoLocalidade {
		throw new ExcecaoPicoMontanhas();	}

	@Override
	public void zonaInicioMontanha() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new InicioMontanhas(personagem));
	}

	@Override
	public void zonaPicoMontanha() {

	}

	@Override
	public void zonaBoss() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 189) 
			this.personagem.alteraLocalizacao(new Boss(personagem));
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