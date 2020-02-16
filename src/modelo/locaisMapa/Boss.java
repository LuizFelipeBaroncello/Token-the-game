package modelo.locaisMapa;

import java.io.Serializable;

import excecoes.localidades.ExcecaoLocalidade;
import interfaces.Localizacao;
import modelo.personagem.Personagem;

@SuppressWarnings("serial")
public class Boss implements Localizacao, Serializable{

	private static final String imagemLocal = "Boss.png";
	private static final String nomeLocal = "Boss";
	private static final int numLocal = 9;
	private static final String historiaLocal = "<html>_____Quando finalmente derrotou as criaturas,"
			+ " percebe seu irm�o fugindo em dire��o a um corredor, ao persegui-lo nota que chegou a "
			+ "uma sala grande com alguns arm�rios, no canto da mesma Dimitri parece injetar um l�quido"
			+ " vermelho em seu bra�o, em quest�o de segundos ap�s fazer isso, seu tamanho dobra e se"
			+ " torna irreconhec�vel, aparentando apenas ser muito perigoso.<br>_____Neste ponto Logan"
			+ " percebe que o �nico jeito de seguir em frente � enfrentar seu pr�prio irm�o.";
	
	private Personagem personagem;
	
	public Boss(Personagem personagem){
		this.personagem = personagem;
	}
	
	@Override
	public void zonaTropical() throws ExcecaoLocalidade{
		throw new ExcecaoLocalidade();
	}

	@Override
	public void zonaComCavernas() throws ExcecaoLocalidade {
		throw new ExcecaoLocalidade();
	}

	@Override
	public void zonaComNeblina() throws ExcecaoLocalidade {
		throw new ExcecaoLocalidade();
	}

	@Override
	public void zonaComPantano() throws ExcecaoLocalidade {
		throw new ExcecaoLocalidade();
	}

	@Override
	public void zonaComCampos() throws ExcecaoLocalidade {
		throw new ExcecaoLocalidade();
	}

	@Override
	public void zonaComPedras() throws ExcecaoLocalidade {
		throw new ExcecaoLocalidade();
	}

	@Override
	public void zonaComFlorestas() throws ExcecaoLocalidade {
		throw new ExcecaoLocalidade();
	}

	@Override
	public void zonaInicioMontanha() throws ExcecaoLocalidade {
		throw new ExcecaoLocalidade();
	}

	@Override
	public void zonaPicoMontanha() throws ExcecaoLocalidade {
		this.personagem.alteraLocalizacao(new PicoMontanhas(personagem));
	}

	@Override
	public void zonaBoss() {
		
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