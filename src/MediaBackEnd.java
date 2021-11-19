import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MediaBackEnd {

    private Media[] media;
    private String filePath;
    private int maxMediaEntry;
    private int mediaCounter;

    public MediaBackEnd() {

        this.filePath = "Test.csv";
        this.mediaCounter = 0;

        File file = new File(filePath);
        if (file.exists()) {
            fileReader();

        } else {
            media = new Media[10];
            maxMediaEntry = 10;
        }
        expandMaxEntry();
        // System.out.println("Counter " + mediaCounter);
        // media[mediaCounter] = new Book("asdasd", 88888888);
        // for (int i = 0; i < media.length; i++) {
        //     if (media[i] != null) {
        //         System.out.println(media[i].GetDescription());

        //     }
        // }
    }

    public void fileReader() {

        BufferedReader reader = null;
        // Try and Catch utilised for exception catching for invalid BufferedReading.
        try {
            reader = new BufferedReader(new FileReader(this.filePath));
            String currentLine = reader.readLine();

            int entries = Integer.parseInt(currentLine);
            this.media = new Media[entries];
            maxMediaEntry = entries;

            currentLine = reader.readLine();
            while (currentLine != null && !currentLine.equals("")) {
                String[] readMedia = currentLine.split(",");

                if (readMedia[0].charAt(0) == '0') {
                    media[this.mediaCounter] = new Book(readMedia[1], Long.parseLong(readMedia[2].trim()));
                    this.mediaCounter++;
                } else if (readMedia[0].charAt(0) == '1') {
                    media[this.mediaCounter] = new Movie(readMedia[1], readMedia[2], Float.parseFloat(readMedia[3]),
                            readMedia[4]);
                    this.mediaCounter++;
                } else if (readMedia[0].charAt(0) == '2') {
                    media[this.mediaCounter] = new Song(readMedia[1], Float.parseFloat(readMedia[2].trim()));
                    this.mediaCounter++;
                } else {
                    throw new InvalidMediaTypeException(readMedia[0]);
                }
                currentLine = reader.readLine();
                reader.close();
            }

        } catch (Exception e) {

            System.out.println("Error while reading file: " + e.getMessage());
        }
    }

    
    public void saveFile(String fileName) {

        try {

            BufferedWriter writeToFile = new BufferedWriter(new FileWriter(fileName + ".csv", true));
            writeToFile.write(this.mediaCounter);
            int i = 0;
            while (i < mediaCounter) {
                media[i].Serialize(writeToFile);
            }
            writeToFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void expandMaxEntry() {

        Media[] temp = new Media[this.maxMediaEntry + 1];
        int j = 0;
        while (j < media.length) {
            temp[j] = media[j];
            j++;
        }
        this.maxMediaEntry++;
        media = temp;
    }

    // Getter and Setter explicitly public for accessible from everywhere.
    // Parameters within class to initialize attributes
    public int getMediaCounter() {
        return this.mediaCounter;
    }

    public Media[] getMedia() {
        return media;
    }

}
