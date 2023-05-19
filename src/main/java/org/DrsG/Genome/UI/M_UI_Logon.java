package org.DrsG.Genome.UI;

import org.DrsG.Genome.BeBl.D_BeBl_User;
import org.DrsG.Genome.BeBl.D_BeBl_UserList;
import org.DrsG.Genome.UC.T_UC_UserSearcher;

import java.util.Scanner;

public class M_UI_Logon {

    public M_UI_Logon(){}

    public D_BeBl_User perform (D_BeBl_UserList theUserList)
    {
        String userRole = null ;
        D_BeBl_User activeUser = new D_BeBl_User();
        boolean invalidInput = false;
        boolean stop = false;
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("++ Role of active users  ++");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("\n");
        do {
            System.out.println("Enter your First name: ");
            Scanner consoleInput = new Scanner(System.in);
            String aFirstName = consoleInput.nextLine();
            System.out.println("Enter your Last name: ");
            String aLastName = consoleInput.nextLine();
            System.out.println("Entered User: " + aFirstName + " " + aLastName);

            T_UC_UserSearcher userSearcher = new T_UC_UserSearcher();
            activeUser = userSearcher.perform(theUserList, aFirstName, aLastName);

            System.out.println("active user: " + activeUser.getOverview());

            if (activeUser.getFirstName().equals("INVALID_USER") && (activeUser.getLastName().equals("INVALID_USER")))
                {
                    System.out.println("Invalid User - enter a valid first and lastname or contact Technical Support");
                    do
                    {
                        invalidInput = true;
                        System.out.println("1 - Do you want to re-enter a user?");
                        System.out.println("    Enter 1");
                        System.out.println("Q - Quite the logon procedure?");
                        System.out.println("    Enter Q");
                        String invalidUserChoise = consoleInput.nextLine();
                        System.out.println("Entered choice: " + invalidUserChoise);
                        switch (invalidUserChoise) {
                            case "1":
                                invalidInput = false;
                                break;
                            case "Q":
                                invalidInput = false;
                                stop = true;
                                break;
                            default:
                        }
                    } while (invalidInput);
                }
        } while (activeUser.getFirstName().equals("INVALID_USER") && (activeUser.getLastName().equals("INVALID_USER")) || stop);
        return activeUser;
    }
}
