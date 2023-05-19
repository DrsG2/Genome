package org.DrsG;
import org.DrsG.Genome.CCC.T_CCC_FileRead;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The T_FileRead Test Class")  // give meaningful display name
public class Test_T_FileRead
{
    private Test_T_FileRead()
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
        String fileName = "team.txt";
        String fullFileName = fileLocation + "\\" + fileName;
        // WHEN
        System.out.println("WHEN: ");
        System.out.println("a FileRead is performed");
        T_CCC_FileRead fileReader = new T_CCC_FileRead();
        String fileContent = "";
        fileContent = fileReader.perform(fullFileName);
        // THEN
        System.out.println("THEN: ");
        System.out.println("A string is returned that contains the content of the file");
        // Result
        System.out.println("RESULT: ");
        System.out.println(fileContent);

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
