package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_User;
import org.DrsG.Genome.BeBl.D_BeBl_UserList;

public class T_UC_UserSearcher {

    public T_UC_UserSearcher(){}

    public D_BeBl_User perform(D_BeBl_UserList aUserList, String aFirstName, String aLastname)
    {
        String fullName = aFirstName + aLastname;
        D_BeBl_User activeUser = new D_BeBl_User();
        //System.out.println(fullName);
        for (D_BeBl_User aUser:aUserList.getUsers())
        {
            String aUserName = aUser.getFirstName() + aUser.getLastName();
            //System.out.println(aUser);
            if (fullName.toUpperCase().equals(aUserName.toUpperCase()))
            {
                activeUser.setFirstName(aUser.getFirstName());
                activeUser.setLastName(aUser.getLastName());
                activeUser.setRole(aUser.getRole());
            }
        }
        return activeUser;
    }
}
