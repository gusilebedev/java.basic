import java.io.File;

public class Main {

    private static int newWidth = 300;
    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\Сергей\\Desktop\\src";
        String dstFolder = "C:\\Users\\Сергей\\Desktop\\dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int middle = files.length / 4;

        File[] files1 = new File[middle];
        System.arraycopy(files, 0 ,files1, 0 ,middle);
        ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder,start);
        int point = middle;
        resizer1.start();

        File[] files2 = new File[files.length - middle * 3];
        System.arraycopy(files,point,files2,0,files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder,start);
        point += files2.length;
        resizer2.start();

        File[] files3 = new File[files.length - middle * 3];
        System.arraycopy(files,point,files3,0,files3.length);
        ImageResizer resizer3 = new ImageResizer(files3, newWidth, dstFolder,start);
        point += files3.length;
        resizer3.start();

        File[] files4 = new File[files.length - point];
        System.arraycopy(files,point,files4,0,files4.length);
        ImageResizer resizer4 = new ImageResizer(files4, newWidth, dstFolder,start);
        resizer4.start();
    }
}