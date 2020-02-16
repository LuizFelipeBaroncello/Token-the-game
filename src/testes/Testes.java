package testes;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

import excecoes.ExcecaoMelhoriaNaoDisponivel;
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
import modelo.locaisMapa.Campo;
import modelo.locaisMapa.Cavernas;
import modelo.locaisMapa.Floresta;
import modelo.locaisMapa.InicioMontanhas;
import modelo.locaisMapa.Neblina;
import modelo.locaisMapa.Pantano;
import modelo.locaisMapa.Pedras;
import modelo.locaisMapa.PicoMontanhas;
import modelo.locaisMapa.Tropical;
import modelo.melhorias.DisponibilidadeDePontos;
import modelo.melhorias.GerenciadorDeMelhorias;
import modelo.melhorias.Pontos;
import modelo.personagem.Ataque;
import modelo.personagem.Defesa;
import modelo.personagem.Heroi;
import modelo.personagem.Inimigo;
import modelo.personagem.Personagem;


public class Testes {

	private Heroi heroi;
	private Inimigo inimigo;
	
	@Before
	public void setup(){
		Ataque ataque = new Ataque(0, 20);
		Defesa defesa = new Defesa(100, 0, 0);
		heroi = new Heroi("Joao Neves", "teste", ataque, defesa, "imagem.png");
		inimigo = new Inimigo("Lama viva", "teste", ataque, defesa, "imagem.png", 3, 1);
	}
	
	//++++++++++++++++	Testes de cadastros 	++++++++++++++++\\
	
	@Test
	public void testaCadastroHeroi() throws ExcecaoLocalidade {
		Ataque ataque = new Ataque(0, 20);
		Defesa defesa = new Defesa(100, 0, 0);
		Personagem personagem = new Heroi("Joao Neves", "teste", ataque, defesa, "imagem.png");
		assertEquals("Joao Neves", personagem.getNome());
		assertEquals("teste", personagem.getHistoria());
		assertEquals(20, personagem.getAtaqueFisico());
		assertEquals(0, personagem.getAtaqueMagico());
		assertEquals(100, personagem.getVidaMaxima());
		assertEquals(0, personagem.getResistenciaMagica());
		assertEquals(0, personagem.getResistenciaFisica());
	}
	
	@Test
	public void testaCadastroInimigo() throws ExcecaoLocalidade {
		Ataque ataque = new Ataque(0, 20);
		Defesa defesa = new Defesa(100, 0, 0);
		Personagem personagem = new Inimigo("Lama viva", "teste", ataque, defesa, "imagem.png", 3,1);
		assertEquals("Lama viva", personagem.getNome());
		assertEquals("teste", personagem.getHistoria());
		assertEquals(20, personagem.getAtaqueFisico());
		assertEquals(0, personagem.getAtaqueMagico());
		assertEquals(100, personagem.getVidaMaxima());
		assertEquals(0, personagem.getResistenciaMagica());
		assertEquals(0, personagem.getResistenciaFisica());
		assertEquals("imagem.png", personagem.getImagemPersonagem());
		assertEquals(3, ((Inimigo) personagem).getExperienciaAoDerrotar());
	}
	
	@Test
	public void testaCadastroJogador(){
		Jogador testeJogador = new Jogador(this.heroi);
		assertEquals("Joao Neves", testeJogador.getHeroi().getNome());
	}
	
	//++++++++++++++++	Testes Para Movimentacao pelo mapa	++++++++++++++++\\
	
