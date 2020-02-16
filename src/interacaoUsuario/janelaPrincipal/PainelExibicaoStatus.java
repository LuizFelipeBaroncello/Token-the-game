package interacaoUsuario.janelaPrincipal;

import java.awt.Rectangle;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.Controle;

@SuppressWarnings("serial")
public class PainelExibicaoStatus extends JPanel{

	private JLabel imagemFundo;
	
	public PainelExibicaoStatus(){
		setLayout(null);
		adicionaInformacoes();
		criaImagemPainel();
		setSize(205, 159);
		setLocation(206, 493);
		setVisible(true);
	}

	private void adicionaInformacoes() {
		JLabel textoHeroi = new JLabel(Controle.getControle().getToStringHeroi());
		textoHeroi.setBounds(15, -10, 190, 180);
		add(textoHeroi);
	}

	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setBounds(new Rectangle(0, 0, 205, 159));
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "PainelExibicaoStatus.png"));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}

}