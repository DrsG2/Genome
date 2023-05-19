package org.DrsG.Genome.CCGP;

import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.BeBl.D_BeBl_User;

import java.util.Scanner;
public class T_CCPG_RemoveUserChecker {

    public T_CCPG_RemoveUserChecker(){}

    public void perform(D_BeBl_Repository theRepository)
    {
        Scanner consoleInput = new Scanner(System. in);
        boolean invalidInput = true;
        System.out.println("Current User List : ");
        System.out.println(theRepository.getUsers().getOverview());
        do
        {
            System.out.println("\nEnter the ID of the user to remove");
            String idUserString = consoleInput.nextLine();
            int idUser;
            try {
                idUser = Integer.parseInt(idUserString);
                invalidInput = true;
                if ( (idUser >= 0) && (idUser < (theRepository.getUsers().getUsers().size()) ))
                    {
                        System.out.println("remove user with ID = " + idUser);
                        invalidInput = false;
                        D_BeBl_User removeUser = new D_BeBl_User();
                        removeUser = theRepository.getUsers().getUsers().get(idUser);
                        theRepository.getUsers().getUsers().remove(removeUser);
                        System.out.println(theRepository.getUsers().getOverview());
                    }
                else
                    {
                        System.out.println("ID does not exist");
                        invalidInput = true;
                    }
                } catch (NumberFormatException e)
                    {
                        System.out.println ("Invalid input");
                        invalidInput = true;
                    }
        } while (invalidInput);
    }
}
