package com.walmart.filedownload.service.impl;

import com.walmart.filedownload.service.FileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public byte[] download(String filename) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get("/etc/"+filename));
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
