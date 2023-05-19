package org.DrsG.Genome.UI;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.BeBl.D_BeBl_User;
import org.DrsG.Genome.UC.T_UC_AlignmentNameSearcher;
import org.DrsG.Genome.UC.T_UC_CopyAlignment;
import org.DrsG.Genome.UC.T_UC_UserSearcher;

import java.util.Scanner;

public class M_UI_TeamLeadOperations {

    public M_UI_TeamLeadOperations(){}

    public void perform(D_BeBl_Repository theRepository, D_BeBl_User activeUser)
    {
        System.out.println(" Welcome " + activeUser.getFirstName() + " " + activeUser.getLastName());
        System.out.println(" Your role is " + activeUser.getRole());
        Scanner consoleInput = new Scanner(System. in);
        String operation;
        boolean validInput;
        boolean continueWorking = true;
        do
        {
            do
            {
                System.out.println("---------------------------------------------------------------------");
                System.out.println("The following operations are available to you:");
                System.out.println("0 - Show the Optimal Alignment's Standard and SNiP Alignment and the AlignmentScore");
                System.out.println("1 - View all assigned Alignments (work in progress)");
                System.out.println("2 - Assign a copy of the current Optimal Alignment to a Bioinformatician");
                System.out.println("3 - Promote an Alignment of a Bioinformaticial to Optimal Alignment");
                System.out.println("4 - Write all Alignments of the Bioinformaticians to file");
                System.out.println("5 - Write all Alignments Reports to file");
                System.out.println("Q - Quite working as Team Leader");
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Enter your choice: ");
                operation = consoleInput.nextLine();
                switch (operation)
                    {
                        case "0":
                            validInput = true;
                            System.out.println(theRepository.getOptimalAlignment().getStandardAlignment());
                            System.out.println(theRepository.getOptimalAlignment().getSNipAlignment());
                            System.out.println("***************************");
                            System.out.println("* Alignment Score :" + theRepository.getOptimalAlignment().getAlignmentScore());
                            System.out.println("***************************");
                            break;
                        case "1":
                            validInput = true;
                            if (theRepository.getWorkAlignments().size() > 0)
                            {
                                for (D_BeBl_Alignment anAlignment : theRepository.getWorkAlignments())
                                {
                                    String alignmentName = anAlignment.getName();
                                    String assignedUser = anAlignment.getOwner().getOverview();
                                    int alignmentScore = anAlignment.getAlignmentScore();
                                    System.out.println("---------------------------------");
                                    System.out.println("Alignment Name=" + alignmentName);
                                    System.out.print("Owner = " + assignedUser);
                                    System.out.println("Alignment Score = " + alignmentScore);
                                    System.out.println("---------------------------------");
                                }
                            }
                            else
                            {
                                System.out.println("-----------------------------------------------------");
                                System.out.println("There are no current assignments to bioinformaticians");
                                System.out.println("-----------------------------------------------------");
                            }
                            break;
                        case "2":
                            validInput = true;
                            boolean invalidInput = true;
                            System.out.println("Enter the ID of the user you want to have the current Optimal Alignment assigned to.");
                            System.out.println("List of users :");
                            System.out.println(theRepository.getUsers().getOverview());
                            do
                            {
                                System.out.println("\nEnter the ID of the user to assign");
                                String idUserString = consoleInput.nextLine();
                                int idUser;
                                try {
                                    idUser = Integer.parseInt(idUserString);
                                    invalidInput = true;
                                    if ( (idUser >= 0) && (idUser < (theRepository.getUsers().getUsers().size()) ))
                                    {
                                       D_BeBl_Alignment assignedAlignment = new D_BeBl_Alignment();
                                       D_BeBl_User assignedUser = theRepository.getUsers().getUser(idUser);
                                       assignedAlignment.setOwner(assignedUser);
                                       assignedAlignment.setReferenceGenomeSequence(theRepository.getOptimalAlignment().getReferenceGenomeSequence());
                                       for (D_BeBl_GenomeSequence aGenomeSequence:theRepository.getOptimalAlignment().getSampleGenomeSequences())
                                       {
                                           D_BeBl_GenomeSequence assignedGenomeSequence = new D_BeBl_GenomeSequence();
                                           assignedGenomeSequence.setId(aGenomeSequence.getId());
                                           assignedGenomeSequence.setSequence(aGenomeSequence.getSequence().toString());
                                           assignedAlignment.addSampleGenomeSequence(aGenomeSequence);
                                       }
                                       assignedAlignment.setName(assignedUser.getFirstName()+"*" + assignedUser.getLastName()+ "*" + System.currentTimeMillis());
                                       invalidInput = false;
                                       theRepository.addWorkAlignemnt(assignedAlignment);
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

                            break;
                        case "3":
                            validInput =true;
                            boolean invalidName = true;
                            do
                                {
                                    System.out.println("Please provide the name of the Alignment");
                                    String alignmentName = consoleInput.nextLine();
                                    T_UC_AlignmentNameSearcher alignmentNameSearcher = new T_UC_AlignmentNameSearcher();
                                    D_BeBl_Alignment newOptimalAlignment = new D_BeBl_Alignment();
                                    D_BeBl_Alignment searchResult = new D_BeBl_Alignment();
                                    searchResult = alignmentNameSearcher.perform(theRepository.getWorkAlignments(), alignmentName);
                                    T_UC_CopyAlignment alignmentCopier = new T_UC_CopyAlignment();
                                    newOptimalAlignment = alignmentCopier.perform(searchResult);
                                    if (!newOptimalAlignment.getName().equals("empty"))
                                    {
                                        invalidName = false;
                                        theRepository.setOptimalAlignment(newOptimalAlignment);
                                    }
                                    else
                                    {
                                        System.out.println("Not a valid alignment name!");
                                        invalidName = true;
                                    }
                                    // get the name of the alignment
                                    //copy the content of the alignment in to the optimal alignment
                                } while (invalidName);

                            break;
                        case "4":
                            validInput =true;
                            break;
                        case "5":
                            validInput =true;
                            break;
                        case "Q":
                            validInput = true;
                            continueWorking = false;
                            break;
                        default:
                            validInput = false;
                            System.out.println("Invlaid input");
                    }
            } while (!validInput);

        } while (continueWorking);
    }
}
