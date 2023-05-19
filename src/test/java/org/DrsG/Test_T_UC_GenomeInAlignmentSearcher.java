package org.DrsG;

import org.DrsG.Genome.BeBl.D_BeBl_GenomeSequence;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.UC.T_UC_GenomeInAlignmentSearcher;
import org.DrsG.Genome.UC.T_UC_RepositoryInitiation;
import org.DrsG.Genome.UC.T_UC_SequenceInAlignmentSearcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@DisplayName("The T_UC_GenomeInAlignmentSearcher Test Class")  // give meaningful display name
public class Test_T_UC_GenomeInAlignmentSearcher
{
    private Test_T_UC_GenomeInAlignmentSearcher()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The GenomeInAlignmentSearcher Test Case")
    // give meaningful display name
    void testGenomeSearch()
    {
        // GIVEN
        System.out.println("GIVEN: ");
        System.out.println("An Alignment and a GenomeID");
        D_BeBl_Repository aRepository = new D_BeBl_Repository();
        T_UC_RepositoryInitiation aRepositoryInitiator = new T_UC_RepositoryInitiation();
        aRepositoryInitiator.perform(aRepository);
        String aGenomeID = ">1993.F1.BE.93.VI850";
        //System.out.println(aRepository.getInitialOverview());
        // WHEN
        System.out.println("WHEN: ");
        System.out.println("The a search for the GenomeID in the Alignment is performed");
        T_UC_GenomeInAlignmentSearcher aGenomeSearcher = new T_UC_GenomeInAlignmentSearcher();
        D_BeBl_GenomeSequence searchResult = new D_BeBl_GenomeSequence() ;
        searchResult = aGenomeSearcher.perform(aRepository.getOptimalAlignment(), aGenomeID);
       // THEN
        System.out.println("THEN: ");
        System.out.println("The a list of ID's of genome sequences containing the sequence is returned");
        // Result
        System.out.println("RESULT: ");
        System.out.println("Genome Sequences  corresponding with the Genome ID ");
        System.out.println(searchResult.getOverview());


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
