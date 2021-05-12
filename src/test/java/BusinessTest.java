import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessTest {

    @Test
    void getLastLinesOfInvoiceForSmallBusiness () {

        Business business = new Business (Business.SMALL);
        String expectedValue = "=                                                          ----------+ =\r\n" +
                               "=                                                Totaal    €   100,00  =\r\n" +
                               "=                                                                      =\r\n" +
                               "=              Factuur is vrijgesteld van OB o.g.v. artikel 25 Wet OB  =\r\n";
        String actualValue = business.getLastLinesOfInvoice (100);
        assertEquals (expectedValue, actualValue);

    }

    @Test
    void getLastLinesOfInvoiceForNormalBusiness () {
        Business business = new Business (Business.NORMAL);
        String expectedValue = "=                                                          ----------+ =\r\n" +
                               "=                                                Subtotaal €   100,00  =\r\n" +
                               "=                                                21% BTW   €    21,00  =\r\n" +
                               "=                                                          ----------+ =\r\n" +
                               "=                                                Totaal    €   121,00  =\r\n";
        String actualValue = business.getLastLinesOfInvoice (100);
        assertEquals (expectedValue, actualValue);
    }
}