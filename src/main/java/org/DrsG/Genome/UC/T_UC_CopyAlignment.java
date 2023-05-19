package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;

public class T_UC_CopyAlignment {

    public T_UC_CopyAlignment(){}

    public D_BeBl_Alignment perform (D_BeBl_Alignment anAlignment)
    {
        D_BeBl_Alignment newAlignment = new D_BeBl_Alignment();
        newAlignment.setName(anAlignment.getName());
        newAlignment.setOwner(anAlignment.getOwner());
        newAlignment.setReferenceGenomeSequence(anAlignment.getReferenceGenomeSequence());
        for (D_BeBl_GenomeSequence aGenomeSequence: anAlignment.getSampleGenomeSequences())
        {
            newAlignment.addSampleGenomeSequence(aGenomeSequence);
        }
        return newAlignment;
    }
}
