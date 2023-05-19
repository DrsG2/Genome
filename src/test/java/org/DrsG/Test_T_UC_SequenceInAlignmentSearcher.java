package org.DrsG;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.UC.T_UC_SequenceInAlignmentSearcher;
import org.DrsG.Genome.UC.T_UC_RepositoryInitiation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@DisplayName("The T_UC_SequenceInAlignmentSearcher Test Class")  // give meaningful display name
public class Test_T_UC_SequenceInAlignmentSearcher
{
    private Test_T_UC_SequenceInAlignmentSearcher()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The SequenceInAlignmentSearcher Test Case")
    // give meaningful display name
    void testAlignmentSearch()
    {
        // GIVEN
        System.out.println("GIVEN: ");
        System.out.println("An Alignment and a Sequence");
        D_BeBl_Repository aRepository = new D_BeBl_Repository();
        T_UC_RepositoryInitiation aRepositoryInitiator = new T_UC_RepositoryInitiation();
        aRepositoryInitiator.perform(aRepository);
        String sequence = "CCAGGGAGTTGCGCCAAGACCACCCTCCATACGC";
        //System.out.println(aRepository.getInitialOverview());
        // WHEN
        System.out.println("WHEN: ");
        System.out.println("The a search of the sequence of the Alignment is performed");
        T_UC_SequenceInAlignmentSearcher alignmentSearcher = new T_UC_SequenceInAlignmentSearcher();
        ArrayList<String> searchResult = new ArrayList<String>();
        searchResult = alignmentSearcher.perform(aRepository.getOptimalAlignment(), sequence);
       // THEN
        System.out.println("THEN: ");
        System.out.println("The a list of ID's of genome sequences containing the sequence is returned");
        // Result
        System.out.println("RESULT: ");
        System.out.println("Genome Sequences containing sequence " + sequence + " :  \n");
        System.out.println(searchResult);


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
