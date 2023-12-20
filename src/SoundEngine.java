import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEngine {
    public static void playExplosion(){
        File audioFile = new File("src/resources/explosion.wav");
        if(audioFile.exists()){
            try {
                AudioInputStream audio = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
