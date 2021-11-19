import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MediaBackEnd {

    private Media[] media;
    private String filePath;
    private int mediaCounter;

    public MediaBackEnd() {

        this.filePath = "Test.csv";
        this.mediaCounter = 0;
        
        File file = new File(filePath);
        if(file.exists())
        {
            fileReader();

        }
        else
        {
            media = new Media[10];
        }




         for (int i = 0; i < media.length; i++) {
           System.out.println(media[i].GetDescription());
        } 

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
            
            int entreis = Integer.parseInt(currentLine);
            this.media = new Media[entreis];
            
           
            currentLine = reader.readLine();
			while (currentLine != null && !currentLine.equals("")) {
                String[] readMedia = currentLine.split(",");

               if(readMedia[0].charAt(0) == '0')
               {
                   media[mediaCounter] = new Book(Long.parseLong(readMedia[1])); 
                   mediaCounter++;
               }
               else if(readMedia[0].charAt(0) == '2')
               {
                   media[mediaCounter] = new Song(Float.parseFloat(readMedia[1]));
                   mediaCounter++;
               }
                currentLine = reader.readLine();
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
