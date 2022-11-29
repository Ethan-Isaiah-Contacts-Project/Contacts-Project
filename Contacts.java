import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Contacts  {

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

    private String name;
    private String phone;

    Contacts(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

     String directory = "ContactsPackage";
     String filename = "contacts.txt";

     Path dataDirectory = Paths.get(directory);
     Path dataFile = Paths.get(directory, filename);

Contacts Isaiah = new Contacts("Isaiah", "7204389371");

List<String> contactList = Arrays.asList("line 1", "line 2");


//    /**
//     * Use Files class from Java 1.7 to write files, internally uses OutputStream
//     * @param data
//     */
//    private static void writeUsingFiles(String data) {
//        try {
//            Files.write(Paths.get("/Users/pankaj/files.txt"), data.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }




    public static void main(String[] args) throws IOException {



    }
}
