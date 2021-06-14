import javax.annotation.processing.SupportedSourceVersion;
import java.io.File;
import java.util.Scanner;

public class Main {
    private static int num = 0;

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.println("osu folder path: ");
        String filePath1 = user.nextLine();
        String song = "\\Songs";
        String filePath = filePath1.concat(song);
        int od1 = 0;
        int od2 = 0;
        int hp1 =0;
        int hp2 =0;
        int select = 0;
        String db = "\\osu!.db";
        String Od1 ="OverallDifficulty: ";
        String Hp1 ="HPDrainRate: ";
        System.out.println("please select od or hp (1/2)");
        select = user.nextInt();
        if(select == 1)
        {
            System.out.println("Enter the od value you want to change: ");
            od1 = user.nextInt();
            String srcStr = Od1 + od1;
            System.out.println("Enter the od value after change");
            od2 = user.nextInt();
            String desStr =Od1 + od2 ;
            editProperties(filePath,srcStr,desStr);

            try{
                File file = new File(filePath1.concat(db));
                if(file.delete())
                {
                    System.out.println(file.getName() + "db has been deleted");
                }
                else
                    System.out.println("File deleted failed, pleased deleted the osu!.db");
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else  if (select == 2)
        {
            System.out.println("Enter the hp value you want to change");
            hp1 = user.nextInt();
            String srcStr = Hp1 + hp1;
            System.out.println("Enter the hp value after change");
            hp2 = user.nextInt();
            String desStr =Hp1  + hp2 ;
            editProperties(filePath,srcStr,desStr);
            try{
                File file = new File(filePath1.concat(db));
                if(file.delete())
                {
                    System.out.println(file.getName() + "db has been deleted");
                }
                else
                    System.out.println("File deleted failed, pleased deleted the osu!.db");
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
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
