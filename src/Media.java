import java.io.*;

public abstract class Media {

    protected int ID;
    protected MediaType type;
    protected String title = null;

    public enum MediaType {
        BOOK, MOVIE, SONG
    }

    public abstract String GetDescription();

    public abstract void Serialize(BufferedWriter bw);

    public Media(String title) {
        this.title = title;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getTitle() {
        return title;
    }

    public boolean setTitle(String title) {
        this.title = title;
        return false;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

}