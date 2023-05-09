package org.example;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private final ResourceLoader resourceLoader;


    public Service(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void writeToFileInResourceFolder(String fileName,List<String> content) throws IOException {
        // Get the resource folder as a Resource object
        Resource resourceFolder = resourceLoader.getResource("classpath:static");

        // Create a file in the resource folder
        File file = new File(resourceFolder.getFile(), fileName);
        System.out.println("into the files to save");
        // Write some data to the file
        String data = "Hello, world!";
        try (FileOutputStream outputStream = new FileOutputStream(file,false)) {
            for(String s : content)
               outputStream.write(s.getBytes());
        }
    }

    public List<String> readLinesFromFileInResourceFolder(String fileName) throws Exception {
        Resource resourceFile = resourceLoader.getResource("classpath:static/"+fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceFile.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public void deleteFile(String fileName) throws IOException {

        if (resourceLoader.getResource("classpath:static/" + fileName).exists()) {
            File file = resourceLoader.getResource("classpath:static/" + fileName).getFile();
            file.delete();
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete file");
        }
    }

    public void writeToFileInResourceFolderPDF(String fileName,InputStream inputStream) throws IOException {
        // Get the resource folder as a Resource object
        Resource resourceFolder = resourceLoader.getResource("classpath:static");

        // Create a file in the resource folder
        File file = new File(resourceFolder.getFile(), fileName);
        System.out.println("into the files to save");
        try (FileOutputStream outputStream = new FileOutputStream(file.getPath())) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

    }

    public InputStream readLinesFromFileInResourceFolderPDF(String fileName) throws Exception {
        Resource resourceFile = resourceLoader.getResource("classpath:static/"+fileName);
        InputStream fileInputStream = new FileInputStream(resourceFile.getFile());
        return fileInputStream;
    }

}
