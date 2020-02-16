package interacaoUsuario.janelaPrincipal;

import java.awt.Rectangle;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.Controle;

@SuppressWarnings("serial")
public class PainelPontosDisponiveis extends JPanel{

	private JLabel imagemFundo;
	
	public PainelPontosDisponiveis(int posicaoX, int posicaoY){
		setLayout(null);
		criaLabelInformacoes();
		criaImagemPainel();
		setSize(121, 96);
		setLocation(posicaoX, posicaoY);
		setVisible(true);
	}

	private void criaLabelInformacoes() {
		JLabel informacoes = new JLabel(Controle.getControle().getStringPontosDisponiveis());
		informacoes.setBounds(12, 0, 121, 96);
		add(informacoes);
	}

	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "PainelPontosDisponiveis.png"));
		imagemFundo.setBounds(new Rectangle(0, 0, 121, 96));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}
	
}