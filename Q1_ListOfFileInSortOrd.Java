import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;


public class Q1_ListOfFileInSortOrd
{
  public static void main(String[] args)
  {
    File dir = new File("C:\\");
    if(dir.isDirectory())
    {
         File[] files = dir.listFiles();

      System.out.println("All the files including folders");
      System.out.println("--------------------------------");

      for(File file:files)
      {
        System.out.println(file.getName());
      }
   

      FileFilter fileFilter = new FileFilter()
      {
        @Override
        public boolean accept(File file) {
          return !file.isDirectory();
        }
      };
   
   files = dir.listFiles(fileFilter);
   
      System.out.println("\nAfter filtering the folders");
      System.out.println("--------------------------------");

      Arrays.sort(files, new Comparator()
      {
        @Override
        public int compare(Object f1, Object f2) {
          return ((File) f1).getName().compareTo(((File) f2).getName());
        }
      });

      for(File file:files)
      {
        System.out.println(file.getName());
      }
      System.out.println("\nAfter sorting by name");
      System.out.println("----------------------------------");


      //Prints files in order by file size
      for(File file:files)
      {
        System.out.println(file.getName());
      }
      System.out.println("\nAfter sorting by length");
      System.out.println("-------------------------------");

      // Sort files by date.
      Arrays.sort(files, new Comparator()
      {
        @Override
        public int compare(Object f1, Object f2)
        {
          if (((File) f1).lastModified() < ((File) f2).lastModified())
          {
            return -1;
          }
          else if (((File) f1).lastModified() > ((File) f2).lastModified())
          {
            return 1;
          }
          else
          {
            return 0;
          }
        }
      });

      //Prints files in order by last modified date
      for(File file:files)
      {
        System.out.println(file.getName());
      }
      System.out.println("-------------------------");
    }
  }
}