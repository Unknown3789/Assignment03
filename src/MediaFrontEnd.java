import java.io.*;
//import Media.MediaType;

public class MediaFrontEnd {

    private MediaBackEnd mediaBackEnd;
    private BufferedReader inputScanner;

    public MediaFrontEnd(MediaBackEnd mediaBackEnd) {

        this.mediaBackEnd = mediaBackEnd;

        System.out.println("Media Archiver!");
        System.out.println("");
        System.out.println("A Light and Easy Application to store Media Titles!");
        System.out.println("");
        System.out.println(" ___________________________________________________________");
        String readFileName = systemInput("| Welcome! Please make your Selection:                      |");
        // While loop will cycle through until user has confirmed a selection.
        while (readFileName.equals("") || !readFileName.equalsIgnoreCase("exit")) {
            readFileName = systemInput("\n" + "Please make a Selection: ");
        }
    }

    public String systemInput(String userPrompts) {
        this.mediaBackEnd.expandMaxEntry();
        String systemInput = null;
        // Try and Catch utilised for exception catching for invalid BufferedReading.
        try {
            if (this.inputScanner == null)
                this.inputScanner = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(userPrompts);

            System.out.println(" ___________________________________________________________");
            System.out.println("| [0] View Media Entries                                    |");
            System.out.println("| [1] Search for Title Entry >> Must be exact Title name << |");
            System.out.println("| [2] Add a Media Record                                    |");
            System.out.println("| [3] Save a Book Entry                                     |");
            System.out.println("| [exit] Exit                                               |");
            System.out.println(" ___________________________________________________________");
            System.out.println("");
            systemInput = this.inputScanner.readLine();
            // if else statments for user inputs, Switch Statments would be more efficent
            // and readable for menus.
            if (systemInput.equals("0")) {
                this.viewMediaTable();
            } else if (systemInput.equals("1")) {
                this.searchTitle();
            } else if (systemInput.equals("2")) {
                this.addMedia();
            } else if (systemInput.equals("3")) {
                this.mediaBackEnd.saveFile("mediaArchive");
            } else if (systemInput.equalsIgnoreCase("exit")) {
                System.out.println("");
                System.out.println(">>TTYL, Good Bye<<");
            }

        } catch (Exception e) {
            // Throws format exception if nothing or incorrect primitive type is entered.
            System.out.println("Incorrect Input has been Entered: " + e.getMessage());

        }
        // Will repeat functions until conditions are met, from above selection.
        return systemInput;

    }

    // Formatted Table Views for each media class, break the objects up for
    // readability.
    public void viewMediaTable() {
        System.out.println("");
        System.out.println("Which Media would you like to See?");
        System.out.println(">> Press [1] to view Books");
        System.out.println(">> Press [2] to view Movies");
        System.out.println(">> Press [3] to View Songs");
        System.out.println(">> Press Enter to Return to Menu <<");
        System.out.println("");

        try {
            String tableInput = this.inputScanner.readLine();
            if (tableInput.equals("1")) {
                // System.out.format class is used to trim whitespace and format the objexgt
                // variables into rows and columns.
                String leftAlignFormat = "| %-20s| %-19s | %-13s|%n";

                System.out.format("+---------------------+---------------------+--------------+%n");
                System.out.format("| Book Title          | Book Page Number    | iSBN         |%n");
                System.out.format("+---------------------+---------------------+--------------+%n");

                int i = 0;
                while (i < this.mediaBackEnd.getMediaCounter()) {
                    if (this.mediaBackEnd.getMedia()[i].getType() == Media.MediaType.BOOK) {
                        Book temp = ((Book) this.mediaBackEnd.getMedia()[i]);
                        System.out.format(leftAlignFormat, temp.title, temp.getPageCount(), temp.getISBN());
                    }
                    i++;
                }
                System.out.format("+---------------------+---------------------+--------------+%n");
                System.out.println("");
                System.out.println("");

            } else if (tableInput.equals("2")) {
                String leftAlignFormat = "| %-20s| %-19s | %-13s| %-36s|%n";

                System.out.format(
                        "+---------------------+---------------------+--------------+-------------------------------------+%n");
                System.out.format(
                        "| Movie Title         | Movie Director      | Movie Length | Movie Description                   |%n");
                System.out.format(
                        "+---------------------+---------------------+--------------+-------------------------------------+%n");

                int i = 0;
                while (i < this.mediaBackEnd.getMediaCounter()) {
                    if (this.mediaBackEnd.getMedia()[i].getType() == Media.MediaType.MOVIE) {
                        Movie temp = ((Movie) this.mediaBackEnd.getMedia()[i]);
                        System.out.format(leftAlignFormat, temp.title, temp.getDirector(), temp.getLength(),
                                temp.getComment());
                    }
                    i++;
                }
                System.out.format(
                        "+---------------------+---------------------+--------------+-------------------------------------+%n");
                System.out.println("");
                System.out.println("");
            } else if (tableInput.equals("3")) {
                String leftAlignFormat = "| %-20s| %-21s |%n";

                System.out.format("+---------------------+-----------------------+%n");
                System.out.format("| Song Title          | Song Length in Seconds|%n");
                System.out.format("+---------------------+-----------------------+%n");

                int i = 0;
                while (i < this.mediaBackEnd.getMediaCounter()) {
                    if (this.mediaBackEnd.getMedia()[i].getType() == Media.MediaType.SONG) {
                        Song temp = ((Song) this.mediaBackEnd.getMedia()[i]);
                        System.out.format(leftAlignFormat, temp.title, temp.getLengthInSeconds());
                    }
                    i++;
                }
                System.out.format("+---------------------+-----------------------+%n");

                System.out.println("");
                System.out.println("");
            }

        } catch (IOException e) {
            System.out.println("Something Unexpected happen? Please contact IT: " + e.getMessage());
            ;
        }

    }

