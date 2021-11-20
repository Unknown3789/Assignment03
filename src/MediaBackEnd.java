import java.io.*;

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
    }

    public Boolean SearchTitle(String title) {

        int i = 0;
        while (i < this.mediaCounter) {
            if (media[i].title != null) {
                if (media[i].title.equals(title)) {
                    return true;
                }
                i++;
            }
        }
        return false;
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
                    media[this.mediaCounter] = new Book(readMedia[1], Integer.parseInt(readMedia[2]),
                            Long.parseLong(readMedia[3].trim()));
                    this.mediaCounter++;
                } else if (readMedia[0].charAt(0) == '1') {
                    media[this.mediaCounter] = new Movie(readMedia[1], readMedia[2],
                            Float.parseFloat(readMedia[3].trim()), readMedia[4]);
                    this.mediaCounter++;
                } else if (readMedia[0].charAt(0) == '2') {
                    media[this.mediaCounter] = new Song(readMedia[1], Float.parseFloat(readMedia[2].trim()));
                    this.mediaCounter++;
                } else {
                    throw new InvalidMediaTypeException(readMedia[0]);
                }
                currentLine = reader.readLine();
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }

    public void addBookType(String title, int pageCount, long iSBN) {
        this.media[this.mediaCounter] = new Book(title, pageCount, iSBN);
        this.mediaCounter++;
    }

    public void addSongType(String title, float length) {
        this.media[this.mediaCounter] = new Song(title, length);
        this.mediaCounter++;
    }

    public void addMovieType(String title, String director, float length, String comment) {
        this.media[this.mediaCounter] = new Movie(title, director, length, comment);
        this.mediaCounter++;
    }

    public void saveFile(String fileName) {

        try {

            BufferedWriter writeToFile = new BufferedWriter(new FileWriter(fileName + ".csv"));
            writeToFile.write(this.mediaCounter + "\n");
            int i = 0;
            while (i < mediaCounter) {
                media[i].Serialize(writeToFile);
                i++;
            }
            System.out.println("Save Successful!");
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

    public boolean isDatabaseFull() {
        return this.mediaCounter >= this.maxMediaEntry;
    }

    // Getter and Setter explicitly public for accessible from everywhere.
    // Parameters within class to initialize attributes
    public int getMediaCounter() {
        return this.mediaCounter;
    }

    public Media[] getMedia() {
        return media;
    }

    public boolean SearchTitle(Book tempBook) {
        return false;
    }
}
