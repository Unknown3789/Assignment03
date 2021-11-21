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

        return "Hey, I'm a Movie and my movie Time is " + length + "minutes long.";
    }

    @Override
    public void Serialize(BufferedWriter writeFile) {

        try {
            writeFile.append(1 + "," + title + "," + director + "," + length + "," + comment);
            writeFile.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
