package interacaoUsuario.janelaPrincipal;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import controle.Controle;

@SuppressWarnings("serial")
public class PainelExibeHistoria extends JLabel{
	
	private JButton fechaHistoria;
	
	public PainelExibeHistoria(){
		setLayout(null);
		criaBotaoFecharHistoria();
		exibeHistoria();
		criaImagemPainel();
		setSize(600, 484);
		setLocation(195, 110);
		setVisible(true);
	}

	private void criaBotaoFecharHistoria() {
		fechaHistoria = new JButton("Fechar");
		fechaHistoria.setBounds(500, 6, 90, 24);
		add(fechaHistoria);
	}

	private void exibeHistoria() {
		JLabel historia = new JLabel(Controle.getControle().getHistoriaLocal());
		historia.setBounds(70, 14, 450, 484);
		add(historia);
	}

	private void criaImagemPainel() {
		setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "PapelParaHistoria.png"));
		setBounds(new Rectangle(0, 0, 600, 484));
		setVisible(true);
	}

	public void adicionaAcaoBotaoFecharHistoria(ActionListener acao) {
		fechaHistoria.addActionListener(acao);
	}
	
}