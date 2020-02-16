package modelo.batalha;

import java.io.Serializable;

import excecoes.batalha.ExcecaoDanoBloqueado;
import excecoes.batalha.ExcecaoEmpateJokenpo;
import excecoes.batalha.ExcecaoJokenpoNaoLocalizado;
import modelo.batalha.Jokenpo.EscolhaJokenpo;
import modelo.personagem.Heroi;
import modelo.personagem.Inimigo;

@SuppressWarnings("serial")
public class Batalha implements Serializable{

	private Jokenpo jokenpo;
	private EscolhaJokenpo escolhaHeroi;
	private EscolhaInimigo escolhaInimigo;
	private SimuladorDeGolpe simuladorDeGolpe;
	private Heroi heroi;
	private Inimigo inimigo;
	private FugaBatalha fugaBatalha;
	private EstatisticasBatalha estatisticasBatalha;
	
	public Batalha(Heroi heroi, Inimigo inimigo) {
		this.heroi = heroi;
		this.jokenpo = new Jokenpo();
		this.inimigo = inimigo;
		this.fugaBatalha = new FugaBatalha();
		this.estatisticasBatalha = new EstatisticasBatalha();
	}
	
	public void simulaEscolhaInimigo(){
		this.escolhaInimigo = new EscolhaInimigo();
	}
	
	public EscolhaJokenpo getEscolhaInimigo(){
		return  escolhaInimigo.getEscolhaInimigo();
	}
	
	public void setEscolhasJokenpo(EscolhaJokenpo escolhaHeroi, EscolhaJokenpo escolhaInimigo){
		this.jokenpo.setEscolhas(escolhaHeroi, escolhaInimigo);
		this.escolhaHeroi = escolhaHeroi;
	}
	
	public EscolhaJokenpo getEscolhaHeroi() {
		return escolhaHeroi;
	}

	public boolean heroiVenceuJokenpo() throws ExcecaoEmpateJokenpo, ExcecaoJokenpoNaoLocalizado{
		return this.jokenpo.heroiVenceu();
	}
	
	public void simulaGolpeInimigo() throws ExcecaoDanoBloqueado{
		if (inimigo.getAtaqueFisico() > inimigo.getAtaqueMagico()){
			this.simuladorDeGolpe = new SimuladorDeGolpeFisico();
			this.simuladorDeGolpe.simulaGolpe(this.inimigo, this.heroi);	
		}else{
			this.simuladorDeGolpe = new SimuladorDeGolpeMagico();
			this.simuladorDeGolpe.simulaGolpe(this.inimigo, this.heroi);
		}
	}
	
 	public void simulaGolpeFisicoHeroi() throws ExcecaoDanoBloqueado {
		this.simuladorDeGolpe = new SimuladorDeGolpeFisico();
		this.simuladorDeGolpe.simulaGolpe(this.heroi, this.inimigo);			
	}

	public void simulaGolpeMagicoHeroi() throws ExcecaoDanoBloqueado {	
		this.simuladorDeGolpe = new SimuladorDeGolpeMagico();
		this.simuladorDeGolpe.simulaGolpe(this.heroi, this.inimigo);	
	}

	public boolean existeVencedor(){
		if (this.heroi.getVidaBatalha() == 0){
			return true;
		}else 
			if (this.inimigo.getVidaBatalha() == 0) 
				return true;
			else
				return false;
	}
	
	public boolean heroiVenceuBatalha(){
		return this.inimigo.getVidaBatalha() == 0;
	}
	
	public void tentarFugirBatalha(int caminhoEscolhido){
		this.fugaBatalha.setEscolhaPortaJogador(caminhoEscolhido);
	}
	
	public boolean heroiFugiuDaBatalha(){
		return this.fugaBatalha.heroiFugiuBatalha();
	}
	
	public void atualizaEstatisticasBatalha(boolean heroiFoiAtacado, boolean heroiTentouFugir){
		this.estatisticasBatalha.atualizaEstatisticasBatalha(heroiFoiAtacado, heroiTentouFugir);
	}
	
	public String getToStringEstatisticasBatalha(){
		return this.estatisticasBatalha.toString();
	}
	
	public int experienciaGanhaAoGanharBatalha(){
		return this.inimigo.getExperienciaAoDerrotar();
	}
	
	public int experienciaPerdidaAoPerderBatalha(){
		return this.inimigo.getExperienciaQueRetiraAoGanhar();
	}
	
	public int experienciaGanhaAoFugirDeBatalha(){
		return 1;
	}

	public String getToStringInimigo(){
		return this.inimigo.toString();
	}
	
	public void atualizaVidaInimigo(){
		this.inimigo.atualizaVidaBatalha();
	}
	
	public int getVidaTotalHeroi(){
		return this.heroi.getVidaMaxima();
	}
	
	public int getVidaBatalhaHeroi(){
		return this.heroi.getVidaBatalha();
	}
	
	public int getVidaTotalInimigo(){
		return this.inimigo.getVidaMaxima();
	}
	
	public int getVidaBatalhaInimigo(){
		return this.inimigo.getVidaBatalha();
	}
	
	public void setInimigoPerdeuBatalha(){
		this.inimigo.setBatalhaPerdida();
	}

	public String getImagemInimigo() {
		return this.inimigo.getImagemPersonagem();
	}
	
}