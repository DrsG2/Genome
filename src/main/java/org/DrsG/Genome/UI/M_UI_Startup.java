package org.DrsG.Genome.UI;

import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.UC.T_UC_RepositoryInitiation;

import java.util.Scanner;

public class M_UI_Startup {

    public M_UI_Startup(){}

    public D_BeBl_Repository perform()
    {
        D_BeBl_Repository theRepository = new D_BeBl_Repository();
        System.out.println("*******************************************************************");
        System.out.println("*                                                                 *");
        System.out.println("*          Genome Analyser                                        *");
        System.out.println("*                                                                 *");
        System.out.println("*******************************************************************\n\n\n");
        Boolean continueLooping = true;

        do {
            System.out.println("Chose the Repository Load options by enter the number of the option");
            System.out.println("1 - Default Initial Load ");
            System.out.println("    Loads the Repository with the default hiv.fasta and team.txt file");
            System.out.println("2 - Custom Initial Load");
            System.out.println("    Loads the Repository with a provided .fasta and a .txt file containing the team");
            System.out.println("3 - Existing Repository load");
            System.out.println("    Load an existing Repository and Work-in-Progress Alignments");
            System.out.println("Q - Quite the application");
            System.out.println("\\\\");
            System.out.println("Your choice: ");
            // read the import
            Scanner consoleInput = new Scanner(System. in);
            String stringFromConsoleInput = consoleInput.nextLine();
            //System.out.println("read from console: " + stringReadFromConsole);
            //stringReadFromConsole = '3';
            T_UC_RepositoryInitiation repositoryInitiation = new T_UC_RepositoryInitiation();
            switch (stringFromConsoleInput) {
                case "1":
                    System.out.println("Start initializing the Repository with default hiv.fasta and team.txt file");
                    repositoryInitiation.perform(theRepository);
                    continueLooping = false;
                    break;
                case "2":
                    System.out.println("Start initializing the Repository with provided .fasta and .txt file");
                    System.out.println("Please provide the directory in which the .fasta and .txt file are located");
                    // read the directory
                    stringFromConsoleInput = consoleInput.nextLine();
                    System.out.println("provided input = " + stringFromConsoleInput);
                    theRepository.setRepositoryLocation(stringFromConsoleInput);
                    System.out.println("Please provide the names of the  .fasta file");
                    // read the fasta file name
                    stringFromConsoleInput = consoleInput.nextLine();
                    System.out.println("provided input = " + stringFromConsoleInput);
                    theRepository.setDefaultFASTAfile(stringFromConsoleInput);
                    System.out.println("Please provide the full path to the .txt team file");
                    // read the txt file name
                    stringFromConsoleInput = consoleInput.nextLine();
                    System.out.println("provided input = " + stringFromConsoleInput);
                    theRepository.setDefaultUsersfile(stringFromConsoleInput);
                    repositoryInitiation.perform(theRepository);
                    continueLooping = false;
                    break;
                case "3":
                    System.out.println("Please provide the repository name");
                    // read the name
                    // Start the T_RepositoryLoader
                    continueLooping = false;
                    break;
                case "Q":
                    continueLooping = false;
                default:
                    System.out.println("invalid option - enter valid option");
            }
        } while (continueLooping);

        return theRepository;
    }
}
