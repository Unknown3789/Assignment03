import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MediaFrontEnd {

    private MediaBackEnd mediaBackEnd;
    private BufferedReader inputScanner;

    public MediaFrontEnd(MediaBackEnd mediaBackEnd) {

        // Initialized variables to allow them to be called with 'this.'.
        this.mediaBackEnd = mediaBackEnd;

        System.out.println("Best Reads!");
        System.out.println("");
        System.out.println("A Light and Easy Application to explore reviewed Novels!");
        System.out.println("");
        System.out.println(" ___________________________________________________________");
        String readFileName = systemInput("| Welcome! Please make your Selection:                      |");
        while (readFileName.equals("") || !readFileName.equalsIgnoreCase("exit")) {
            readFileName = systemInput("\n" + "Please make a Selection: ");
        }
        // this.mediaBackEnd.saveFile();
    }

    public String systemInput(String userPrompts) {

        String systemInput = null;
        // Try and Catch utilised for exception catching for invalid BufferedReading.
        try {
            if (this.inputScanner == null)
                this.inputScanner = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(userPrompts);

            System.out.println(" ___________________________________________________________");
            System.out.println("| [0] View Book Entries                                     |");
            System.out.println("| [1] Search for Book Entry >> Must be exact Title name <<  |");
            System.out.println("| [2] Add a Book Title                                      |");
            System.out.println("| [3] Edit a Book Entry                                     |");
            System.out.println("| [4] Delete a Book Entry                                   |");
            System.out.println("| [5] Save a Book Entry                                     |");
            System.out.println("| [6] Expand your Book Entry Inventory                      |");
            System.out.println("| [exit] Exit                                               |");
            System.out.println(" ___________________________________________________________");

            systemInput = this.inputScanner.readLine();
            // if else statments for user inputs.
            if (systemInput.equals("0")) {
                // this.viewTable();
                // } else if (systemInput.equals("1")) {
                // this.searchTitle();
                // } else if (systemInput.equals("2")) {
                // this.addTitle();
                // } else if (systemInput.equals("3")) {
                // this.editTitle();
                // } else if (systemInput.equals("4")) {
                // this.deleteEntry();
                // } else if (systemInput.equals("5")) {
                // this.saveToFile();
                // } else if (systemInput.equals("6")) {
                // // User Option to Expand Memory if Needed
                // this.mediaBackEnd.expandMaxEntry();
                // } else if (systemInput.equalsIgnoreCase("exit")) {
                // System.out.println("");
                // System.out.println(">>TTYL, Good Bye<<");
                // }
            }

        } catch (Exception e) {
            // Throws format exception if nothing or incorrect primitive type is entered.
            System.out.println("");
            String errorMessage = "Error: Incorrect Input";
            System.out.println(errorMessage);

        }
        // Will repeat functions until conditions are met, from above selection.
        return systemInput;

    }

    public void saveFile() {

        System.out.println("Please enter the name of the file");
        try {
            String fileName = inputScanner.readLine();
            this.mediaBackEnd.saveFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
