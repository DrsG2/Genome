package org.DrsG;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.UC.T_UC_RepositoryInitiation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The T_RepositoryInitiation Test Class")  // give meaningful display name
public class Test_T_UC_RepositoryInitiation
{
    private Test_T_UC_RepositoryInitiation()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The RepositoryInitiation Test Case")
    // give meaningful display name
    void testTemplate()
    {
        // GIVEN
        System.out.println("GIVEN: ");
        System.out.println("An empty repository object");
        D_BeBl_Repository aRepository = new D_BeBl_Repository();
        // WHEN
        System.out.println("WHEN: ");
        System.out.println("The RepositoryInitiator is performed");
        T_UC_RepositoryInitiation aRepositoryInitiator = new T_UC_RepositoryInitiation();
        aRepositoryInitiator.perform(aRepository);
        // THEN
        System.out.println("THEN: ");
        System.out.println("The default fasta and user files are read and added to the repository");
        // Result
        System.out.println("RESULT: ");
        System.out.println(aRepository.getInitialOverview());


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
