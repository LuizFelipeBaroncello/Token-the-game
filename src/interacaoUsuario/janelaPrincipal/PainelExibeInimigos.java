package interacaoUsuario.janelaPrincipal;

import java.awt.Rectangle;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.Controle;

@SuppressWarnings("serial")
public class PainelExibeInimigos extends JPanel{

	private JLabel imagemFundo;
	
	public PainelExibeInimigos(int posicao) {
		setLayout(null);
		adicionaImagemInimigo(posicao);
		adicionaToStringInimigo(posicao);
		criaImagemPainel();
		setSize(219, 468);
		setLocation(740, 22);
		setVisible(true);
	}

	private void adicionaToStringInimigo(int posicao) {
		JLabel textoInimigo = new JLabel(Controle.getControle().getToStringInimigo(posicao));
		textoInimigo.setBounds(14, 273, 190, 180);
		add(textoInimigo);
	}

	private void adicionaImagemInimigo(int posicao) {
		JLabel imagemInimigo = new JLabel();
		imagemInimigo.setBounds(15, 15, 191, 243);
		imagemInimigo.setIcon(new ImageIcon("resources" + File.separator + "imagensInimigos" + File.separator + Controle.getControle().getImagemInimigo(posicao)));
		imagemInimigo.setVisible(true);
		add(imagemInimigo);
	}

	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "PainelExibeInimigos.png"));
		imagemFundo.setBounds(new Rectangle(0, 0, 220, 468));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}

}