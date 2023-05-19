package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_User;
import org.DrsG.Genome.BeBl.D_BeBl_UserList;

public class T_UC_RoleChecker {

    public T_UC_RoleChecker(){}

    public String perform(D_BeBl_UserList aUserList, String aFirstName, String aLastname)
    {
        String theRole = "INVALID_USER";
        String fullName = aFirstName + aLastname;
        //System.out.println(fullName);
        for (D_BeBl_User aUser:aUserList.getUsers())
        {
            String aUserName = aUser.getFirstName() + aUser.getLastName();
            //System.out.println(aUser);
            if (fullName.toUpperCase().equals(aUserName.toUpperCase()))
            {
                theRole = aUser.getRole();
            }
        }
        return theRole;
    }
}
