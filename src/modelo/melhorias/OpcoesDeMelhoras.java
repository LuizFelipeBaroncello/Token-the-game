package modelo.melhorias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import excecoes.ExcecaoMelhoriaNaoDisponivel;

@SuppressWarnings("serial")
public class OpcoesDeMelhoras implements Serializable{

	private List<Melhora> melhorasDeVidaTotal;
	private List<Melhora> melhorasDeAtaqueFisico;
	private List<Melhora> melhorasDeAtaqueMagico;
	private List<Melhora> melhorasDeDefesaFisica;
	private List<Melhora> melhorasDeDefesaMagica;

	public OpcoesDeMelhoras() {
		inicializaMelhorasDeVidaTotal();
		inicializaMelhorasDeAtaqueFisico();
		inicializaMelhorasDeAtaqueMagico();
		inicializaMelhorasDeDefesaFisica();
		inicializaMelhorasDeDefesaMagica();
	}

	private void inicializaMelhorasDeVidaTotal() {
		this.melhorasDeVidaTotal = new ArrayList<>();
		List<Integer> valoresMelhoras = new ArrayList<>(Arrays.asList(50, 50, 50, 50, 50, 50, 50, 50, 50));
		for (int i = 0; i < valoresMelhoras.size(); i++) {
			this.melhorasDeVidaTotal.add(new MelhoraDeVidaTotal(valoresMelhoras.get(i)));
		}
	}

	private void inicializaMelhorasDeAtaqueFisico() {
		this.melhorasDeAtaqueFisico = new ArrayList<>();
		List<Integer> valoresMelhoras = new ArrayList<>(Arrays.asList(25, 65, 65, 65, 90, 90, 100, 100, 210));
		for (int i = 0; i < valoresMelhoras.size(); i++) {
			this.melhorasDeAtaqueFisico.add(new MelhoraDeAtaqueFisico(valoresMelhoras.get(i)));
		}
	}

	private void inicializaMelhorasDeAtaqueMagico() {
		this.melhorasDeAtaqueMagico = new ArrayList<>();
		List<Integer> valoresMelhoras = new ArrayList<>(Arrays.asList(50, 50, 50, 50, 100, 100, 150, 150, 200));
		for (int i = 0; i < valoresMelhoras.size(); i++) {
			this.melhorasDeAtaqueMagico.add(new MelhoraDeAtaqueMagico(valoresMelhoras.get(i)));
		}
	}

