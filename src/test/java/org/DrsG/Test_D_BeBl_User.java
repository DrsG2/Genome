package org.DrsG;
import org.DrsG.Genome.BeBl.D_BeBl_User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("The D_BeBl_User Test Class")  // give meaningful display name
public class Test_D_BeBl_User
{
    private Test_D_BeBl_User()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("Testing basics of D_BeBl_User - 1")
    // give meaningful display name
    void A1_BasicTest()
    {
        System.out.println("*************************************");
        System.out.println("Testing basics of D_BeBl_User - 1");
        // GIVEN
        System.out.println("GIVEN: a first name, a last name and a role as Strings");
        String aFirstName = "John";
        String aLastName = "Doe";
        String aRole = "TeamLeaD";
        // WHEN
        System.out.println("WHEN: a new users is created and the first, last and role are assinged");
        // THEN
        System.out.println("THEN: a user object is created of which the overview can be printed");
        D_BeBl_User aUser = new D_BeBl_User();
        aUser.setFirstName(aFirstName);
        aUser.setLastName(aLastName);
        aUser.setRole(aRole);
        // Result
        System.out.println("RESULT: ");
        System.out.println("Overview = ");
        System.out.println(aUser.getOverview());
        assertEquals(aFirstName, aUser.getFirstName());
        assertEquals(aLastName, aUser.getLastName());
        assertEquals(aRole.toUpperCase(), aUser.getRole());

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
    @Test
    @DisplayName("Testing basics of D_BeBl_User - 2")
        // give meaningful display name
    void A2_BasicTest()
    {
        System.out.println("*************************************");
        System.out.println("Testing basics of D_BeBl_User - 2");
        // GIVEN
        System.out.println("GIVEN: a first name, a last name and a role as Strings");
        String aFirstName = "John";
        String aLastName = "Doe";
        String aRole = "TeCHnicalSupport";
        // WHEN
        System.out.println("WHEN: a new users is created and the first, last and role are assinged");
        // THEN
        System.out.println("THEN: a user object is created of which the overview can be printed");
        D_BeBl_User aUser = new D_BeBl_User();
        aUser.setFirstName(aFirstName);
        aUser.setLastName(aLastName);
        aUser.setRole(aRole);
        // Result
        System.out.println("RESULT: ");
        System.out.println("Overview = ");
        System.out.println(aUser.getOverview());
        assertEquals(aFirstName, aUser.getFirstName());
        assertEquals(aLastName, aUser.getLastName());
        assertEquals(aRole.toUpperCase(), aUser.getRole());

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

    @Test
    @DisplayName("Testing basics of D_BeBl_User - 3")
        // give meaningful display name
    void A3_BasicTest()
    {
        System.out.println("*************************************");
        System.out.println("Testing basics of D_BeBl_User - 3");
        // GIVEN
        System.out.println("GIVEN: a first name, a last name and a role as Strings");
        String aFirstName = "John";
        String aLastName = "Doe";
        String aRole = "BioInformatician";
        // WHEN
        System.out.println("WHEN: a new users is created and the first, last and role are assinged");
        // THEN
        System.out.println("THEN: a user object is created of which the overview can be printed");
        D_BeBl_User aUser = new D_BeBl_User();
        aUser.setFirstName(aFirstName);
        aUser.setLastName(aLastName);
        aUser.setRole(aRole);
        // Result
        System.out.println("RESULT: ");
        System.out.println("Overview = ");
        System.out.println(aUser.getOverview());
        assertEquals(aFirstName, aUser.getFirstName());
        assertEquals(aLastName, aUser.getLastName());
        assertEquals(aRole.toUpperCase(), aUser.getRole());

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
    @Test
    @DisplayName("Testing the assignment of a wrong role ")
        // give meaningful display name
    void B_Wrong_Role_Test()
    {
        System.out.println("*************************************");
        System.out.println("Testing the assignment of a wrong role ");
        // GIVEN
        System.out.println("GIVEN: a first name, a last name and a (wrong) role as Strings");
        String aFirstName = "John";
        String aLastName = "Doe";
        String aRole = "teamLead";
        // WHEN
        System.out.println("WHEN: a new users is created and the first, last and role are assigned");
        // THEN
        System.out.println("THEN: an error message should be printed and the assigned role is NONE");
        D_BeBl_User aUser = new D_BeBl_User();
        aUser.setFirstName(aFirstName);
        aUser.setLastName(aLastName);
        aUser.setRole(aRole);
        // Result
        System.out.println("RESULT: ");
        System.out.println("Overview = ");
        System.out.println(aUser.getOverview());
        assertEquals(aRole.toUpperCase(), aUser.getRole());
    }

}
