import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class FileSearch {
    public static void fileSearch(String path) {
        System.out.println("\nПоиск файлов .json .csv:");
        List <File> fileList = new ArrayList<>();
        getFilesSearch(new File(path), fileList);
        for(File file: fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }
    private static void getFilesSearch(File filePath, List<File> fileList) {
        if (filePath.isDirectory()) {
            File[] directoryFiles = filePath.listFiles();
            if (directoryFiles != null) {
                for (File file: directoryFiles) {
                    if (file.isDirectory()) {
                        getFilesSearch(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".json") || file.getName().toLowerCase().endsWith(".csv") ) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}
