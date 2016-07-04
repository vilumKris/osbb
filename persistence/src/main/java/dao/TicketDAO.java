package dao;

import model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Администратор on 03.07.2016.
 */
public interface TicketDAO extends GenericDAO<TicketEntity, Integer> {
}
