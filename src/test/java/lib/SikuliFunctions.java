package lib;


import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliFunctions {

    private static Screen s;
    private static SikuliFunctions single_instance = null;
    private SikuliFunctions(){
        s= new Screen();
    }

    public static SikuliFunctions getInstance()
    {
        if (single_instance == null)
            single_instance = new SikuliFunctions();

        return single_instance;
    }

    public String imagePath()
    {
        String workingDir = System.getProperty("user.dir");
        String path=workingDir+"/src/main/resources/images";
        return path;
    }



    public void findImage(String image) throws FindFailed {
        String path= imagePath()+"/"+image;
        Pattern pattern = new Pattern(path);
        s.find(pattern);
    }

    public void clickButton(String image) throws FindFailed {
        String path= imagePath()+"/"+image;
        Pattern pattern = new Pattern(path);
        s.click(pattern);
    }

    public void sendText(String image, String text) throws FindFailed {
        String path= imagePath()+"/"+image;
        Pattern pattern = new Pattern(path);
        s.paste(pattern,text);
    }

    public void swait(String image) throws FindFailed {
        String path= imagePath()+"/"+image;
        Pattern pattern = new Pattern(path);
        s.wait(pattern, 15);
    }
}
