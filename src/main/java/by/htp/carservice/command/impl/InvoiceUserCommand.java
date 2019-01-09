package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import by.htp.carservice.util.SplitRequestParam;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class InvoiceUserCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_INVOICE = "invoiceList";
    private static final String SESSION_USER = "user";
    private static final String SESSION_USER_INVALIDATE = "/WEB-INF/jsp/info/sessionInvalidate.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = ((User) session.getAttribute(SESSION_USER));
        if (user == null) {
            return SESSION_USER_INVALIDATE;
        }
        long userId = user.getIdUser();
        SplitRequestParam splitRequestParam = new SplitRequestParam();
        Map<String, String> resultSplit = splitRequestParam.splitRequest(request);
        List<Invoice> invoiceList;
        try {
            invoiceList = factory.getInvoicePaginationDataService().paginateById(resultSplit,userId);
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in check login", e);
            return new ErrorCommand().getPathJsp();
        }
        splitRequestParam.splitRequestBack(request, resultSplit);
        request.getSession().setAttribute(SESSION_INVOICE, invoiceList);
        return new InvoiceUserCommand().getPathJsp();
    }
}
