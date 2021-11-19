import java.io.BufferedWriter;
import java.io.IOException;

public class Movie extends Media {

    public Movie(String title, String director, float length, String comment){
        super(title);
        type = Media.MediaType.MOVIE;
    }

    @Override
    public String GetDescription() {

        return "Hey, I'm a Movie " ;
    }

    @Override
    public void Serialize(BufferedWriter writeFile) {

        try {
            writeFile.append(0 + ",");
            writeFile.newLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
