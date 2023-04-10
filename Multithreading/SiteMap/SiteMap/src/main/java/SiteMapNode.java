import lombok.Getter;
import java.util.Vector;

@Getter
public class SiteMapNode {
    private String url;
    public Vector<String>  siteMapChild;

    public SiteMapNode(String url) {
        this.url = url;
        siteMapChild = new Vector<>();
    }
    public void addChild(String child) {
        siteMapChild.add(child);
    }
}
