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
    
}
