package interacaoUsuario;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ReproduzMusica {

	private Clip clip;
	
	public void comecaMusica(String soundName) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			clip  = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.loop(100);
		} catch (Exception ex) {
			
		}
	}
	
	public void paraMusica(){
		clip.stop();
		clip.close();
	}
	
}