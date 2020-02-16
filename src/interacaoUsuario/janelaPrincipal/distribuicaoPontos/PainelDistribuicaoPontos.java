package interacaoUsuario.janelaPrincipal.distribuicaoPontos;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controle.Controle;
import excecoes.ExcecaoMelhoriaNaoDisponivel;
import excecoes.ExcecaoSemPontos;
import interacaoUsuario.JanelasDeApoio;
import interacaoUsuario.janelaPrincipal.PainelPontosDisponiveis;

@SuppressWarnings("serial")
public class PainelDistribuicaoPontos extends JPanel{

	private JLabel imagemFundo;
	private PainelPontosDisponiveis painelPontosDisponiveis;
	private PainelExibeHeroi painelExibeHeroi;
	private JButton botaoOk;
	private JButton botaoReset;
	private List<JButton> conjuntoMelhoriasVida;
	private List<JButton> conjuntoMelhoriasAtaqueMagico;
	private List<JButton> conjuntoMelhoriasAtaqueFisico;
	private List<JButton> conjuntoMelhoriasDefesaMagica;
	private List<JButton> conjuntoMelhoriasDefesaFisica;
	private JanelasDeApoio apoio;
	
	public PainelDistribuicaoPontos(){
		setLayout(null);
		apoio = new JanelasDeApoio();
		criaBotaoOk();
		criaBotaoReset();
		criaPainelExibeHeroi();
		criaPainelPontosDisponiveis();
		criaTextFieldsDescricao();
		criaBotoesPontosDeDefesaFisica();
		criaBotoesPontosDeDefesaMagica();
		criaBotoesPontosDeAtaqueFisico();
		criaBotoesPontosDeAtaqueMagico();
		criaBotoesPontosDeVida();
		criaImagemPainel();
		setSize(995, 689);
		setLocation(0, 0);
		setVisible(true);
	}
	
