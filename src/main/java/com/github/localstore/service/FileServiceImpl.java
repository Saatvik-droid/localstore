package com.github.localstore.service;

import com.github.localstore.dao.FileDao;
import com.github.localstore.model.FileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileDao fileDao;

    @Override
    public FileModel saveFile(FileModel fileModel) {
        return fileDao.save(fileModel);
    }
}
