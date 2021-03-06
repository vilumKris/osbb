//package dao;
//
//
//import dao.impl.HouseDAOimpl;
//import model.HouseEntity;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
///**
// * Created by nazar.dovhyy on 02.07.2016.
// */
//public class HouseDAOTest {
//
//    private static final HouseEntity NULL_HOUSE = null;
//    private HouseDAO houseEntityDAO = new HouseDAOimpl();
//    private static HouseEntity houseEntity;
//
//    @Before
//    public void beforeMethod() {
//        houseEntity = new HouseEntity();
//    }
//
//
//    @Test
//    public void testHouseEntityCRUDOperations() {
//
//        houseEntity.setAddress("Horodocka str. 110");
//        houseEntity = houseEntityDAO.save(houseEntity);
//        assertNotNull(houseEntity);
//        assertNotEquals(0, houseEntity.getHouseId());
//
//        houseEntity.setAddress("updated address information");
//
//        houseEntity = houseEntityDAO.update(houseEntity);
//
//        int sizeAfterUpdate = houseEntityDAO.findAll().size();
//
//        assertNotNull(houseEntity);
//        assertTrue(sizeAfterUpdate == 1);
//        assertEquals("updated address information", houseEntity.getAddress());
//
//        houseEntityDAO.delete(houseEntity);
//
//        final int sizeAfterDelete = houseEntityDAO.findAll().size();
//        assertTrue(sizeAfterDelete == 0);
//
//
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testSaveNull() {
//        houseEntityDAO.save(NULL_HOUSE);
//
//    }
//
//
//}
