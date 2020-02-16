package interacaoUsuario.janelaPrincipal.batalha;

import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PainelJokenpo extends JPanel{

	private JLabel imagemFundo;
	private JLabel imagemAtacar;
	private JLabel imagemFingirAtaque;
	private JLabel imagemDesviar;
	private JLabel exibeEscolha;
	
	public PainelJokenpo(){
		setLayout(null);
		criaLabelExibeEscolha();
		criaLabelEscolhaSeuMovimento();
		criaTextFieldExibeTurno();
		criaImagemAtacar();
		criaImagemFingirAtaque();
		criaImagemDesvia();
		criaImagemPainel();
		setSize(983, 303);
		setLocation(3, 3);
		setVisible(true);
	}

	private void criaLabelExibeEscolha() {
		exibeEscolha = new JLabel("Movimento: ");
		exibeEscolha.setBounds(800, 14, 140, 24);
		add(exibeEscolha);
	}
	
	public void setExibeEscolha(String movimento){
		exibeEscolha.setVisible(false);
		remove(exibeEscolha);
		exibeEscolha = new JLabel("Movimento: " + movimento);
		exibeEscolha.setBounds(800, 14, 170, 24);
		add(exibeEscolha);
		exibeEscolha.setVisible(true);
		remove(imagemFundo);
		add(imagemFundo);
	}

	private void criaLabelEscolhaSeuMovimento() {
		JLabel escolhaSeuMovimento = new JLabel("Escolha Seu Movimento");
		escolhaSeuMovimento.setBounds(430, 30, 140, 24);
		add(escolhaSeuMovimento);
	}

	private void criaTextFieldExibeTurno() {
		JTextField turnoAtual = new JTextField("Turno: Jokenpo");
		turnoAtual.setEditable(false);
		turnoAtual.setBounds(14, 14, 90, 24);
		add(turnoAtual);
	}

	private void criaImagemAtacar() {
		imagemAtacar = new JLabel();
		imagemAtacar.setBounds(15, 65, 296, 215);
		imagemAtacar.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "batalha" + File.separator + "Atacar.png"));
		imagemAtacar.setVisible(true);
		imagemAtacar.setToolTipText("Movimento de Ataque");
		add(imagemAtacar);
	}

	private void criaImagemFingirAtaque() {
		imagemFingirAtaque = new JLabel();
		imagemFingirAtaque.setBounds(326, 65, 328, 215);
		imagemFingirAtaque.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "batalha" + File.separator + "FingirAtaque.png"));
		imagemFingirAtaque.setVisible(true);
		imagemFingirAtaque.setToolTipText("Movimento para Fingir Ataque");
		add(imagemFingirAtaque);
	}
	
	private void criaImagemDesvia() {
		imagemDesviar = new JLabel();
		imagemDesviar.setBounds(669, 65, 328, 215);
		imagemDesviar.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "batalha" + File.separator + "Desviar.png"));
		imagemDesviar.setVisible(true);
		imagemDesviar.setToolTipText("Movimento para Desviar");
		add(imagemDesviar);
	}
	
	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "batalha" + File.separator + "PainelTurnosBatalha.png"));
		imagemFundo.setBounds(new Rectangle(0, 0, 983, 303));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}
	
	public void adicionaAcaoAtaca(MouseListener acao){
		imagemAtacar.addMouseListener(acao);
	}
	
	public void adicionaAcaoFingeAtacar(MouseListener acao){
		imagemFingirAtaque.addMouseListener(acao);
	}
	
	public void adicionaAcaoDesvia(MouseListener acao){
		imagemDesviar.addMouseListener(acao);
	}
	
}