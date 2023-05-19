package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;
import org.DrsG.Genome.CCC.T_CCC_FileWrite;
import org.DrsG.Genome.CCGP.D_CCPG_Environment;

public class T_UC_SaveAlignment {

    public T_UC_SaveAlignment(){}

    public boolean perform(String aRepositoryName, String alignmenOverviewForSaving)
    {
        D_CCPG_Environment theEnvironment = new D_CCPG_Environment();
        String aRepositorylocation = theEnvironment.getRepositoriesLocation();
        System.out.println(alignmenOverviewForSaving);

        String contentToSave = "";
        boolean saveOK = false;
        String theAlignmentString = alignmenOverviewForSaving.substring(0,alignmenOverviewForSaving.length()-1);
        String [] theAlignmentStringComponents = theAlignmentString.split("\n",-1);
        int alignmentNameIndex = 1;
        int referenceGenomeSequenceIDIndex =3;
        int referenceGenomeSequenceStringIndex = 4;
        int sampleGenomeSequencesStartIndex = 5;
        String theAlignmentFileName = aRepositorylocation + "\\" + aRepositoryName + "\\" + aRepositoryName + "." + theAlignmentStringComponents[alignmentNameIndex] + ".alignment.txt";
        //System.out.println(theAlignmentFileName);
        contentToSave = contentToSave + "Reference Genome Sequence \n";
        contentToSave = contentToSave + theAlignmentStringComponents[referenceGenomeSequenceIDIndex] + "\n";
        contentToSave = contentToSave + theAlignmentStringComponents[referenceGenomeSequenceStringIndex] + "\n";
        for (int i=sampleGenomeSequencesStartIndex; i<(theAlignmentStringComponents.length-1); i = i + 2)
        {
            int idIndex = i;
            int genomesequenceIndex = i +1;
            String id = theAlignmentStringComponents[idIndex];
            String sequence = theAlignmentStringComponents[genomesequenceIndex];
            contentToSave = contentToSave + id + "\n";
            contentToSave = contentToSave + sequence + "\n";
        }
        //System.out.println(contentToSave);
        T_CCC_FileWrite fileWriter = new T_CCC_FileWrite();
        saveOK = fileWriter.perform(theAlignmentFileName, contentToSave);
        return saveOK;
    }
}
