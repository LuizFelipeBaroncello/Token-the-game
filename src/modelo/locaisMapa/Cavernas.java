package modelo.locaisMapa;

import java.io.Serializable;

import excecoes.localidades.ExcecaoCavernas;
import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoSemExperiencia;
import interfaces.Localizacao;
import modelo.personagem.Personagem;

@SuppressWarnings("serial")
public class Cavernas implements Localizacao, Serializable {

	private static final String imagemLocal = "Cavernas.png";
	private static final String nomeLocal = "Cavernas";
	private static final int numLocal = 3;
	private static final String historiaLocal = "<html>_____J� cansando de ficar no p�ntano, seguiu em frente at� estar ao lado"
			+ " de uma cadeia de montanhas, as quais vira quando estava na parte tropical da ilha. Ao se aproximar, nota muitas"
			+ " cavernas e resolve explor�-las, at� porque fazia sentido se esconder em cavernas com aquela natureza estranha "
			+ "que havia encontrado fora delas.<br>_____Ao entrar na caverna, se sentiu mais sozinho que o �ltimo Americano "
			+ "vivo, ap�s o pa�s de Logan (Russia) lan�ar um ataque nuclear contra os Estados Unidos, fato ocorrido h� poucos"
			+ " anos.<br>_____Logo na primeira caverna, notou uma c�mera de seguran�a, a qual tinha apar�ncia antiga, embora "
			+ "parecesse funcionar. Isso apenas o estimulou a explorar ainda mais a caverna.";

	private Personagem personagem;
	
	public Cavernas(Personagem personagem){
		this.personagem = personagem;
	}

	@Override
	public void zonaTropical() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Tropical(personagem));
	}

	@Override
	public void zonaComCavernas() {
		
	}

	@Override
	public void zonaComNeblina() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Neblina(personagem));
	}

	@Override
	public void zonaComPantano() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new Pantano(personagem));
	}

	@Override
	public void zonaComCampos() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		if (personagem.getExperiencia() >= 54) 
			this.personagem.alteraLocalizacao(new Campo(personagem));
		else
			throw new ExcecaoSemExperiencia();
	}

	@Override
	public void zonaComPedras() throws ExcecaoLocalidade{
		throw new ExcecaoCavernas();
	}

	@Override
	public void zonaComFlorestas() throws ExcecaoLocalidade {
		throw new ExcecaoCavernas();
	}

	@Override
	public void zonaInicioMontanha() throws ExcecaoLocalidade {
		throw new ExcecaoCavernas();
	}

	@Override
	public void zonaPicoMontanha() throws ExcecaoLocalidade {
		throw new ExcecaoCavernas();
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
		throw new ExcecaoCavernas();	
	}
	
}