package dao;

import dao.impl.MessageDAOImpl;
import dao.impl.TicketDAOImpl;
import model.MessageEntity;
import model.TicketEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Kris on 03.07.2016.
 */
public class TicketDAOTest {
    private TicketDAO ticketEntityDAO = new TicketDAOImpl();
    private TicketEntity ticketEntity;

    @Before
    public void beforeMethod() {
        ticketEntity = new TicketEntity();
    }

    @Test
    public void testMessageEntityOperations(){
        ticketEntity.setUserId(2);
        ticketEntity.setTime(new Date());
        ticketEntity.setName("first ticket");
        ticketEntity.setDiscription("test description");

        ticketEntity = ticketEntityDAO.save(ticketEntity);
        Assert.assertNotNull(ticketEntity);
        Assert.assertTrue(ticketEntity.getTicketId()!=0);

        ticketEntity.setUserId(3);
        ticketEntity = ticketEntityDAO.update(ticketEntity);

        int size = ticketEntityDAO.findAll().size();
        Assert.assertTrue(size == 1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveNullMessageEntity(){
        ticketEntity = null;
        ticketEntityDAO.save(ticketEntity);

    }

}
