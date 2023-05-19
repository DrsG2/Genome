package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_Alignment;
import org.DrsG.Genome.BeBl.D_BeBl_Repository;
import org.DrsG.Genome.BeBl.D_BeBl_UserList;

import java.io.File;

public class T_UC_RepositoryInitiation
{

    public T_UC_RepositoryInitiation(){}

    public void perform(D_BeBl_Repository theRepository)
    {

        String initialFileLocation = theRepository.getRepositoryLocation();
        String userFile = theRepository.getDefaultUsersfile();
        String fullnameUserFile = initialFileLocation + "\\" + userFile;

        // check if file exists
        File f = new File(fullnameUserFile);
        if (f.exists())
        {
            System.out.println("File OK");
        }
        else
        {
            System.out.println("File NOK");
        }
        //

        String genomesequencesFile = theRepository.getDefaultFASTAfile();
        String fullnameGenomeSequencerFile = initialFileLocation + "\\" + genomesequencesFile;
        D_BeBl_UserList theUserList = new D_BeBl_UserList();
        T_UC_UserListLoader userListLoad = new T_UC_UserListLoader();
        theUserList = userListLoad.perform(fullnameUserFile);
        theRepository.setUsers(theUserList);
        D_BeBl_Alignment optimalAlignment = new D_BeBl_Alignment();
        T_UC_AlignmentLoader theAlignmentLoad = new T_UC_AlignmentLoader();
        optimalAlignment = theAlignmentLoad.perform(fullnameGenomeSequencerFile);
        theRepository.setOptimalAlignment(optimalAlignment);

    }


}
