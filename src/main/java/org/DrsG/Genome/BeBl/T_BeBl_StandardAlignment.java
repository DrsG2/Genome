package org.DrsG.Genome.BeBl;

import java.util.ArrayList;

public class T_BeBl_StandardAlignment {

    public T_BeBl_StandardAlignment()
    {
    }

    public String perform(D_BeBl_Alignment anAlignment)
    {
        String standardAlignment =              "******************************** \n";
        standardAlignment = standardAlignment + "* Standard Alignment           * \n";
        standardAlignment = standardAlignment + "******************************** \n";
        D_BeBl_GenomeSequence referenceGenomeSequence = anAlignment.getReferenceGenomeSequence();
        standardAlignment = standardAlignment + "Reference Genome Sequence: \n" + referenceGenomeSequence.getOverview() + "\n";
        standardAlignment = standardAlignment + "Standard Alignment to Reference Genome Sequence: \n";

        ArrayList<D_BeBl_GenomeSequence> sampleGenomeSequences = anAlignment.getSampleGenomeSequences() ;

        for (D_BeBl_GenomeSequence aGenomeSequence:sampleGenomeSequences )
        {
            if (!referenceGenomeSequence.getId().equals(aGenomeSequence.getId()))
            {
                standardAlignment = standardAlignment + ">" + aGenomeSequence.getId() + "\n";
                standardAlignment = standardAlignment + aGenomeSequence.getSequence() + "\n";
            }
        }

        return standardAlignment;
    }
}
