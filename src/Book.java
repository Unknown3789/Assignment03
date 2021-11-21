import java.io.*;

public class Book extends Media {

    private long ISBN;
    private int pageCount;

    public Book(String title, int pageCount, long isbn) {
        super(title);
        this.ISBN = isbn;
        this.pageCount = pageCount;
        type = Media.MediaType.BOOK;
    }

    @Override
    public String GetDescription() {

        return "Hey, I'm a book and this is my ISBN:  " + ISBN;
    }

    @Override
    public void Serialize(BufferedWriter writeFile) {

        try {
            writeFile.append(0 + "," + title + "," + pageCount + "," + ISBN);
            writeFile.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long iSBN) {
        ISBN = iSBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
