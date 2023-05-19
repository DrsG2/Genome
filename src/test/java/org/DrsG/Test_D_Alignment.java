package org.DrsG;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Test Class")  // give meaningful display name
public class Test_D_Alignment
{
    private Test_D_Alignment()
    {
        // If constructor required, write here
    }

    @Test
    @DisplayName("The Test Case")
    // give meaningful display name
    void testTemplate()
    {
        // GIVEN
        System.out.println("GIVEN: ");
        // WHEN
        System.out.println("WHEN: ");
        // THEN
        System.out.println("THEN: ");
        // Result
        System.out.println("RESULT: ");

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
