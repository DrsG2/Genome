package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;

import java.util.ArrayList;

public class T_UC_SubSequenceInAlignmentSearcher {

    public T_UC_SubSequenceInAlignmentSearcher(){}
    public ArrayList<D_BeBl_GenomeSequence> perform(D_BeBl_Alignment theAlignment, String theSubSequence)
    {
        ArrayList<D_BeBl_GenomeSequence> resultGenomeSequences = new ArrayList<D_BeBl_GenomeSequence>();

        for (D_BeBl_GenomeSequence aGenomeSequence: theAlignment.getSampleGenomeSequences())
        {
            if (aGenomeSequence.getSequence().contains(theSubSequence.toUpperCase()))
            {
                resultGenomeSequences.add(aGenomeSequence);
            }
        }
        return resultGenomeSequences;
    }
}
