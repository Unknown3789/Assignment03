import java.io.*;

public class MediaBackEnd {
    // Explicitly private variables. Explicitly private access modifiers - these
    // will need to be called by 'this.' for access. Declared Global Data types and
    // Classes.
    private Media[] media;
    private String filePath;
    private int maxMediaEntry;
    private int mediaCounter;

    // Constructor Class, this class contains all the constructors that will be
    // invoked to create the objects from this classes design.
    public MediaBackEnd() {
        // initialised filePath for hardcoded BufferedReading and BufferWriting.
        this.filePath = "mediaArchive.csv";
        this.mediaCounter = 0;
        // initializing Global Variables and declaring the variables.
        File file = new File(filePath);
        if (file.exists()) {
            fileReader();

        } else {
            media = new Media[13];
            maxMediaEntry = 13;
        }
        //discreetly expand max entries.
        expandMaxEntry();
    }

    // handles title search, uses boolean Result class to confirm match and index.
    // While utilsing a while loop to read the arrays, searching the tile. Possibly
    // better options would be foreach class, allowing loop to perform an action
    // over the loop , it is more convenient and concise then normal iterators.
    public Result SearchTitle(String title) {

        int i = 0;
        while (i < this.mediaCounter) {
            if (media[i].title != null) {
                if (media[i].title.equals(title)) {
                    return new Result(true, i);
                }
                i++;
            }
        }
        return new Result(false, i);
    }

    public boolean SearchTitle(Book tempBook) {
        return false;
    }

    // The File is called here as it only needs to be called once and
	// not again after the program is running.
	// BufferedReader is used over FileReader due to its efficiency in terms of
	// performance. BufferedReader IO operations are less and its performance is
	// better, reading in larger chunks over FileReader with reads directly from
	// File in smaller byte sized operations.
    public void fileReader() {

        BufferedReader reader = null;
        // Try and Catch utilised for exception catching for invalid BufferedReading.
        try {
            reader = new BufferedReader(new FileReader(this.filePath));
            String currentLine = reader.readLine();
            // Dyanmically set array size based on initial int in .csv, this set
            // Media[entries].
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
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }

    // Class object to add Book information. Parameters within class to
	// initialize attributes.
    public void addBookType(String title, int pageCount, long iSBN) {
        this.media[this.mediaCounter] = new Book(title, pageCount, iSBN);
        this.mediaCounter++;
    }

    // Class object to add Song information. Parameters within class to
	// initialize attributes.
    public void addSongType(String title, float length) {
        this.media[this.mediaCounter] = new Song(title, length);
        this.mediaCounter++;
    }

    // Class object to add Movie information. Parameters within class to
	// initialize attributes.
    public void addMovieType(String title, String director, float length, String comment) {
        this.media[this.mediaCounter] = new Movie(title, director, length, comment);
        this.mediaCounter++;
    }

    // Hardcoded BufferedWriter that re-writes the file after adding, editing or
	// deleting entries to keep the file up to date. False clause allows for File
	// overwriting.
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
            System.out.println("Error during file write: " + e.getMessage());
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
}
