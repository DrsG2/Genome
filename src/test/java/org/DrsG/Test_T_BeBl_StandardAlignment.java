package org.DrsG;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.BeBl.T_BeBl_SNiPAlignment;
import org.DrsG.Genome.BeBl.T_BeBl_StandardAlignment;
import org.DrsG.Genome.UC.T_UC_RepositoryInitiation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The T_BeBl_StandardAlignment Test Class")  // give meaningful display name
public class Test_T_BeBl_StandardAlignment
{
    private Test_T_BeBl_StandardAlignment()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The StandardAlignmentTest Case")
    // give meaningful display name
    void testStandardAlignment()
    {
        // GIVEN
        System.out.println("GIVEN: ");
        System.out.println("An Alignment");
        D_BeBl_Repository aRepository = new D_BeBl_Repository();
        T_UC_RepositoryInitiation aRepositoryInitiator = new T_UC_RepositoryInitiation();
        aRepositoryInitiator.perform(aRepository);
        //System.out.println(aRepository.getInitialOverview());
        // WHEN
        System.out.println("WHEN: ");
        System.out.println("The StandardAlignment is performed");
        T_BeBl_StandardAlignment standardAlignmentCreator = new T_BeBl_StandardAlignment();
        String standardAlignmentString;
        standardAlignmentString = standardAlignmentCreator.perform(aRepository.getOptimalAlignment());

        // THEN
        System.out.println("THEN: ");
        System.out.println("The StandardAlignment is created");
        // Result
        System.out.println("RESULT: ");
        System.out.println("StandardAlignment = \n" + standardAlignmentString);


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
