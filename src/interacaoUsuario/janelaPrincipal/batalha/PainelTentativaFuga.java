package interacaoUsuario.janelaPrincipal.batalha;

import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PainelTentativaFuga extends JPanel {

	private JLabel imagemFundo;
	private List<JLabel> conjuntoOpcoesFuga;
	
	public PainelTentativaFuga(){
		setLayout(null);
		criaLabelsTentativaFuga();
		criaLabelExibeMensagem();
		criaImagemPainel();
		setSize(620, 250);
		setLocation(187, 3);
		setVisible(true);
	}
	
	private void criaLabelsTentativaFuga() {
		conjuntoOpcoesFuga = new ArrayList<JLabel>();
		JLabel porta = new JLabel();
		porta.setBounds(13, 71, 35, 116);
		conjuntoOpcoesFuga.add(porta);
		add(conjuntoOpcoesFuga.get(0));
		
		porta = new JLabel();
		porta.setBounds(63, 65, 38, 126);
		conjuntoOpcoesFuga.add(porta);
		add(conjuntoOpcoesFuga.get(1));
		
		porta = new JLabel();
		porta.setBounds(122, 57, 50, 136);
		conjuntoOpcoesFuga.add(porta);
		add(conjuntoOpcoesFuga.get(2));
		
		porta = new JLabel();
		porta.setBounds(190, 48, 66, 156);
		conjuntoOpcoesFuga.add(porta);
		add(conjuntoOpcoesFuga.get(3));
		
		porta = new JLabel();
		porta.setBounds(271, 39, 68, 176);
		conjuntoOpcoesFuga.add(porta);
		add(conjuntoOpcoesFuga.get(4));
		
		porta = new JLabel();
		porta.setBounds(375, 21, 102, 186);
		conjuntoOpcoesFuga.add(porta);
		add(conjuntoOpcoesFuga.get(5));
		
		porta = new JLabel();
		porta.setBounds(486, 10, 102, 186);
		conjuntoOpcoesFuga.add(porta);
		add(conjuntoOpcoesFuga.get(6));

	}

	private void criaLabelExibeMensagem() {
		JLabel escolhaUmaPorta = new JLabel("Escolha uma das rotas de fuga");
		escolhaUmaPorta.setBounds(220, 220, 200, 24);
		add(escolhaUmaPorta);
	}

	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "batalha" + File.separator + "TentarFugir.png"));
		imagemFundo.setBounds(new Rectangle(0, 0, 620, 250));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}

	public void adicionaAcaoPorta(int numPorta, MouseListener acao){
		this.conjuntoOpcoesFuga.get(numPorta).addMouseListener(acao);
	}
	
}