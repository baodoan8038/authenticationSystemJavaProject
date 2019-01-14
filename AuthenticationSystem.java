package authenticationsystem;
import java.security.MessageDigest;
import java.util.*;
import java.io.File; 
import java.io.PrintStream;
public class AuthenticationSystem {

    public static void main(String[] args) throws Exception {
        //Declare variables
        String userName = "";
        String passWord = "";
        String digestPassword = "";
        int testCounter = 0;
        int remainAttempt = 0;
        final int constantCounter = 3;
        String logOut = "";
        //Declare Scanner
        Scanner scnr = new Scanner(System.in);
        
        //Welcome Message
        System.out.printf("Hello! Welcome to Authentication System\n\n");
        System.out.println("You have a total of 3 attempt(s) to enter valid login credentials");
        //Prompt for username and password
        while(testCounter < 3){
            System.out.println("To login please enter your username and password: (To quit please enter 'q')");
            System.out.print("Username: ");
            userName = scnr.nextLine();
            if(userName.equals("q")){
                System.out.println("*Program has exit successfully*");
                System.exit(0);
            }
            System.out.print("Password: ");
            passWord = scnr.nextLine();
            System.out.println();
        
        //MD5 Code Block
            String original = passWord;  
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(original.getBytes());
                byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
            digestPassword = sb.toString();
        
        //Print Text File depend on login credential
        //Hello Professor Lovejoy, please change the file path of 4 text files below
        //So this program could run without error.  The file path below are from my computer.
        //It could be changed when you decompressed this java package.
            File adminFile = new File("D:\\8 Weeks Portion 2\\IT 145 App Dev\\HomeWork\\"
                    + "authenticationSystem\\src\\authenticationsystem\\admin.txt"); 
            File zookeeperFile = new File("D:\\8 Weeks Portion 2\\IT 145 App Dev\\HomeWork\\"
                    + "authenticationSystem\\src\\authenticationsystem\\zookeeper.txt"); 
            File veterinarianFile = new File("D:\\8 Weeks Portion 2\\IT 145 App Dev\\HomeWork\\"
                    + "authenticationSystem\\src\\authenticationsystem\\veterinarian.txt"); 
            Scanner adminScnr = new Scanner(adminFile); 
            Scanner zookeeperScnr = new Scanner(zookeeperFile);
            Scanner veterinarianScnr = new Scanner(veterinarianFile);
        
        //Compare username and password on credential file
            Scanner credentialScnr = new Scanner(new File("D:\\8 Weeks Portion 2\\"
                    + "IT 145 App Dev\\HomeWork\\authenticationSystem\\"
                    + "src\\authenticationsystem\\credentials.txt"));
            String jobPosition = "";
            credentialScnr.useDelimiter("\t");
            while (credentialScnr.hasNext()){
                String credentialInfo = credentialScnr.nextLine();
                String credentialList[] = credentialInfo.split("\t");
                if(credentialList[0].equals(userName) && credentialList[1].equals(digestPassword)){
                    jobPosition = credentialList[3];
                    switch(jobPosition){
                        case "admin":
                            System.out.println("*Logged In Successfully*");
                            while (adminScnr.hasNextLine())
                            System.out.println(adminScnr.nextLine());
                            System.out.print("*Enter In Character 'q' to quit program* \n*Or Press 'Enter' key to log out of session*: ");
                            logOut = scnr.nextLine();
                            if(logOut.equals("q")){
                                System.out.println("*Program has exit successfully*");
                                System.exit(0);
                            }
                            testCounter = -1;
                            System.out.printf("Hello! Welcome to Authentication System\n\n");
                            break;
                        case "zookeeper": 
                            System.out.println("*Logged In Successfully*");
                            while (zookeeperScnr.hasNextLine())
                            System.out.println(zookeeperScnr.nextLine());
                            System.out.print("*Enter In Character 'q' to quit program* \n*Or Press 'Enter' key to log out of session*: ");
                            logOut = scnr.nextLine();
                            if(logOut.equals("q")){
                                System.out.println("*Program has exit successfully*");
                                System.exit(0);
                            }
                            testCounter = -1;
                            System.out.printf("Hello! Welcome to Authentication System\n\n");
                            break;
                        case "veterinarian":
                            System.out.println("*Logged In Successfully*");
                            while (veterinarianScnr.hasNextLine())
                            System.out.println(veterinarianScnr.nextLine());
                            System.out.print("*Enter In Character 'q' to quit program* \n*Or Press 'Enter' key to log out of session*: ");
                            logOut = scnr.nextLine();
                            if(logOut.equals("q")){
                                System.out.println("*Program has exit successfully*");
                                System.exit(0);
                            }
                            testCounter = -1;
                            System.out.printf("Hello! Welcome to Authentication System\n\n");
                            break;
                    }// Switch end bracket
                }// If end bracket
            
            }//secondary while end bracket
            
        //Display Error Messages for failed attempts
        testCounter+=1;
        remainAttempt = constantCounter - testCounter;
        System.out.printf("You have a total of %d attempt(s) left to enter valid login credentials\n",remainAttempt);
        
        }//primary while end bracket
        
        // Failed Attempt Message
        System.out.println("You have reached a maximum of 3 failed attempts. \nThe program will now exit.");
        
    }
    
}
