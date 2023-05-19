package org.DrsG.Genome.CCC;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class T_CCC_FolderContent {
    public T_CCC_FolderContent(){}

    public ArrayList<String> perform(String folderName)
    {
        ArrayList<String > folderList = new ArrayList<String>();
        File directoryContent = new File(folderName);
        String directoryContentList[] = directoryContent.list();
        for (int i=0; i<directoryContentList.length; i++)
        {
            folderList.add(directoryContentList[i]);
        }
        return folderList;
    }
}
