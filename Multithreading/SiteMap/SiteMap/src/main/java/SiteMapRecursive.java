import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Vector;
import java.util.concurrent.RecursiveTask;
@Getter
public class SiteMapRecursive extends RecursiveTask <Vector> {

    private final SiteMapNode siteMapNode;
    private Vector <String> urlPool = new Vector();

    public SiteMapRecursive(SiteMapNode siteMapNode) {
        this.siteMapNode = siteMapNode;
    }

    @Override
    protected Vector compute() {
        String url = siteMapNode.getUrl();
        urlPool.add(url);
        siteMapNode.addChild(url);
        Vector <SiteMapRecursive> vectorTask = new Vector<>();
        try {
            Thread.sleep(150);
            Document document = Jsoup.connect(url).ignoreContentType(true).userAgent("Mozilla/5.0").get();
            Elements elements = document.select("a[href]");
            for (Element element : elements) {
                String attrUrl = element.absUrl("href");
                if (attrUrl.equals(url)
                        || urlPool.contains(attrUrl)
                        || siteMapNode.getSiteMapChild().contains(attrUrl)
                        || !attrUrl.startsWith(url)
                        || attrUrl.isEmpty()
                        || attrUrl.contains("#")) {
                    continue;
                }
                siteMapNode.addChild(attrUrl);
                SiteMapRecursive siteMapRecursive = new SiteMapRecursive(new SiteMapNode(attrUrl));
                siteMapRecursive.fork();
                vectorTask.add(siteMapRecursive);
            }
            for (SiteMapRecursive task : vectorTask) {
                urlPool.addAll(task.join());
            }
        } catch (InterruptedException | IOException e) {
            Thread.currentThread().interrupt();
        }
        return siteMapNode.getSiteMapChild();
    }
}