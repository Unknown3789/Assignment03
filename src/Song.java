import java.io.*;

public class Song extends Media {

    private float lengthInSeconds;

    public Song(String title, float length) {
        super(title);
        
        lengthInSeconds = length;
        type = MediaType.SONG;
    }

    public float SongLengthInSeconds() {
        return lengthInSeconds;
    }

    @Override
    public String GetDescription() {

        return "Hey, I'm a song at " + lengthInSeconds + "seconds long.";
    }

    @Override
    public void Serialize(BufferedWriter writeFile) {

        try {
            writeFile.write(2 + "," + title + "," + lengthInSeconds);
            writeFile.newLine();
        } catch (IOException e) {

        }

    }

    public float getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(float lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }
    

}
