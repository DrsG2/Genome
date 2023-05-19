package org.DrsG;
import org.DrsG.Genome.BeBl.D_BeBl_User;
import org.DrsG.Genome.BeBl.D_BeBl_UserList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The D_BeBl_UserList Test Class")  // give meaningful display name
public class Test_D_BeBl_UserList
{
    private Test_D_BeBl_UserList()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("Test adding users to D_BeBlUsers")
    // give meaningful display name
    void A_AddUsers()
    {
        System.out.println("*******************************");
        System.out.println("Test adding users to D_BeBlUsers");
        // GIVEN
        System.out.println("GIVEN: 3 users ");
        // WHEN
        String firstName1 = "John";
        String lastName1 = "Doe the first";
        String role1 =  "TeamLeader";
        D_BeBl_User user1 = new D_BeBl_User(firstName1,lastName1,role1);
        String firstName2 = "John";
        String lastName2 = "Doe the second";
        String role2 =  "Technician";
        D_BeBl_User user2 = new D_BeBl_User(firstName2,lastName2,role2);
        String firstName3 = "John";
        String lastName3 = "Doe the third";
        String role3 =  "Bioinformatician";
        D_BeBl_User user3 = new D_BeBl_User(firstName3,lastName3,role3);
        System.out.println("WHEN: the 3 users are added to the list");
        // THEN
        D_BeBl_UserList aUserList = new D_BeBl_UserList();
        aUserList.addUser(user1);
        aUserList.addUser(user2);
        aUserList.addUser(user3);
        System.out.println("THEN: we get a list of 3 users. The first user with have id 0, the second id 1 and third id 2");
        // Result
        System.out.println("RESULT: ");
        System.out.println(aUserList.getOverview());
        assertEquals(0,aUserList.getUserID(user1));
        assertEquals(1,aUserList.getUserID(user2));
        assertEquals(2,aUserList.getUserID(user3));
        assertEquals(user1, aUserList.getUser(0));
        assertEquals(user2, aUserList.getUser(1));
        assertEquals(user3, aUserList.getUser(2));

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
