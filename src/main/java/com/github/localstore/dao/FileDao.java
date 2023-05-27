package com.github.localstore.dao;

import com.github.localstore.model.FileModel;
import org.springframework.data.repository.CrudRepository;

public interface FileDao extends CrudRepository<FileModel, Long> {

}
