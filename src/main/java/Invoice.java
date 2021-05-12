import java.util.ArrayList;

public class Invoice {

    private static int nextInvoiceNumber = 0;

    public Invoice () {
    }

    private int getNextInvoiceNumber () {
        nextInvoiceNumber += 13;
        return nextInvoiceNumber;
    }

    public void printInvoice (Customer customer, ArrayList<InvoiceLine> lines) {

        double totalPrice = 0.0;
        StringBuilder invoice = new StringBuilder ();

        invoice.append (InvoiceFormatter.getHeader ());
        invoice.append (InvoiceFormatter.getLine(false,"Invoice Number: %d", getNextInvoiceNumber ()));
        invoice.append (InvoiceFormatter.getEmptyLine ());
        invoice.append (customer);
        invoice.append (InvoiceFormatter.getEmptyLine ());

        for (InvoiceLine line : lines) {
            Product product = line.getProduct ();
            int numberOfProducts = line.getNumberOfProducts ();
            double linePrice = product.getPrice () * numberOfProducts;
            totalPrice += linePrice;
            invoice.append (InvoiceFormatter.getLine (false, "%4d %-50s € %8.2f", numberOfProducts, product.getName (), linePrice));
        }

        invoice.append (InvoiceFormatter.getLine (true, "---------- +"));
        invoice.append (InvoiceFormatter.getLine (true, "Subtotaal € %8.2f  ", totalPrice));
        invoice.append (InvoiceFormatter.getLine (true, "21%% BTW   € %8.2f  ", totalPrice * 0.21));
        invoice.append (InvoiceFormatter.getLine (true, "---------- +"));
        invoice.append (InvoiceFormatter.getLine (true, "Totaal    € %8.2f  ", totalPrice * 1.21));
        invoice.append (InvoiceFormatter.getFooter());
        System.out.print (invoice);
    }
}
