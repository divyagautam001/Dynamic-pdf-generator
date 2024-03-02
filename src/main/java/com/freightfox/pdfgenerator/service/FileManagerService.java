package com.freightfox.pdfgenerator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileManagerService {

    Logger logger = LoggerFactory.getLogger(FileManagerService.class);
    @Value("${project.pdf.path}")
    private String path;

    public InputStream getResource(String filename) {
        File directory = new File(path);
        if (!directory.exists()) directory.mkdir();

        String fullpath = path + "/" + filename;
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(fullpath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return inputStream;
    }

    public boolean doesFileExist(String filename) {
        File directory = new File(path);
        if (!directory.exists()) directory.mkdir();

        String fullpath = path + "/" + filename;
        File f = new File(fullpath);
        return f.exists();
    }

    public void saveResource(String filename, ByteArrayOutputStream byteArrayOutputStream) {
        File directory = new File(path);
        if (!directory.exists()) directory.mkdir();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + "/" + filename);
            byteArrayOutputStream.writeTo(fileOutputStream);
            byteArrayOutputStream.close();
            byteArrayOutputStream.flush();
            fileOutputStream.close();
            logger.info("new file created successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
