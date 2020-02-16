package interacaoUsuario.janelaPrincipal.batalha;

import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PainelHeroiGanhouJokenpo extends JPanel {

	private JLabel imagemFundo;
	private JLabel imagemGolpeFisico;
	private JLabel imagemGolpeMagico;
	private JLabel imagemTentarFugir;
	private JLabel exibeEscolha;
	
	public PainelHeroiGanhouJokenpo(){
		setLayout(null);
		criaImagemGolpeFisico();
		criaImagemGolpeMagico();
		criaImagemTentarFugir();
		criaLabelExibeEscolha();
		criaTextFieldExibeTurno();
		criaLabelEscolhaSuaAcao();
		criaImagemPainel();
		setSize(983, 303);
		setLocation(3, 3);
		setVisible(true);
	}
	
	private void criaImagemTentarFugir() {
		imagemTentarFugir = new JLabel();
		imagemTentarFugir.setBounds(669, 65, 328, 215);
		imagemTentarFugir.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "batalha" + File.separator + "Fugir.png"));
		imagemTentarFugir.setVisible(true);
		imagemTentarFugir.setToolTipText("Tentar Fugir");
		add(imagemTentarFugir);
	}

	private void criaImagemGolpeMagico() {
		imagemGolpeMagico = new JLabel();
		imagemGolpeMagico.setBounds(326, 65, 328, 215);
		imagemGolpeMagico.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "batalha" + File.separator + "Magia.png"));
		imagemGolpeMagico.setVisible(true);
		imagemGolpeMagico.setToolTipText("Golpe Magico");
		add(imagemGolpeMagico);
	}

	private void criaImagemGolpeFisico() {
		imagemGolpeFisico = new JLabel();
		imagemGolpeFisico.setBounds(15, 65, 246, 194);
		imagemGolpeFisico.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "batalha" + File.separator + "AtaqueFisico.png"));
		imagemGolpeFisico.setVisible(true);
		imagemGolpeFisico.setToolTipText("Golpe Fisico");
		add(imagemGolpeFisico);
	}

	private void criaLabelExibeEscolha() {
		exibeEscolha = new JLabel("Acao: ");
		exibeEscolha.setBounds(800, 14, 140, 24);
		add(exibeEscolha);
	}

	public void setExibeEscolha(String escolha){
		exibeEscolha.setVisible(false);
		remove(exibeEscolha);
		exibeEscolha = new JLabel("Acao: " + escolha);
		exibeEscolha.setBounds(800, 14, 170, 24);
		add(exibeEscolha);
		exibeEscolha.setVisible(true);
		remove(imagemFundo);
		add(imagemFundo);
	}
	
	private void criaLabelEscolhaSuaAcao() {
		JLabel escolhaSuaAcao = new JLabel("Escolha Sua acao");
		escolhaSuaAcao.setBounds(430, 30, 140, 24);
		add(escolhaSuaAcao);
	}

	private void criaTextFieldExibeTurno() {
		JTextField turnoAtual = new JTextField("Turno: Escolher acao");
		turnoAtual.setEditable(false);
		turnoAtual.setBounds(14, 14, 140, 24);
		add(turnoAtual);
	}
	
	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "batalha" + File.separator + "PainelTurnosBatalha.png"));
		imagemFundo.setBounds(new Rectangle(0, 0, 983, 303));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}
	
	public void adicionaAcaoGolpeFisico(MouseListener acao){
		imagemGolpeFisico.addMouseListener(acao);
	}
	
	public void adicionaAcaoGolpeMagico(MouseListener acao){
		imagemGolpeMagico.addMouseListener(acao);
	}
	
	public void adicionaAcaoTentarFugir(MouseListener acao){
		imagemTentarFugir.addMouseListener(acao);
	}
	
}