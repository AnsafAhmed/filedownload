package com.walmart.filedownload.service;

import org.springframework.core.io.ByteArrayResource;

public interface FileService {
    byte[] download(String filename);
}
