public class BillSplitterUI {
    private final BillSplitter billSplitter;
    public BillSplitterUI(BillSplitter billSplitter) {
        this.billSplitter = billSplitter;
    }

    public void calcAndShow() {
        billSplitter.split();

        TextUiUtils.showText("Предлагаю разделить чек следующим образом:");
        for (int i = 0; i < billSplitter.getFriendCount(); i++) {
            TextUiUtils.showText( (i+1) + " гость платит   " + CostUtils.costToString(billSplitter.getPart(i)));
        }
        TextUiUtils.showLine();
    }
}
