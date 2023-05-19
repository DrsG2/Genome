package org.DrsG.Genome.BeBl;

import java.util.ArrayList;
public class T_BeBl_AlignmentScoreCalculator {

    public T_BeBl_AlignmentScoreCalculator()
    {}

    public int perform(D_BeBl_Alignment anAlignment)
    {
        int alignmentScore = 0;
        D_BeBl_GenomeSequence referenceGenomeSequence = new D_BeBl_GenomeSequence();
        referenceGenomeSequence = anAlignment.getReferenceGenomeSequence();
        String refGenomeSequenceString = referenceGenomeSequence.getSequence();
        ArrayList<D_BeBl_GenomeSequence> sampleGenomeSequences = anAlignment.getSampleGenomeSequences() ;

        for (D_BeBl_GenomeSequence aGenomeSequence:sampleGenomeSequences )
        {
            if (!referenceGenomeSequence.getId().equals(aGenomeSequence.getId()))
                {
                    String aGenomeSequenceString = aGenomeSequence.getSequence();
                    for (int i = 0; i < refGenomeSequenceString.length() - 1; i++)
                        {
                            char refChar = refGenomeSequenceString.charAt(i);
                            char sampleChar = aGenomeSequenceString.charAt(i);
                            boolean theSame = false;
                            theSame = (refChar == sampleChar);
                            if (!theSame)
                                {
                                    alignmentScore++;
                                }
                        }
                }
        }
        return alignmentScore;
    }
}
