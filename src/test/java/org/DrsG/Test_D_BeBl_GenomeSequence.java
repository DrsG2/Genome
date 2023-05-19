package org.DrsG;
import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The Test Class")  // give meaningful display name
public class Test_D_BeBl_GenomeSequence
{
    private Test_D_BeBl_GenomeSequence()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The D_BeBl_GenomeSequence Test Case")
    // give meaningful display name
    void testTemplate()
    {
        System.out.println("****************************");
        System.out.println("The D_BeBl_GenomeSequence Test Case");
        // GIVEN
        System.out.println("GIVEN: ");
        System.out.println("An id and a sequence");
        // WHEN
        String id = "2023.U.C.P89";
        String sequence = "TTTTTGGGGCCCCAAAAAGGTTCC";
        System.out.println("WHEN: ");
        System.out.println("A genomeseuqence is created with the id and sequence");
        // THEN
        D_BeBl_GenomeSequence aGenomeSequence = new D_BeBl_GenomeSequence();
        aGenomeSequence.setId(id);
        aGenomeSequence.setSequence(sequence);
        System.out.println("THEN: ");
        System.out.println("A genome sequence object is created");
        // Result
        System.out.println("RESULT: ");
        System.out.println(aGenomeSequence.getOverview());
        assertEquals(id, aGenomeSequence.getId());
        assertEquals(sequence, aGenomeSequence.getSequence());

    }
}
