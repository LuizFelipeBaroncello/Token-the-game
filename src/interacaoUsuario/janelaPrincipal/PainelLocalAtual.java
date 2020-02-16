package interacaoUsuario.janelaPrincipal;

import java.awt.Rectangle;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.Controle;

@SuppressWarnings("serial")
public class PainelLocalAtual extends JPanel{

	private JLabel imagemFundo;
	
	public PainelLocalAtual(){
		setLayout(null);
		criaLabelLocalAtual();
		criaImagemPainel();
		setSize(274, 30);
		setLocation(281, 8);
		setVisible(true);
	}
	
	private void criaLabelLocalAtual() {
		JLabel localAtual = new JLabel("Local Atual: " + Controle.getControle().getLocalAtual());
		localAtual.setBounds(16, 6, 250, 20);
		add(localAtual);
	}

	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "PainelLocalAtual.png"));
		imagemFundo.setBounds(new Rectangle(0, 0, 274, 30));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}
	
}