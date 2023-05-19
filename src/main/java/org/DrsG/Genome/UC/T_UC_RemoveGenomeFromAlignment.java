package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;

public class T_UC_RemoveGenomeFromAlignment {

    public T_UC_RemoveGenomeFromAlignment(){}

    public void perform(D_BeBl_Alignment anAlignment, D_BeBl_GenomeSequence aGenomeSequence)
    {
        if (!anAlignment.getReferenceGenomeSequence().getId().equals(aGenomeSequence.getId()))
        {
            anAlignment.getSampleGenomeSequences().remove(aGenomeSequence);
        }
        else
        {
            if (anAlignment.getSampleGenomeSequences().size() == 1)
            {
                System.out.println("Alignment only contains one GenomeSequence - not allowed to remove this GenomeSequence");
            }
            D_BeBl_GenomeSequence newReferenceSequence = new D_BeBl_GenomeSequence();
            newReferenceSequence.setId(anAlignment.getSampleGenomeSequences().get(1).getId());
            newReferenceSequence.setSequence(anAlignment.getSampleGenomeSequences().get(1).getSequence());
            anAlignment.setReferenceGenomeSequence(newReferenceSequence);
            anAlignment.getSampleGenomeSequences().remove(aGenomeSequence);
        }
    }

}
