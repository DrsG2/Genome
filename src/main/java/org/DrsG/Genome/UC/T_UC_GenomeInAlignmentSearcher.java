package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;

public class T_UC_GenomeInAlignmentSearcher {
    public T_UC_GenomeInAlignmentSearcher()
    {}

    public D_BeBl_GenomeSequence perform (D_BeBl_Alignment anAlignment, String aGenomeSequenceID)
    {
        D_BeBl_GenomeSequence theGenomeSequence = new D_BeBl_GenomeSequence();
        for (D_BeBl_GenomeSequence aGenomeSequence:anAlignment.getSampleGenomeSequences())
        {
            if (aGenomeSequence.getId().equals(aGenomeSequenceID))
            {
                theGenomeSequence = aGenomeSequence;
                break;
            }
        }
        return theGenomeSequence;
    }
}
