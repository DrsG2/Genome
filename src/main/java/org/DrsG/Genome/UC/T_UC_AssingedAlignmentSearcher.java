package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.BeBl.D_BeBl_User;

import java.util.ArrayList;

public class T_UC_AssingedAlignmentSearcher {

    public T_UC_AssingedAlignmentSearcher(){}

    public ArrayList<D_BeBl_Alignment> perform(ArrayList<D_BeBl_Alignment> theWorkAlignments, D_BeBl_User theUser)
    {
        ArrayList<D_BeBl_Alignment> userAssignedAlignments = new ArrayList<D_BeBl_Alignment>();
        String userFirstName = theUser.getFirstName().toUpperCase();
        String userLastName = theUser.getLastName().toUpperCase();
        for (D_BeBl_Alignment anAlignment:theWorkAlignments)
        {
            if ((anAlignment.getOwner().getFirstName().toUpperCase().equals(userFirstName)) && (anAlignment.getOwner().getLastName().toUpperCase().equals(userLastName)))
            {
                userAssignedAlignments.add(anAlignment);
            }
        }
        return userAssignedAlignments;

    }
}
