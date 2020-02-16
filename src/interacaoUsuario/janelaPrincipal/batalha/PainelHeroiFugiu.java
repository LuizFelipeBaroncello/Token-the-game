package interacaoUsuario.janelaPrincipal.batalha;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PainelHeroiFugiu extends JPanel {

	private JLabel imagemFundo;
	private JButton botaoOk;
	
	public PainelHeroiFugiu(){
		setLayout(null);
		criaLabelInformacao();
		criaTextFieldExibeTurno();
		criaBotaoOk();
		criaImagemPainel();
		setSize(983, 303);
		setLocation(3, 3);
		setVisible(true);
	}
	
	private void criaBotaoOk() {
		botaoOk = new JButton("ok");
		botaoOk.setBounds(450, 190, 60, 24);
		add(botaoOk);
	}

	public void adicionaAcaoBotaoOk(ActionListener acao){
		botaoOk.addActionListener(acao);
	}
	
	private void criaLabelInformacao() {
		JLabel informacao = new JLabel("Voce consegui encontrar a porta certa, por isso fugirá da batalha.");
		informacao.setBounds(320, 145, 500, 24);
		add(informacao);
	}
	
	private void criaTextFieldExibeTurno() {
		JTextField turnoAtual = new JTextField("Turno: Fugir");
		turnoAtual.setEditable(false);
		turnoAtual.setBounds(14, 14, 120, 24);
		add(turnoAtual);
	}

	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "batalha" + File.separator + "PainelTurnosBatalha.png"));
		imagemFundo.setBounds(new Rectangle(0, 0, 983, 303));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}
	
}