package interacaoUsuario.janelaPrincipal.batalha;

import java.awt.Rectangle;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controle.Controle;

@SuppressWarnings("serial")
public class LabelExibePersonagensBatalha extends JLabel {

	public LabelExibePersonagensBatalha() {
		setLayout(null);
		adicionaImagemHeroi();
		adicionaFundoImagemHeroi();
		adicionaToStringHeroi();
		adicionaFundoToStringHeroi();
		adicionaBarraVidaTotalHeroi();
		adicionaBarraVidaPerdidaHeroi();
		adcionaLabelImagemVs();
		adicionaImagemInimigo();
		adicionaFundoImagemInimigo();
		adicionaToStringInimigo();
		adicionaFundoToStringInimigo();
		adicionaBarraVidaTotalInimigo();
		adicionaBarraVidaPerdidaInimigo();
		
		setSize(984, 273);
		setLocation(9, 353);
		setVisible(true);
	}

	private void adicionaBarraVidaTotalInimigo() {
		JLabel imagemVidaTotalHeroi = new JLabel();
		imagemVidaTotalHeroi.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal"
				+ File.separator + "batalha" + File.separator + "BarraVidaTotal.png"));
		imagemVidaTotalHeroi.setBounds(new Rectangle(543, 52, Controle.getControle().porcentagemVidaInimigoEmBatalha(), 27));
		imagemVidaTotalHeroi.setVisible(true);
		add(imagemVidaTotalHeroi);
	}

	private void adicionaBarraVidaTotalHeroi() {
		JLabel imagemVidaTotalHeroi = new JLabel();
		imagemVidaTotalHeroi.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal"
				+ File.separator + "batalha" + File.separator + "BarraVidaTotal.png"));
		imagemVidaTotalHeroi.setBounds(new Rectangle(225, 52, Controle.getControle().porcentagemVidaHeroiEmBatalha(), 27));
		imagemVidaTotalHeroi.setVisible(true);
		add(imagemVidaTotalHeroi);
	}

	private void adicionaBarraVidaPerdidaInimigo() {
		JLabel imagemVidaPerdidaInimigo = new JLabel();
		imagemVidaPerdidaInimigo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal"
				+ File.separator + "batalha" + File.separator + "BarraVidaPerdida.png"));
		imagemVidaPerdidaInimigo.setBounds(new Rectangle(543, 52, 215, 27));
		imagemVidaPerdidaInimigo.setVisible(true);
		add(imagemVidaPerdidaInimigo);
	}

	private void adicionaBarraVidaPerdidaHeroi() {
		JLabel imagemVidaPerdidaHeroi = new JLabel();
		imagemVidaPerdidaHeroi.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal"
				+ File.separator + "batalha" + File.separator + "BarraVidaPerdida.png"));
		imagemVidaPerdidaHeroi.setBounds(new Rectangle(225, 52, 215, 27));
		imagemVidaPerdidaHeroi.setVisible(true);
		add(imagemVidaPerdidaHeroi);
	}

	private void adicionaFundoToStringInimigo() {
		JLabel imagemFundoImagemHeroi = new JLabel();
		imagemFundoImagemHeroi.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal"
				+ File.separator + "batalha" + File.separator + "FundoStatusBatalha.png"));
		imagemFundoImagemHeroi.setBounds(new Rectangle(545, 80, 215, 190));
		imagemFundoImagemHeroi.setVisible(true);
		add(imagemFundoImagemHeroi);
	}

	private void adicionaToStringInimigo() {
		JLabel textoInimigo = new JLabel(Controle.getControle().getToStringInimigoEmBatalha());
		textoInimigo.setBounds(557, 85, 190, 180);
		add(textoInimigo);
	}

	private void adicionaFundoImagemInimigo() {
		JLabel imagemFundoImagemHeroi = new JLabel();
		imagemFundoImagemHeroi.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal"
				+ File.separator + "batalha" + File.separator + "FundoImagemBatalha.png"));
		imagemFundoImagemHeroi.setBounds(new Rectangle(760, 0, 216, 273));
		imagemFundoImagemHeroi.setVisible(true);
		add(imagemFundoImagemHeroi);
	}

	private void adicionaImagemInimigo() {
		JLabel imagemInimigo = new JLabel();
		imagemInimigo.setBounds(772, 14, 191, 243);
		imagemInimigo.setIcon(new ImageIcon("resources" + File.separator + "imagensInimigos" + File.separator
				+ Controle.getControle().getImagemInimigoBatalha()));
		imagemInimigo.setVisible(true);
		add(imagemInimigo);
	}

	private void adcionaLabelImagemVs() {
		JLabel imagemVs = new JLabel();
		imagemVs.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator
				+ "batalha" + File.separator + "Vs.png"));
		imagemVs.setBounds(new Rectangle(445, 100, 84, 125));
		imagemVs.setVisible(true);
		add(imagemVs);
	}

	private void adicionaFundoToStringHeroi() {
		JLabel imagemFundoImagemHeroi = new JLabel();
		imagemFundoImagemHeroi.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal"
				+ File.separator + "batalha" + File.separator + "FundoStatusBatalha.png"));
		imagemFundoImagemHeroi.setBounds(new Rectangle(223, 80, 215, 190));
		imagemFundoImagemHeroi.setVisible(true);
		add(imagemFundoImagemHeroi);
	}

	private void adicionaFundoImagemHeroi() {
		JLabel imagemFundoImagemHeroi = new JLabel();
		imagemFundoImagemHeroi.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal"
				+ File.separator + "batalha" + File.separator + "FundoImagemBatalha.png"));
		imagemFundoImagemHeroi.setBounds(new Rectangle(0, 0, 216, 273));
		imagemFundoImagemHeroi.setVisible(true);
		add(imagemFundoImagemHeroi);
	}

	private void adicionaToStringHeroi() {
		JLabel textoInimigo = new JLabel(Controle.getControle().getToStringHeroi());
		textoInimigo.setBounds(235, 94, 190, 180);
		add(textoInimigo);
	}

	private void adicionaImagemHeroi() {
		JLabel imagemInimigo = new JLabel();
		imagemInimigo.setBounds(12, 14, 191, 243);
		imagemInimigo.setIcon(new ImageIcon("resources" + File.separator + "imagensJanelaPrincipal" + File.separator
				+ "batalha" + File.separator + "Heroi.png"));
		imagemInimigo.setVisible(true);
		add(imagemInimigo);
	}

}