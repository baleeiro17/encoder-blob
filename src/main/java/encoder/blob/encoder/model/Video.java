package encoder.blob.encoder.model;

public class Video {

    private String name;
    private String linkDownload;

    public Video(String name, String link) {
        this.name = name;
        this.linkDownload = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }


}
