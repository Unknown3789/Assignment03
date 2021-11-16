import java.io.BufferedWriter;
import java.io.IOException;

public class Book extends Media {

    private String ISBN;

    public Book(String isbn)
    {
        ISBN = isbn;
        type = Media.MediaType.BOOK;
    }
    public String GetISBN()
    {
        return ISBN;
    }
   

    @Override
    public String GetDescrition() {

       
        return "Hey, I'm a book " + ISBN;
    }

    @Override
    public void Serialize(BufferedWriter writeFile) {
        
        try {
            writeFile.append(0 + "," + ISBN);
            writeFile.newLine();
        } catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
