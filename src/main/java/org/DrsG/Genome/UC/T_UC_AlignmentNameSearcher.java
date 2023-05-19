package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;

import java.util.ArrayList;

public class T_UC_AlignmentNameSearcher {

    public T_UC_AlignmentNameSearcher(){}

    public D_BeBl_Alignment perform(ArrayList<D_BeBl_Alignment> theWorkAlignments, String alignmentName)
    {
        D_BeBl_Alignment theAlignment = new D_BeBl_Alignment();
        for (D_BeBl_Alignment anAlignment: theWorkAlignments)
        {
            //System.out.println(anAlignment.getName());
            //System.out.println(alignmentName);
            if (alignmentName.equals(anAlignment.getName()))
            {
                theAlignment = anAlignment;
                break;
            }
        }
        //System.out.println(theAlignment.getOverview());
        return theAlignment;

    }
}
