package modelo.melhorias;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class DisponibilidadeDePontos implements Serializable{

	private Map<Integer, Boolean> mapaPontosDisponiveis;

	public DisponibilidadeDePontos() {
		this.mapaPontosDisponiveis = new HashMap<Integer, Boolean>();
		inicializaMapaPontosDisponiveis();
	}
	
	private void inicializaMapaPontosDisponiveis() {
		this.mapaPontosDisponiveis.put(9, true);
		this.mapaPontosDisponiveis.put(21, true);
		this.mapaPontosDisponiveis.put(36, true);
		this.mapaPontosDisponiveis.put(54, true);
		this.mapaPontosDisponiveis.put(75, true);
		this.mapaPontosDisponiveis.put(99, true);
		this.mapaPontosDisponiveis.put(126, true);
		this.mapaPontosDisponiveis.put(156, true);
		this.mapaPontosDisponiveis.put(189, true);
		
	}

	public boolean pontosEstaoDisponiveis(int experienciaAtual){
		boolean variavelDeRetorno;
		if(mapaPontosDisponiveis.get(experienciaAtual) != null){
			variavelDeRetorno = mapaPontosDisponiveis.get(experienciaAtual);
			mapaPontosDisponiveis.put(experienciaAtual, false);
			return variavelDeRetorno;
		}else
			return false;
	}
	
}