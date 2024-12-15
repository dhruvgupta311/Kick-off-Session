import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomMessage{
    public static void main(String[] args){
        // Input message template
        String message = "Hello <<name>>, We have your full name as <<full name>> in our system. "
                + "Your contact number is 91-xxxxxxxxxx. Please, let us know in case of any clarification. "
                + "Thank you BridgeLabz 01/01/2016.";

        // User details
        String firstName = "Dhruv";
        String fullName = "Dhruv Gupta";
        String contactNumber = "6378883984";

        // Current date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = formatter.format(new Date());

        // Replace <<name>> with first name
        message = message.replaceAll("<<name>>", firstName);

        // Replace <<full name>> with the full name
        message = message.replaceAll("<<full name>>", fullName);

        // Replace contact number
        message = message.replaceAll("91-xxxxxxxxxx", "91-" + contactNumber);

        // Replace date in the format XX/XX/XXXX with the current date
        message = message.replaceAll("\\b\\d{2}/\\d{2}/\\d{4}\\b", currentDate);

        // Print the modified message
        System.out.println(message);
    }
}
