import org.imgscalr.Scalr;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
public class ImageResizer extends Thread{
    private File[] files;
    private int newWidth;
    private String dstFolder;
    private long start;

    public ImageResizer(File[] files, int newWidth, String dstFolder,long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            for(File file : files) {
                BufferedImage originalImage = ImageIO.read(file);
                if(originalImage == null) {
                    continue;
                }
                BufferedImage resizedImage = Scalr.resize(originalImage, newWidth);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(resizedImage,"jpg",newFile);

                originalImage.flush();
                resizedImage.flush();
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Finished after start: " + (System.currentTimeMillis() - start) + "ms");
    }
}
