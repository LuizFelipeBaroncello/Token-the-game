package interacaoUsuario.janelaPrincipal;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PainelFimDeJogo extends JPanel{

	private JLabel imagemFundo;
	private JButton botaoFechar;
	
	public PainelFimDeJogo(String imagemFundoString){
		setLayout(null);
		criaBotoes();
		criaImagemPainel(imagemFundoString);
		setSize(995, 689);
		setLocation(0, -18);
		setVisible(true);
	}

	private void criaBotoes() {
		botaoFechar = new JButton("Fechar");
		botaoFechar.setBounds(420, 440, 140, 24);
		add(botaoFechar);
	}

	public void adicionaAcaoBotaoFechar(ActionListener acao){
		this.botaoFechar.addActionListener(acao);
	}
	
	private void criaImagemPainel(String imagemFundoString) {
		imagemFundo = new JLabel();
		imagemFundo.setLocation(0, 0);
		imagemFundo.setSize(998, 699);
		imagemFundo.setIcon(new ImageIcon(imagemFundoString));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}

}