package org.DrsG;
import org.DrsG.Genome.BeBl.D_BeBl_UserList;
import org.DrsG.Genome.UC.T_UC_UserListLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The UserListLoader Test Class")  // give meaningful display name
public class Test_T_UserListLoader
{
    private Test_T_UserListLoader()
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
        System.out.println("a UserListLoader is performed");
        T_UC_UserListLoader userListLoad = new T_UC_UserListLoader();
        D_BeBl_UserList theUserList = new D_BeBl_UserList();
        theUserList = userListLoad.perform(fullFileName);
         // THEN
        System.out.println("THEN: ");
        // Result
        System.out.println("RESULT: ");
        System.out.println(theUserList.getOverview());

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
