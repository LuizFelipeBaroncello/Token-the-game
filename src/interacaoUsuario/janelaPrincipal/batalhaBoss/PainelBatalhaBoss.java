package interacaoUsuario.janelaPrincipal.batalhaBoss;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.Controle;
import interacaoUsuario.janelaPrincipal.batalha.LabelExibePersonagensBatalha;
import interacaoUsuario.janelaPrincipal.batalha.PainelHeroiGanhouBatalha;
import interacaoUsuario.janelaPrincipal.batalha.PainelHeroiGanhouJokenpo;
import interacaoUsuario.janelaPrincipal.batalha.PainelHeroiPerdeuBatalha;
import interacaoUsuario.janelaPrincipal.batalha.PainelHeroiPerdeuJokenpo;
import interacaoUsuario.janelaPrincipal.batalha.PainelJokenpo;

@SuppressWarnings("serial")
public class PainelBatalhaBoss extends JPanel{

	private JLabel imagemFundo;
	private PainelJokenpo painelJokenpo;
	private PainelHeroiGanhouJokenpo painelHeroiGanhouJokenpo;
	private PainelHeroiPerdeuJokenpo painelHeroiPerdeuJokenpo;
	private JButton botaoEstatisticas;
	private JButton botaoAjuda;
	private PainelHeroiGanhouBatalha painelHeroiGanhouBatalha;
	private PainelHeroiPerdeuBatalha painelHeroiPerdeuBatalha;
	private LabelExibePersonagensBatalha labelExibePersonagensBatalha;
		
 	public PainelBatalhaBoss(){
		setLayout(null);
		criaBotaoEstatisticas();
		criaBotaoAjuda();
		criaLabelExibeHeroi();
		painelHeroiGanhouBatalha = new PainelHeroiGanhouBatalha();
		painelHeroiPerdeuBatalha = new PainelHeroiPerdeuBatalha();
		criaImagemPainel();
		defineRumoBatalha();
		setSize(995, 689);
		setLocation(0, 0);
		setVisible(true);
	}
 	
	private void criaLabelExibeHeroi() {
		labelExibePersonagensBatalha = new LabelExibePersonagensBatalha();
		labelExibePersonagensBatalha.setBounds(11, 353, 436, 273);
		labelExibePersonagensBatalha.setVisible(true);
		add(labelExibePersonagensBatalha);
	}

	private void criaBotaoEstatisticas() {
		botaoEstatisticas = new JButton("Estatisticas");
		botaoEstatisticas.setBounds(855, 307, 130, 24);
		botaoEstatisticas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Controle.getControle().exibeEstatisticasBatalha();
			}
		});
		add(botaoEstatisticas);
	}

	private void criaBotaoAjuda() {
		botaoAjuda = new JButton("Ajuda");
		botaoAjuda.setBounds(3, 307, 75, 24);
		botaoAjuda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Controle.getControle().exibeTextoAjudaBatalha();
			}
		});
		add(botaoAjuda);
	}

	private void defineRumoBatalha() {
		if (!Controle.getControle().batalhaContinua()) {
			batalhaAcaba();
		}else{
			batalhaContinua();
		}
	}

	private void batalhaContinua() {
		this.painelJokenpo = new PainelJokenpo();
		add(painelJokenpo);
		painelJokenpo.adicionaAcaoAtaca(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {

			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
		
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				painelJokenpo.setExibeEscolha("Ataque");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				painelJokenpo.setVisible(false);
				remove(painelJokenpo);
				atualizaPainelSuperior(Controle.getControle().verificaSeHeroiGanhaJokenpoAtacando());
			}
		});
		painelJokenpo.adicionaAcaoFingeAtacar(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {

			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
		
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				painelJokenpo.setExibeEscolha("Finge Ataque");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				painelJokenpo.setVisible(false);
				remove(painelJokenpo);
				atualizaPainelSuperior(Controle.getControle().verificaSeHeroiGanhaJokenpoFingindoAtaque());
			}


		});
		painelJokenpo.adicionaAcaoDesvia(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {

			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
		
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				painelJokenpo.setExibeEscolha("Desvia");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				painelJokenpo.setVisible(false);
				remove(painelJokenpo);
				atualizaPainelSuperior(Controle.getControle().verificaSeHeroiGanhaJokenpoDesviando());
			}
		});
		atualizaPainel();
	}

	private void batalhaAcaba() {
		if (Controle.getControle().heroiVenceuBatalha()) {
			atualizaPainel();
			add(painelHeroiGanhouBatalha);
		}else{
			atualizaPainel();
			add(painelHeroiPerdeuBatalha);
		}
	}
	
	private void atualizaPainelSuperior(boolean heroiGanhouJokenpo) {
		if (heroiGanhouJokenpo) {
			painelHeroiGanhouJokenpo = new PainelHeroiGanhouJokenpo();
			add(painelHeroiGanhouJokenpo);
			painelHeroiGanhouJokenpo.adicionaAcaoGolpeFisico(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
				
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
			
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
				
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					painelHeroiGanhouJokenpo.setExibeEscolha("Desferir golpe fisico");
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					painelHeroiGanhouJokenpo.setVisible(false);
					remove(painelHeroiGanhouJokenpo);
					Controle.getControle().simulaGolpeFisicoHeroi();
					defineRumoBatalha();
					atualizaPainel();
					Controle.getControle().atualizaEstatisticasBatalha();
				}
			});
			painelHeroiGanhouJokenpo.adicionaAcaoGolpeMagico(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
				
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
			
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
				
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					painelHeroiGanhouJokenpo.setExibeEscolha("Desferir golpe magico");
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					painelHeroiGanhouJokenpo.setVisible(false);
					remove(painelHeroiGanhouJokenpo);
					Controle.getControle().simulaGolpeMagicoHeroi();
					defineRumoBatalha();
					atualizaPainel();
					Controle.getControle().atualizaEstatisticasBatalha();
				}
			});
			atualizaPainel();
		}else{
			painelHeroiPerdeuJokenpo = new PainelHeroiPerdeuJokenpo();
			add(painelHeroiPerdeuJokenpo);
			painelHeroiPerdeuJokenpo.adicionaAcaoBotaoOk(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					painelHeroiPerdeuJokenpo.setVisible(false);
					Controle.getControle().simulaGolpeInimigo();
					remove(painelHeroiPerdeuJokenpo);
					defineRumoBatalha();
					atualizaPainel();
					Controle.getControle().atualizaEstatisticasBatalha();
				}
				
			});
			
			atualizaPainel();
		}
	}

	public void adicionaAcaoBotaoOkFimBatalha(ActionListener acao){
		painelHeroiGanhouBatalha.adicionaAcaoBotaoOk(acao);
		painelHeroiPerdeuBatalha.adicionaAcaoBotaoOk(acao);
	}

	private void atualizaPainel(){
		imagemFundo.setVisible(false);
		labelExibePersonagensBatalha.setVisible(false);
		remove(labelExibePersonagensBatalha);
		remove(imagemFundo);
		labelExibePersonagensBatalha = new LabelExibePersonagensBatalha();
		add(labelExibePersonagensBatalha);
		add(imagemFundo);
		labelExibePersonagensBatalha.setVisible(true);
		imagemFundo.setVisible(true);
	}

	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "locais" + File.separator + Controle.getControle().getImagemLocal()));
		imagemFundo.setBounds(new Rectangle(0, 0, 995, 689));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}
	
}