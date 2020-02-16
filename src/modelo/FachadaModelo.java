package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import excecoes.ExcecaoInimigoNaoEncontrado;
import excecoes.ExcecaoMelhoriaNaoDisponivel;
import excecoes.ExcecaoSemPontos;
import excecoes.batalha.ExcecaoDanoBloqueado;
import excecoes.batalha.ExcecaoEmpateJokenpo;
import excecoes.batalha.ExcecaoJokenpoNaoLocalizado;
import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoSemExperiencia;
import interfaces.EstrategiaSelecionaInimigos;
import modelo.batalha.Batalha;
import modelo.batalha.Jokenpo.EscolhaJokenpo;
import modelo.fabricaInimigos.FabricaEstrategiaSelecionaInimigos;
import modelo.jogador.Jogador;
import modelo.melhorias.GerenciadorDeMelhorias;
import modelo.personagem.Ataque;
import modelo.personagem.Defesa;
import modelo.personagem.Heroi;
import modelo.personagem.Inimigo;

@SuppressWarnings("serial")
public class FachadaModelo implements Serializable{

	private Batalha batalha;
	private GerenciadorDeMelhorias gerenciadorMelhorias;
	private Jogador jogador;
	private List<Inimigo> listaInimigos;
	private	boolean heroiFoiAtacado;
	private boolean heroiTentouFugir;
	private Serializacao serializacao;

	public FachadaModelo() {
		this.heroiFoiAtacado = false;
		this.heroiTentouFugir = false;
		this.gerenciadorMelhorias = new GerenciadorDeMelhorias();
		this.listaInimigos = new ArrayList<Inimigo>();
		this.serializacao = new Serializacao();
	}
	
	public void InicializaJogador() {
		String historia = "Teve uma vida normal, sempre esforçado e almeja reencontrar seu irmao";
		Ataque ataque = new Ataque(0, 20);
		Defesa defesa = new Defesa(100, 0, 0);
		Heroi heroi = new Heroi("Logan", historia, ataque, defesa, "Logan.png");
		this.jogador = new Jogador(heroi);
	}
	
	public void setLocalInimigos(String classe){
		EstrategiaSelecionaInimigos estrategia = FabricaEstrategiaSelecionaInimigos.getFabricaSelecionaInimigos().retornaEstrategia(classe);
		this.listaInimigos = estrategia.retornaConjuntoInimigos();
	}
	
	public void criaBatalha(int posicaoInimigo) {
		this.batalha = new Batalha(this.jogador.getHeroi(), this.listaInimigos.get(posicaoInimigo));
		this.jogador.adicionaBatalhaAoStatus();
	}
		
	public int getNumInimigosDisponiveis(){
		return this.listaInimigos.size();
	}
	
	public String getNomeInimigo(int posicao){
		return this.listaInimigos.get(posicao).getNome();
	}
	
	public String getToStringHeroi(){
		return this.jogador.getHeroi().toString();
	}
	
	public int getVidaTotalHeroiEmBatalha(){
		return this.batalha.getVidaTotalHeroi();
	}
	
	public int getVidaBatalhaHeroiEmBatalha(){
		return this.batalha.getVidaBatalhaHeroi();
	}
	
	public int getVidaTotalInimigoEmBatalha(){
		return this.batalha.getVidaTotalInimigo();
	}
	
	public int getVidaBatalhaInimigoEmBatalha(){
		return this.batalha.getVidaBatalhaInimigo();		
	}
	
 	public String getToStringInimigoEmBatalha(){
		return this.batalha.getToStringInimigo();
	}
	
	public void simulaGolpeFisicoHeroi() throws ExcecaoDanoBloqueado{
		this.batalha.simulaGolpeFisicoHeroi();
	}
	
	public void simulaGolpeMagicoHeroi() throws ExcecaoDanoBloqueado{
		this.batalha.simulaGolpeMagicoHeroi();
	}
	
