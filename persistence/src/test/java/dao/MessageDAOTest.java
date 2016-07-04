package dao;

import dao.impl.MessageDAOImpl;
import model.MessageEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Kris on 03.07.2016.
 */
public class MessageDAOTest {
    private static final MessageEntity MESSAGE_NULL = null;
    private MessageDAO messageEntityDAO = new MessageDAOImpl();
    private  MessageEntity messageEntity;

    @Before
    public void beforeMethod() {
        messageEntity = new MessageEntity();
    }

    @Test
    public void testMessageEntityOperations(){
        messageEntity.setTicketId(1);
        messageEntity.setUserId(2);
        messageEntity.setTime(new Date());
        messageEntity.setDescription("my description");
        messageEntity = messageEntityDAO.save(messageEntity);
        Assert.assertNotNull(messageEntity);
        Assert.assertTrue(messageEntity.getMessageId()!=0);

        messageEntity.setUserId(3);
        messageEntity = messageEntityDAO.update(messageEntity);

        int size = messageEntityDAO.findAll().size();
        Assert.assertTrue(size == 1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveNullMessageEntity(){
        messageEntity = null;
        messageEntityDAO.save(messageEntity);

    }


}
