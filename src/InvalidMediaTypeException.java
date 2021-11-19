public class InvalidMediaTypeException extends Exception {

    public InvalidMediaTypeException(String type) 
    {
        super("Invalid media type " + type);
    }
    
}
