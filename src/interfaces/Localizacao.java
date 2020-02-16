package interfaces;

import excecoes.localidades.ExcecaoLocalidade;
import excecoes.localidades.ExcecaoSemExperiencia;

public interface Localizacao {

	public void zonaTropical() throws ExcecaoLocalidade, ExcecaoSemExperiencia;
	
	public void zonaComCavernas() throws ExcecaoLocalidade, ExcecaoSemExperiencia;
	
	public void zonaComNeblina() throws ExcecaoLocalidade, ExcecaoSemExperiencia;
	
	public void zonaComPantano() throws ExcecaoLocalidade, ExcecaoSemExperiencia;
	
	public void zonaComCampos() throws ExcecaoLocalidade, ExcecaoSemExperiencia;
	
	public void zonaComPedras() throws ExcecaoLocalidade, ExcecaoSemExperiencia;
	
	public void zonaComFlorestas() throws ExcecaoLocalidade, ExcecaoSemExperiencia;
	
	public void zonaInicioMontanha() throws ExcecaoLocalidade, ExcecaoSemExperiencia;
	
	public void zonaPicoMontanha() throws ExcecaoLocalidade, ExcecaoSemExperiencia;

	public void zonaBoss() throws ExcecaoLocalidade, ExcecaoSemExperiencia;
	
	public String getImagemLocal();
	
	public String getNomeLocal();
	
	public String getHistoriaLocal();
	
	public int getNumLocal();
}