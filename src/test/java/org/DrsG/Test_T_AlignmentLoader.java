package org.DrsG;
import org.DrsG.Genome.UC.T_UC_AlignmentLoader;
import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The T_ AlignmentLoader Test Class")  // give meaningful display name
public class Test_T_AlignmentLoader
{
    private Test_T_AlignmentLoader()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The Perform Test Case")
    // give meaningful display name
    void testTemplate()
    {
        // GIVEN
        System.out.println("GIVEN: ");
        System.out.println("A file location and and a file name");
        String fileLocation = "C:\\Users\\ghaer\\OneDrive\\Developments\\Genome\\Data";
        String fileName = "hiv.fasta";
        String fullFileName = fileLocation + "\\" + fileName;
        // WHEN
        System.out.println("WHEN: ");
        System.out.println("a AlignmentLoader is performed");
        T_UC_AlignmentLoader alignmentLoad = new T_UC_AlignmentLoader();
        D_BeBl_Alignment theAlignment = new D_BeBl_Alignment();
        theAlignment = alignmentLoad.perform(fullFileName);
        // THEN
        System.out.println("THEN: ");
        // Result
        System.out.println("RESULT: ");
        System.out.println(theAlignment.getOverview());

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
