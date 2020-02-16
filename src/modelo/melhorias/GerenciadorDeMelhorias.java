package modelo.melhorias;

import java.io.Serializable;

import excecoes.ExcecaoMelhoriaNaoDisponivel;

@SuppressWarnings("serial")
public class GerenciadorDeMelhorias implements Serializable{

	private Pontos pontos;
	private DisponibilidadeDePontos disponibilidadeDePontos;
	private OpcoesDeMelhoras opcoesDeMelhoras;

	public GerenciadorDeMelhorias() {
		this.pontos = new Pontos();
		this.disponibilidadeDePontos = new DisponibilidadeDePontos();
		this.opcoesDeMelhoras = new OpcoesDeMelhoras();
	}

	public void atualizaNovosPontos(int experienciaAtual) {
		for (int i = 0; i < experienciaAtual + 1; i++) {
			if (this.disponibilidadeDePontos.pontosEstaoDisponiveis(i)) {
				this.pontos.setPontoDeAtaque();
				this.pontos.setPontoDeDefesa();
				this.pontos.setPontoDeVida();
			}
		}
		atualizaNovasMelhorias();
	}

	private void atualizaNovasMelhorias() {
		atualizaMelhoriasVidaTotal();
		atualizaMelhoriasAtaqueMagicoEFisico();
		atualizaMelhoriasDefesaMagicaEFisica();
	}

	private void atualizaMelhoriasDefesaMagicaEFisica() {
		for (int i = 0; i < this.pontos.getPontosDeDefesa(); i++) {
			this.opcoesDeMelhoras.setMelhoraDefesaFisicaDisponivel(i);
			this.opcoesDeMelhoras.setMelhoraDefesaMagicaDisponivel(i);
		}
	}

	private void atualizaMelhoriasAtaqueMagicoEFisico() {
		for (int i = 0; i < this.pontos.getPontosDeAtaque(); i++) {
			this.opcoesDeMelhoras.setMelhoraAtaqueFisicoDisponivel(i);
			this.opcoesDeMelhoras.setMelhoraAtaqueMagicoDisponivel(i);			
		}
	}

	private void atualizaMelhoriasVidaTotal() {
		for (int i = 0; i < this.pontos.getPontosDeVida(); i++) {
			this.opcoesDeMelhoras.setMelhoraVidaTotalDisponivel(i);			
		}
	}

	public int getPontosDeVidaDisponiveis() {
		return this.pontos.getPontosDeVida();
	}

	public int getPontosDeAtaqueDisponiveis() {
		return this.pontos.getPontosDeAtaque();
	}

	public int getPontosDeDefesaDisponiveis() {
		return this.pontos.getPontosDeDefesa();
	}

	public void descontaPontoDeVida() {
		this.pontos.descontaPontoDeVida();
	}

	public void descontaPontoDeAtaque() {
		this.pontos.descontaPontoDeAtaque();
	}

	public void descontaPontoDeDefesa() {
		this.pontos.descontaPontoDeDefesa();
	}

	public int getNumMelhoriasDeVidaTotal() {
		return opcoesDeMelhoras.getNumMelhoriasDeVidaTotal();
	}

	public int getNumMelhoriasDeAtaqueFisico() {
		return opcoesDeMelhoras.getNumMelhoriasDeAtaqueFisico();
	}

	public int getNumMelhoriasDeAtaqueMagico() {
		return opcoesDeMelhoras.getNumMelhoriasDeAtaqueMagico();
	}
	
	public int getNumMelhoriasDeDefesaFisica() {
		return opcoesDeMelhoras.getNumMelhoriasDeDefesaFisica();
	}
	
	public int getNumMelhoriasDeDefesaMagica() {
		return opcoesDeMelhoras.getNumMelhoriasDeDefesaMagica();
	}
	
	public int getMelhoriaVida(int posicao) throws ExcecaoMelhoriaNaoDisponivel{
		int valorMelhoria = opcoesDeMelhoras.getMelhoriaDeVidaTotal(posicao);
		pontos.descontaPontoDeVida();
		return valorMelhoria;
	}
	
	public int getMelhoriaAtaqueFisico(int posicao) throws ExcecaoMelhoriaNaoDisponivel{
		int valorMelhoria = opcoesDeMelhoras.getMelhoriaDeAtaqueFisico(posicao);
		pontos.descontaPontoDeAtaque();
		return valorMelhoria;
	}
	
	public int getMelhoriaAtaqueMagico(int posicao) throws ExcecaoMelhoriaNaoDisponivel{
		int valorMelhoria = opcoesDeMelhoras.getMelhoriaDeAtaqueMagico(posicao);
		pontos.descontaPontoDeAtaque();
		return valorMelhoria;
	}
	
	public int getMelhoriaDefesaFisica(int posicao) throws ExcecaoMelhoriaNaoDisponivel{
		int valorMelhoria = opcoesDeMelhoras.getMelhoriaDeDefesaFisica(posicao);
		pontos.descontaPontoDeDefesa();
		return valorMelhoria;
	}
	
	public int getMelhoriaDefesaMagica(int posicao) throws ExcecaoMelhoriaNaoDisponivel{
		int valorMelhoria = opcoesDeMelhoras.getMelhoriaDeDefesaMagica(posicao);
		pontos.descontaPontoDeDefesa();
		return valorMelhoria;
	}
	
	public int getValorMelhoriaVida(int posicao){
		return this.opcoesDeMelhoras.getValorMelhoriaVida(posicao);
	}
	
	public int getValorMelhoriaAtaqueFisico(int posicao){
		return this.opcoesDeMelhoras.getValorMelhoriaAtaqueFisico(posicao);
	}
	
	public int getValorMelhoriaAtaqueMagico(int posicao){
		return this.opcoesDeMelhoras.getValorMelhoriaAtaqueMagico(posicao);
	}
	
	public int getValorMelhoriaDefesaFisica(int posicao){
		return this.opcoesDeMelhoras.getValorMelhoriaDefesaFisica(posicao);
	}
	
	public int getValorMelhoriaDefesaMagica(int posicao){
		return this.opcoesDeMelhoras.getValorMelhoriaDefesaMagica(posicao);
	}
	
	public String getToStrignPontosDisponiveis(){
		return    "<html> Pts Disponiveis<br>"
				+ "Pts de vida: " + this.getPontosDeVidaDisponiveis() + "<br>"
				+ "Pts de ataque: " + this.getPontosDeAtaqueDisponiveis() + "<br>"
				+ "Pts de defesa: " + this.getPontosDeDefesaDisponiveis() + "<br>";
	}
	
}