package encoder.blob.encoder.service.implementation;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import com.ctc.wstx.shaded.msv_core.util.Uri;

import org.springframework.stereotype.Service;

import encoder.blob.encoder.model.Video;
import encoder.blob.encoder.service.BlobService;

@Service
public class BlobServiceImpl implements BlobService {

    private BlobContainerClient containerClient() {

        BlobContainerClient container = new BlobServiceClientBuilder()
                .connectionString("UseDevelopmentStorage=true;")
                .buildClient()
                .getBlobContainerClient("videos");

        if (!container.exists()) container.create();

        return container;
    }

    @Override
    public  List<Video> getAllVideos() {

        BlobContainerClient container = containerClient();

        List<Video> videos = new ArrayList<Video>();

        for (BlobItem blobItem : container.listBlobs() ) {
            videos.add( new Video( blobItem.getName(), container.getBlobContainerUrl()+"/"+ blobItem.getName() ) );
            videos.add( new Video( blobItem.getName(), container.getBlobContainerUrl()+"/"+ blobItem.getName() ) );
            videos.add( new Video( blobItem.getName(), container.getBlobContainerUrl()+"/"+ blobItem.getName() ) );
            videos.add( new Video( blobItem.getName(), container.getBlobContainerUrl()+"/"+ blobItem.getName() ) );
            videos.add( new Video( blobItem.getName(), container.getBlobContainerUrl()+"/"+ blobItem.getName() ) );
            videos.add( new Video( blobItem.getName(), container.getBlobContainerUrl()+"/"+ blobItem.getName() ) );
            videos.add( new Video( blobItem.getName(), container.getBlobContainerUrl()+"/"+ blobItem.getName() ) );
            break;
        }

        return videos;
    }

    @Override
    public String storeVideo(String filename, InputStream content, long length) {

        BlobClient blobClient = containerClient().getBlobClient(filename);

        // System.out.println("\nUploading to Blob storage as blob:\n\t" + blobClient.getBlobUrl());

        String urlVideo = blobClient.getBlobUrl();

        // Upload the blob
        blobClient.upload(content, length);
        
        return urlVideo;
    }
    
}