	@Test
	public void testaCaminhoSeguindoSequencia() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		heroi.adicionaExperiencia(9);
		heroi.vaiParaAreaNeblina();
		assertEquals(Neblina.class, heroi.getLocalizacao().getClass());	
		heroi.adicionaExperiencia(12);
		heroi.vaiParaAreaPantano();
		assertEquals(Pantano.class, heroi.getLocalizacao().getClass());	
		heroi.adicionaExperiencia(15);
		heroi.vaiParaAreaCavernas();
		assertEquals(Cavernas.class, heroi.getLocalizacao().getClass());	
		heroi.adicionaExperiencia(18);
		heroi.vaiParaAreaCampo();
		assertEquals(Campo.class, heroi.getLocalizacao().getClass());	
		heroi.adicionaExperiencia(21);
		heroi.vaiParaAreaPedras();
		assertEquals(Pedras.class, heroi.getLocalizacao().getClass());	
		heroi.adicionaExperiencia(24);
		heroi.vaiParaAreaFlorestas();
		assertEquals(Floresta.class, heroi.getLocalizacao().getClass());	
		heroi.adicionaExperiencia(27);
		heroi.vaiParaAreaInicioMontanha();
		assertEquals(InicioMontanhas.class, heroi.getLocalizacao().getClass());	
		heroi.adicionaExperiencia(30);
		heroi.vaiParaAreaPicoMontanhas();
		assertEquals(PicoMontanhas.class, heroi.getLocalizacao().getClass());	
	}
	
	@Test
	public void tentaVoltarAhUmLocal() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		heroi.adicionaExperiencia(9);
		heroi.vaiParaAreaNeblina();
		assertEquals(Neblina.class, heroi.getLocalizacao().getClass());	
		heroi.vaiParaAreaTropical();
		assertEquals(Tropical.class, heroi.getLocalizacao().getClass());	
	}
	
	@Test(expected = ExcecaoSemExperiencia.class)
	public void tentaIrParaCaminhoSemExperienciaParaOMesmo() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		heroi.vaiParaAreaNeblina();
	}
	
	@Test(expected = ExcecaoLocalidade.class)
	public void tendoExperienciaTentaIrParaLocalLongeNoMapa() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		heroi.adicionaExperiencia(190);
		heroi.vaiParaAreaPantano();
	}
	
	@Test
	public void fazTodosOsCaminhosPossiveisQueAindaNaoForamTestados() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		heroi.adicionaExperiencia(190);
		heroi.vaiParaAreaFlorestas();
		assertEquals(Floresta.class, heroi.getLocalizacao().getClass());	
		heroi.vaiParaAreaPedras();
		assertEquals(Pedras.class, heroi.getLocalizacao().getClass());	
		heroi.vaiParaAreaCampo();
		assertEquals(Campo.class, heroi.getLocalizacao().getClass());	
		heroi.vaiParaAreaTropical();
		assertEquals(Tropical.class, heroi.getLocalizacao().getClass());	
		heroi.vaiParaAreaCavernas();
		assertEquals(Cavernas.class, heroi.getLocalizacao().getClass());	
		heroi.vaiParaAreaPantano();
		assertEquals(Pantano.class, heroi.getLocalizacao().getClass());	
		heroi.vaiParaAreaNeblina();
		assertEquals(Neblina.class, heroi.getLocalizacao().getClass());	
	}
	
	//++++++++++++++++	Testes referentes a Batalhas	++++++++++++++++\\

	@Test
	public void testaSeExisteVencedorComGolpeFraco() throws ExcecaoDanoBloqueado, ExcecaoEmpateJokenpo, ExcecaoJokenpoNaoLocalizado, CloneNotSupportedException{
		Batalha batalha = new Batalha(heroi, inimigo);
		batalha.setEscolhasJokenpo(EscolhaJokenpo.Ataca, EscolhaJokenpo.FingeQueAtaca);
		batalha.simulaGolpeFisicoHeroi();
		assertEquals(false, batalha.existeVencedor());
		assertEquals(false, batalha.heroiVenceuBatalha());
	}
	
	@Test
	public void testaSeExisteVencedorComVariosGolpes() throws ExcecaoDanoBloqueado, ExcecaoEmpateJokenpo, ExcecaoJokenpoNaoLocalizado, CloneNotSupportedException{
		Batalha batalha = new Batalha(heroi, inimigo);
		batalha.setEscolhasJokenpo(EscolhaJokenpo.Ataca, EscolhaJokenpo.FingeQueAtaca);
		batalha.simulaGolpeFisicoHeroi();
		batalha.simulaGolpeFisicoHeroi();
		batalha.simulaGolpeFisicoHeroi();
		batalha.simulaGolpeFisicoHeroi();
		batalha.simulaGolpeFisicoHeroi();
		assertEquals(true, batalha.existeVencedor());
		assertEquals(true, batalha.heroiVenceuBatalha());
	}
	
	@Test
	public void testaTodasPossibilidadesQueDaoVitoriaNoJokenpo() throws ExcecaoEmpateJokenpo, ExcecaoJokenpoNaoLocalizado, CloneNotSupportedException{
		Batalha batalha = new Batalha(heroi, inimigo);
		batalha.setEscolhasJokenpo(EscolhaJokenpo.Ataca, EscolhaJokenpo.FingeQueAtaca);
		assertEquals(true, batalha.heroiVenceuJokenpo());
		batalha.setEscolhasJokenpo(EscolhaJokenpo.Desvia, EscolhaJokenpo.Ataca);
		assertEquals(true, batalha.heroiVenceuJokenpo());
		batalha.setEscolhasJokenpo(EscolhaJokenpo.FingeQueAtaca, EscolhaJokenpo.Desvia);
		assertEquals(true, batalha.heroiVenceuJokenpo());
	}
	
	@Test
	public void testaTodasPossibilidadesQueDaoDerrotaNoJokenpo() throws ExcecaoEmpateJokenpo, ExcecaoJokenpoNaoLocalizado, CloneNotSupportedException{
		Batalha batalha = new Batalha(heroi, inimigo);
		batalha.setEscolhasJokenpo(EscolhaJokenpo.FingeQueAtaca, EscolhaJokenpo.Ataca);
		assertEquals(false, batalha.heroiVenceuJokenpo());
		batalha.setEscolhasJokenpo(EscolhaJokenpo.Ataca, EscolhaJokenpo.Desvia);
		assertEquals(false, batalha.heroiVenceuJokenpo());
		batalha.setEscolhasJokenpo(EscolhaJokenpo.Desvia, EscolhaJokenpo.FingeQueAtaca);
		assertEquals(false, batalha.heroiVenceuJokenpo());
	}
	
	@Test
	public void testaTodasPossibilidadesQueDaoEmpateNoJokenpo() throws ExcecaoJokenpoNaoLocalizado, CloneNotSupportedException {
		Batalha batalha = new Batalha(heroi, inimigo);
		batalha.setEscolhasJokenpo(EscolhaJokenpo.Ataca, EscolhaJokenpo.Ataca);
		try {
			assertEquals(true, batalha.heroiVenceuJokenpo());
			fail();
		} catch (ExcecaoEmpateJokenpo e) {
		} 
		batalha.setEscolhasJokenpo(EscolhaJokenpo.Desvia, EscolhaJokenpo.Desvia);
		try {
			assertEquals(true, batalha.heroiVenceuJokenpo());
			fail();
		} catch (ExcecaoEmpateJokenpo e) {
		}
		batalha.setEscolhasJokenpo(EscolhaJokenpo.FingeQueAtaca, EscolhaJokenpo.FingeQueAtaca);
		try {
			assertEquals(true, batalha.heroiVenceuJokenpo());
			fail();
		} catch (ExcecaoEmpateJokenpo e) {
		}
	}
	
	//++++++++++++++++	Testes referentes a disponibilidade de pontos	++++++++++++++++\\
	
	@Test
	public void verificaSePontosEstaoDisponiveis(){
		DisponibilidadeDePontos disponibilidade = new DisponibilidadeDePontos();
		assertEquals(true, disponibilidade.pontosEstaoDisponiveis(9));
		assertEquals(true, disponibilidade.pontosEstaoDisponiveis(21));
		assertEquals(true, disponibilidade.pontosEstaoDisponiveis(36));
		assertEquals(true, disponibilidade.pontosEstaoDisponiveis(54));
		assertEquals(true, disponibilidade.pontosEstaoDisponiveis(75));
		assertEquals(true, disponibilidade.pontosEstaoDisponiveis(99));
		assertEquals(true, disponibilidade.pontosEstaoDisponiveis(126));
		assertEquals(true, disponibilidade.pontosEstaoDisponiveis(156));
		assertEquals(true, disponibilidade.pontosEstaoDisponiveis(189));
	}
	
	@Test
	public void verificaSePontosDeixamDeFicarDisponiveis(){
		DisponibilidadeDePontos disponibilidade = new DisponibilidadeDePontos();
		disponibilidade.pontosEstaoDisponiveis(9);
		assertEquals(false, disponibilidade.pontosEstaoDisponiveis(9));
		disponibilidade.pontosEstaoDisponiveis(21);
		assertEquals(false, disponibilidade.pontosEstaoDisponiveis(21));
		disponibilidade.pontosEstaoDisponiveis(36);
		assertEquals(false, disponibilidade.pontosEstaoDisponiveis(36));
		disponibilidade.pontosEstaoDisponiveis(54);
		assertEquals(false, disponibilidade.pontosEstaoDisponiveis(54));
		disponibilidade.pontosEstaoDisponiveis(75);
		assertEquals(false, disponibilidade.pontosEstaoDisponiveis(75));
		disponibilidade.pontosEstaoDisponiveis(99);
		assertEquals(false, disponibilidade.pontosEstaoDisponiveis(99));
		disponibilidade.pontosEstaoDisponiveis(126);
		assertEquals(false, disponibilidade.pontosEstaoDisponiveis(126));
		disponibilidade.pontosEstaoDisponiveis(156);
		assertEquals(false, disponibilidade.pontosEstaoDisponiveis(156));
		disponibilidade.pontosEstaoDisponiveis(189);
		assertEquals(false, disponibilidade.pontosEstaoDisponiveis(189));
	}
	
	@Test
	public void verificaSePontosFicamDisponiveisEmExperienciaErrada(){
		DisponibilidadeDePontos disponibilidade = new DisponibilidadeDePontos();
		assertEquals(false, disponibilidade.pontosEstaoDisponiveis(1));
		assertEquals(false, disponibilidade.pontosEstaoDisponiveis(3));
		assertEquals(false, disponibilidade.pontosEstaoDisponiveis(400));	
	}
	
	@Test
	public void verificaSePontosPodemSerSetadosEPegosNormalmente(){
		Pontos pontos = new Pontos();
		pontos.setPontoDeAtaque();
		pontos.setPontoDeAtaque();
		pontos.setPontoDeVida();
		assertEquals(2, pontos.getPontosDeAtaque());
		assertEquals(1, pontos.getPontosDeVida());
		assertEquals(0, pontos.getPontosDeDefesa());
	}
		
	//++++++++++++++++	Testes referentes ao gerenciador de melhorias	++++++++++++++++\\
	
	@Test
	public void verificaSeOsPontosEMelhoriasSeIniciamIndisponiveis(){
		GerenciadorDeMelhorias melhorias = new GerenciadorDeMelhorias();
		try {
			melhorias.getMelhoriaVida(0);
			fail();
		} catch (ExcecaoMelhoriaNaoDisponivel e) {
		}
		try {
			melhorias.getMelhoriaAtaqueFisico(0);
			fail();
		} catch (ExcecaoMelhoriaNaoDisponivel e) {
		}
		try {
			melhorias.getMelhoriaAtaqueMagico(0);
			fail();
		} catch (ExcecaoMelhoriaNaoDisponivel e) {
		}
		try {
			melhorias.getMelhoriaDefesaFisica(0);
			fail();
		} catch (ExcecaoMelhoriaNaoDisponivel e) {
		}
		try {
			melhorias.getMelhoriaDefesaMagica(0);
			fail();
		} catch (ExcecaoMelhoriaNaoDisponivel e) {
		}
		assertEquals(0, melhorias.getPontosDeVidaDisponiveis());
		assertEquals(0, melhorias.getPontosDeAtaqueDisponiveis());
		assertEquals(0, melhorias.getPontosDeDefesaDisponiveis());	
	}
	
	@Test
	public void verificaSeExistemNoveMelhoriasDeCada(){
		GerenciadorDeMelhorias melhorias = new GerenciadorDeMelhorias();
		
		assertEquals(9, melhorias.getNumMelhoriasDeVidaTotal());
		assertEquals(9, melhorias.getNumMelhoriasDeAtaqueFisico());
		assertEquals(9, melhorias.getNumMelhoriasDeAtaqueMagico());
		assertEquals(9, melhorias.getNumMelhoriasDeDefesaFisica());
		assertEquals(9, melhorias.getNumMelhoriasDeDefesaMagica());
	}
	
	@Test
	public void verificaSeComNoveDeExperieciaLiberaMelhorias() throws ExcecaoMelhoriaNaoDisponivel{
		GerenciadorDeMelhorias melhorias = new GerenciadorDeMelhorias();
		
		melhorias.atualizaNovosPontos(22);
		assertEquals(2, melhorias.getPontosDeVidaDisponiveis());
		assertEquals(2, melhorias.getPontosDeAtaqueDisponiveis());
		assertEquals(2, melhorias.getPontosDeDefesaDisponiveis());
		
		assertEquals(50, melhorias.getMelhoriaVida(0));
		assertEquals(25, melhorias.getMelhoriaAtaqueFisico(0));
		assertEquals(50, melhorias.getMelhoriaAtaqueMagico(0));
		assertEquals(10, melhorias.getMelhoriaDefesaFisica(0));
		assertEquals(20, melhorias.getMelhoriaDefesaMagica(0));
		
		assertEquals(1, melhorias.getPontosDeVidaDisponiveis());
		assertEquals(0, melhorias.getPontosDeAtaqueDisponiveis());
		assertEquals(0, melhorias.getPontosDeDefesaDisponiveis());
	}
	
	@Test
	public void verificaSeAoReiniciarMelhoriasElasFicamDisponiveis() throws ExcecaoMelhoriaNaoDisponivel{
		GerenciadorDeMelhorias melhorias = new GerenciadorDeMelhorias();
		
		melhorias.atualizaNovosPontos(22);
		melhorias.getMelhoriaVida(0);
		melhorias.getMelhoriaVida(1);
		melhorias.getMelhoriaAtaqueFisico(0);
		melhorias.getMelhoriaAtaqueMagico(0);
		melhorias.getMelhoriaDefesaFisica(0);
		melhorias.getMelhoriaDefesaMagica(0);
		try {
			melhorias.getMelhoriaVida(0);
			fail();
		} catch (ExcecaoMelhoriaNaoDisponivel e) {
		}
		melhorias = new GerenciadorDeMelhorias();
		melhorias.atualizaNovosPontos(22);
		melhorias.getMelhoriaVida(0);
		assertEquals(1, melhorias.getPontosDeVidaDisponiveis());
	}
	
	//++++++++++++++++	Testes referentes a fabrica de inimigos	++++++++++++++++\\
	
	@Test
	public void verificaSeFabricaRetornaInimigosTropicais(){
		EstrategiaSelecionaInimigos estrategia = FabricaEstrategiaSelecionaInimigos.getFabricaSelecionaInimigos().retornaEstrategia("class modelo.locaisMapa.Tropical");
		List<Inimigo> inimigos = estrategia.retornaConjuntoInimigos();
		assertEquals("Bufalo Tucano", inimigos.get(0).getNome());
		assertEquals("Urso Humanoide", inimigos.get(1).getNome() );
		assertEquals("Tigre Gigante", inimigos.get(2).getNome() );
	}
	
	@Test
	public void verificaSeFabricaRetornaInimigosDaNeblina(){
		EstrategiaSelecionaInimigos estrategia = FabricaEstrategiaSelecionaInimigos.getFabricaSelecionaInimigos().retornaEstrategia("class modelo.locaisMapa.Neblina");
		List<Inimigo> inimigos = estrategia.retornaConjuntoInimigos();
		assertEquals("Fantasma Humido", inimigos.get(0).getNome());
		assertEquals("Cobra Modificada", inimigos.get(1).getNome() );
		assertEquals("Inseto Gigante", inimigos.get(2).getNome() );
	}
	
	
}