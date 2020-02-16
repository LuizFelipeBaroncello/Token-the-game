	package interacaoUsuario.janelaPrincipal;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.Controle;

@SuppressWarnings("serial")
public class PainelBotoesAuxilo extends JPanel{

	private JLabel imagemFundo;
	private JButton botaoVerHistoriaLocal;
	
	public PainelBotoesAuxilo(){
		setLayout(null);
		criaBotoes();
		criaImagemPainel();
		setSize(185, 32);
		setLocation(419, 509);
		setVisible(true);
	}
	
	private void criaBotoes() {
		botaoVerHistoriaLocal = new JButton("Ver Historia");
		botaoVerHistoriaLocal.setBounds(new Rectangle(4, 4, 110, 23));
		add(botaoVerHistoriaLocal);
	
		
		JButton botaoAjuda = new JButton("Help");
		botaoAjuda.setBounds(new Rectangle(117, 4, 65, 23));
		botaoAjuda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Controle.getControle().exibeTextoAjuda();
			}
		});
		add(botaoAjuda);
	}
	
	public void adicionaAcaoBotaoHistoria(ActionListener acao){
		this.botaoVerHistoriaLocal.addActionListener(acao);
	}

	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "PainelBotoesAuxilio.png"));
		imagemFundo.setBounds(new Rectangle(0, 0, 185, 32));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}
	
	public void setTextoBotao(String text){
		this.botaoVerHistoriaLocal.setText(text);
	}
	
}