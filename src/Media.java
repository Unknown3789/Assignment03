import java.io.BufferedWriter;

public abstract class Media {
    public enum MediaType {
        BOOK, MOVIE, SONG
    }

    protected int ID;
    protected MediaType type;
    protected String title;

    public MediaType GetType() {
        return type;
    }

    public abstract String GetDescription();

    public abstract void Serialize(BufferedWriter bw);

}