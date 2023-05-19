package org.DrsG.Genome.CCGP;

import org.DrsG.Genome.BeBl.D_BeBl_User;
import org.DrsG.Genome.BeBl.D_BeBl_UserList;

import java.util.Scanner;

public class T_CCPG_AddUserChecker
{
    public T_CCPG_AddUserChecker(){}

    public void perform(D_BeBl_UserList theUserList)
    {
        boolean invalidInput = true;
        Scanner consoleInput = new Scanner(System. in);
        D_BeBl_User newUser = new D_BeBl_User();
        do
        {
            System.out.println("Enter First Name: ");
            String firstName = consoleInput.nextLine();
            System.out.println("Enter Last Name:  ");
            String lastName= consoleInput.nextLine();
            System.out.println("Enter role: ");
            String role = consoleInput.nextLine();
            if ((role.toUpperCase().equals("TEAMLEAD")||role.toUpperCase().equals("TECHNICALSUPPORT")||role.toUpperCase().equals("BIOINFORMATICIAN")))
            {
                invalidInput = false;
                firstName = firstName.replace(" ","_");
                newUser.setFirstName(firstName);
                lastName = lastName.replace(" ", "_");
                newUser.setLastName(lastName);
                role = role.toUpperCase();
                newUser.setRole(role);
                System.out.println(firstName + " " + lastName + " " + role);
                theUserList.addUser(newUser);
                System.out.println(theUserList.getOverview());
            }
            else
            {
                invalidInput = true;
                System.out.println("Incorrect role specified. Re-Enter information");
            }
        } while (invalidInput);

    }
}
