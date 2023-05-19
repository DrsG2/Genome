package org.DrsG;

import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.UC.T_UC_GenomeInAlignmentSearcher;
import org.DrsG.Genome.UC.T_UC_RemoveGenomeFromAlignment;
import org.DrsG.Genome.UC.T_UC_RepositoryInitiation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The T_UC_RemoveGenomeFrom Test Class")  // give meaningful display name
public class Test_T_UC_RemoveGenomeFromAlignment
{
    private Test_T_UC_RemoveGenomeFromAlignment()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The RemoveGenomeFromAlignment Test Case")
    // give meaningful display name
    void testGenomeSearch()
    {
        // GIVEN
        System.out.println("GIVEN: ");
        System.out.println("An Alignment and a Genome");
        D_BeBl_Repository aRepository = new D_BeBl_Repository();
        T_UC_RepositoryInitiation aRepositoryInitiator = new T_UC_RepositoryInitiation();
        aRepositoryInitiator.perform(aRepository);
        String aGenomeID = ">1990.U.CD.90.90CD121E12";
        T_UC_GenomeInAlignmentSearcher aGenomeSearcher = new T_UC_GenomeInAlignmentSearcher();
        D_BeBl_GenomeSequence genomeSequenceToRemove = new D_BeBl_GenomeSequence() ;
        genomeSequenceToRemove = aGenomeSearcher.perform(aRepository.getOptimalAlignment(), aGenomeID);
        //System.out.println(aRepository.getInitialOverview());
        // WHEN
        System.out.println("Number of GenomeSequences in the Alignment = " + aRepository.getOptimalAlignment().getSampleGenomeSequences().size());
        System.out.println("WHEN: ");
        System.out.println("The a remove of a genomesequence objects from Alignment is performed");
        T_UC_RemoveGenomeFromAlignment aGenomeSequenceFromAlignmentRemover = new T_UC_RemoveGenomeFromAlignment();
        aGenomeSequenceFromAlignmentRemover.perform(aRepository.getOptimalAlignment(), genomeSequenceToRemove);
       // THEN
        System.out.println("THEN: ");
        System.out.println("The Genome sequence is removed from the Alignment - one less sequence in the Alignment");
        // Result
        System.out.println("RESULT: ");
        System.out.println("Number of GenomeSequences in the Alignment = " + aRepository.getOptimalAlignment().getSampleGenomeSequences().size());
        System.out.println(aRepository.getOptimalAlignment().getOverview());


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
