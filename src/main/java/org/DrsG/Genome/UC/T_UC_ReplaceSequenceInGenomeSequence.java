package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;

public class T_UC_ReplaceSequenceInGenomeSequence {

    public T_UC_ReplaceSequenceInGenomeSequence(){}

    public void perform (D_BeBl_GenomeSequence aGenomeSequence, String aSequenceToReplace, String aSequenceReplacement)
    {
        if (aSequenceToReplace.length() == aSequenceReplacement.length())
        {
            String newGenomeSequenceString = aGenomeSequence.getSequence().replace(aSequenceToReplace, aSequenceReplacement);
            aGenomeSequence.setSequence(newGenomeSequenceString);
        }
        else
        {
            System.out.println("ERROR: the replacement sequence must be equal in length of the sequence to replace");
        }

    }
}