	public void simulaGolpeInimigo() throws ExcecaoDanoBloqueado{
		this.batalha.simulaGolpeInimigo();
		this.heroiFoiAtacado = true;
	}
	
	public void tentarFugirBatalha(int caminhoEscolhido){
		this.batalha.tentarFugirBatalha(caminhoEscolhido);
		this.heroiTentouFugir = true;
	}
	
	public boolean heroiFugiuDaBatalha(){
		return this.batalha.heroiFugiuDaBatalha();
	}
	
	public boolean verificaSeHeroiGanhaJokenpo(EscolhaJokenpo escolhaHeroi){
		do{
			batalha.simulaEscolhaInimigo();
			this.batalha.setEscolhasJokenpo(escolhaHeroi, this.batalha.getEscolhaInimigo());
			try {
				if(this.batalha.heroiVenceuJokenpo())
					return true;
				else
					return false;
			} catch (ExcecaoEmpateJokenpo | ExcecaoJokenpoNaoLocalizado e) {
			}
		}while(true);
	}
	
	public EscolhaJokenpo getEscolhaInimigo(){
		return this.batalha.getEscolhaInimigo();
	}

	public void atualizaEstatisticasBatalha(){
		this.batalha.atualizaEstatisticasBatalha(this.heroiFoiAtacado, this.heroiTentouFugir);
		this.heroiFoiAtacado = false;
		this.heroiTentouFugir = false;
	}
	
	public boolean batalhaContinua(){
		if (this.batalha.existeVencedor()) 
			return false;
		else{
			if (this.batalha.heroiFugiuDaBatalha())
				return false;
			else
				return true;
		}
	}
	
	public boolean heroiVenceuBatalha(){
		return this.batalha.heroiVenceuBatalha();
	}

	public String getEstatisticasBatalha(){	
		return this.batalha.getToStringEstatisticasBatalha();
	}
	
	public void finalizaBatalhaComVitoria(){
		this.batalha.atualizaVidaInimigo();
		this.jogador.getHeroi().atualizaVidaBatalha();
		this.jogador.getHeroi().adicionaExperiencia(this.batalha.experienciaGanhaAoGanharBatalha());
		this.jogador.setBatalhaGanha();
		this.batalha.setInimigoPerdeuBatalha();
	}
	
	public void finalizaBatalhaComDerrota(){
		this.batalha.atualizaVidaInimigo();
		this.jogador.getHeroi().atualizaVidaBatalha();
		this.jogador.getHeroi().retiraExperiencia(this.batalha.experienciaPerdidaAoPerderBatalha());
		this.jogador.setBatalhaPerdida();
	}
	
	public void finalizaBatalhaQueSeFugiu(){
		this.batalha.atualizaVidaInimigo();
		this.jogador.getHeroi().atualizaVidaBatalha();
		this.jogador.getHeroi().adicionaExperiencia(this.batalha.experienciaGanhaAoFugirDeBatalha());
		this.jogador.setBatalhaIgnorada();
	}
	
	public String getStatusJogador(){
		return this.jogador.getStatusJogador();
	}
	
	public void atualizaNovosPontos(){
		this.gerenciadorMelhorias.atualizaNovosPontos(this.jogador.getHeroi().getExperiencia());
	}
	
	public int getNumMelhoriasDeVidaTotal(){
		return this.gerenciadorMelhorias.getNumMelhoriasDeVidaTotal();
	}
	
	public int getNumMelhoriasDeAtaqueFisico(){
		return this.gerenciadorMelhorias.getNumMelhoriasDeAtaqueFisico();
	}
	
	public int getNumMelhoriasDeAtaqueMagico(){
		return this.gerenciadorMelhorias.getNumMelhoriasDeAtaqueMagico();
	}
	
	public int getNumMelhoriasDeDefesaFisica(){
		return this.gerenciadorMelhorias.getNumMelhoriasDeDefesaFisica();
	}
	
