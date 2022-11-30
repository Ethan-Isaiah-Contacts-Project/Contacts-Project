import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//    Contacts data stored in a file named contacts.txt
//    Contact stored as a name and phone number combination.

//    Show all your contacts
//    Add a new contact
//    Search a contact by her name
//    Delete an existing contact

//    When the application starts, the contact list should be read from the file.
//    Before the application exits, the contacts file should be rewritten.

//    UI menu:
//    1. View contacts.
//    2. Add a new contact.
//    3. Search a contact by name.
//    4. Delete an existing contact.
//    5. Exit.
//    Enter an option (1, 2, 3, 4 or 5):

//    Display format:
//    Name | Phone number
//    ---------------
//    Jack Blank | 1231231234
//    Jane Doe | 2342342345
//    Sam Space | 3453453456

//    Flow:
//    1. Load the contacts by calling a method that returns a List of Contact objects.
//    2. Call a method that shows the user the main menu and returns their choice of action.
//    3. Using the user's choice from the previous step, call a method that performs that action (modifying the contents of the List of Contact objects if applicable).
//    4. Keep calling the method from step two until the user chooses to exit.
//    5. Once the user chooses to exit, re-write the contents of the contacts.txt file using the List of Contact objects.


public class Contacts  {

    final static String SPACER = "-----------------------";

    public static void main(String[] args) throws IOException {
        //addContact("Ethan",22);
        String name;
        String number;

        int ch;
        do{
            System.out.println("UI menu:");
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");

            ch = Input.getIntUIMenu(1,5);

            switch (ch) {
                case 1:
                    viewContactList();
                    break;
                case 2:
                    System.out.println(SPACER);
                    System.out.println("ADD CONTACT");
                    System.out.println();
                    name = Input.getContactName();
                    number = Input.getPhoneNumber();
                    addContact(name,number);
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    viewContactListDelete();
                    deleteContact();
                    break;
            }
        }while(ch!=5);

//        System.out.println(buildPhoneNumber(1231231234L));




    }


// 🟣🟣🟣🟣🟣🟣🟣🟣 Below this are the methods built in this Class, with the Exception of the Input Class 🟣🟣🟣🟣🟣🟣🟣🟣


    public static String buildPhoneNumber(long num){
        String formattedNumberString = "";
        String oGNum = String.valueOf(num);
        ;
        for (int i = oGNum.toCharArray().length -1; i >= 0; i--){
            if (   i == oGNum.toCharArray().length -5
                || i == oGNum.toCharArray().length -8
                || i == oGNum.toCharArray().length -11
                || i == oGNum.toCharArray().length -14){
                formattedNumberString = oGNum.toCharArray()[i] + "-" + formattedNumberString;
            } else {
                formattedNumberString = oGNum.toCharArray()[i] + formattedNumberString;
            }
        }
        return formattedNumberString;
    }

    public static void addContact (String name, String number) {

        System.out.println("Added: " + name + " | " + number);
        File file = new File("file.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(new FileWriter(file,true));
            pw.println(name + " | " + number);
            pw.close();
            System.out.println(SPACER);
        }
        catch (IOException e) { System.out.println(e.getMessage());
        }
    }

    public static void searchContact () throws IOException {
        System.out.println(SPACER);
        System.out.println("SEARCH CONTACTS");
        System.out.println();
        String userInput = Input.getSearchString();
        System.out.println();
        userInput = userInput.trim();
        Path filePath = Paths.get("file.txt");
        List<String> fileContents = Files.readAllLines(filePath);
        boolean wasFound = false;

        for (int i =0; i < fileContents.size(); i++) {
            if (fileContents.get(i).toLowerCase().indexOf(userInput.toLowerCase()) != -1 && userInput.toCharArray().length > 0) {
//                System.out.println(SPACER);
                System.out.println("You got : " + fileContents.get(i));
//                System.out.println(SPACER);
                wasFound = true;
            }
        }
        if (!wasFound) {
//            System.out.println(SPACER);
            System.out.println("Could not find : " + userInput);
//            System.out.println(SPACER);
        }
        System.out.println(SPACER);

    }

    public static void viewContactList() throws IOException {
        Path filePath = Paths.get("file.txt");
        List<String> fileContents = Files.readAllLines(filePath);
        System.out.println(SPACER);
        System.out.println("CONTACTS LIST");
        System.out.println();
        System.out.println("Entry #: Name | Number");
        for (int i =0; i < fileContents.size(); i++) {
            System.out.println((i + 1) + ": " + fileContents.get(i));
        }
        System.out.println(SPACER);
    }

    public static void viewContactListDelete() throws IOException {
        Path filePath = Paths.get("file.txt");
        List<String> fileContents = Files.readAllLines(filePath);
        System.out.println(SPACER);
        System.out.println("DELETE CONTACTS");
        System.out.println();
        System.out.println("Entry #: Name | Number");
        System.out.println("0: Exit");
        for (int i =0; i < fileContents.size(); i++) {
            System.out.println((i + 1) + ": " + fileContents.get(i));
        }
        System.out.println();
    }

    public static void deleteContact() throws IOException {
        Path filePath = Paths.get("file.txt");
        List<String> fileContents = Files.readAllLines(filePath);
        System.out.println("Which Entry # to delete : ");
        int userChoice = Input.getInt(0, fileContents.size());


        if (userChoice != 0){
            File file = new File("file.txt");
            new FileWriter(file, false).close();
            try {
                file.createNewFile();
                PrintWriter pw = new PrintWriter(new FileWriter(file,true));
                for (int i = 0; i < fileContents.size(); i++){
                    if (userChoice != (i+1)){
                        pw.println(fileContents.get(i));
                    }
                }
                pw.close();
            }catch (IOException e) { System.out.println(e.getMessage());
            }
            System.out.println("Deleted : " + fileContents.get(userChoice-1));
        }

        System.out.println(SPACER);

    }
}



