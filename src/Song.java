public class Song extends Media {


    public Song(float length)
    {
        lengthInSeconds = length;
        type = MediaType.SONG;
    }
    private float lengthInSeconds;

    public float SongLengthInSeconds()
    {
        return lengthInSeconds;
    }

    @Override
    public String GetDescrition() {
       
        return "Hey, I'm a song " + lengthInSeconds;
    }
    
}
