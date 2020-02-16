package interacaoUsuario.janelaPrincipal;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.Controle;

@SuppressWarnings("serial")
public class PainelOpcoes extends JPanel{

	private JLabel imagemFundo;
	private JButton distribuirPontos;
	
	public PainelOpcoes(){
		setLayout(null);
		criaBotoes();
		criaImagemPainel();
		setSize(308, 90);
		setLocation(419, 544);
		setVisible(true);
	}
	
	private void criaBotoes() {
		JButton statusJogador = new JButton("Status");
		statusJogador.setBounds(new Rectangle(12, 12, 85, 65));
		statusJogador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Controle.getControle().statusJogador();
			}
		});
		add(statusJogador);
		
		distribuirPontos = new JButton("<html>Distribuir Pontos</html>");
		distribuirPontos.setBounds(new Rectangle(110, 12, 85, 65));
		add(distribuirPontos);
		
		JButton salvar = new JButton("Salvar");
		salvar.setBounds(new Rectangle(208, 12, 85, 65));
		salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Controle.getControle().salvar();
			}
		});
		add(salvar);
	}

	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "PainelOpcoes.png"));
		imagemFundo.setBounds(new Rectangle(0, 0, 308, 90));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}
	
	public void adicionaAcaoDistribuirPontos(MouseListener acao){
		this.distribuirPontos.addMouseListener(acao);
	}

}