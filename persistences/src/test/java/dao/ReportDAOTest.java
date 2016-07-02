package dao;

import dao.impl.ReportDAOImpl;
import model.ReportEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by nazar.dovhyy on 02.07.2016.
 */
public class ReportDAOTest {

    private static final ReportEntity REPORT_NULL = null;
    private ReportDAO reportEntityDAO = new ReportDAOImpl();
    private  ReportEntity reportEntity;

    @Before
    public void beforeMethod() {
        reportEntity = new ReportEntity();
    }

    @Test
    public void testReportEntityCRUDOperations(){

        reportEntity.setName("March2016Balance");
        reportEntity.setDatecreation(new Date());
        reportEntity.setFilepath("C/osbb/balance");
        reportEntity.setDescription("info on balance for March 2016");
        reportEntity = reportEntityDAO.save(reportEntity);
        assertNotNull(reportEntity);
        assertTrue(reportEntity.getReportId() != 0);

        reportEntity.setDescription("new March2016Balance");
        ReportEntity updatedReportEntity = reportEntity = reportEntityDAO.update(reportEntity);
        assertSame(updatedReportEntity, reportEntity);

        int afterUpdateReportEntitiesSize = reportEntityDAO.findAll().size();
        assertTrue(afterUpdateReportEntitiesSize == 1);

        reportEntityDAO.delete(updatedReportEntity);
        int afterDeleteReportEntitiesSize = reportEntityDAO.findAll().size();
        assertTrue(afterDeleteReportEntitiesSize == 0);


    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveNullReportEntity(){
        reportEntity = null;
        reportEntityDAO.save(reportEntity);

    }


}
