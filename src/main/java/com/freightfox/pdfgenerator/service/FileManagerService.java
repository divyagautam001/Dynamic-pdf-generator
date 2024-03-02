package com.freightfox.pdfgenerator.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Service
public class FileManagerService {

    public InputStream getResource(String path, String filename) {
        String fullpath = path + "/" + filename;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fullpath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return inputStream;
    }

    public boolean doesFileExist(String path, String filename) {
        String fullpath = path + "/" + filename;
        File directory = new File(path);
        if(!directory.exists()) directory.mkdir();
        File f = new File(fullpath);
        return f.exists();
    }

}
