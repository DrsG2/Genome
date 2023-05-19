package org.DrsG.Genome.BeBl;

import java.util.ArrayList;

public class T_BeBl_SNiPAlignment {

    public T_BeBl_SNiPAlignment(){}

    public String perform (D_BeBl_Alignment anAlignment)
    {
        String snipAlignment =          "******************************** \n";
        snipAlignment = snipAlignment + "* SNip Alignment               * \n";
        snipAlignment = snipAlignment + "******************************** \n";
        D_BeBl_GenomeSequence referenceGenomeSequence = new D_BeBl_GenomeSequence();
        referenceGenomeSequence = anAlignment.getReferenceGenomeSequence();
        String refGenomeSequenceString = referenceGenomeSequence.getSequence();
        snipAlignment = snipAlignment + "Reference Genome Sequence: \n" + referenceGenomeSequence.getOverview() + "\n";
        snipAlignment = snipAlignment + "SNiP Alignment to Reference Genome Sequence: \n";

        ArrayList<D_BeBl_GenomeSequence> sampleGenomeSequences = anAlignment.getSampleGenomeSequences() ;

        for (D_BeBl_GenomeSequence aGenomeSequence:sampleGenomeSequences )
        {
            if (!referenceGenomeSequence.getId().equals(aGenomeSequence.getId()))
            {
                String aGenomeSequenceString = aGenomeSequence.getSequence();
                snipAlignment = snipAlignment + ">" + aGenomeSequence.getId() + "\n";
                for (int i = 0; i < refGenomeSequenceString.length() - 1; i++)
                {
                    char refChar = refGenomeSequenceString.charAt(i);
                    char sampleChar = aGenomeSequenceString.charAt(i);
                    boolean theSame = false;
                    theSame = (refChar == sampleChar);
                    if (!theSame)
                    {
                        snipAlignment = snipAlignment + sampleChar;
                    }
                    else
                    {
                        snipAlignment = snipAlignment + ".";
                    }
                }
                snipAlignment = snipAlignment + "\n";
            }
        }

        return snipAlignment;

    }
}
