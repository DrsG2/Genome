package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;

public class T_UC_ReplaceGenomeInAlignment {

    public T_UC_ReplaceGenomeInAlignment(){}

    public void perform(D_BeBl_Alignment anAlignment, D_BeBl_GenomeSequence aGenomeSequenceToReplace, D_BeBl_GenomeSequence aGenomeSequenceReplacement)
    {
        if (!anAlignment.getReferenceGenomeSequence().getId().equals(aGenomeSequenceToReplace.getId()))
        {
            int location = anAlignment.getSampleGenomeSequences().indexOf(aGenomeSequenceToReplace);
            anAlignment.getSampleGenomeSequences().get(location).setId(aGenomeSequenceReplacement.getId());
            anAlignment.getSampleGenomeSequences().get(location).setSequence(aGenomeSequenceReplacement.getSequence());
        }
        else
        {
            int location = anAlignment.getSampleGenomeSequences().indexOf(aGenomeSequenceToReplace);
            anAlignment.getSampleGenomeSequences().get(location).setId(aGenomeSequenceReplacement.getId());
            anAlignment.getSampleGenomeSequences().get(location).setSequence(aGenomeSequenceReplacement.getSequence());
            anAlignment.getReferenceGenomeSequence().setId(aGenomeSequenceReplacement.getId());
            anAlignment.getReferenceGenomeSequence().setSequence(aGenomeSequenceReplacement.getSequence());
        }
    }
}
