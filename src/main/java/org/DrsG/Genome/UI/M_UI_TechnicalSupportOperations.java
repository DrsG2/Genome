package org.DrsG.Genome.UI;

import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.BeBl.D_BeBl_User;
import org.DrsG.Genome.CCGP.T_CCPG_AddUserChecker;
import org.DrsG.Genome.CCGP.T_CCPG_RemoveUserChecker;
import org.DrsG.Genome.UC.T_UC_RepositoryInitiation;

import java.util.Scanner;

public class M_UI_TechnicalSupportOperations {

    public M_UI_TechnicalSupportOperations(){}

    public void perform(D_BeBl_Repository theRepository, D_BeBl_User activeUser)
    {
        System.out.println("Welcome " + activeUser.getFirstName() + " " + activeUser.getLastName());
        System.out.println("Your role is " + activeUser.getRole());
        Scanner consoleInput = new Scanner(System. in);
        String operation;
        boolean validInput;
        boolean continueWorking = true;
        do
        {
            do
            {
                D_BeBl_Repository newRepository = new D_BeBl_Repository();
                T_UC_RepositoryInitiation repositoryInitiator = new T_UC_RepositoryInitiation();
                System.out.println("---------------------------------------------------------------------");
                System.out.println("The following operations are available to you:");
                System.out.println("1 - Backup the Repository");
                System.out.println("2 - Restore the Repository from a backup");
                System.out.println("3 - Initiate the Repository with the default hiv.fasta and team.txt file");
                System.out.println("4 - Initiate the Repository with a provided .fasta and .txt file");
                System.out.println("5 - Add a new user to the Repository");
                System.out.println("6 - Remove a user from the Repository");
                System.out.println("Q - Quite working as Technical Support");
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Enter your choice: ");
                operation = consoleInput.nextLine();
                switch (operation)
                {
                    case "1":
                        validInput = true;
                        System.out.println("Feature to be implemented");
                        break;
                    case "2":
                        validInput = true;
                        System.out.println("Feature to be implemented");
                        break;
                    case "3":
                        validInput =true;
                        repositoryInitiator.perform(newRepository);
                        theRepository = newRepository;
                        System.out.println("NEW REPO");
                        System.out.println(newRepository.getInitialOverview());
                        break;
                    case "4":
                        validInput =true;
                        newRepository = new D_BeBl_Repository();
                        System.out.println("Please provide the directory in which the .fasta and .txt file are located");
                        String direcotry;
                        // read the directory
                        direcotry = consoleInput.nextLine();
                        System.out.println("provided input = " + direcotry);
                        newRepository.setRepositoryLocation(direcotry);
                        System.out.println("Please provide the names of the  .fasta file");
                        // read the fasta file name
                        String fastaFile;
                        fastaFile = consoleInput.nextLine();
                        System.out.println("provided input = " + fastaFile);
                        newRepository.setDefaultFASTAfile(fastaFile);
                        System.out.println("Please provide the full path to the .txt team file");
                        // read the txt file name
                        String teamFile;
                        teamFile = consoleInput.nextLine();
                        System.out.println("provided input = " + teamFile);
                        newRepository.setDefaultUsersfile(teamFile);
                        repositoryInitiator.perform(newRepository);
                        theRepository = newRepository;
                        System.out.println("NEW REPO");
                        System.out.println(newRepository.getInitialOverview());
                        break;
                    case "5":
                        validInput =true;
                        System.out.println("Provide a First Name, Last Name and Role for the user");
                        System.out.println("if the First Name or Last Name is made up of different parts separated by a space (like Jean Pierre or Van den Broek");
                        System.out.println("then those will be automatically replaced by an (like Jean Pierre  becomes Jean_Pierre and Van den Broek becomes Van_den_Broek");
                        System.out.println("First and Last Name are case insensitive");
                        System.out.println("The Role must be a valid Role: TEAMLEAD, TECHNICALSUPPORT, BIOINFORMATICIAN");
                        T_CCPG_AddUserChecker addUser = new T_CCPG_AddUserChecker();
                        addUser.perform(theRepository.getUsers());
                        break;
                    case "6":
                        validInput =true;
                        System.out.println("Below you can find the list of current users. Please provide the ID (number) of the users you want to remove");
                        System.out.println("By removing a users, you not only remove a users from the user list but also flag all Alignments assinged to that");
                        System.out.println("users as obsolete");
                        T_CCPG_RemoveUserChecker removeUser = new T_CCPG_RemoveUserChecker();
                        // TO DO
                        // get the list of Alignments for that users
                        // change the assinge users to obsolete_FristName, obsole_fastname
                        removeUser.perform(theRepository);
                        break;
                    case "Q":
                        validInput = true;
                        continueWorking = false;
                        break;
                    default:
                        validInput = false;
                        System.out.println("Invalid input");
                }
            } while (!validInput);

        } while (continueWorking);
    }

}