	public int getNumMelhoriasDeDefesaMagica(){
		return this.gerenciadorMelhorias.getNumMelhoriasDeDefesaFisica();
	}
	
	public int getPontosDeVidaDisponiveis(){
		return this.gerenciadorMelhorias.getPontosDeVidaDisponiveis();
	}
	
	public int getPontosDeAtaqueDisponiveis(){
		return this.gerenciadorMelhorias.getPontosDeAtaqueDisponiveis();
	}
	
	public int getPontosDeDefesaDisponiveis(){
		return this.gerenciadorMelhorias.getPontosDeDefesaDisponiveis();
	}
	
	public void setMelhoriaVida(int posicao) throws ExcecaoMelhoriaNaoDisponivel, ExcecaoSemPontos{
		if (getPontosDeVidaDisponiveis() == 0) {
			throw new ExcecaoSemPontos();
		}else
			this.jogador.getHeroi().adicionaVidaMaxima(this.gerenciadorMelhorias.getMelhoriaVida(posicao));			
	}

	public void setMelhoriaAtaqueFisico(int posicao) throws ExcecaoMelhoriaNaoDisponivel, ExcecaoSemPontos{
		if (getPontosDeAtaqueDisponiveis() == 0) {
			throw new ExcecaoSemPontos();
		}else
			this.jogador.getHeroi().adicionaAtaqueFisico(this.gerenciadorMelhorias.getMelhoriaAtaqueFisico(posicao));
	}

	public void setMelhoriaAtaqueMagico(int posicao) throws ExcecaoMelhoriaNaoDisponivel, ExcecaoSemPontos{
		if (getPontosDeAtaqueDisponiveis() == 0) {
			throw new ExcecaoSemPontos();
		}else
			this.jogador.getHeroi().adicionaAtaqueMagico(this.gerenciadorMelhorias.getMelhoriaAtaqueMagico(posicao));		
	}

	public void setMelhoriaDefesaFisica(int posicao) throws ExcecaoMelhoriaNaoDisponivel, ExcecaoSemPontos{
		if (getPontosDeDefesaDisponiveis() == 0) {
			throw new ExcecaoSemPontos();
		}else
			this.jogador.getHeroi().adicionaResistenciaFisica(this.gerenciadorMelhorias.getMelhoriaDefesaFisica(posicao));		
	}

	public void setMelhoriaDefesaMagica(int posicao) throws ExcecaoMelhoriaNaoDisponivel, ExcecaoSemPontos{
		if (getPontosDeDefesaDisponiveis() == 0) {
			throw new ExcecaoSemPontos();
		}else
			this.jogador.getHeroi().adicionaResistenciaMagica(this.gerenciadorMelhorias.getMelhoriaDefesaMagica(posicao));		
	}

	public void reiniciaPontos(){
		this.gerenciadorMelhorias = new GerenciadorDeMelhorias();
		atualizaNovosPontos();
		this.jogador.getHeroi().setVidaMaxima(100);
		this.jogador.getHeroi().setResistenciaFisica(0);
		this.jogador.getHeroi().setResistenciaMagica(0);
		this.jogador.getHeroi().setAtaqueFisico(20);
		this.jogador.getHeroi().setAtaqueMagico(0);
		this.jogador.getHeroi().atualizaVidaBatalha();
	}

	public int getMelhoriaVida(int posicao){
		return this.gerenciadorMelhorias.getValorMelhoriaVida(posicao);
	}
	
	public int getMelhoriaAtaqueFisico(int posicao){
		return this.gerenciadorMelhorias.getValorMelhoriaAtaqueFisico(posicao);
		
	}

	public int getMelhoriaAtaqueMagico(int posicao){
		return this.gerenciadorMelhorias.getValorMelhoriaAtaqueMagico(posicao);
		
	}
	
	public int getMelhoriaDefesaFisica(int posicao){
		return this.gerenciadorMelhorias.getValorMelhoriaDefesaFisica(posicao);
		
	}
	
