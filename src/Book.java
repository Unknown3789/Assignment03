import java.io.BufferedWriter;
import java.io.IOException;

public class Book extends Media {

    private long ISBN;

    // public Book(String ISBN)
    public Book(String iSBN) {

        type = Media.MediaType.BOOK;
    }

    @Override
    public String GetDescription() {

        return "Hey, I'm a book " + ISBN;
    }

    @Override
    public void Serialize(BufferedWriter writeFile) {

        try {
            writeFile.append(0 + "," + ISBN);
            writeFile.newLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
