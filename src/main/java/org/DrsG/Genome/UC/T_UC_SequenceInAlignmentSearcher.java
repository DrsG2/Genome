package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;

import java.util.ArrayList;

public class T_UC_SequenceInAlignmentSearcher {
    public T_UC_SequenceInAlignmentSearcher()
    {}

    public ArrayList<String> perform(D_BeBl_Alignment anAlignment, String aSequence)
    {
        ArrayList<String> result = new ArrayList<String>();
        for (D_BeBl_GenomeSequence genomeSequence:anAlignment.getSampleGenomeSequences())
        {
            if (genomeSequence.getSequence().contains(aSequence))
            {
                result.add(genomeSequence.getId());
            }
        }
        return result;
    }
}
