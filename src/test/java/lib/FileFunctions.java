package lib;

import java.io.File;

public class FileFunctions {


    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();
        for (int i = 0; i < dir_contents.length; i++) {
            System.out.println(dir_contents[i].getName());
            if (dir_contents[i].getName().equals(fileName))
                return flag=true;
        }

        return flag;
    }
}
