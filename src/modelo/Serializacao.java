package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import modelo.fabricaInimigos.InimigosParaJogo;

@SuppressWarnings("serial")
public class Serializacao implements Serializable{

	public FachadaModelo carregaDados() {
		FachadaModelo fachada;
		try {
			FileInputStream in = new FileInputStream("resources" + File.separator + "Dados");
			ObjectInputStream objIn = new ObjectInputStream(in);

			fachada = (FachadaModelo) objIn.readObject();

			in.close();
			objIn.close();
			
			in = new FileInputStream("resources" + File.separator + "DadosInimigos");
			objIn = new ObjectInputStream(in);
			
			InimigosParaJogo.getInimigosParaJogo().setInimigos((InimigosParaJogo) objIn.readObject());
			
			in.close();
			objIn.close();
			
			return fachada;
		} catch (Exception e) {
			return fachada = new FachadaModelo();
		}

	}

	public void salvaArquivo(FachadaModelo fachada) {
		try {
			
			
			FileOutputStream out = new FileOutputStream("resources" + File.separator + "Dados");
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			
			objOut.writeObject(fachada);
			out.close();
			objOut.close();
			
			out = new FileOutputStream("resources" + File.separator + "DadosInimigos");
			objOut = new ObjectOutputStream(out);
			
			objOut.writeObject(InimigosParaJogo.getInimigosParaJogo());
			
			out.close();
			objOut.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}

	
	}

}