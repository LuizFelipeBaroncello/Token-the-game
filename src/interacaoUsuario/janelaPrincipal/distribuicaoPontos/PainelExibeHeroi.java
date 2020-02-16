package interacaoUsuario.janelaPrincipal.distribuicaoPontos;

import java.awt.Rectangle;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.Controle;

@SuppressWarnings("serial")
public class PainelExibeHeroi extends JPanel{

private JLabel imagemFundo;
	
	public PainelExibeHeroi() {
		setLayout(null);
		adicionaImagemHeroi();
		adicionaToStringHeroi();
		criaImagemPainel();
		setSize(219, 468);
		setLocation(690, 180);
		setVisible(true);
	}

	private void adicionaToStringHeroi() {
		JLabel textoHeroi = new JLabel(Controle.getControle().getToStringHeroi());
		textoHeroi.setBounds(14, 253, 190, 180);
		add(textoHeroi);
	}

	private void adicionaImagemHeroi() {
		JLabel imagemHeroi = new JLabel();
		imagemHeroi.setBounds(15, 15, 191, 243);
		imagemHeroi.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "batalha" + File.separator + "Heroi.png"));
		imagemHeroi.setVisible(true);
		add(imagemHeroi);
	}

	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "PainelExibeInimigos.png"));
		imagemFundo.setBounds(new Rectangle(0, 0, 220, 468));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}
	
	
}