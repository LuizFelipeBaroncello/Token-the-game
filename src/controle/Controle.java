package controle;


import excecoes.ExcecaoInimigoNaoEncontrado;
import excecoes.ExcecaoMelhoriaNaoDisponivel;
import excecoes.ExcecaoSemPontos;
import excecoes.batalha.ExcecaoDanoBloqueado;
import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoSemExperiencia;
import interacaoUsuario.JanelasDeApoio;
import modelo.FachadaModelo;
import modelo.batalha.Jokenpo.EscolhaJokenpo;

public class Controle {

	private static Controle controle;
	private FachadaModelo modelo;
	private JanelasDeApoio apoio;

	private Controle() {
		modelo = new FachadaModelo().getJogoSalvo();
		apoio = new JanelasDeApoio();
		try {
			this.modelo.getStatusJogador();
			atualizaInimigosNoLocal();
		} catch (Exception e) {
			apoio.exibeMensagem(
					"<html>_____Era um dia at�pico. Em meio ao forte inverno Russo, "
					+ "Logan havia pego folga no dia em quest�o e<br> resolveu dormir"
					+ " at� tarde. Quando acordou, reparou que algo estava diferente. "
					+ "Logo acima de sua mesa<br> havia uma carta. Inicialmente achou "
					+ "estranho, pois ningu�m mais usa cartas em 2033. Todavia,<br> ao "
					+ "ver o conte�do da mesma, ele entendeu o motivo.<br>____Era uma"
					+ " foto de seu irm�o, Dimitri, aparentemente em uma selva, sozinho"
					+ " e com apar�ncia muito<br> fraca. Atr�s da foto havia as seguintes "
					+ "coordenadas: -30.154092,-131.231436. Ao pesquisar no LupD, site de"
					+ "<br> pesquisa que desbancou o Google, descobriu que isso o levaria "
					+ "at� um local no centro do oceano<br> pac�fico.<br>_____Ap�s alguns"
					+ " dias com essa informa��o, resolveu ir at� olocal s� para conferir "
					+ "se realmente existia algo<br> por la. Pegou seu JetPack, preencheu"
					+ " os termos  internacionais para viagens a�reas e partiu em<br> "
					+ "dire��o �s coordenadas.<br>");
			modelo.InicializaJogador();
		}
	}

	public static Controle getControle() {
		if (controle == null)
			controle = new Controle();
		return controle;
	}

	public String getNomeInimigo(int posicao) {
		atualizaInimigosNoLocal();
		return modelo.getNomeInimigo(posicao);
	}

	private void atualizaInimigosNoLocal() {
		try {
			this.modelo.atualizaInimigosNoLocal();
		} catch (ExcecaoInimigoNaoEncontrado e) {
			System.err.println(e);
		}
	}

	public String getToStringInimigo(int posicao) {
		return modelo.getToStringInimigo(posicao);
	}

	public String getImagemInimigo(int posicao) {
		atualizaInimigosNoLocal();
		return modelo.getImagemInimigo(posicao);
	}

	public String getToStringHeroi() {
		return modelo.getToStringHeroi();
	}

	public String getLocalAtual() {
		return modelo.getNomeLocalAtual();
	}

	public void statusJogador() {
		apoio.exibeMensagem(this.modelo.getStatusJogador());
	}

	public void salvar() {
		modelo.salvaJogo();
		apoio.exibeMensagem("Jogo salvo com sucesso");
	}

	public void exibeTextoAjuda() {
		apoio.exibeMensagem(modelo.getTextoAjuda());
	}

	public String getStringPontosDisponiveis() {
		return modelo.getTextoPontosDisponiveis();
	}

	public String getHistoriaLocal() {
		return this.modelo.getHistoriaLocal();
	}

	public String getImagemLocal() {
		return modelo.getImagemLocal();
	}

	public String getImagemInimigoBatalha() {
		return modelo.getImagemInimigoBatalha();
	}

	public void vaiParaLocal(int local) throws Exception {
		try {
			switch (local) {
			case 0:
				modelo.vaiParaAreaTropical();
				break;
			case 1:
				modelo.vaiParaAreaNeblina();
				break;
			case 2:
				modelo.vaiParaAreaPantano();
				break;
			case 3:
				modelo.vaiParaAreaCavernas();
				break;
			case 4:
				modelo.vaiParaAreaCampo();
				break;
			case 5:
				modelo.vaiParaAreaPedras();
				break;
			case 6:
				modelo.vaiParaAreaFlorestas();
				break;
			case 7:
				modelo.vaiParaAreaInicioMontanha();
				break;
			case 8:
				modelo.vaiParaAreaPicoMontanhas();
				break;
			case 9: modelo.vaiParaBoss();
			}
		} catch (ExcecaoLocalidade e) {
			apoio.exibeMensagem("� muito longe para ir direto para o local desejado");
			throw new Exception();
		} catch (ExcecaoSemExperiencia e) {
			apoio.exibeMensagem("Voce n�o tem experiencia suficiente");
			throw new Exception();
		}
	}

	public void criaBatalha(int inimigo) {
		modelo.criaBatalha(inimigo);
	}

	public boolean verificaSeHeroiGanhaJokenpoAtacando() {
		return modelo.verificaSeHeroiGanhaJokenpo(EscolhaJokenpo.Ataca);
	}

	public boolean verificaSeHeroiGanhaJokenpoFingindoAtaque() {
		return modelo.verificaSeHeroiGanhaJokenpo(EscolhaJokenpo.FingeQueAtaca);
	}

