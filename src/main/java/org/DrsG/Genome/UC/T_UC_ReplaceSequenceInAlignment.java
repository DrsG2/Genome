package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;

public class T_UC_ReplaceSequenceInAlignment {

    public T_UC_ReplaceSequenceInAlignment(){}

    public void perform(D_BeBl_Alignment anAlignment, String aSequenceToReplace, String aSequenceReplacement)
    {

        T_UC_ReplaceSequenceInGenomeSequence aSequenceReplacer = new T_UC_ReplaceSequenceInGenomeSequence();

        for (D_BeBl_GenomeSequence aGenomeSequence: anAlignment.getSampleGenomeSequences())
        {
            aSequenceReplacer.perform(aGenomeSequence, aSequenceToReplace, aSequenceReplacement);
        }

        aSequenceReplacer.perform(anAlignment.getReferenceGenomeSequence(), aSequenceToReplace, aSequenceReplacement);
    }
}
