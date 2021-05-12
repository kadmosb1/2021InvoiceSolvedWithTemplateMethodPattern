public class Business {

    public static final int SMALL = 1;
    public static final int NORMAL = 2;

    private static final int VAT = 21;

    private int type;

    public Business (int type) {
        this.type = type;
    }

    private double getPriceIncludingVAT(double priceExcludingVAT) {
        return (1 + VAT / 100.0) * priceExcludingVAT;
    }

    private double getVAT (double priceExcludingVAT) {
        return VAT / 100.0 * priceExcludingVAT;
    }

    public String getLastLinesOfInvoice (double priceExcludingVAT) {

        StringBuilder lines = new StringBuilder ();
        if (type == NORMAL) {
            double vat = getVAT (priceExcludingVAT);
            double priceIncludingVAT = getPriceIncludingVAT (priceExcludingVAT);

            lines.append (InvoiceFormatter.getLine (true, "----------+"));
            lines.append (InvoiceFormatter.getLine (true, "Subtotaal € %8.2f ", priceExcludingVAT));
            lines.append (InvoiceFormatter.getLine (true, "21%% BTW   € %8.2f ", vat));
            lines.append (InvoiceFormatter.getLine (true, "----------+"));
            lines.append (InvoiceFormatter.getLine (true, "Totaal    € %8.2f ", priceIncludingVAT));
            return lines.toString ();
        }
        else { // type = NORMAL
            lines.append (InvoiceFormatter.getLine (true, "----------+"));
            lines.append (InvoiceFormatter.getLine (true, "Totaal    € %8.2f ", priceExcludingVAT));
            lines.append (InvoiceFormatter.getEmptyLine ());
            lines.append (InvoiceFormatter.getLine (true, "Factuur is vrijgesteld van OB o.g.v. artikel 25 Wet OB "));
            return lines.toString();
        }
    }
}