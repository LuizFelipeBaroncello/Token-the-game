package modelo.fabricaInimigos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import interfaces.EstrategiaSelecionaInimigos;

@SuppressWarnings("serial")
public class FabricaEstrategiaSelecionaInimigos implements Serializable {
	
	private Map<String, EstrategiaSelecionaInimigos> mapaEstrategia;
	private static FabricaEstrategiaSelecionaInimigos fabrica;
	
	private FabricaEstrategiaSelecionaInimigos(){
		this.mapaEstrategia = new HashMap<String, EstrategiaSelecionaInimigos>();
		inicializaHashMap();
	}
	
	private void inicializaHashMap() {
		this.mapaEstrategia.put("class modelo.locaisMapa.Tropical", new EstrategiaSelecionaInimigosTropicais());
		this.mapaEstrategia.put("class modelo.locaisMapa.Neblina", new EstrategiaSelecionaInimigosDaNeblina());
		this.mapaEstrategia.put("class modelo.locaisMapa.Pantano", new EstrategiaSelecionaInimigosDoPantano());
		this.mapaEstrategia.put("class modelo.locaisMapa.Cavernas", new EstrategiaSelecionaInimigosDaCaverna());
		this.mapaEstrategia.put("class modelo.locaisMapa.Campo", new EstrategiaSelecionaInimigosDoCampo());
		this.mapaEstrategia.put("class modelo.locaisMapa.Pedras", new EstrategiaSelecionaInimigosDasPedras());
		this.mapaEstrategia.put("class modelo.locaisMapa.Floresta", new EstrategiaSelecionaInimigosDaFloresta());
		this.mapaEstrategia.put("class modelo.locaisMapa.InicioMontanhas", new EstrategiaSelecionaInimigosMontanhaBaixa());
		this.mapaEstrategia.put("class modelo.locaisMapa.PicoMontanhas", new EstrategiaSelecionaInimigosMontanhaAlta());
		this.mapaEstrategia.put("class modelo.locaisMapa.Boss", new EstrategiaSelecionaBoss());
	}

	public EstrategiaSelecionaInimigos retornaEstrategia(String local){
		return this.mapaEstrategia.get(local);
	}
	
	public static FabricaEstrategiaSelecionaInimigos getFabricaSelecionaInimigos(){
		if (fabrica == null)
			fabrica = new FabricaEstrategiaSelecionaInimigos();
		return fabrica;
	}
	
}