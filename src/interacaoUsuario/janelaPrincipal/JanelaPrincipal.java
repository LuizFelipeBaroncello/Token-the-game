package interacaoUsuario.janelaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import controle.Controle;
import interacaoUsuario.ReproduzMusica;
import interacaoUsuario.janelaPrincipal.batalha.PainelBatalha;
import interacaoUsuario.janelaPrincipal.batalhaBoss.PainelBatalhaBoss;
import interacaoUsuario.janelaPrincipal.distribuicaoPontos.PainelDistribuicaoPontos;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	private PainelExibeInimigos painelExibeInimigos;
	private JLabel imagemMapa;
	private PainelLutarContra painelEscolhaInimigos;
	private PainelExibicaoStatus painelStatusHeroi;
	private PainelLocalAtual painelLocalAtual;
	private PainelOpcoes painelOpcoes;
	private PainelBotoesAuxilo painelBotoesAuxilio;
	private PainelPontosDisponiveis painelPontosDisponiveis;
	private PainelExibeHistoria painelHistoria;
	private ConjuntoBotoesMapa botoesMapa;
	private List<Integer> posicoesMapa;
	private int posicaoAtual;
	private PainelBatalha painelBatalha;
	private PainelBatalhaBoss painelBatalhaBoss;
	private ReproduzMusica musica;
	private PainelDistribuicaoPontos painelDistribuicaoPontos;
	private PainelFimDeJogo painelFimDeJogo;

  	public JanelaPrincipal() {
		iniciaMusicaMenuPrincipal();
		criaPainelLocalAtual();
		criaPainelStatusHeroi();
		criaPainelEscolhaInimigos();
		criaPainelOpcoes();
		criaPainelBotoesAuxilio();
		criaImagemMapa();
		criaBotoesMapa(Controle.getControle().getNumLocal());
		criaJanela();
	}

	private void paraMusica() {
		musica.paraMusica();
	}

	private void iniciaMusicaBatalha() {
		musica = new ReproduzMusica();
		musica.comecaMusica("resources" + File.separator + "sons" + File.separator + "SomBatalha.wav");
	}

	private void iniciaMusicaMenuPrincipal() {
		musica = new ReproduzMusica();
		musica.comecaMusica("resources" + File.separator + "sons" + File.separator + "SomMapa.wav");
	}

	private void criaPainelExibeHistoria() {
		painelHistoria = new PainelExibeHistoria();
		painelHistoria.setVisible(false);
		this.painelHistoria.adicionaAcaoBotaoFecharHistoria(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				painelHistoria.setVisible(false);
				getContentPane().remove(painelHistoria);
				imagemMapa.setVisible(false);
				getContentPane().remove(imagemMapa);
				readicionaComponentes();
			}
		});
		getContentPane().add(painelHistoria);
		atualizaBotoesMapa(botoesMapa.getLocalPersonagem());
		removeComponentesTela();
		imagemMapa.setVisible(true);
		getContentPane().add(imagemMapa);
		painelHistoria.setVisible(true);
	}

	private void criaPainelBotoesAuxilio() {
		this.painelBotoesAuxilio = new PainelBotoesAuxilo();
		this.painelBotoesAuxilio.adicionaAcaoBotaoHistoria(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				criaPainelExibeHistoria();
			}
		});
		getContentPane().add(painelBotoesAuxilio);
	}

	private void criaPainelOpcoes() {
		this.painelOpcoes = new PainelOpcoes();
		this.painelOpcoes.adicionaAcaoDistribuirPontos(new MouseListener() {
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// nada a fazer
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// nada a fazer
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				painelPontosDisponiveis.setVisible(false);
				getContentPane().remove(painelPontosDisponiveis);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Controle.getControle().atualizaNovosPontos();
				criaPainelPontosDisponiveis();
				painelPontosDisponiveis.setVisible(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				criaPainelDistribuiPontos();
				
			}
		});
		getContentPane().add(painelOpcoes);
	}

	private void criaPainelLocalAtual() {
		this.painelLocalAtual = new PainelLocalAtual();
		getContentPane().add(painelLocalAtual);
	}

	private void criaPainelStatusHeroi() {
		this.painelStatusHeroi = new PainelExibicaoStatus();
		getContentPane().add(painelStatusHeroi);
	}

	public void criaBotoesMapa(int localPersonagem){
		posicaoAtual = localPersonagem;
		posicoesMapa = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		botoesMapa = new ConjuntoBotoesMapa(localPersonagem);
		for (int i = 0; i < posicoesMapa.size(); i++) {
			botoesMapa.retornaBotaoLocal(i).setVisible(false);
			botoesMapa.adcionaAcaoBotao(i, criaMouseListenerBotoesMapa(i));
			getContentPane().add(botoesMapa.retornaBotaoLocal(i));
			botoesMapa.retornaBotaoLocal(i).setVisible(true);
		}

		getContentPane().remove(imagemMapa);
		getContentPane().add(imagemMapa);
	}

	private MouseListener criaMouseListenerBotoesMapa(int localMapa){
		return new MouseListener() {
			
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
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Controle.getControle().vaiParaLocal(localMapa);
					atualizaBotoesMapa(localMapa);
					atualizaDadosExibidos();
					criaPainelExibeHistoria();
				} catch (Exception e1) {
				}
			}

		};
	}

	private void atualizaBotoesMapa(int localMapa) {
		posicaoAtual = localMapa;
		for (int i = 0; i < posicoesMapa.size(); i++) {
			botoesMapa.retornaBotaoLocal(i).setVisible(false);
			getContentPane().remove(botoesMapa.retornaBotaoLocal(i));
		}
		criaBotoesMapa(localMapa);
	}

	private void criaPainelExibeInimigo(int posicao) {
		painelExibeInimigos = new PainelExibeInimigos(posicao);
		painelExibeInimigos.setVisible(false);
		getContentPane().add(painelExibeInimigos);
		atualizaBotoesMapa(botoesMapa.getLocalPersonagem());
	}

	private void criaPainelPontosDisponiveis(){
		painelPontosDisponiveis = new PainelPontosDisponiveis(606, 445);
		painelPontosDisponiveis.setVisible(false);
		getContentPane().add(painelPontosDisponiveis);
		getContentPane().remove(imagemMapa);
		getContentPane().add(imagemMapa);
	}

	private void criaPainelEscolhaInimigos() {
		this.painelEscolhaInimigos = new PainelLutarContra(Controle.getControle().getNomeInimigo(0), Controle.getControle().getNomeInimigo(1),
				Controle.getControle().getNomeInimigo(2));
		
		painelEscolhaInimigos.adicionaAcaoInimigo1(new MouseListener() {
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// nada a fazer
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// nada a fazer
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				painelExibeInimigos.setVisible(false);
				getContentPane().remove(painelExibeInimigos);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				criaPainelExibeInimigo(0);
				painelExibeInimigos.setVisible(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				criaPainelBatalha(0);
			}
		});
		painelEscolhaInimigos.adicionaAcaoInimigo2(new MouseListener() {
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// nada a fazer
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// nada a fazer
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				painelExibeInimigos.setVisible(false);
				getContentPane().remove(painelExibeInimigos);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				criaPainelExibeInimigo(1);
				painelExibeInimigos.setVisible(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				criaPainelBatalha(1);
			}
		});
		painelEscolhaInimigos.adicionaAcaoInimigo3(new MouseListener() {
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				//nada a fazer
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				//nada a fazer
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				painelExibeInimigos.setVisible(false);
				getContentPane().remove(painelExibeInimigos);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				criaPainelExibeInimigo(2);
				painelExibeInimigos.setVisible(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				criaPainelBatalha(2);
			}
		});
		getContentPane().add(painelEscolhaInimigos);
		
	}

	private void criaPainelDistribuiPontos(){
		painelPontosDisponiveis.setVisible(false);
		getContentPane().remove(painelPontosDisponiveis);
		removeComponentesTela();
		this.painelDistribuicaoPontos = new PainelDistribuicaoPontos();
		getContentPane().add(painelDistribuicaoPontos);
		painelDistribuicaoPontos.adicionaAcaoBotaoOk(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finalizaPainelDistribuicaoPontos();
			}
		});
	}

	private void criaPainelBatalha(int inimigo){
		paraMusica();
		iniciaMusicaBatalha();
		painelExibeInimigos.setVisible(false);
		getContentPane().remove(painelExibeInimigos);
		removeComponentesTela();
		Controle.getControle().criaBatalha(inimigo);
		if(Controle.getControle().isBoss()){
			this.painelBatalhaBoss = new PainelBatalhaBoss();
			getContentPane().add(painelBatalhaBoss);
			painelBatalhaBoss.adicionaAcaoBotaoOkFimBatalha(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					finalizaPainelBatalhaBoss();
				}
	
			});	
		}else{
			this.painelBatalha = new PainelBatalha();
			getContentPane().add(painelBatalha);
			painelBatalha.adicionaAcaoBotaoOkFimBatalha(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					finalizaPainelBatalha();
				}
	
			});
		}
		
	}
	
	private void finalizaPainelBatalhaBoss() {
		painelBatalhaBoss.setVisible(false);
		getContentPane().remove(painelBatalhaBoss);
		
		if (Controle.getControle().heroiVenceuBatalha()) {
			Controle.getControle().finalizaBatalhaComVitoria();
			painelFimDeJogo = new PainelFimDeJogo("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "FimJogoGanho.png");
		}else{
			Controle.getControle().finalizaBatalhaComDerrota();	
			painelFimDeJogo = new PainelFimDeJogo("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "FimJogoPerdido.png");
		}
		painelFimDeJogo.adicionaAcaoBotaoFechar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		add(painelFimDeJogo);
	}

	private void finalizaPainelBatalha() {
		if (Controle.getControle().heroiVenceuBatalha()) {
			Controle.getControle().finalizaBatalhaComVitoria();
		}else{
			if (Controle.getControle().heroiFugiuDaBatalha())
				Controle.getControle().finalizaBatalhaQueSeFugiu();
			else{
				Controle.getControle().finalizaBatalhaComDerrota();	
			}
		}
		painelBatalha.setVisible(false);
		getContentPane().remove(painelBatalha);
		readicionaComponentes();
		paraMusica();
		iniciaMusicaMenuPrincipal();
	}

	private void finalizaPainelDistribuicaoPontos() {
		painelDistribuicaoPontos.setVisible(false);
		getContentPane().remove(painelDistribuicaoPontos);
		readicionaComponentes();
	}

	private void criaImagemMapa() {
		imagemMapa = new JLabel();
		imagemMapa.setLocation(0, -18);
		imagemMapa.setSize(998, 699);
		imagemMapa.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "Mapa.png"));
		imagemMapa.setVisible(true);
		getContentPane().add(imagemMapa);
	}

	private void criaJanela() {
		this.setTitle("Tokens");
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(995, 689);
		setResizable(false);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void atualizaDadosExibidos(){
		painelEscolhaInimigos.setVisible(false);
		painelStatusHeroi.setVisible(false);
		painelLocalAtual.setVisible(false);
		getContentPane().remove(painelEscolhaInimigos);
		getContentPane().remove(painelStatusHeroi);
		getContentPane().remove(painelLocalAtual);
		criaPainelEscolhaInimigos();
		criaPainelStatusHeroi();
		criaPainelLocalAtual();
		getContentPane().remove(imagemMapa);
		getContentPane().add(imagemMapa);
	}

	private void removeComponentesTela(){
		painelEscolhaInimigos.setVisible(false);
		painelStatusHeroi.setVisible(false);
		painelLocalAtual.setVisible(false);
		painelBotoesAuxilio.setVisible(false);
		painelOpcoes.setVisible(false);
		getContentPane().remove(painelOpcoes);
		getContentPane().remove(painelBotoesAuxilio);
		getContentPane().remove(painelEscolhaInimigos);
		getContentPane().remove(painelStatusHeroi);
		getContentPane().remove(painelLocalAtual);
		for (int i = 0; i < posicoesMapa.size(); i++) {
			botoesMapa.retornaBotaoLocal(i).setVisible(false);
			getContentPane().remove(botoesMapa.retornaBotaoLocal(i));
		}
		imagemMapa.setVisible(false);
		getContentPane().remove(imagemMapa);
	}

	private void readicionaComponentes(){
		criaPainelLocalAtual();
		criaPainelStatusHeroi();
		criaPainelEscolhaInimigos();
		criaPainelOpcoes();
		criaPainelBotoesAuxilio();
		criaImagemMapa();
		criaBotoesMapa(posicaoAtual);
	}

}