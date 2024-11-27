import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.util.Scanner;


public class UserDom {
    public static void main(String[] args) throws Exception {
    // Load and parse the XML file
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
          DocumentBuilder builder = factory.newDocumentBuilder();
          Document document = builder.parse(new File("s.xml"));
          document.getDocumentElement().normalize();
          // Input User ID
          Scanner scanner = new Scanner(System.in);
          System.out.print("Enter User ID: ");
          int userId = scanner.nextInt();
          // Fetch user details
          NodeList userList = document.getElementsByTagName("user");
          boolean userFound = false;
          for (int i = 0; i < userList.getLength(); i++) {
          Element user = (Element) userList.item(i);
          int id = Integer.parseInt(user.getElementsByTagName("userid").item(0).getTextContent());
          if (id == userId) {
               System.out.println("User Details:");
               System.out.println("ID: " + id);
               System.out.println("Name: " + 
               user.getElementsByTagName("username").item(0).getTextContent());
               System.out.println("Address: " + 
               user.getElementsByTagName("address").item(0).getTextContent());
               System.out.println("Phone: " + user.getElementsByTagName("phone").item(0).getTextContent());
               System.out.println("Email: " + user.getElementsByTagName("email").item(0).getTextContent());
               userFound = true;
               break;
              }
          }
          if (!userFound) {
             System.out.println("User not available.");
           }
          scanner.close();
        }
    }
    
