package org.DrsG.Genome.CCC;

import java.io.BufferedReader;
import java.io.File;

public class T_CCC_FileRead {

    public T_CCC_FileRead(){}

    public String perform (String fileName)
    {
        String readFromFile = "";

        try
        {
            int lineNr=0;
            File aFile = new File(fileName);
            BufferedReader aBr = new BufferedReader(new java.io.FileReader(aFile));
            String aLine = "";
            //open file, read from it and put it in the bufferedreader
            while (aLine != null)
            {
                aLine = aBr.readLine();

                if (aLine != null)
                {
                    readFromFile = readFromFile + aLine + "\n";
                    lineNr++;
                }
            }
        }
        //System.out.println("Number of Service defintions read:" + lineNr);
        //System.out.println("Number of errors :" + errors);
        catch (Exception e)
        {
            System.out.println("***Exception***");
            //LogItem logitem = new D_LogItem();
            System.out.println(e.toString());
        }

        return readFromFile;
    }

}
