package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_User;

import java.util.ArrayList;

public class T_UC_ReportCreator {

    public T_UC_ReportCreator(){}

    public String perform (ArrayList<D_BeBl_Alignment> theAlignments, D_BeBl_User aUser)
    {
        String reportContent = "";
        reportContent = reportContent + "Report Alignments Scores of assigned Alignments to " + aUser.getLastName() + " " + aUser.getLastName() + "\n";
        int bestAlignmentScore = theAlignments.get(0).getAlignmentScore() ;
        String bestAlignmentName = theAlignments.get(0).getName();
        for (D_BeBl_Alignment anAlignment: theAlignments)
        {
            String id = anAlignment.getName();
            int score = anAlignment.getAlignmentScore();
            if (score < bestAlignmentScore)
            {
                bestAlignmentScore = score;
                bestAlignmentName = id;
            }
            reportContent = reportContent + id + " -- Alignment score = " + score + "\n";
        }

        reportContent = reportContent + "Best Alignment score is for Alignment " + bestAlignmentName + " : " + bestAlignmentScore + "\n";
        return reportContent;
    }
}
