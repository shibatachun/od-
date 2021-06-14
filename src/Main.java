import java.io.File;

public class Main {
    private static int num = 0;

    public static void main(String[] args) {
        String filePath = "F:\\test";
        String srcStr1 = "OverallDifficulty: 5";
        String srcStr2 = "HPDrainRate: 4";
        String srcStr3 = "HPDrainRate: 5";

        String desStr = "OverallDifficulty: 8";
        String desStr2 = "HPDrainRate: 8";

        editProperties(filePath,srcStr1,desStr);

        System.out.println("总共文件数： " + num);


    }

    public static void editProperties(String filepath, String srcStr, String desStr)
    {
        File file = new File(filepath);

        if(file.isDirectory())
        {
            File[] subFiles = file.listFiles();
            for (File subFile : subFiles) {
                if (subFile.isDirectory())
                {
                    editProperties(subFile.getAbsolutePath(),srcStr,desStr);
                }else {
                    if(subFile.getName().endsWith(".osu"))
                    {
                        System.out.println(subFile.getAbsolutePath());
                        editfile.propertiesChange(subFile.getAbsolutePath(),srcStr,desStr);
                        num++;
                    }else {
                        continue;
                    }
                }
            }
        }else{
            if(file.getName().endsWith(".osu"))
            {
                System.out.println(file.getAbsolutePath());
                editfile.propertiesChange(file.getAbsolutePath(),srcStr,desStr);
                num++;
            }
        }
    }
}
