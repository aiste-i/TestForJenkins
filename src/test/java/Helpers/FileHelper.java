package Helpers;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.stream.Collectors;

public class FileHelper {
    private static final String filename1 = "data1.txt";
    private static final String file1Str = "3rd Album\n3rd Album";
    private static final String filename2 = "data2.txt";
    private static final String file2Str = "3rd Album\nMusic 2\n3rd Album";
    private static final String initialPath = FileSystems.getDefault().getPath("").toAbsolutePath() + "\\src\\test\\java\\Helpers\\Files\\";


    public static boolean filesForTestExist(){
        return new File(initialPath + filename1).isFile() && new File(initialPath + filename2).isFile();
    }

    public static void createFilesForTest(){
        createFile(initialPath + filename1, file1Str);
        createFile(initialPath + filename2, file2Str);
    }

    public static List<String> getLinesFromFile(String filename){
        var file = filename.equals(filename1) ? filename : filename2;
        try {
            var reader = new BufferedReader(new FileReader(initialPath + file));
            return reader.lines().collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void createFile(String filePath, String content){
        //create file
        var file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //write to file
        try {
            var writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
