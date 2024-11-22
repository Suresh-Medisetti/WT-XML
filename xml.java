import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.util.Scanner;

 class UserDom {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("s.xml"));
        doc.getDocumentElement().normalize();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter User ID:");
        int userIdInput = scanner.nextInt();
        boolean userFound = false;

        NodeList users = doc.getElementsByTagName("user");
        for (int i = 0; i < users.getLength(); i++) {
            Node node = users.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element userElement = (Element) node;
                int userId = Integer.parseInt(
                    userElement.getElementsByTagName("userid").item(0).getTextContent()
                );
                if (userId == userIdInput) {
                    System.out.println("User Details:");
                    System.out.println("UserID: " + 
                        userElement.getElementsByTagName("userid").item(0).getTextContent());
                    System.out.println("Username: " + 
                        userElement.getElementsByTagName("username").item(0).getTextContent());
                    System.out.println("Address: " + 
                        userElement.getElementsByTagName("address").item(0).getTextContent());
                    System.out.println("Phone: " + 
                        userElement.getElementsByTagName("phone").item(0).getTextContent());
                    System.out.println("Email: " + 
                        userElement.getElementsByTagName("email").item(0).getTextContent());
                    userFound = true;
                    break;
                }
            }
        }

        if (!userFound) {
            System.out.println("User not available.");
        }
    }
}
