import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите URL сайта: ");
        BufferedReader readerUrl = new BufferedReader(new InputStreamReader(System.in));
        String url = readerUrl.readLine();
        String name = new URL(url).getHost().replace(".", "_");
        parseSiteFileRecording(url, name);
    }
    private static void parseSiteFileRecording (String url,String name){
        SiteMapNode siteMapNode = new SiteMapNode(url);
        SiteMapRecursive siteMapRecursive = new SiteMapRecursive(siteMapNode);
        new ForkJoinPool().invoke(siteMapRecursive);
        StringBuilder stringBuilder = new StringBuilder();
        for (String node : siteMapRecursive.getUrlPool()) {
            stringBuilder.append(stringTab(node));
        }
        try {
            String fileName = "data/" + name + ".txt";
            PrintWriter writer = new PrintWriter(fileName);
            writer.write(stringBuilder.toString());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String stringTab (String str){
        char slash = str.charAt(str.length() - 1);
        if(slash == '/') {
            str = str.substring(0, str.length() - 1);
        }
        int tab = str.length() - str.replace(String.valueOf('/'), "").length() - 2;
        String line = String.join("", Collections.nCopies(tab, "\t")) + str + "\n";
        return line;
    }
}

