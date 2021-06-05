package encoder.blob.encoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import encoder.blob.encoder.service.BlobService;
import encoder.blob.encoder.model.Video;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("blob")
public class BlobController {

    @Autowired
    private BlobService blobService;

    @GetMapping("/getVideos")
    public ResponseEntity<Object> getUrlVideo() {

        List<Video> videos = new ArrayList<Video>();

        videos = blobService.getAllVideos();

        return new ResponseEntity<>(videos, HttpStatus.OK);
        
    }

    @PostMapping("/storeVideo")
    public ResponseEntity<Object> uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {

        String url = blobService.storeVideo(file.getOriginalFilename(), file.getInputStream(), file.getSize());

        return ResponseEntity.ok(new Object() {
            public final boolean success = true;
            public final String urlvideo = url;
        });
    }
}