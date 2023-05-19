package org.DrsG;

import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.BeBl.D_BeBl_User;
import org.DrsG.Genome.UI.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner consoleInput = new Scanner(System. in);
        // Starting the program and initializing the Repository
        M_UI_Startup startup = new M_UI_Startup();
        D_BeBl_Repository theRepository;
        theRepository = startup.perform();
        boolean continueWorking = true;
        do
        {
            // Starting up the logon screen
            M_UI_Logon logon = new M_UI_Logon();
            D_BeBl_User activeUser = new D_BeBl_User();
            activeUser = logon.perform(theRepository.getUsers());
            String role = activeUser.getRole();
            //System.out.println("You start working as " + role);
            switch (role)
                {
                case "TEAMLEAD":
                    M_UI_TeamLeadOperations teamLeadOperations = new M_UI_TeamLeadOperations();
                    teamLeadOperations.perform(theRepository, activeUser);
                    break;
                case "TECHNICALSUPPORT":
                    M_UI_TechnicalSupportOperations technicalSupportOperations = new M_UI_TechnicalSupportOperations();
                    technicalSupportOperations.perform(theRepository, activeUser);
                    break;
                case "BIOINFORMATICIAN":
                    M_UI_BioInformatician bioInformatician = new M_UI_BioInformatician();
                    bioInformatician.perform(theRepository, activeUser);
                    break;
                case "INVALID_USER":
                    break;
                default:
                    break;
                }
            //
            // code to continue or not
            System.out.print("\033[H\033[2J");
            System.out.flush();
            boolean validinput = false;
            do
                {
                    System.out.println("Logon a new users ?");
                    System.out.println("Y - Yes logon as a new user");
                    System.out.println("Q - Quite the application");
                    String stringFromConsoleInput = consoleInput.nextLine();
                    switch (stringFromConsoleInput)
                    {
                    case "Y":
                        validinput=true;
                        continueWorking = true;
                        break;
                    case "Q":
                        validinput = true;
                        continueWorking = false;
                        System.out.println("Quiting the application");
                        break;
                    default:
                        System.out.println("Invalid input\n");
                        validinput = false;
                        break;
                     }
                } while (!validinput);
        } while (continueWorking);
    }
}