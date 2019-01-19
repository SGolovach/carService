package by.htp.carservice.transaction.imlp;

import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionComment;
import by.htp.carservice.transaction.TransactionFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CommentTransactionImplTest {
    Comment comment;
    TransactionComment factory;

    @BeforeMethod
    public void setUp() {
        comment = new Comment();
        factory = TransactionFactory.getInstance().getTransactionComment();
    }

    @AfterMethod
    public void tearDown() {
        comment = null;
        factory = null;
    }

    @Test
    public void testTakeTransaction() throws ServiceException {
        comment = factory.takeTransaction(1);
        assertEquals(comment.getIdComment(),0);
    }

    @Test
    public void testTakeAllQuery() throws ServiceException {
        List<Comment> commentList = factory.takeAllQuery();
        assertEquals(commentList.size(),0);
    }

    @Test
    public void testCountRecordTransaction() throws ServiceException {
        int count = factory.countRecordTransaction();
        assertEquals(count,0);
    }

    @Test
    public void testCountRecordByIdTransaction() throws ServiceException {
        int count = factory.countRecordByIdTransaction(1);
        assertEquals(count,0);
    }
}