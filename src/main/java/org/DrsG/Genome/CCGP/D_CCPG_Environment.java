package org.DrsG.Genome.CCGP;

public class D_CCPG_Environment {

    String programLocation;
    String dataLocation;
    String repositoriesLocation;
    String repositoriesBackupLocation;
    public D_CCPG_Environment()
    {
        programLocation = "C:\\Users\\ghaer\\OneDrive\\Developments\\Genome";
        dataLocation = "C:\\Users\\ghaer\\OneDrive\\Developments\\Genome\\Data";
        repositoriesLocation = dataLocation + "\\Repositories";
        repositoriesBackupLocation = dataLocation + "\\Repositories_Backup";
    }

    public String getProgramLocation()
    {
        return this.programLocation;
    }

    public String getDataLocation()
    {
        return this.dataLocation;
    }
    public String getRepositoriesLocation()
    {
        return this.repositoriesLocation;
    }

    public String getRepositoriesBackupLocation()
    {
        return this.repositoriesBackupLocation;
    }

}
