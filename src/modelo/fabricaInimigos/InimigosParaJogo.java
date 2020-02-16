package modelo.fabricaInimigos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.personagem.Ataque;
import modelo.personagem.Defesa;
import modelo.personagem.Inimigo;

@SuppressWarnings("serial")
public class InimigosParaJogo implements Serializable {
	
	private static InimigosParaJogo inimigos;
	private Map<String, List<Inimigo>> mapaInimigos ;
	
	private InimigosParaJogo(){
		mapaInimigos = new HashMap<String, List<Inimigo>>();
		preencheMapa();
	}
	
	public static InimigosParaJogo getInimigosParaJogo(){
		if (inimigos == null)
			 inimigos = new InimigosParaJogo();
		return inimigos;
	}
	
	@SuppressWarnings("static-access")
	public void setInimigos(InimigosParaJogo inimigos){
		this.inimigos = inimigos;
	}

	private void preencheMapa() {
		List<Inimigo> conjuntoInimigos;
		Ataque ataque;
		Defesa defesa;
		Inimigo inimigo;
		int experienciaAoDerrotar;
		int experienciaRetiradaAoPerder;
		
		//==================Inimigos Area Tropical==================\\
		
		conjuntoInimigos = new ArrayList<Inimigo>();

		experienciaRetiradaAoPerder = 1;
		experienciaAoDerrotar = 3;
		ataque = new Ataque(0, 10);//magico, fisico
		defesa = new Defesa(150, 5, 0);//vida, fisica, magica
		inimigo = new Inimigo("Bufalo Tucano", "Criatura muito inquieta, ataca para se defender.", ataque, defesa, "BufaloTucano.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 1;
		experienciaAoDerrotar = 3;
		ataque = new Ataque(0, 20);
		defesa = new Defesa(85, 0, 40);
		inimigo = new Inimigo("Urso Humanoide", "Mais esperto que um urso normal e bipede, certamente estranho.", ataque, defesa, "UrsoHumanoide.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 1;
		experienciaAoDerrotar = 3;
		ataque = new Ataque(0, 45);
		defesa = new Defesa(50, 0, 0);
		inimigo = new Inimigo("Tigre Gigante", "Definitivamente a pior criatura ja encontrada por essa regiao.", ataque, defesa, "TigreGigante.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);
		
		mapaInimigos.put("class modelo.locaisMapa.Tropical", conjuntoInimigos);
		
		//==================Inimigos Area Nebulosa==================\\
		
		conjuntoInimigos = new ArrayList<Inimigo>();

		experienciaRetiradaAoPerder = 2;
		experienciaAoDerrotar = 4;
		ataque = new Ataque(50, 2);
		defesa = new Defesa(45, 100, 20);
		inimigo = new Inimigo("Fantasma Humido", "Pode facilmente ser confundido com a neblina local.", ataque, defesa, "FantasmaHumido.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 2;
		experienciaAoDerrotar = 4;
		ataque = new Ataque(30, 30);
		defesa = new Defesa(70, 10, 40);
		inimigo = new Inimigo("Cobra Modificada", "Uma cobra que certamente passou por testes em laboratório.", ataque, defesa, "CobraModificada.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 2;
		experienciaAoDerrotar = 4;
		ataque = new Ataque(0, 40);
		defesa = new Defesa(200, 10, 10);
		inimigo = new Inimigo("Inseto Gigante", "Aparentemente o clima humido e a falta de predadores favorece os insetos.", ataque, defesa, "InsetoGigante.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);
		
		mapaInimigos.put("class modelo.locaisMapa.Neblina", conjuntoInimigos);

		//==================Inimigos Area Pantano==================\\
		
		conjuntoInimigos = new ArrayList<Inimigo>();

		experienciaRetiradaAoPerder = 2;
		experienciaAoDerrotar = 5;
		ataque = new Ataque(0, 108);//magico, fisico
		defesa = new Defesa(300, 30, 0);//vida, fisica, magica
		inimigo = new Inimigo("Sapo Gigante", "O caráter pantanoso da região certamente ajudou na evolução desta criatura.", ataque, defesa, "SapoGigante.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 2;
		experienciaAoDerrotar = 5;
		ataque = new Ataque(0, 185);
		defesa = new Defesa(50, 75, 0);
		inimigo = new Inimigo("Jacaré 15 M", "Lembra muito os filmes de jurassic park pelo tamanho insano.", ataque, defesa, "Jacare.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 2;
		experienciaAoDerrotar = 5;
		ataque = new Ataque(0, 1000);
		defesa = new Defesa(100, 0, 90);
		inimigo = new Inimigo("Sucuri Gigante", "Rapida, mortal e extremamente grande.", ataque, defesa, "SucuriGigante.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);
		
		mapaInimigos.put("class modelo.locaisMapa.Pantano", conjuntoInimigos);
		

		//==================Inimigos Area Caverna==================\\
		
		conjuntoInimigos = new ArrayList<Inimigo>();

		experienciaRetiradaAoPerder = 3;
		experienciaAoDerrotar = 6;
		ataque = new Ataque(380, 50);//magico, fisico
		defesa = new Defesa(350, 100, 0);//vida, fisica, magica
		inimigo = new Inimigo("Reptil Desconhecido", "Muitas escamas e lento.", ataque, defesa, "ReptilDesconhecido.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 3;
		experienciaAoDerrotar = 6;
		ataque = new Ataque(190, 0);
		defesa = new Defesa(30, 165, 125);
		inimigo = new Inimigo("Eletricidade viva", "Aparencia muito semelhante a de raios em tempestades.", ataque, defesa, "EletricidadeViva.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 3;
		experienciaAoDerrotar = 6;
		ataque = new Ataque(0, 145);
		defesa = new Defesa(355, 0, 0);
		inimigo = new Inimigo("Bite", "Lembra muito criaturas do profundo oceano, se adaptou a escuridão.", ataque, defesa, "Bite.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);
		
		mapaInimigos.put("class modelo.locaisMapa.Cavernas", conjuntoInimigos);

		//==================Inimigos Area Campo==================\\
		
		conjuntoInimigos = new ArrayList<Inimigo>();

		experienciaRetiradaAoPerder = 3;
		experienciaAoDerrotar = 7;
		ataque = new Ataque(0, 300);//magico, fisico
		defesa = new Defesa(300, 140, 100);//vida, fisica, magica
		inimigo = new Inimigo("Leão Gigante", "Depois de extinto reencontrar um desse tamanho certamente é algo de se admirar.", ataque, defesa, "LeaoGigante.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 3;
		experienciaAoDerrotar = 7;
		ataque = new Ataque(160, 100);
		defesa = new Defesa(260, 210, 150);
		inimigo = new Inimigo("Lama Viva", "Tudo onde ecosta fica sujo e não aparenta sentir dor.", ataque, defesa, "LamaViva.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 3;
		experienciaAoDerrotar = 7;
		ataque = new Ataque(141, 140);
		defesa = new Defesa(350, 210, 150);
		inimigo = new Inimigo("Tatu Gigante", "Com o tamanho de um carro e um casco muito duro.", ataque, defesa, "TatuGigante.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);
		
		mapaInimigos.put("class modelo.locaisMapa.Campo", conjuntoInimigos);

		//==================Inimigos Area Pedras==================\\
		
		conjuntoInimigos = new ArrayList<Inimigo>();

		experienciaRetiradaAoPerder = 4;
		experienciaAoDerrotar = 8;
		ataque = new Ataque(0, 480);//magico, fisico
		defesa = new Defesa(170, 250, 35);//vida, fisica, magica
		inimigo = new Inimigo("Spin Raptor", "Muito semelhante a um velociraptor, porém com espinhos pelo corpo.", ataque, defesa, "SpintRaptor.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 4;
		experienciaAoDerrotar = 8;
		ataque = new Ataque(0, 400);
		defesa = new Defesa(400, 0, 0);
		inimigo = new Inimigo("Laguia", "Uma aguia que caçaria um elefante sem dificuldades.", ataque, defesa, "Laguia.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 4;
		experienciaAoDerrotar = 8;
		ataque = new Ataque(190, 180);
		defesa = new Defesa(1000, 240, 200);
		inimigo = new Inimigo("Pedra Viva", "Uma pedra que age como animal.", ataque, defesa, "PedraViva.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);
		
		mapaInimigos.put("class modelo.locaisMapa.Pedras", conjuntoInimigos);

		//==================Inimigos Area Floresta==================\\
		
		conjuntoInimigos = new ArrayList<Inimigo>();

		experienciaRetiradaAoPerder = 4;
		experienciaAoDerrotar = 9;
		ataque = new Ataque(250, 290);//magico, fisico
		defesa = new Defesa(400, 325, 231);//vida, fisica, magica
		inimigo = new Inimigo("Planta Carnivora", "Tamanho familia das plantas carnivoras tradicionais.", ataque, defesa, "PlantaCarnivora.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 4;
		experienciaAoDerrotar = 9;
		ataque = new Ataque(1000, 0);
		defesa = new Defesa(50, 75, 0);
		inimigo = new Inimigo("Cipó Esmagador", "Ser pego por ele significa que não existe volta.", ataque, defesa, "CipoEsmagador.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 4;
		experienciaAoDerrotar = 9;
		ataque = new Ataque(10, 400);
		defesa = new Defesa(200, 100, 100);
		inimigo = new Inimigo("Borboleta Carnivora", "Bonita e mortal.", ataque, defesa, "BorboletaCarnivora.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);
		
		mapaInimigos.put("class modelo.locaisMapa.Floresta", conjuntoInimigos);

		//==================Inimigos Area Montanha Baixa==================\\
		
		conjuntoInimigos = new ArrayList<Inimigo>();

		experienciaRetiradaAoPerder = 5;
		experienciaAoDerrotar = 10;
		ataque = new Ataque(350, 400);//magico, fisico
		defesa = new Defesa(500, 395, 425);//vida, fisica, magica
		inimigo = new Inimigo("Gigante de Pedra", "Aparenta ser a versão adulta de Pedra Viva.", ataque, defesa, "GiganteDePedra.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 5;
		experienciaAoDerrotar = 10;
		ataque = new Ataque(0, 650);
		defesa = new Defesa(1200, 0, 0);
		inimigo = new Inimigo("Grande Pássaro", "De longe pode ser confundido com um avião.", ataque, defesa, "GrandePassaro.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 10;
		experienciaAoDerrotar = 10;
		ataque = new Ataque(0, 320);
		defesa = new Defesa(560, 100, 100);
		inimigo = new Inimigo("Gato Vegetariano", "Criatura dócil.", ataque, defesa, "GatoVegetariano.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);
		
		mapaInimigos.put("class modelo.locaisMapa.InicioMontanhas", conjuntoInimigos);

		//==================Inimigos Area Montanha Alta==================\\
		
		conjuntoInimigos = new ArrayList<Inimigo>();

		experienciaRetiradaAoPerder = 6;
		experienciaAoDerrotar = 11;
		ataque = new Ataque(650, 650);//magico, fisico
		defesa = new Defesa(10, 10, 10);//vida, fisica, magica
		inimigo = new Inimigo("Sanguessuga Modificada", "Dimitri parece ter caprichado neste.", ataque, defesa, "SanguessugaModificada.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 6;
		experienciaAoDerrotar = 11;
		ataque = new Ataque(150, 800);
		defesa = new Defesa(1200, 200, 15);
		inimigo = new Inimigo("Tubarão Terrestre", "Muito forte e raivoso.", ataque, defesa, "TubaraoTerrestre.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);

		experienciaRetiradaAoPerder = 6;
		experienciaAoDerrotar = 11;
		ataque = new Ataque(0, 400);
		defesa = new Defesa(500, 615, 490);
		inimigo = new Inimigo("Cachorro Modificado", "Parece um animal qualquer, apenas parece.", ataque, defesa, "CachorroModificado.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);
		
		mapaInimigos.put("class modelo.locaisMapa.PicoMontanhas", conjuntoInimigos);
		
		//==================BOSS==================\\

		conjuntoInimigos = new ArrayList<Inimigo>();		

		experienciaRetiradaAoPerder = 10;
		experienciaAoDerrotar = 8001;
		ataque = new Ataque(555, 540);
		defesa = new Defesa(5000, 330, 400);
		inimigo = new Inimigo("Dimitri", "Irmão de Logan.", ataque, defesa, "Dimitri.png", experienciaAoDerrotar, experienciaRetiradaAoPerder);
		conjuntoInimigos.add(inimigo);
		conjuntoInimigos.add(inimigo);
		conjuntoInimigos.add(inimigo);
		
		mapaInimigos.put("class modelo.locaisMapa.Boss", conjuntoInimigos);
	}
	
	public List<Inimigo> retornaConjuntoInimigos(String tipo){
		return this.mapaInimigos.get(tipo);
	}
	
}