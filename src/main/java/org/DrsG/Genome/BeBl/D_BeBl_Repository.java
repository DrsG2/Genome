package org.DrsG.Genome.BeBl;

import java.util.ArrayList;

public class D_BeBl_Repository {

    public D_BeBl_Repository()
    {
    }
    private String repositoryName = "HIV";
    private D_BeBl_Alignment optimalAlignment = new D_BeBl_Alignment();
    private ArrayList<D_BeBl_Alignment> workAlignments = new ArrayList<D_BeBl_Alignment>();
    private D_BeBl_UserList users = new D_BeBl_UserList();
    private String repositoryLocation = "C:\\Users\\ghaer\\OneDrive\\Developments\\Genome\\Data";
    private String defaultFASTAfile = "HIV.FASTA";
    private String defaultUsersfile = "team.txt";


    public void setRepositoryName(String aName)
    {
        this.repositoryLocation = aName;
    }

    public void setOptimalAlignment(D_BeBl_Alignment anAlignemnt)
    {
        this.optimalAlignment = anAlignemnt;
    }

    public void addWorkAlignemnt(D_BeBl_Alignment anAlignment)
    {
        this.workAlignments.add(anAlignment);
    }

    public void setUsers(D_BeBl_UserList aUserList)
    {
        this.users = aUserList;
    }

    public void setRepositoryLocation(String aLocation)
    {
        this.repositoryLocation = aLocation;
    }

    public void setDefaultFASTAfile (String aFASTAfile)
    {
        this.defaultFASTAfile = aFASTAfile;
    }

    public void setDefaultUsersfile (String aUserfile)
    {
        this.defaultUsersfile = aUserfile;
    }

    public String getRepositoryName()
    {
        return  this.repositoryName;
    }

    public String getRepositoryLocation()
    {
        return this.repositoryLocation;
    }

    public String getDefaultFASTAfile()
    {
        return this.defaultFASTAfile;
    }

    public String getDefaultUsersfile()
    {
        return this.defaultUsersfile;
    }

    public D_BeBl_UserList getUsers(){return this.users;};

    public ArrayList<D_BeBl_Alignment> getWorkAlignments() {
        return this.workAlignments;
    }

    public D_BeBl_Alignment getOptimalAlignment()
    {
        return this.optimalAlignment;
    }
    public String getInitialOverview()
    {
        String overview = "";
        overview = overview + "********************************************************************************\n";
        overview = overview + "Default FASTA file = " + this.repositoryLocation + "\\" + this.defaultFASTAfile + "\n";
        overview = overview + "Defautl Team file = " +  this.repositoryLocation + "\\" + this.defaultUsersfile + "\n";
        overview = overview + "********************************************************************************\n";
        overview = overview + "Defined users : \n";
        overview = overview + this.users.getOverview();
        overview = overview + "********************************************************************************\n";
        overview = overview + "Optimal Alignment : \n";
        this.optimalAlignment.setName("The Optimal Alignment");
        overview = overview + this.optimalAlignment.getOverview();
        overview = overview + "Work_in_Progress Alignments: NONE";

        return overview;
    }
}

