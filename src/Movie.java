import java.io.*;

public class Movie extends Media {

    private String director;
    private float length;
    private String comment;

    public Movie(String title, String director, float length, String comment) {

        super(title);
        this.director = director;
        this.length = length;
        this.comment = comment;
        type = Media.MediaType.MOVIE;
    }

    @Override
    public String GetDescription() {

        return title + director + length + comment;
    }

    @Override
    public void Serialize(BufferedWriter writeFile) {

        try {
            writeFile.append(0 + "," + title + "," + length + comment);
            writeFile.newLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
