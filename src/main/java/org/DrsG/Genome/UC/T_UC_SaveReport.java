package org.DrsG.Genome.UC;

import org.DrsG.Genome.BeBl.D_BeBl_User;
import org.DrsG.Genome.CCC.T_CCC_FileWrite;
import org.DrsG.Genome.CCGP.D_CCPG_Environment;

public class T_UC_SaveReport {

    public T_UC_SaveReport(){}

    public boolean perform (String aRepositoryName, String reportContent, D_BeBl_User activeUser)
    {
        boolean saveSucces = false;
        D_CCPG_Environment theEnvironment = new D_CCPG_Environment();
        String aRepositorylocation = theEnvironment.getRepositoriesLocation();
        String fullFileName = aRepositorylocation + "\\" + aRepositoryName + "\\" + aRepositoryName + "." + activeUser.getFirstName() + activeUser.getLastName() + ".score.txt";
        System.out.println("Filename = " + fullFileName);
        T_CCC_FileWrite fileWriter = new T_CCC_FileWrite();
        saveSucces = fileWriter.perform(fullFileName, reportContent);
        return saveSucces;
    }
}
