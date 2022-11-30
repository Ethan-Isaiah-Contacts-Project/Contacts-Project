import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    private static String stringUserInput;
    private static String validStringUserInput;

    public static String getString(){
        System.out.print("Enter a string : ");
        stringUserInput = scanner.nextLine();
        return stringUserInput;
    }

    public static String getSearchString(){
        System.out.print("Search for : ");
        stringUserInput = scanner.nextLine();
        return stringUserInput;
    }

    public static String getString(String prompt){
        System.out.println(prompt);
        System.out.print("Enter a string : ");
        stringUserInput = scanner.nextLine();
        return stringUserInput;
    }

    public static String getContactName(){
        System.out.print("Firstname Lastname : ");
        stringUserInput = scanner.nextLine();
        return stringUserInput;
    }

    public static boolean yesNo(){
        System.out.print("Yes or No? : ");
        stringUserInput = scanner.nextLine();
        if (stringUserInput.toLowerCase().equals("y") || stringUserInput.toLowerCase().equals("ye") || stringUserInput.toLowerCase().equals("yes")) {
            stringUserInput = "true";
        } else if (stringUserInput.toLowerCase().equals("n") || stringUserInput.toLowerCase().equals("no")) {
            stringUserInput = "false";
        } else {
            System.out.print("Invalid entry... ");
            yesNo();
        }
        return Boolean.parseBoolean(stringUserInput);
    }

    public static boolean yesNo(String prompt){
        System.out.println(prompt);
        System.out.print("Yes or No? : ");
        stringUserInput = scanner.nextLine();
        if (stringUserInput.toLowerCase().equals("y") || stringUserInput.toLowerCase().equals("ye") || stringUserInput.toLowerCase().equals("yes")) {
            stringUserInput = "true";
        } else if (stringUserInput.toLowerCase().equals("n") || stringUserInput.toLowerCase().equals("no")) {
            stringUserInput = "false";
        } else {
            System.out.print("Invalid entry... ");
            yesNo(prompt);
        }
        return Boolean.parseBoolean(stringUserInput);
    }

    public static int getHex(){
        System.out.print("Enter a hexadecimal : ");
        stringUserInput = scanner.nextLine();
        try {
            Integer.parseInt(stringUserInput, 16);
        } catch (NumberFormatException nfe){
            System.out.println("Invalid input... ");
            getHex();
        }
        return Integer.parseInt(stringUserInput, 16);
    }

    public static int getBinary(){
        System.out.print("Enter a binary number (1's and 0's) : ");
        stringUserInput = scanner.nextLine();
        try{
            Integer.parseInt(stringUserInput, 2);
        } catch (NumberFormatException nfe){
            System.out.println("Invalid input...");
            getBinary();
        }
        return Integer.parseInt(stringUserInput, 2);
    }

    public static int getInt(int min, int max){
        System.out.print("Enter an integer between " + (min - 1) + " and " + (max + 1) + " : ");
        stringUserInput = scanner.nextLine();
        try {
            Integer.parseInt(stringUserInput);
        } catch (NumberFormatException nfe){
            System.out.println("Invalid input... ");
            getInt(min, max);
        }
        if (Integer.parseInt(stringUserInput) >= min && Integer.parseInt(stringUserInput) <= max){
            validStringUserInput = stringUserInput;
        } else {
            System.out.println("Invalid input... ");
            getInt(min, max);
        }
        return Integer.parseInt(validStringUserInput);
    }

    public static int getInt(int min, int max, String prompt){
        System.out.println(prompt);
        System.out.print("Enter an integer between " + (min - 1) + " and " + (max + 1) + " : ");
        stringUserInput = scanner.nextLine();
        try {
            Integer.parseInt(stringUserInput);
        } catch (NumberFormatException nfe){
            System.out.println("Invalid input... ");
            getInt(min, max, prompt);
        }
        if (Integer.parseInt(stringUserInput) >= min && Integer.parseInt(stringUserInput) <= max){
            validStringUserInput = stringUserInput;
        } else {
            System.out.println("Invalid input... ");
            getInt(min, max, prompt);
        }
        return Integer.parseInt(validStringUserInput);
    }

    public static int getIntUIMenu(int min, int max){
        String prompt = "Enter an option (";
        for (int i = min; i <= max; i++){
            if (i == max){
                prompt += i + ") : ";
                break;
            }
            prompt += i + ", ";
        }
        System.out.print(prompt);
        stringUserInput = scanner.nextLine();
        try {
            Integer.parseInt(stringUserInput);
        } catch (NumberFormatException nfe){
            System.out.println("Invalid input... ");
            getIntUIMenu(min, max);
        }
        if (Integer.parseInt(stringUserInput) >= min && Integer.parseInt(stringUserInput) <= max){
            validStringUserInput = stringUserInput;
        } else {
            System.out.println("Invalid input... ");
            getIntUIMenu(min, max);
        }
        return Integer.parseInt(validStringUserInput);
    }

    public static int getInt(){
        System.out.print("Enter an integer : ");
        stringUserInput = scanner.nextLine();
        try {
            Integer.parseInt(stringUserInput);
        } catch (NumberFormatException nfe){
            System.out.println("Invalid input... ");
            getInt();
        }
        validStringUserInput = stringUserInput;
        return Integer.parseInt(validStringUserInput);
    }

    public static long getPhoneNumber(){
        System.out.print("Phone Number (ex: 1112223456): ");
        stringUserInput = scanner.nextLine();
        try {
            Long.parseLong(stringUserInput);
        } catch (NumberFormatException nfe){
            System.out.println("Invalid input... ");
            getPhoneNumber();
        }

        validStringUserInput = stringUserInput;
        return Long.parseLong(validStringUserInput);
    }

    public static int getInt(String prompt){
        System.out.println(prompt);
        System.out.print("Enter an integer : ");
        stringUserInput = scanner.nextLine();
        try {
            Integer.parseInt(stringUserInput);
        } catch (NumberFormatException nfe){
            System.out.println("Invalid input... ");
            getInt(prompt);
        }
        validStringUserInput = stringUserInput;
        return Integer.parseInt(validStringUserInput);
    }

    public static double getDouble(double min, double max){
        System.out.print("Enter a double between " + min + " and " + max + " : ");
        stringUserInput = scanner.nextLine();
        try {
            Double.parseDouble(stringUserInput);
        } catch (NumberFormatException nfe){
            System.out.println("Invalid input... ");
            getDouble(min, max);
        }
        if (Double.parseDouble(stringUserInput) > min && Double.parseDouble(stringUserInput) < max){
            validStringUserInput = stringUserInput;
        } else {
            System.out.println("Invalid input... ");
            getDouble(min, max);
        }
        return Double.parseDouble(validStringUserInput);
    }

    public static double getDouble(double min, double max, String prompt){
        System.out.println(prompt);
        System.out.print("Enter a double between " + min + " and " + max + " : ");
        stringUserInput = scanner.nextLine();
        try {
            Double.parseDouble(stringUserInput);
        } catch (NumberFormatException nfe){
            System.out.println("Invalid input... ");
            getDouble(min, max, prompt);
        }
        if (Double.parseDouble(stringUserInput) > min && Double.parseDouble(stringUserInput) < max){
            validStringUserInput = stringUserInput;
        } else {
            System.out.println("Invalid input... ");
            getDouble(min, max, prompt);
        }
        return Double.parseDouble(validStringUserInput);
    }

    public static double getDouble(){
        System.out.print("Enter a double : ");
        stringUserInput = scanner.nextLine();
        try {
            Double.parseDouble(stringUserInput);
        } catch (NumberFormatException nfe){
            System.out.println("Invalid input... ");
            getDouble();
        }
        validStringUserInput = stringUserInput;
        return Double.parseDouble(validStringUserInput);
    }

    public static double getDouble(String prompt){
        System.out.println(prompt);
        System.out.print("Enter a double : ");
        stringUserInput = scanner.nextLine();
        try {
            Double.parseDouble(stringUserInput);
        } catch (NumberFormatException nfe){
            System.out.println("Invalid input... ");
            getDouble(prompt);
        }
        validStringUserInput = stringUserInput;
        return Double.parseDouble(validStringUserInput);
    }

    public static void main(String[] args) {

//        System.out.println(getString("Hello there... "));
//        System.out.println(yesNo("Hello there... "));
//        System.out.println(getInt(1,10,"Hello there... "));
//        System.out.println(getInt("Hello there... "));
//        System.out.println(getDouble(1,10,"Hello there... "));
//        System.out.println(getDouble("Hello there... "));
//        System.out.println(getHex());
//        System.out.println(getBinary());


    }
}

