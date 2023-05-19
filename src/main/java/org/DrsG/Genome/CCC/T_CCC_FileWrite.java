package org.DrsG.Genome.CCC;

import java.io.FileWriter;
import java.io.IOException;

public class T_CCC_FileWrite {

    public T_CCC_FileWrite(){}

    public boolean perform(String aFullFilename, String fileContent)
    {
        boolean writeOK = false;
        try
            {
                FileWriter fileWriter = new FileWriter(aFullFilename);
                fileWriter.write(fileContent);
                fileWriter.close();
                writeOK = true;
            }
        catch (IOException e)
            {
                System.out.println("An error occured.");
                e.printStackTrace();
                writeOK = false;
            }
        return writeOK;
    }
}
