package interacaoUsuario;

import javax.swing.JOptionPane;

public class JanelasDeApoio {

	public String recebeTexto(String mensagem){
		return JOptionPane.showInputDialog(mensagem);
	}
	
	public void exibeMensagem(String mensagem){
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public int recebeIntComRestricao(String mensagem, int valorMinimo, int valorMaximo){
		
		
		boolean repetidor = false;
		int intRecebido = -1;
		
		do{
			String stringInt = JOptionPane.showInputDialog(mensagem);
			try {
				intRecebido = Integer.parseInt(stringInt);
				if(intRecebido >= valorMinimo && intRecebido <= valorMaximo){
					repetidor = false;
				}else{
					repetidor = true;
					this.exibeMensagem("O número digitado não atende aos parametros, favor tentar novamente.");
				}
			}catch (NumberFormatException nfe){
				this.exibeMensagem("Por favor digite apenas numeros");
				repetidor = true;
			}
				
		}while(repetidor);
	
		return intRecebido;
		
	}
	
}