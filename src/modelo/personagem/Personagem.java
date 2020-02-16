package modelo.personagem;

import java.io.Serializable;

import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoSemExperiencia;
import interfaces.Localizacao;

@SuppressWarnings("serial")
public abstract class Personagem implements Serializable{

	private String nome;
	private String historia;
	private Ataque ataque;
	private Defesa defesa;
	private Localizacao localizacao;
	private int experiencia;
	private String imagemPersonagem;

	public Personagem(String nome, String historia, Ataque ataque, Defesa defesa, String imagemPersonagem) {
		this.nome = nome;
		this.historia = historia;
		this.ataque = ataque;
		this.defesa = defesa;
		this.experiencia = 0;
		this.imagemPersonagem = imagemPersonagem;
	}
	
	public String getImagemPersonagem() {
		return imagemPersonagem;
	}

	public void adicionaExperiencia(int experiencia) {
		this.experiencia += experiencia;
	}
	
	public void retiraExperiencia(int experiencia){
		this.experiencia -= experiencia;
	}
	
	public int getExperiencia() {
		return this.experiencia;
	}

	public void setLocalizacao(Localizacao localizacao){
		this.localizacao = localizacao;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public String getNome() {
		return nome;
	}

	public String getHistoria() {
		return historia;
	}
	
	public void alteraLocalizacao(Localizacao localizacao){
		this.localizacao = localizacao;
	}
	
	public void vaiParaAreaCampo() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.localizacao.zonaComCampos();
	}
	
	public void vaiParaAreaCavernas() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.localizacao.zonaComCavernas();
	}
	
	public void vaiParaAreaFlorestas() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.localizacao.zonaComFlorestas();
	}
	
	public void vaiParaAreaInicioMontanha() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.localizacao.zonaInicioMontanha();
	}
	
	public void vaiParaAreaNeblina() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.localizacao.zonaComNeblina();
	}

	public void vaiParaAreaPantano() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.localizacao.zonaComPantano();
	}
	
	public void vaiParaAreaBoss() throws ExcecaoLocalidade, ExcecaoSemExperiencia {
		this.localizacao.zonaBoss();
	}
	
	public void vaiParaAreaPedras() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.localizacao.zonaComPedras();
	}
	
	public void vaiParaAreaPicoMontanhas() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.localizacao.zonaPicoMontanha();
	}
	
	public void vaiParaAreaTropical() throws ExcecaoLocalidade, ExcecaoSemExperiencia{
		this.localizacao.zonaTropical();
	}
	
	public void adicionaResistenciaMagica(int resistenciaMagica){
		this.defesa.adicionaResistenciaMagica(resistenciaMagica);
	}
	
	public void setResistenciaMagica(int resistenciaMagica){
		this.defesa.setResistenciaMagica(resistenciaMagica);
	}
	
	public void adicionaResistenciaFisica(int resistenciaFisica){
		this.defesa.adicionaResistenciaFisica(resistenciaFisica);
	}
	
	public void setResistenciaFisica(int resistenciaFisica){
		this.defesa.setResistenciaFisica(resistenciaFisica);
	}

	public void adicionaVidaMaxima(int vida){
		this.defesa.adicionaVida(vida);
		this.atualizaVidaBatalha();
	}
	
	public void setVidaMaxima(int vida){
		this.defesa.setVidaMaxima(vida);
	}
	
	public int getVidaMaxima(){
		return this.defesa.getVidaMaxima();
	}
	
	public void atualizaVidaBatalha(){
		this.defesa.atualizaVidaBatalha();
	}
	
	public void retiraVidaBatalha(int vida){
		this.defesa.retiraVidaBatalha(vida);
	}
	
	public int getVidaBatalha(){
		return this.defesa.getVidaBatalha();
	}
	
	public int getResistenciaMagica(){
		return this.defesa.getResistenciaMagica();
	}
	
	public int getResistenciaFisica(){
		return this.defesa.getResistenciaFisica();
	}

	public int getAtaqueMagico(){
		return this.ataque.getAtaqueMagico();
	}
	
	public int getAtaqueFisico(){
		return this.ataque.getAtaqueFisico();
	}
	
	public void setAtaqueMagico(int ataqueMagico){
		this.ataque.setAtaqueMagico(ataqueMagico);
	}
	
	public void setAtaqueFisico(int ataqueFisico){
		this.ataque.setAtaqueFisico(ataqueFisico);
	}
	
	public void adicionaAtaqueMagico(int ataqueMagico){
		this.ataque.adicionaAtaqueMagico(ataqueMagico);
	}
	
	public void adicionaAtaqueFisico(int ataqueFisico){
		this.ataque.adicionaAtaqueFisico(ataqueFisico);
	}
	
	public String getNomeLocalAtual(){
		return this.localizacao.getNomeLocal();
	}
	
	public String getImagemLocalAtual(){
		return this.localizacao.getImagemLocal();
	}
	
	public String getHistoriaLocal(){
		return this.localizacao.getHistoriaLocal();
	}
	
	public int getNumLocal(){
		return this.localizacao.getNumLocal();
	}
	
}