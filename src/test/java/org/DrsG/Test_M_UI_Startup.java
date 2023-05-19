package org.DrsG;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.UI.M_UI_Startup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Startup Test Class")  // give meaningful display name
public class Test_M_UI_Startup
{
    private Test_M_UI_Startup()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The Start Case")
    // give meaningful display name
    void testTemplate()
    {
        // GIVEN
        System.out.println("GIVEN: ");
        System.out.println("The repository initialization menu");
        M_UI_Startup startup = new M_UI_Startup();
        D_BeBl_Repository theRepository;
        theRepository = startup.perform();
        // WHEN
        System.out.println("WHEN: ");
        System.out.println("A choice is made");
        // THEN
        System.out.println("THEN: ");
        // Result
        System.out.println("The corresponding initiation is started");
        System.out.println("RESULT: ");
        System.out.println(theRepository.getInitialOverview());

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
