package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_User;
import org.DrsG.Genome.BeBl.D_BeBl_UserList;
import org.DrsG.Genome.CCC.T_CCC_FileRead;

public class T_UC_UserListLoader {

    public T_UC_UserListLoader(){}

    public D_BeBl_UserList perform(String usersFileName)
    {
        D_BeBl_UserList theUserList = new D_BeBl_UserList();
        T_CCC_FileRead fileReader = new T_CCC_FileRead();
        String theUserListString = fileReader.perform(usersFileName);
        theUserListString = theUserListString.substring(0,theUserListString.length()-1);
        String [] theUserListStrings = theUserListString.split("\n",-1);
        for (String aUserString:theUserListStrings)
        {
            String[] theUserParts = aUserString.split(" ",-1);
            String userRole = theUserParts[0];
            // System.out.println("UserRole = " + userRole);
            String userFirstName = theUserParts[1];
            //System.out.println("userFirstname = " + userFirstName);
            String userLastName = theUserParts[2];
            //System.out.println("userLastname = " + userLastName);
            D_BeBl_User aUser = new D_BeBl_User();
            aUser.setRole(userRole);
            aUser.setFirstName(userFirstName);
            aUser.setLastName(userLastName);
            theUserList.addUser(aUser);
        }
        return theUserList;
    }
}
