package dao;

import model.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Roman on 02.07.2016.
 */
public interface VoteDAO extends JpaRepository<VoteEntity, Integer> {
}