	public int getMelhoriaDefesaMagica(int posicao){
		return this.gerenciadorMelhorias.getValorMelhoriaDefesaMagica(posicao);
	}
	
	public String getNomeLocalAtual(){
		return this.jogador.getHeroi().getNomeLocalAtual();
	}
	
	public String getImagemLocal(){
		return this.jogador.getHeroi().getImagemLocalAtual();
	}
	
	public String getHistoriaLocal(){
		return this.jogador.getHeroi().getHistoriaLocal();
	}
	
	public int getNumLocal(){
		return this.jogador.getHeroi().getNumLocal();
	}
	
	public void vaiParaAreaCampo() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.jogador.getHeroi().vaiParaAreaCampo();
	}
	
	public void vaiParaAreaCavernas() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.jogador.getHeroi().vaiParaAreaCavernas();
	}
	
	public void vaiParaAreaFlorestas() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.jogador.getHeroi().vaiParaAreaFlorestas();
	}
	
	public void vaiParaAreaInicioMontanha() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.jogador.getHeroi().vaiParaAreaInicioMontanha();
	}
	
	public void vaiParaAreaNeblina() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.jogador.getHeroi().vaiParaAreaNeblina();
	}

	public void vaiParaAreaPantano() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.jogador.getHeroi().vaiParaAreaPantano();
	}
	
	public void vaiParaAreaPedras() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.jogador.getHeroi().vaiParaAreaPedras();
	}
	
	public void vaiParaAreaPicoMontanhas() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.jogador.getHeroi().vaiParaAreaPicoMontanhas();
	}
	
	public void vaiParaAreaTropical() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.jogador.getHeroi().vaiParaAreaTropical();
	}
	
	public void vaiParaBoss() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		this.jogador.getHeroi().vaiParaAreaBoss();
	}
	
	public void atualizaInimigosNoLocal() throws ExcecaoInimigoNaoEncontrado{
		String classe = this.jogador.getHeroi().getLocalizacao().getClass() + "";
		this.setLocalInimigos(classe);		
	}
	
	
	public void caouzone(){
		
	}

	public void salvaJogo(){
		this.serializacao.salvaArquivo(this);
	}
	
	public FachadaModelo getJogoSalvo(){
		return this.serializacao.carregaDados();
	}
	
	public String getToStringInimigo(int posicao){
		return this.listaInimigos.get(posicao).toString();
	}
	
	public String getImagemInimigo(int posicao){
		return this.listaInimigos.get(posicao).getImagemPersonagem();
	}

	public String getTextoAjuda() {
		return  "Seja bem vindo ao painel de ajuda do jogo.\n"
			+	"-Para lutar contra um inimigo que está no local atual, basta clicar em seu nome no menu Lutar contra;\n"
			+   "-Para ir para outro local do mapa, basta clicar na bandeira em cima dele;\n"
			+   "-Voce sempre vai estar no local que exibir o alfinete azul;\n"
			+ 	"-Para salvar basta clicar no botão salvar;\n"
			+   "-Cada local tem um pedaço da história, que pode ser lido em 'ver historia'\n"
			+ 	"-Sempre que tiver experiencia suficiente para ir para um novo local, tambem é possível aumentar seus atributos através do painel\n"
			+   "'Distribuir Pontos'\n"
			+ 	"\n"
			+ 	"OBS: Só é possivel ir para um lugar caso tenha experiencia suficiente, a qual é indicada ao passar o mouse sobre a bandeira do local;\n"
			+ 	"OBS²: Sempre que iniciar uma nova distribuição de pontos é necessário resetar os pontos.";
	}
	
	public String getTextoPontosDisponiveis(){
		return this.gerenciadorMelhorias.getToStrignPontosDisponiveis();
	}

	public String getImagemInimigoBatalha() {
		return this.batalha.getImagemInimigo();
	}

}