    // add<edia method to add additional Media Objects.
    public void addMedia() throws InvalidMediaTypeException {

        System.out.println("");
        System.out.println("What type of Media do you want to Create?");
        System.out.println(">> Press [1] for Book Entry <<");
        System.out.println(">> Press [2] for Song Entry <<");
        System.out.println(">> Press [3] for Movie Entry <<");

        try {
            String userInput = this.inputScanner.readLine();
            // If elseif used here, Switch statments would be more effective in this case
            // due to better performance and less condition checks are needed. User is only
            // selecting an option no need for condtion checks.
            if (userInput.equals("1")) {
                int i = 0;
                Book tempBook = ((Book) this.mediaBackEnd.getMedia()[i]);

                System.out.println("Please Enter Your Title:" + "\n");
                String title = this.inputScanner.readLine();
                if (!this.mediaBackEnd.SearchTitle(title).isMatch()) {
                    System.out.println("Please Enter the Page Count: " + "\n");
                    int pageCount = Integer.parseInt(this.inputScanner.readLine());
                    System.out.println("PLease Enter the ISBN: " + "\n");
                    long iSBN = Long.parseLong(this.inputScanner.readLine());
                    System.out.println("");
                    System.out.println("############################");
                    System.out.println("Adding Your Title deets.....");
                    ((MediaBackEnd) this.mediaBackEnd).addBookType(title, pageCount, iSBN);
                    System.out.println("Book Title Added");
                    this.saveFile();

                } else if (this.mediaBackEnd.SearchTitle(tempBook.title).isMatch()) {
                    System.out.println("That Book Title Already Added!");

                }

            } else if (userInput.equals("2")) {
                int i = 2;
                Song tempSong = ((Song) this.mediaBackEnd.getMedia()[i]);

                System.out.println("Please Enter the Song Title:" + "\n");
                String title = this.inputScanner.readLine();
                if (!this.mediaBackEnd.SearchTitle(title).isMatch()) {
                    System.out.println("Please Enter the Song Length in Seconds: " + "\n");
                    float length = Float.parseFloat(this.inputScanner.readLine());
                    System.out.println("");
                    System.out.println("############################");
                    System.out.println("Adding Your Title deets.....");
                    ((MediaBackEnd) this.mediaBackEnd).addSongType(title, length);
                    System.out.println("Song Title Added");
                    this.saveFile();

                } else if (this.mediaBackEnd.SearchTitle(tempSong.title).isMatch()) {
                    System.out.println("That Song Already Exists!");

                }

            } else if (userInput.equals("3")) {
                int i = 1;
                Movie tempMovie = ((Movie) this.mediaBackEnd.getMedia()[i]);

                System.out.println("Please Enter the Movie Title:" + "\n");
                String title = this.inputScanner.readLine();
                if (!this.mediaBackEnd.SearchTitle(title).isMatch()) {
                    System.out.println("Please Enter the Directors Name: " + "\n");
                    String directName = this.inputScanner.readLine();
                    System.out.println("Please Enter the Movie length in Minutes: " + "\n");
                    float length = Float.parseFloat(this.inputScanner.readLine());
                    System.out.println("");
                    System.out.println("Please Enter the Movie Description: " + "\n");
                    String movieComment = this.inputScanner.readLine();
                    System.out.println("");
                    System.out.println("############################");
                    System.out.println("Adding Your Title deets.....");
                    ((MediaBackEnd) this.mediaBackEnd).addMovieType(title, directName, length, movieComment);
                    System.out.println("Movie Title Added");
                    System.out.println("");
                    this.saveFile();

                } else if (this.mediaBackEnd.SearchTitle(tempMovie.title).isMatch()) {
                    System.out.println("That Movie Already Exists!");
                }
            }

        } catch (IOException e) {
            System.out.println("");
            throw new InvalidMediaTypeException("Incorrect Media Type Entered!");
        }
    }

    // saveFile method allows user to save a user defined File.
    public void saveFile() {
        System.out.println("");
        System.out.println("Would you like to Save this file?");
        System.out.println(">> Press [1] for YES");
        System.out.println(">> Press [2] for NO");
        System.out.println("");

        try {
            String saveInput = this.inputScanner.readLine();

            if (saveInput.equals("1")) {
                System.out.println("Please enter the name of the file");
                String fileName = inputScanner.readLine();
                this.mediaBackEnd.saveFile(fileName);
            } else if (saveInput.equals("2")) {
                System.out.println("Not Saved...");
            }

        } catch (IOException e) {
            System.out.println("System Erroring while saving....");
            System.out.println(e.getMessage());
        }
    }

    // searchTitle uses backEnd handling to match the media to the index allowing
    // user to request correct Title.
    public void searchTitle() {

        System.out.println("Please enter Title");
        String title;
        try {
            title = this.inputScanner.readLine().toString();
            Result result = this.mediaBackEnd.SearchTitle(title);

            if (result.isMatch()) {
                System.out.println("Record Found: " + title + " - "
                        + this.mediaBackEnd.getMedia()[result.getIndex()].GetDescription());
            } else
                System.out.println("No record Found.....");

        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }

    }

    // Boolean method to check array size.
    public boolean isDatabaseFull() {
        this.mediaBackEnd.isDatabaseFull();
        return false;
    }

}
