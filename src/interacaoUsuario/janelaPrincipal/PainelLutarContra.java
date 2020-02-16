package interacaoUsuario.janelaPrincipal;

import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class PainelLutarContra extends JPanel {
	
	private JLabel imagemFundo;
	private JButton inimigo1;
	private JButton inimigo2;
	private JButton inimigo3;
	
	public PainelLutarContra(String nomeInimigo1, String nomeInimigo2, String nomeInimigo3){
		setLayout(null);
		criaBotoes(nomeInimigo1, nomeInimigo2, nomeInimigo3);
		criaLabel();
		criaImagemPainel();
		setSize(230, 140);
		setLocation(732, 495);
		setVisible(true);
	}

	private void criaLabel() {
		JLabel lutarContra = new JLabel("Lutar Contra:");
		lutarContra.setBounds(14, 14, 90, 24);
		add(lutarContra);
	}

	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setBounds(new Rectangle(0, 0, 238, 140));
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "PainelLutarContra.png"));
		imagemFundo.setVisible(true);
		add(imagemFundo);
		
	}

	private void criaBotoes(String nomeInimigo1, String nomeInimigo2, String nomeInimigo3) {
		inimigo1 = new JButton(nomeInimigo1);
		inimigo1.setBounds(new Rectangle(32, 38, 170, 24));
		add(inimigo1);
		inimigo2 = new JButton(nomeInimigo2);
		inimigo2.setBounds(new Rectangle(32, 66, 170, 24));
		add(inimigo2);
			
		inimigo3 = new JButton(nomeInimigo3);
		inimigo3.setBounds(new Rectangle(32, 94, 170, 24));
		add(inimigo3);	

	}
	
	public void adicionaAcaoInimigo1(MouseListener acao){
		this.inimigo1.addMouseListener(acao);
	}
	
	public void adicionaAcaoInimigo2(MouseListener acao){
		this.inimigo2.addMouseListener(acao);
	}
	
	public void adicionaAcaoInimigo3(MouseListener acao){
		this.inimigo3.addMouseListener(acao);
	}
	
}