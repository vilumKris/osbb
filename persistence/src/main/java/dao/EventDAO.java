package dao;

import model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nataliia on 02.07.16.
 */
public interface EventDAO extends GenericDAO<EventEntity, Integer> {
}