	private void criaBotaoReset() {
		botaoReset = new JButton("Resetar pontos");
		botaoReset.setBounds(690, 156, 150, 24);
		botaoReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Controle.getControle().resetaPontos();
				atualizaPainelReset();
			}

		});
		add(botaoReset);
	}
	
	private void atualizaBasicoPainel(){
		painelPontosDisponiveis.setVisible(false);
		remove(painelPontosDisponiveis);
		painelExibeHeroi.setVisible(false);
		remove(painelExibeHeroi);	
		criaPainelExibeHeroi();
		criaPainelPontosDisponiveis();
		remove(imagemFundo);
		add(imagemFundo);
	}
	
	private void atualizaPainelReset() {
		for (int i = 0; i < 9; i++) {
			conjuntoMelhoriasVida.get(i).setVisible(false);
			conjuntoMelhoriasAtaqueFisico.get(i).setVisible(false);
			conjuntoMelhoriasAtaqueMagico.get(i).setVisible(false);
			conjuntoMelhoriasDefesaFisica.get(i).setVisible(false);
			conjuntoMelhoriasDefesaMagica.get(i).setVisible(false);
			remove(conjuntoMelhoriasVida.get(i));
			remove(conjuntoMelhoriasAtaqueFisico.get(i));
			remove(conjuntoMelhoriasAtaqueMagico.get(i));
			remove(conjuntoMelhoriasDefesaFisica.get(i));
			remove(conjuntoMelhoriasDefesaMagica.get(i));
		}
		criaBotoesPontosDeDefesaFisica();
		criaBotoesPontosDeDefesaMagica();
		criaBotoesPontosDeAtaqueFisico();
		criaBotoesPontosDeAtaqueMagico();
		criaBotoesPontosDeVida();
		atualizaBasicoPainel();
	}
	
	private void atualizaPainelEVida() {
		for (int i = 0; i < 9; i++) {
			conjuntoMelhoriasVida.get(i).setVisible(false);
			remove(conjuntoMelhoriasVida.get(i));
		}	
		criaBotoesPontosDeVida();
		atualizaBasicoPainel();
	}
	
	private void atualizaPainelEAtaqueFisico() {
		for (int i = 0; i < 9; i++) {
			conjuntoMelhoriasAtaqueFisico.get(i).setVisible(false);
			remove(conjuntoMelhoriasAtaqueFisico.get(i));
		}
		criaBotoesPontosDeAtaqueFisico();
		atualizaBasicoPainel();
	}
	
	private void atualizaPainelEAtaqueMagico(){
		for (int i = 0; i < 9; i++) {
			conjuntoMelhoriasAtaqueMagico.get(i).setVisible(false);
			remove(conjuntoMelhoriasAtaqueMagico.get(i));
		}
		criaBotoesPontosDeAtaqueMagico();
		atualizaBasicoPainel();
	}
	
	private void atualizaPainelEDefesaFisica() {
		for (int i = 0; i < 9; i++) {
			conjuntoMelhoriasDefesaFisica.get(i).setVisible(false);
			remove(conjuntoMelhoriasDefesaFisica.get(i));
		}
		criaBotoesPontosDeDefesaFisica();
		atualizaBasicoPainel();
	}
	
	private void atualizaPainelEDefesaMagica() {
		for (int i = 0; i < 9; i++) {
			conjuntoMelhoriasDefesaMagica.get(i).setVisible(false);
			remove(conjuntoMelhoriasDefesaMagica.get(i));
		}
		criaBotoesPontosDeDefesaMagica();
		atualizaBasicoPainel();
	}

	private void criaBotaoOk() {
		botaoOk = new JButton("ok");
		botaoOk.setBounds(315, 570, 140, 50);
		add(botaoOk);
	}

	private void criaPainelExibeHeroi() {
		painelExibeHeroi = new PainelExibeHeroi();
		add(painelExibeHeroi);
	}

	private void criaPainelPontosDisponiveis() {
		painelPontosDisponiveis = new PainelPontosDisponiveis(83, 545);
		add(painelPontosDisponiveis);
	}

	private void criaTextFieldsDescricao() {
		JTextField melhoriasVida = new JTextField("Melhorias de Vida");
		melhoriasVida.setEditable(false);
		melhoriasVida.setBounds(65, 175, 105, 24);
		this.add(melhoriasVida);
		
		JTextField melhoriasAtaque = new JTextField("Melhorias de Ataque");
		melhoriasAtaque.setEditable(false);
		melhoriasAtaque.setBounds(235, 130, 120, 24);
		this.add(melhoriasAtaque);
		
		JTextField fisico = new JTextField("Fisico");
		fisico.setEditable(false);
		fisico.setBounds(236, 175, 40, 24);
		this.add(fisico);
		
		JTextField magico = new JTextField("Magico");
		magico.setEditable(false);
		magico.setBounds(320, 175, 45, 24);
		this.add(magico);
		
		JTextField melhoriasDefesa = new JTextField("Melhorias de Defesa");
		melhoriasDefesa.setEditable(false);
		melhoriasDefesa.setBounds(463, 130, 120, 24);
		this.add(melhoriasDefesa);
		
		JTextField fisica = new JTextField("Fisica");
		fisica.setEditable(false);
		fisica.setBounds(463, 175, 40, 24);
		this.add(fisica);
		
		JTextField magica = new JTextField("Magica");
		magica.setEditable(false);
		magica.setBounds(552, 175, 45, 24);
		this.add(magica);
	}

	private void criaBotoesPontosDeDefesaMagica() {
		conjuntoMelhoriasDefesaMagica = new ArrayList<>();
		JButton botaoDefesaMagica;
		int posicaoY = 220;
		for (int i = 0; i < 9; i++) {
			botaoDefesaMagica = new JButton("+" + Controle.getControle().getMelhoriaDefesaMagica(i));
			botaoDefesaMagica.setBounds(537, posicaoY, 70, 24);
			botaoDefesaMagica.setEnabled(false);
			conjuntoMelhoriasDefesaMagica.add(botaoDefesaMagica);
			conjuntoMelhoriasDefesaMagica.get(i).addActionListener(criaAcaoBotaoDefesaMagica(i));
			add(conjuntoMelhoriasDefesaMagica.get(i));
			
			posicaoY += 32;
		}
		
	
		conjuntoMelhoriasDefesaMagica.get(0).setEnabled(true);
	}
	
	private void criaBotoesPontosDeDefesaFisica() {
		int posicaoY = 220;
		conjuntoMelhoriasDefesaFisica = new ArrayList<>();
		JButton botaoDefesaFisica;
		
		for (int i = 0; i < 9; i++) {
			botaoDefesaFisica = new JButton("+" + Controle.getControle().getMelhoriaDefesaFisica(i));
			botaoDefesaFisica.setBounds(448, posicaoY, 70, 24);
			botaoDefesaFisica.setEnabled(false);
			conjuntoMelhoriasDefesaFisica.add(botaoDefesaFisica);
			conjuntoMelhoriasDefesaFisica.get(i).addActionListener(criaAcaoBotaoDefesaFisica(i));
			add(conjuntoMelhoriasDefesaFisica.get(i));	
			
			posicaoY += 32;
		}
		conjuntoMelhoriasDefesaFisica.get(0).setEnabled(true);
	}

 	private void criaBotoesPontosDeAtaqueFisico() {
		conjuntoMelhoriasAtaqueFisico = new ArrayList<>();
		JButton botaoAtaqueFisico;
		int posicaoY = 220;
		for (int i = 0; i < 9; i++) {
			botaoAtaqueFisico = new JButton("+" + Controle.getControle().getMelhoriaAtaqueFisico(i));
			botaoAtaqueFisico.setBounds(221, posicaoY, 70, 24);
			botaoAtaqueFisico.setEnabled(false);
			conjuntoMelhoriasAtaqueFisico.add(botaoAtaqueFisico);
			conjuntoMelhoriasAtaqueFisico.get(i).addActionListener(criaAcaoBotaoAtaqueFisico(i));			
			add(conjuntoMelhoriasAtaqueFisico.get(i));
			
			posicaoY += 32;
		}
		
		conjuntoMelhoriasAtaqueFisico.get(0).setEnabled(true);
	}
	
	private void criaBotoesPontosDeAtaqueMagico() {
		conjuntoMelhoriasAtaqueMagico = new ArrayList<>();
		JButton botaoAtaqueMagico;
		int posicaoY = 220;
		for (int i = 0; i < 9; i++) {
			botaoAtaqueMagico = new JButton("+" + Controle.getControle().getMelhoriaAtaqueMagico(i));
			botaoAtaqueMagico.setBounds(310, posicaoY, 70, 24);
			botaoAtaqueMagico.setEnabled(false);
			conjuntoMelhoriasAtaqueMagico.add(botaoAtaqueMagico);
			conjuntoMelhoriasAtaqueMagico.get(i).addActionListener(criaAcaoBotaoAtaqueMagico(i));
			add(conjuntoMelhoriasAtaqueMagico.get(i));
			
			posicaoY += 32;
		}
		
		conjuntoMelhoriasAtaqueMagico.get(0).setEnabled(true);
	}

	private void criaBotoesPontosDeVida() {
		conjuntoMelhoriasVida = new ArrayList<>();
		JButton botaoVida;
		int posicaoY = 220;
		for (int i = 0; i < 9; i++) {
			botaoVida = new JButton("+" + Controle.getControle().getMelhoriaVida(i));
			botaoVida.setBounds(83, posicaoY, 70, 24);
			botaoVida.setEnabled(false);
			conjuntoMelhoriasVida.add(botaoVida);
			conjuntoMelhoriasVida.get(i).addActionListener(criaAcaoBotaoVida(i));
			add(conjuntoMelhoriasVida.get(i));
			posicaoY += 32;
		}
		conjuntoMelhoriasVida.get(0).setEnabled(true);		
	}

	private ActionListener criaAcaoBotaoVida(int i) {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Controle.getControle().setMelhoriaVida(i);
					Controle.getControle().atualizaNovosPontos();
					atualizaPainelEVida();
					conjuntoMelhoriasVida.get(0).setEnabled(false);
					conjuntoMelhoriasVida.get(i+1).setEnabled(true);
				} catch (ExcecaoMelhoriaNaoDisponivel | ExcecaoSemPontos e1) {
					apoio.exibeMensagem("Não é possivel adquirir esta melhoria");
				} catch (IndexOutOfBoundsException e2){
					
				}
			}
		};
	}
	
	private ActionListener criaAcaoBotaoAtaqueFisico(int i) {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Controle.getControle().setMelhoriaAtaqueFisico(i);
					Controle.getControle().atualizaNovosPontos();
					atualizaPainelEAtaqueFisico();
					conjuntoMelhoriasAtaqueFisico.get(0).setEnabled(false);
					conjuntoMelhoriasAtaqueFisico.get(i+1).setEnabled(true);
				} catch (ExcecaoMelhoriaNaoDisponivel | ExcecaoSemPontos e1) {
					apoio.exibeMensagem("Não é possivel adquirir esta melhoria");
				} catch (IndexOutOfBoundsException e2){
					
				}
			}
		};
	}
	
	private ActionListener criaAcaoBotaoAtaqueMagico(int i) {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Controle.getControle().setMelhoriaAtaqueMagico(i);
					Controle.getControle().atualizaNovosPontos();
					atualizaPainelEAtaqueMagico();
					conjuntoMelhoriasAtaqueMagico.get(0).setEnabled(false);
					conjuntoMelhoriasAtaqueMagico.get(i+1).setEnabled(true);
				} catch (ExcecaoMelhoriaNaoDisponivel | ExcecaoSemPontos e1) {
					apoio.exibeMensagem("Não é possivel adquirir esta melhoria");
				} catch (IndexOutOfBoundsException e2){
					
				}
			}
		};
	}
	
	private ActionListener criaAcaoBotaoDefesaFisica(int i) {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Controle.getControle().setMelhoriaDefesaFisica(i);
					Controle.getControle().atualizaNovosPontos();
					atualizaPainelEDefesaFisica();
					conjuntoMelhoriasDefesaFisica.get(0).setEnabled(false);
					conjuntoMelhoriasDefesaFisica.get(i+1).setEnabled(true);
				} catch (ExcecaoMelhoriaNaoDisponivel | ExcecaoSemPontos e1) {
					apoio.exibeMensagem("Não é possivel adquirir esta melhoria");
				} catch (IndexOutOfBoundsException e2){
					
				}
			}
		};
	}
	
	private ActionListener criaAcaoBotaoDefesaMagica(int i) {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Controle.getControle().setMelhoriaDefesaMagica(i);
					Controle.getControle().atualizaNovosPontos();
					atualizaPainelEDefesaMagica();
					conjuntoMelhoriasDefesaMagica.get(0).setEnabled(false);
					conjuntoMelhoriasDefesaMagica.get(i+1).setEnabled(true);
				} catch (ExcecaoMelhoriaNaoDisponivel | ExcecaoSemPontos e1) {
					apoio.exibeMensagem("Não é possivel adquirir esta melhoria");
				} catch (IndexOutOfBoundsException e2){
					
				}
			}
		};
	}

	private void criaImagemPainel() {
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator + "DistribuicaoPontos.png"));
		imagemFundo.setBounds(new Rectangle(0, 0, 995, 689));
		imagemFundo.setVisible(true);
		add(imagemFundo);
	}
	
	public void adicionaAcaoBotaoOk(ActionListener acao){
		botaoOk.addActionListener(acao);
	}
	
}