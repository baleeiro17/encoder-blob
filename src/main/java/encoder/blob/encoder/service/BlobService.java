package encoder.blob.encoder.service;


import encoder.blob.encoder.model.Video;
import java.io.InputStream;
import java.util.List;

public interface BlobService {
    String storeVideo(String filename, InputStream content, long length);
    List<Video> getAllVideos();
}