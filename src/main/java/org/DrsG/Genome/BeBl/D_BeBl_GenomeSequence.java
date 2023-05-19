package org.DrsG.Genome.BeBl;

public class D_BeBl_GenomeSequence {

    private String id = "empty";
    private String sequence;

    public D_BeBl_GenomeSequence()
    {

    }

    public void setId(String anID)
    {
        this.id = anID;
    }

    public void setSequence(String aSequence)
    {
        this.sequence = aSequence;
    }

    public String getId()
    {
        return this.id;
    }

    public String getSequence()
    {
        return this.sequence;
    }

    public String getOverview()
    {
        String overview = "";
        overview = overview + ">" + this.id + "\n" + this.sequence + "\n";
        return overview;
    }
}
