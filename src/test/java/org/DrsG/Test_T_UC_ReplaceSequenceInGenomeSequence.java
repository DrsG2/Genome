package org.DrsG;
import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.UC.T_UC_ReplaceSequenceInGenomeSequence;
import org.DrsG.Genome.UC.T_UC_RepositoryInitiation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The T_UC_ReplaceSequenceInGenomeSequence Test Class")  // give meaningful display name
public class Test_T_UC_ReplaceSequenceInGenomeSequence
{
    private Test_T_UC_ReplaceSequenceInGenomeSequence()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The ReplaceSequence in Genome Test Case")
    // give meaningful display name
    void testReplaceSequenceInGenomeSequence()
    {
        // GIVEN
        System.out.println("GIVEN: ");
        System.out.println("An Genome Sequence, a Sequence to replace and a replacement Sequence");
        D_BeBl_Repository aRepository = new D_BeBl_Repository();
        T_UC_RepositoryInitiation aRepositoryInitiator = new T_UC_RepositoryInitiation();
        aRepositoryInitiator.perform(aRepository);
        D_BeBl_GenomeSequence aGenomeSequence = aRepository.getOptimalAlignment().getReferenceGenomeSequence();
        String aSequenceToReplace = "CAAACCCGCCGGT";
        String aReplacementSequence = "TTTTTTTTTTTTT";
        //System.out.println(aRepository.getInitialOverview());
        // WHEN
        System.out.println("WHEN: ");
        System.out.println("The replacement is performed");
        T_UC_ReplaceSequenceInGenomeSequence aSequenceReplacer = new T_UC_ReplaceSequenceInGenomeSequence();
        aSequenceReplacer.perform(aGenomeSequence, aSequenceToReplace, aReplacementSequence);
       // THEN
        System.out.println("THEN: ");
        System.out.println("The genome sequence has the old subsequence replaced by the new");
        // Result
        System.out.println("RESULT: ");
        System.out.println(aGenomeSequence.getOverview());



    /* assertTrue --> Assert that condition is true
    assertFalse --> Assert that condition is false
    assertNull --> Assert that object is null
    assertNotNull --> Assert that object is not null
    assertEquals --> Assert that expected and actual are equal
    assertNotEquals -->Assert that expected and actual are not equal
    assertArrayEquals --> Assert that expected and actual arrays are equals
    assertSame --> Assert that expected and actual refer to the same object
    assertNotSame --> Assert that expected and actual do not refer to the same object
    */
    }
}