	public boolean verificaSeHeroiGanhaJokenpoDesviando() {
		return modelo.verificaSeHeroiGanhaJokenpo(EscolhaJokenpo.Desvia);
	}

	public void simulaGolpeInimigo() {
		try {
			modelo.simulaGolpeInimigo();
		} catch (ExcecaoDanoBloqueado e) {
			apoio.exibeMensagem("O inimigo n�o foi capaz de prover dano");
		}
	}

	public void simulaGolpeFisicoHeroi() {
		try {
			modelo.simulaGolpeFisicoHeroi();
		} catch (ExcecaoDanoBloqueado e) {
			apoio.exibeMensagem("Seu dano foi bloqueado");
		}
	}

	public void simulaGolpeMagicoHeroi() {
		try {
			modelo.simulaGolpeMagicoHeroi();
		} catch (ExcecaoDanoBloqueado e) {
			apoio.exibeMensagem("Seu dano foi bloqueado");
		}
	}

	public void tentaFugir(int i) {
		modelo.tentarFugirBatalha(i);
	}

	public boolean heroiFugiu() {
		return modelo.heroiFugiuDaBatalha();
	}

	public boolean heroiVenceuBatalha() {
		return modelo.heroiVenceuBatalha();
	}

	public void finalizaBatalhaComVitoria() {
		modelo.finalizaBatalhaComVitoria();
	}

	public boolean heroiFugiuDaBatalha() {
		return modelo.heroiFugiuDaBatalha();
	}

	public void finalizaBatalhaQueSeFugiu() {
		modelo.finalizaBatalhaQueSeFugiu();
	}

	public void finalizaBatalhaComDerrota() {
		modelo.finalizaBatalhaComDerrota();
	}

	public void atualizaEstatisticasBatalha() {
		modelo.atualizaEstatisticasBatalha();
	}

	public void exibeTextoAjudaBatalha() {
		apoio.exibeMensagem("Seja bem vindo ao painel de ajuda em rela��o a batalha:\n"
				+ "A batalha � dividida em turnos, sendo que inicialmente � necessario ver quem vai poder atacar,\n"
				+ "para isto � necessario uma batalha de movimentos que funciona da seguinte maneira:\n"
				+ "-Atacar ganha de Fingir ataque;\n" + "-Fingir ataque ganha de Desviar;\n"
				+ "-Desviar ganha de ataque\n"
				+ "Quem ganhar na batalha de movimentos ganhar� o direito de escolher suas a��es no segundo turno, \n"
				+ "as quais incluem:\n" + "-Ataque fisico;\n" + "-Ataque magico;\n" + "-Tentar fugir;\n"
				+ "A batalha apenas ter� fim quando um dos participantes estiver como vida zero, ou se Logan fugir.\n"
				+ "*As vidas s�o mostradas ao lado da foto de cada personagem");
	}

	public void exibeEstatisticasBatalha() {
		apoio.exibeMensagem(modelo.getEstatisticasBatalha());
	}

	public boolean batalhaContinua() {
		return modelo.batalhaContinua();
	}

	public String getToStringInimigoEmBatalha() {
		return modelo.getToStringInimigoEmBatalha();
	}

	public int porcentagemVidaHeroiEmBatalha() {
		return (215 * modelo.getVidaBatalhaHeroiEmBatalha()) / modelo.getVidaTotalHeroiEmBatalha();
	}

	public int porcentagemVidaInimigoEmBatalha() {
		return (215 * modelo.getVidaBatalhaInimigoEmBatalha()) / modelo.getVidaTotalInimigoEmBatalha();
	}

	public int getMelhoriaVida(int i) {
		return modelo.getMelhoriaVida(i);
	}

	public int getMelhoriaAtaqueFisico(int i) {
		return modelo.getMelhoriaAtaqueFisico(i);
	}
	
	public int getMelhoriaAtaqueMagico(int i){
		return modelo.getMelhoriaAtaqueMagico(i);
	}

	public int getMelhoriaDefesaFisica(int i) {
		return modelo.getMelhoriaDefesaFisica(i);
	}
	
	public int getMelhoriaDefesaMagica(int i){
		return modelo.getMelhoriaDefesaMagica(i);
	}

	public void resetaPontos() {
		modelo.reiniciaPontos();
	}

	public void setMelhoriaVida(int i) throws ExcecaoMelhoriaNaoDisponivel, ExcecaoSemPontos {
			modelo.setMelhoriaVida(i);
	}
	
	public void setMelhoriaAtaqueFisico(int i) throws ExcecaoMelhoriaNaoDisponivel, ExcecaoSemPontos {
			modelo.setMelhoriaAtaqueFisico(i);
	}
	
	public void setMelhoriaAtaqueMagico(int i) throws ExcecaoMelhoriaNaoDisponivel, ExcecaoSemPontos {
			modelo.setMelhoriaAtaqueMagico(i);
	}
	
	public void setMelhoriaDefesaFisica(int i) throws ExcecaoMelhoriaNaoDisponivel, ExcecaoSemPontos {
			modelo.setMelhoriaDefesaFisica(i);
	}
	
	public void setMelhoriaDefesaMagica(int i) throws ExcecaoMelhoriaNaoDisponivel, ExcecaoSemPontos {
			modelo.setMelhoriaDefesaMagica(i);
	}

	public void atualizaNovosPontos() {
		modelo.atualizaNovosPontos();
	}

	public int getNumLocal(){
		return modelo.getNumLocal();
	}

	public boolean isBoss() {
		if(modelo.getNumLocal() == 9){
			return true;
		}else{
			return false;
		}
	}
	
}