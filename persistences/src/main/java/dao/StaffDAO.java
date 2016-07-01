package dao;

import model.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Aska on 01.07.2016.
 */
public interface StaffDAO extends JpaRepository<StaffEntity, Integer> {

}
