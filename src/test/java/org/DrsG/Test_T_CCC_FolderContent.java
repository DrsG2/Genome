package org.DrsG;
import org.DrsG.Genome.CCC.T_CCC_FolderContent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@DisplayName("The T_CCC_FolderContent Test Class")  // give meaningful display name
public class Test_T_CCC_FolderContent
{
    private Test_T_CCC_FolderContent()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The FolderContent Case")
    // give meaningful display name
    void testTemplate()
    {
        // GIVEN
        System.out.println("GIVEN: ");
        System.out.println("A folder path");
        String location = "C:\\Users\\ghaer\\OneDrive\\Developments\\Genome\\Data";
        // WHEN
        System.out.println("WHEN: ");
        System.out.println("The folder content is performed");
        T_CCC_FolderContent folderContentCreator = new T_CCC_FolderContent();
        ArrayList<String>  folderContent =new ArrayList<String>();
        folderContent = folderContentCreator.perform(location);
        // THEN
        System.out.println("THEN: ");
        // Result
        System.out.println("The content of the folder is given");
        System.out.println("RESULT: ");
        System.out.println(folderContent.toString());

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
