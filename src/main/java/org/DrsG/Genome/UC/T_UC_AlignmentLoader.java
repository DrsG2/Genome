package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;
import org.DrsG.Genome.CCC.T_CCC_FileRead;

public class T_UC_AlignmentLoader {

    public T_UC_AlignmentLoader(){}

    public D_BeBl_Alignment perform(String alignmentFileName)
    {
        D_BeBl_Alignment loadedAlignment = new D_BeBl_Alignment();
        T_CCC_FileRead fileReader = new T_CCC_FileRead();
        String theAlignmentString = fileReader.perform(alignmentFileName);
        theAlignmentString = theAlignmentString.substring(0,theAlignmentString.length()-1);
        String [] theGenomeSequencesStrings = theAlignmentString.split("\n",-1);
        for (int i=0; i<(theGenomeSequencesStrings.length-1); i = i + 2)
        {
            int idIndex = i;
            int genomesequenceIndex = i +1;
            D_BeBl_GenomeSequence genomeSequence = new D_BeBl_GenomeSequence();
            String id = theGenomeSequencesStrings[idIndex];
            id = id.substring(1, id.length());
            genomeSequence.setId(id);
            String sequence = theGenomeSequencesStrings[genomesequenceIndex];
            genomeSequence.setSequence(sequence);
            loadedAlignment.addSampleGenomeSequence(genomeSequence);
        }
        return loadedAlignment;
    }
}
