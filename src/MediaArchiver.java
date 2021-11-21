public class MediaArchiver {

    private MediaBackEnd mediaBackEnd;
    private MediaFrontEnd mediaFrontEnd;

    public MediaArchiver() {
        this.mediaBackEnd = new MediaBackEnd();
        this.mediaFrontEnd = new MediaFrontEnd(this.mediaBackEnd);
    }

    public static void main(String[] args) {
        MediaArchiver startUp = new MediaArchiver();
    }
}