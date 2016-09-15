package com.saltyfish.framework.service;

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by weck on 16/9/7.
 */
@Service
public class FileService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public String saveImage(MultipartFile image, Long timeStamp) throws IOException {
        String fileType = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
        if (!fileType.equalsIgnoreCase("BMP") && !fileType.equalsIgnoreCase("JPG") && !fileType.equalsIgnoreCase("JPEG") && !fileType.equalsIgnoreCase("PNG") && !fileType.equalsIgnoreCase("GIF")) {
            return "";
        }
        InputStream inputStream = image.getInputStream();
        String aliases = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        saveFileStream("image", inputStream, aliases, fileType, image.getOriginalFilename(), timeStamp);
        return "/file/download/" + aliases;
    }

    public String saveDocument(MultipartFile file, Long timeStamp) throws IOException {
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        InputStream inputStream = file.getInputStream();
        String aliases = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        saveFileStream("doc", inputStream, aliases, fileType, file.getOriginalFilename(), timeStamp);
        return "/file/download/" + aliases;
    }

    public void saveFileStream(String collectionName, InputStream inputStream, String aliases, String fileType, String originalName, Long timeStamp) {
        DB db = mongoTemplate.getDb();
        GridFS gridFS = new GridFS(db, collectionName);
        GridFSInputFile gridFSInputFile = gridFS.createFile(inputStream);
        gridFSInputFile.put("originalName", originalName);
        gridFSInputFile.put("aliases", aliases);
        gridFSInputFile.put("fileType", fileType);
        gridFSInputFile.put("timeStamp", timeStamp);
        gridFSInputFile.save();
    }

}
