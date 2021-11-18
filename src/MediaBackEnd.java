import java.io.BufferedReader;
import java.io.FileReader;

public class MediaBackEnd {

    private Media[] media;
    private String filePath;
    private int mediaCounter;

    public MediaBackEnd() {

        this.filePath = "Test.csv";

        this.media = new Media[2];

        this.media[0] = new Book("Unknown");
        this.media[1] = new Song(0f);
        // this.media[3] = new Game("Unknown");

        int i = 0;
        while (i < this.media.length) {
            if (this.media[i].GetType() == Media.MediaType.BOOK) {
                this.media[i] = new Book("isbn");
            } else if (this.media[i].GetType() == Media.MediaType.SONG) {
                this.media[i] = new Song(0);
            }
            i++;
        }

        this.mediaCounter = 0;

       /*  for (int i = 0; i < media.length; i++) {
            // System.out.println(media[i].GetDescrition());
            if (media[i].GetType() == Media.MediaType.BOOK) {
                System.out.println("Book isbn " + ((Book) media[i]).GetISBN());
            } else if (media[i].GetType() == Media.MediaType.SONG) {
                System.out.println("Song length" + ((Song) media[i]).SongLengthInSeconds());
            }
        } */

       /*  try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Test.csv")));
            for (int i = 0; i < this.media.length; i++) {
                this.media[i].Serialize(bw);
            }
            bw.close();
        } catch (IOException e) {

            e.printStackTrace();
        } */
        // 0, Author, ISBN
        // 2, Author, title, LEngth

        /*
         * System.out.println("What media you want?\n1 - Book\n2 - Song\n3 - Movie");
         * Scanner scan = new Scanner(System.in); int choice = scan.nextInt();
         * 
         * if(choice == 1) { for(int i=0; i< media.length; i++) { if(media[i].GetType()
         * == Media.MediaType.BOOK) {
         * 
         * } } }
         */

    }

    public void fileReader() {

		BufferedReader reader = null;
		// Try and Catch utilised for exception catching for invalid BufferedReading.
		try {
			reader = new BufferedReader(new FileReader(this.filePath));
			String currentLine = reader.readLine();

			if (currentLine != null && !currentLine.equals("")) {
				currentLine = reader.readLine();
				// While Loop works well in this example over a for loop, as conditions are
				// being utilised instead of counters.
				while (currentLine != null && !currentLine.equals("")) {
					String[] readMedia = currentLine.split(",");
					//this.media(Integer.parseInt(readMedia[0]), readMedia[1], Long.parseLong(readMedia[2]));
					currentLine = reader.readLine();
				}
			}
			reader.close();

		} catch (Exception e) {
			System.out.println("");
			String errorMessage = "Error: Nothing Entered";
			System.out.println(errorMessage);

		}
	}
    
    public void readMediaData(){

    }
   

}
