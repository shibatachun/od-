import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class editfile {

    public static void propertiesChange(String filepath, String srcStr, String desStr)
    {
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        List list = new ArrayList<>();

        try
        {
            fr = new FileReader(new File(filepath));
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null){
                if (line.contains(srcStr))
                {
                    line = line.replace(srcStr, desStr);
                }
                list.add(line);
                line = br.readLine();
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            try{
                br.close();
                fr.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            fw = new FileWriter(filepath);
            bw = new BufferedWriter(fw);
            for(Object s : list)
            {
                bw.write((String) s);
                bw.newLine();
            }
            System.out.println("文件修改成功");
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            try{
                bw.close();
                fw.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
