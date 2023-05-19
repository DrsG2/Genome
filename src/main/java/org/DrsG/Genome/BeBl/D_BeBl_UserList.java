package org.DrsG.Genome.BeBl;

import java.util.ArrayList;

public class D_BeBl_UserList {

    private ArrayList<D_BeBl_User> userList =  new ArrayList<D_BeBl_User>();
    private String userListName;

    public void addUser(D_BeBl_User aUser)
    {
        this.userList.add(aUser);
    }

    public void removeUser(D_BeBl_User aUser)
    {
        Boolean succesfulRemoval;
        succesfulRemoval = this.userList.remove(aUser);
        if (!succesfulRemoval)
            {
                System.out.println("User does not exist");
            }
        else
            {
                System.out.println("User succesfully removed");
                // add code to remove alignments of that users
            }
    }

    public int getUserID(D_BeBl_User aUser)
    {
        return this.userList.indexOf(aUser);
    }

    public D_BeBl_User getUser(int aUserID)
    {
        return this.userList.get(aUserID);
    }

    public ArrayList<D_BeBl_User> getUsers(){return this.userList;};

    public String getOverview()
    {
        String overview = "";
        for (D_BeBl_User aUser:this.userList)
        {
            overview = overview + "ID = " + this.getUserID(aUser) + " ; " + aUser.getOverview();
        }
        return overview;
    }
}
