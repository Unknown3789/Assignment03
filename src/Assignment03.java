public class Assignment03 {

    private MediaBackEnd mediaBackEnd;
    private MediaFrontEnd mediaFrontEnd;

    public Assignment03() {
        this.mediaBackEnd = new MediaBackEnd();
        this.mediaFrontEnd = new MediaFrontEnd(this.mediaBackEnd);
    }

    public static void main(String[] args) {
        Assignment03 startUp = new Assignment03();
    }
}