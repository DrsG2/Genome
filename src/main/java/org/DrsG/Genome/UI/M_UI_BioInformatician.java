package org.DrsG.Genome.UI;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.BeBl.D_BeBl_User;
import org.DrsG.Genome.UC.*;

import java.util.ArrayList;
import java.util.Scanner;

public class M_UI_BioInformatician {

    public M_UI_BioInformatician(){}

    public void perform(D_BeBl_Repository theReposotiry, D_BeBl_User activeUser)
    {
        System.out.println("Welcome " +  activeUser.getFirstName() + " " + activeUser.getLastName());
        System.out.println("Your role is :" + activeUser.getRole());
        Scanner consoleInput = new Scanner(System. in);
        String operation;
        boolean validInput;
        boolean continueWorking = true;
        boolean invalidAlignment = true;
        T_UC_AssingedAlignmentSearcher assingedAlignmentSearcher = new T_UC_AssingedAlignmentSearcher();
        T_UC_AlignmentNameSearcher alignmentNameSearcher = new T_UC_AlignmentNameSearcher();
        ArrayList<D_BeBl_Alignment> assingedAlignments =  new ArrayList<D_BeBl_Alignment>();
        do
        {
            do
            {
                System.out.println("---------------------------------------------------------------------");
                System.out.println("The following operations are available to you:");
                System.out.println(" 1 - List the Alignments assigned to me");
                System.out.println(" 2 - List the AlignmentScores of all Alignments");
                System.out.println(" 3 - Search through all sequences in an Alignment for a sub sequence");
                System.out.println(" 4 - Replace a sub sequence in all genome sequences of an Alignment");
                System.out.println(" 5 - Replace a sub sequence in one genome sequence of an Alignment");
                System.out.println(" 6 - Show the StandardAlignment of an Alignment");
                System.out.println(" 7 - Show the SNiPAlignment of an Alignment");
                System.out.println(" 8 - Show the AlignmentScope of an Alignment");
                System.out.println(" 9 - Add a genomeSequence to an Alignment");
                System.out.println("10 - Remove a genome sequence from an Alignment");
                System.out.println("11 - Replace a genome sequence with another genome sequence");
                System.out.println("12 - Write an Alignment to file");
                System.out.println("13 - Write an Alignment Report to file");
                System.out.println(" Q - Quite working as Bioinformatician.");
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Enter your choice: ");
                operation = consoleInput.nextLine();
                switch (operation)
                {
                    case "1":
                        validInput = true;
                        assingedAlignments = assingedAlignmentSearcher.perform(theReposotiry.getWorkAlignments(), activeUser);
                        System.out.println("///////////////////////");
                        System.out.println("/ Assigned Alignments /");
                        System.out.println("///////////////////////");
                        if (assingedAlignments.size() == 0)
                        {
                            System.out.println("No alignments assigned to you. Contact your teamlead");
                        }
                        for (D_BeBl_Alignment anAlignment:assingedAlignments)
                        {
                            System.out.println("Alignment Name: " + anAlignment.getName());
                        }
                        break;
                    case "2":
                        validInput = true;
                        assingedAlignments = assingedAlignmentSearcher.perform(theReposotiry.getWorkAlignments(), activeUser);
                        System.out.println("///////////////////////");
                        System.out.println("/ Assigned Alignments  and Alignment Scores/");
                        System.out.println("///////////////////////");
                        if (assingedAlignments.size() == 0)
                        {
                            System.out.println("No alignments assigned to you. Contact your teamlead");
                        }
                        for (D_BeBl_Alignment anAlignment:assingedAlignments)
                        {
                            System.out.println("Alignment Name: " + anAlignment.getName() + "--- Alignment Score = " + anAlignment.getAlignmentScore());
                        }
                        break;
                    case "3":
                        validInput =true;
                        assingedAlignments = assingedAlignmentSearcher.perform(theReposotiry.getWorkAlignments(), activeUser);
                        do
                        {
                            System.out.println("Enter the name of the Alignment in which you want to search");
                            String anAlignmentName = consoleInput.nextLine();
                            D_BeBl_Alignment theAlignment = alignmentNameSearcher.perform(assingedAlignments, anAlignmentName);
                            if (theAlignment.getName().equals("empty"))
                            {
                                System.out.println("Not a valid alignment name!");
                                invalidAlignment = true;
                            }
                            else
                            {
                                System.out.println("Enter the sub sequence:");
                                String theSubSequence = consoleInput.nextLine();
                                T_UC_SubSequenceInAlignmentSearcher subSequenceInAlignmentSearcher = new T_UC_SubSequenceInAlignmentSearcher();
                                ArrayList<D_BeBl_GenomeSequence> genomeSequencesContainingTheSubString = subSequenceInAlignmentSearcher.perform(theAlignment, theSubSequence);
                                if (genomeSequencesContainingTheSubString.size() == 0)
                                {
                                    System.out.println("No Genome Sequences found containing the subsequence");
                                }
                                else
                                {
                                    System.out.println("Nr of Genome Sequences containing the sub sequence: " + genomeSequencesContainingTheSubString.size());
                                    for (D_BeBl_GenomeSequence aGenomeSequence: genomeSequencesContainingTheSubString)
                                    {
                                        System.out.println("Genome ID:" + aGenomeSequence.getId());
                                    }
                                    invalidAlignment = false;
                                }
                            }
                        } while (invalidAlignment);
                        break;
                    case "4":
                        validInput =true;
                        assingedAlignments = assingedAlignmentSearcher.perform(theReposotiry.getWorkAlignments(), activeUser);
                        do
                        {
                            System.out.println("Enter the name of the Alignment in which you want to replace a sub sequence in all genome sequences");
                            String anAlignmentName = consoleInput.nextLine();
                            D_BeBl_Alignment theAlignment = alignmentNameSearcher.perform(assingedAlignments, anAlignmentName);
                            if (theAlignment.getName().equals("empty"))
                            {
                                System.out.println("Not a valid alignment name!");
                                invalidAlignment = true;
                            }
                            else
                            {
                                System.out.println("Enter the sub sequence to replace:");
                                String theSubSequenceToReplace = consoleInput.nextLine();
                                System.out.println("Enter the replacement sub sequence - MUST BE OF SAME LENGTH AS Sub Sequence to Replace!!");
                                // TO DO : check if the length is OK !!!!
                                String theReplacementSubSequence = consoleInput.nextLine();
                                T_UC_ReplaceSequenceInAlignment sequenceInAlignmentReplacer = new T_UC_ReplaceSequenceInAlignment();
                                sequenceInAlignmentReplacer.perform(theAlignment, theSubSequenceToReplace, theReplacementSubSequence);
                                invalidAlignment = false;
                            }
                        } while (invalidAlignment);
                        break;
                    case "5":
                        validInput =true;
                        assingedAlignments = assingedAlignmentSearcher.perform(theReposotiry.getWorkAlignments(), activeUser);
                        do
                        {
                            System.out.println("Enter the name of the Alignment in which you want to replace a sub sequence in a genome sequences");
                            String anAlignmentName = consoleInput.nextLine();
                            D_BeBl_Alignment theAlignment = alignmentNameSearcher.perform(assingedAlignments, anAlignmentName);
                            if (theAlignment.getName().equals("empty"))
                            {
                                System.out.println("Not a valid alignment name!");
                                invalidAlignment = true;
                            }
                            else
                            {
                                System.out.println("Enter the ID of the genome in which you want to replace a subsequence");
                                String aGenomeID = consoleInput.nextLine();
                                T_UC_GenomeInAlignmentSearcher aGenomeInAlignmentSearcher = new T_UC_GenomeInAlignmentSearcher();
                                D_BeBl_GenomeSequence theGenomeSequence = new D_BeBl_GenomeSequence();
                                theGenomeSequence = aGenomeInAlignmentSearcher.perform(theAlignment, aGenomeID);

                                if (theGenomeSequence.equals("empty"))
                                {
                                    System.out.println("Not a valid Genome Sequence in Alignment " + theAlignment.getName());
                                    invalidAlignment = true;
                                }
                                else
                                {
                                    System.out.println("Enter the sub sequence to replace:");
                                    String theSubSequenceToReplace = consoleInput.nextLine();
                                    System.out.println("Enter the replacement sub sequence - MUST BE OF SAME LENGTH AS Sub Sequence to Replace!!");
                                    // TO DO : check if the length is OK !!!!
                                    String theReplacementSubSequence = consoleInput.nextLine();
                                    T_UC_ReplaceSequenceInGenomeSequence sequenceInGenomeReplacer = new T_UC_ReplaceSequenceInGenomeSequence();
                                    sequenceInGenomeReplacer.perform(theGenomeSequence, theSubSequenceToReplace, theReplacementSubSequence);
                                    invalidAlignment = false;
                                }
                            }
                        } while (invalidAlignment);
                        break;
                    case "6":
                        validInput =true;
                        assingedAlignments = assingedAlignmentSearcher.perform(theReposotiry.getWorkAlignments(), activeUser);
                        do
                        {
                            System.out.println("Enter the name of the Alignment of which you want to see the Standard Alignment");
                            String anAlignmentName = consoleInput.nextLine();
                            D_BeBl_Alignment theAlignment = alignmentNameSearcher.perform(assingedAlignments, anAlignmentName);
                            if (theAlignment.getName().equals("empty"))
                            {
                                System.out.println("Not a valid alignment name!");
                                invalidAlignment = true;
                            }
                            else
                            {
                               System.out.println("Standard Alignment for " + anAlignmentName);
                               System.out.println(theAlignment.getStandardAlignment());
                               invalidAlignment = false;
                            }
                        } while (invalidAlignment);
                        break;
                    case "7":
                        validInput =true;
                        assingedAlignments = assingedAlignmentSearcher.perform(theReposotiry.getWorkAlignments(), activeUser);
                        do
                        {
                            System.out.println("Enter the name of the Alignment of which you want to see the SNip Alignment");
                            String anAlignmentName = consoleInput.nextLine();
                            D_BeBl_Alignment theAlignment = alignmentNameSearcher.perform(assingedAlignments, anAlignmentName);
                            if (theAlignment.getName().equals("empty"))
                            {
                                System.out.println("Not a valid alignment name!");
                                invalidAlignment = true;
                            }
                            else
                            {
                                System.out.println("SNip Alignment for " + anAlignmentName);
                                System.out.println(theAlignment.getSNipAlignment());
                                invalidAlignment = false;
                            }
                        } while (invalidAlignment);
                        break;
                    case "8":
                        validInput =true;
                        assingedAlignments = assingedAlignmentSearcher.perform(theReposotiry.getWorkAlignments(), activeUser);
                        do
                        {
                            System.out.println("Enter the name of the Alignment of which you want to see the Alignment Score");
                            String anAlignmentName = consoleInput.nextLine();
                            D_BeBl_Alignment theAlignment = alignmentNameSearcher.perform(assingedAlignments, anAlignmentName);
                            if (theAlignment.getName().equals("empty"))
                            {
                                System.out.println("Not a valid alignment name!");
                                invalidAlignment = true;
                            }
                            else
                            {
                                System.out.println("Alignment Score for " + anAlignmentName);
                                System.out.println(theAlignment.getAlignmentScore());
                                invalidAlignment = false;
                            }
                        } while (invalidAlignment);
                        break;
                    case "9":
                        validInput =true;
                        System.out.println("Functionality to be implemented.");
                        break;
                    case "10":
                        validInput =true;
                        System.out.println("Functionality to be implemented.");
                        break;
                    case "11":
                        validInput =true;
                        System.out.println("Functionality to be implemented.");
                        break;
                    case "12":
                        validInput =true;
                        boolean succesfulSave = false;
                        //System.out.println("Functionality to be implemented.");
                        T_UC_SaveAlignment anAlignmentSaver = new T_UC_SaveAlignment();
                        assingedAlignments = assingedAlignmentSearcher.perform(theReposotiry.getWorkAlignments(), activeUser);
                        do
                        {
                            System.out.println("Enter the name of the Alignment to save");
                            String anAlignmentName = consoleInput.nextLine();
                            D_BeBl_Alignment theAlignment = alignmentNameSearcher.perform(assingedAlignments, anAlignmentName);
                            if (theAlignment.getName().equals("empty"))
                            {
                                System.out.println("Not a valid alignment name!");
                                invalidAlignment = true;
                            }
                            else
                            {
                                T_UC_SaveAlignment alignmentSaver = new T_UC_SaveAlignment();
                                String alignmentOverviewForSaving = theAlignment.getOverviewForSaving();
                                succesfulSave = alignmentSaver.perform(theReposotiry.getRepositoryName(), alignmentOverviewForSaving);
                                System.out.println("Save succesful = "  + succesfulSave );
                                invalidAlignment = false;
                            }
                        } while (invalidAlignment);
                        break;
                    case "13":
                        validInput =true;
                        assingedAlignments = assingedAlignmentSearcher.perform(theReposotiry.getWorkAlignments(), activeUser);
                        boolean succesfulSaveReport = false;
                        T_UC_ReportCreator aReportCreator = new T_UC_ReportCreator();
                        //T_UC_SaveReport aReportSaver = new T_UC_SaveReport;
                        String reportContent = "";
                        if (assingedAlignments.size() == 0)
                        {
                            System.out.println("There are no Alignments assinged to you, hence, no report is created");
                        }
                        else
                        {
                            reportContent = aReportCreator.perform(assingedAlignments, activeUser);
                            //succesfulSaveReport = aReportSaver.perform(theReposotiry, reportContent);
                        }
                        System.out.println(reportContent);
                        T_UC_SaveReport reportSaver = new T_UC_SaveReport();
                        succesfulSaveReport = reportSaver.perform(theReposotiry.getRepositoryName(), reportContent, activeUser);
                        System.out.println("success save report = " + succesfulSaveReport);
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
