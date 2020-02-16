package interacaoUsuario.janelaPrincipal;

import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ConjuntoBotoesMapa {

	private List<JLabel> botoes;
	private List<Integer> posicoesX;
	private List<Integer> posicoesY;
	private List<Integer> experienciaNecessaria;
	private int localPersonagem;
	
	public ConjuntoBotoesMapa(int localPersonagem){
		this.localPersonagem = localPersonagem;
		posicoesX = new ArrayList<>(Arrays.asList(540, 852, 600, 570, 380, 260, 155, 170, 197, 197));
		posicoesY = new ArrayList<>(Arrays.asList(394, 240, 145, 235, 250, 230, 290, 200, 102, 75));
		experienciaNecessaria = new ArrayList<>(Arrays.asList(0, 9, 21, 36, 54, 75, 99, 126, 156, 189));
		botoes = new ArrayList<JLabel>();
		iniciaBotoes(localPersonagem);
	}

	private void iniciaBotoes(int localPersonagem) {
		for (int i = 0; i < posicoesX.size(); i++) {
			if (i == localPersonagem)
				botoes.add(criaAlfinete(i));
			else
				botoes.add(criaBandeira(i));
		}
	}

	private JLabel criaAlfinete(int indice) {
		JLabel imagemAlfinete = new JLabel();
		imagemAlfinete.setBounds(posicoesX.get(indice), posicoesY.get(indice), 50, 50);
		imagemAlfinete.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "Alfinete.png"));
		return imagemAlfinete;
	}

	private JLabel criaBandeira(int indice){
		JLabel imagemBandeira = new JLabel();
		imagemBandeira.setToolTipText("Experiencia necessária: " + experienciaNecessaria.get(indice));
		imagemBandeira.setBounds(posicoesX.get(indice), posicoesY.get(indice), 26, 29);
		imagemBandeira.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "BandeiraLocais.png"));
		return imagemBandeira;
	}
	
	public JLabel retornaBotaoLocal(int posicao){
		return this.botoes.get(posicao);
	}
	
	public void adcionaAcaoBotao(int posicao, MouseListener acao){
		this.botoes.get(posicao).addMouseListener(acao);
	}

	
	public int getLocalPersonagem() {
		return localPersonagem;
	}
	
}