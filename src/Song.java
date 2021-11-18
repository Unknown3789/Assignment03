import java.io.BufferedWriter;
import java.io.IOException;

public class Song extends Media {

    private float lengthInSeconds;

    public Song(float length) {
        lengthInSeconds = length;
        type = MediaType.SONG;
    }

    public float SongLengthInSeconds() {
        return lengthInSeconds;
    }

    @Override
    public String GetDescription() {

        return "Hey, I'm a song " + lengthInSeconds;
    }

    @Override
    public void Serialize(BufferedWriter writeFile) {

        try {
            writeFile.write(2 + "," + lengthInSeconds);
            writeFile.newLine();
        } catch (IOException e) {

        }

    }

}
