package org.DrsG.Genome.BeBl;

import java.util.ArrayList;

public class D_BeBl_Alignment {

    private String name = "empty";
    private D_BeBl_User owner = new D_BeBl_User();
    private D_BeBl_GenomeSequence referenceGenomeSequence = new D_BeBl_GenomeSequence();
    private ArrayList<D_BeBl_GenomeSequence> sampleGenomeSequences = new ArrayList<D_BeBl_GenomeSequence>();
    public D_BeBl_Alignment(){}

    public void setName(String aName)
    {
        this.name = aName;
    }

    public void setReferenceGenomeSequence (D_BeBl_GenomeSequence aGnomeSequence)
    {
        this.referenceGenomeSequence = aGnomeSequence;
    }

    public void addSampleGenomeSequence(D_BeBl_GenomeSequence aSampleGenomeSequence)
    {
        this.sampleGenomeSequences.add(aSampleGenomeSequence);
        if (this.sampleGenomeSequences.size() == 1)
            {
                this.referenceGenomeSequence = aSampleGenomeSequence;
            }
    }

    public void setOwner(D_BeBl_User aUser)
    {
        this.owner = aUser;
    }

    public String getName()
    {
        return this.name;
    }

    public D_BeBl_User getOwner(){ return this.owner;}

    public D_BeBl_GenomeSequence getReferenceGenomeSequence()
    {
        return this.referenceGenomeSequence;
    }

    public ArrayList<D_BeBl_GenomeSequence> getSampleGenomeSequences()
    {
        return sampleGenomeSequences;
    }

    public String getStandardAlignment()
    {
        String standardAlignment;
        T_BeBl_StandardAlignment aStandardAlignmentProvider = new T_BeBl_StandardAlignment();
        standardAlignment = aStandardAlignmentProvider.perform(this);
        return standardAlignment;
    }

    public String getSNipAlignment()
    {
        String theSNiPAlignment;
        T_BeBl_SNiPAlignment aSNiPAlignmentProvider = new T_BeBl_SNiPAlignment();
        theSNiPAlignment = aSNiPAlignmentProvider.perform(this);
        return theSNiPAlignment;
    }

    public int getAlignmentScore()
    {
        int score;
        T_BeBl_AlignmentScoreCalculator anAlignmentScoreCalculator = new T_BeBl_AlignmentScoreCalculator();
        score = anAlignmentScoreCalculator.perform(this);
        return score;
    }

    public String getOverview()
    {
        String overview = "";
        overview = overview + "Alignment name: " + this.name + "\n";
        overview = overview + "Alignment owner: " + this.owner.getOverview();
        overview = overview + "Alignment Reference Genome Sequence: \n" + this.referenceGenomeSequence.getOverview();
        overview = overview + "All Genome Sequences of Alignment: \n";
        for (D_BeBl_GenomeSequence gs:this.sampleGenomeSequences)
        {
            overview = overview + gs.getOverview();
        }
        return overview;
    }

    public String getOverviewForSaving()
    {
        String overviewForSaving ="";
        overviewForSaving = overviewForSaving + "AlignmentName: \n";
        overviewForSaving = overviewForSaving + this.getName() + "\n";
        overviewForSaving = overviewForSaving + "Reference Genome Sequence:\n";
        overviewForSaving = overviewForSaving + ">" + this.getReferenceGenomeSequence().getId() + "\n";
        overviewForSaving = overviewForSaving + this.getReferenceGenomeSequence().getSequence()+ "'\n";
        overviewForSaving = overviewForSaving + "Sample Genome Sequences:" + "\n";
        for (D_BeBl_GenomeSequence aGenomeSequence:this.getSampleGenomeSequences())
        {
            overviewForSaving = overviewForSaving + ">" + aGenomeSequence.getId() + "\n";
            overviewForSaving = overviewForSaving + this.getReferenceGenomeSequence().getSequence() + "\n";
        }
        return overviewForSaving;
    }

}
