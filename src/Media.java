import java.io.*;

public abstract class Media {

    protected int ID;
    protected MediaType type;
    protected String title;

    public enum MediaType {
        BOOK, MOVIE, SONG
    }

    public Media(String title) {
        this.title = title;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public abstract String GetDescription();

    public abstract void Serialize(BufferedWriter bw);

}