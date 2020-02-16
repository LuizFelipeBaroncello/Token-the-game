package modelo.batalha;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EstatisticasBatalha implements Serializable{

	private int numRodadas;
	private int vezesHeroiGanhoJokenpo;
	private int vezesHeroiTentouFugir;
	private int vezesHeroiFoiAtacado;
	
	public EstatisticasBatalha(){
		this.numRodadas = 0;
		this.vezesHeroiFoiAtacado = 0;
		this.vezesHeroiTentouFugir = 0;
		this.vezesHeroiGanhoJokenpo = 0;
	}
	
	public void atualizaEstatisticasBatalha(boolean heroiFoiAtacado, boolean heroiTentouFugir){
		this.numRodadas++;
		if (heroiFoiAtacado)
			this.vezesHeroiFoiAtacado++;
		else
			this.vezesHeroiGanhoJokenpo++;
		if (heroiTentouFugir)
			this.vezesHeroiTentouFugir++;	
	}
	
	@Override
	public String toString(){
		return "Numero de Rodadas: " + this.numRodadas + "\n" +
				"Vezes que heroi ganhou no Jokenpo: " + this.vezesHeroiGanhoJokenpo +  "\n" +
				"Vezes que heroi tentou fugir: " + this.vezesHeroiTentouFugir +  "\n" +
				"Vezes que heroi foi atacado: " + this.vezesHeroiFoiAtacado + "\n";
	}

}