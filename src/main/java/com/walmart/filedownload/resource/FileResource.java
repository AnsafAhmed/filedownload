package com.walmart.filedownload.resource;

import com.walmart.filedownload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/downloads")
public class FileResource {

    @Autowired
    FileService fileService;

    @GetMapping(path = "/file/{filename}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable(value = "filename") String filename) {
        ByteArrayResource resource = new ByteArrayResource(fileService.download(filename));

        return ResponseEntity.ok().body(resource);
    }
}
