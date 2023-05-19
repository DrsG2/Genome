package org.DrsG;
import org.DrsG.Genome.CCC.T_CCC_FileRead;
import org.DrsG.Genome.CCC.T_CCC_FileWrite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Test T_CCC_FileWrite Class")  // give meaningful display name
public class Test_T_CCC_FileWrite
{
    private Test_T_CCC_FileWrite()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The FileWriter Case")
    // give meaningful display name
    void testTemplate()
    {
        // GIVEN
        System.out.println("GIVEN: ");
        System.out.println("A full name (path + file name of a file) and some content");
        String fileLocation = "C:\\Users\\ghaer\\OneDrive\\Developments\\Genome\\Data\\";
        String fileName = "output.txt";
        String fullFileName = fileLocation + fileName;
        String someContent = "Just some content \n you know.";
        // WHEN
        System.out.println("WHEN: ");
        System.out.println(" FileWriter is performed");
        T_CCC_FileWrite fileWriter = new T_CCC_FileWrite();
        boolean writeOK = fileWriter.perform(fullFileName, someContent);
        // THEN
        System.out.println("THEN: ");
        System.out.println("The content is written to the file");
        // Result
        System.out.println("RESULT: ");
        System.out.println("WriteOK = " + writeOK);
        T_CCC_FileRead fileReader = new T_CCC_FileRead();
        String someReadContent = fileReader.perform(fullFileName);
        System.out.println(someReadContent);


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
