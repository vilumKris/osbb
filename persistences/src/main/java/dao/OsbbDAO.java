package dao;

import model.OsbbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Roman on 02.07.2016.
 */
public interface OsbbDAO extends  JpaRepository<OsbbEntity, Integer>{
}