	private void inicializaMelhorasDeDefesaFisica() {
		this.melhorasDeDefesaFisica = new ArrayList<>();
		List<Integer> valoresMelhoras = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 45, 45, 55, 70, 85));
		for (int i = 0; i < valoresMelhoras.size(); i++) {
			this.melhorasDeDefesaFisica.add(new MelhoraDeDefesaFisica(valoresMelhoras.get(i)));
		}
	}

	private void inicializaMelhorasDeDefesaMagica() {
		this.melhorasDeDefesaMagica = new ArrayList<>();
		List<Integer> valoresMelhoras = new ArrayList<>(Arrays.asList(20, 20, 30, 30, 55, 55, 90, 90, 110));
		for (int i = 0; i < valoresMelhoras.size(); i++) {
			this.melhorasDeDefesaMagica.add(new MelhoraDeDefesaMagica(valoresMelhoras.get(i)));
		}
	}

	public int getNumMelhoriasDeVidaTotal() {
		return this.melhorasDeVidaTotal.size();
	}

	public int getMelhoriaDeVidaTotal(int posicao) throws ExcecaoMelhoriaNaoDisponivel {
		if (this.melhorasDeVidaTotal.get(posicao).isMelhoraDisponivel()) {
			this.melhorasDeVidaTotal.get(posicao).setMelhoraDisponivel(false);
			return  this.melhorasDeVidaTotal.get(posicao).getMelhora();
		}else
			throw new ExcecaoMelhoriaNaoDisponivel();
	}
	
	public void setMelhoraVidaTotalDisponivel(int posicao){
		this.melhorasDeVidaTotal.get(posicao).setMelhoraDisponivel(true);
	}
	
	public int getNumMelhoriasDeAtaqueFisico() {
		return this.melhorasDeAtaqueFisico.size();
	}

	public int getMelhoriaDeAtaqueFisico(int posicao) throws ExcecaoMelhoriaNaoDisponivel {
		if (this.melhorasDeAtaqueFisico.get(posicao).isMelhoraDisponivel()) {
			this.melhorasDeAtaqueFisico.get(posicao).setMelhoraDisponivel(false);
			return this.melhorasDeAtaqueFisico.get(posicao).getMelhora();
		}else
			throw new ExcecaoMelhoriaNaoDisponivel();
	}

	public void setMelhoraAtaqueFisicoDisponivel(int posicao){
		this.melhorasDeAtaqueFisico.get(posicao).setMelhoraDisponivel(true);
	}
	
	public int getNumMelhoriasDeAtaqueMagico() {
		return this.melhorasDeAtaqueMagico.size();
	}

	public int getMelhoriaDeAtaqueMagico(int posicao) throws ExcecaoMelhoriaNaoDisponivel {
		if (this.melhorasDeAtaqueMagico.get(posicao).isMelhoraDisponivel()) {
			this.melhorasDeAtaqueMagico.get(posicao).setMelhoraDisponivel(false);
			return this.melhorasDeAtaqueMagico.get(posicao).getMelhora();
		}else
			throw new ExcecaoMelhoriaNaoDisponivel();
	}
	
	public void setMelhoraAtaqueMagicoDisponivel(int posicao){
		this.melhorasDeAtaqueMagico.get(posicao).setMelhoraDisponivel(true);
	}
	
	public int getNumMelhoriasDeDefesaFisica(){
		return this.melhorasDeDefesaFisica.size();
	}
	
	public int getMelhoriaDeDefesaFisica(int posicao) throws ExcecaoMelhoriaNaoDisponivel{
		if (this.melhorasDeDefesaFisica.get(posicao).isMelhoraDisponivel()) {
			this.melhorasDeDefesaFisica.get(posicao).setMelhoraDisponivel(false);
			return this.melhorasDeDefesaFisica.get(posicao).getMelhora();
		}else
			throw new ExcecaoMelhoriaNaoDisponivel();
	}

	public void setMelhoraDefesaFisicaDisponivel(int posicao){
		this.melhorasDeDefesaFisica.get(posicao).setMelhoraDisponivel(true);
	}
	
	public int getNumMelhoriasDeDefesaMagica(){
		return this.melhorasDeDefesaMagica.size();
	}
	
	public int getMelhoriaDeDefesaMagica(int posicao) throws ExcecaoMelhoriaNaoDisponivel{
		if (this.melhorasDeDefesaMagica.get(posicao).isMelhoraDisponivel()) {
			this.melhorasDeDefesaMagica.get(posicao).setMelhoraDisponivel(false);
			return this.melhorasDeDefesaMagica.get(posicao).getMelhora();
		}else
			throw new ExcecaoMelhoriaNaoDisponivel();
	}
	
	public void setMelhoraDefesaMagicaDisponivel(int posicao){
		this.melhorasDeDefesaMagica.get(posicao).setMelhoraDisponivel(true);
	}
	
	public int getValorMelhoriaVida(int posicao){
		return this.melhorasDeVidaTotal.get(posicao).getMelhora();
	}
	
	public int getValorMelhoriaAtaqueFisico(int posicao){
		return this.melhorasDeAtaqueFisico.get(posicao).getMelhora();
	}
	
	public int getValorMelhoriaAtaqueMagico(int posicao){
		return this.melhorasDeAtaqueMagico.get(posicao).getMelhora();
	}
	
	public int getValorMelhoriaDefesaFisica(int posicao){
		return this.melhorasDeDefesaFisica.get(posicao).getMelhora();
	}
	
	public int getValorMelhoriaDefesaMagica(int posicao){
		return this.melhorasDeDefesaMagica.get(posicao).getMelhora();
	}
	
}