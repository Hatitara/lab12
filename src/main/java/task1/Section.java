package task1;

public abstract class Section {

    private final int denomination;
    private int amount;
    private Section nextSection;

    public Section(int denomination) {
        this.denomination = denomination;
        this.amount = 0;
    }

    public void setAmount(int amount) {
        this.amount = Math.max(amount, 0);
    }

    public void setNextSection(Section nextSection) {
        this.nextSection = nextSection;
    }

    public boolean hasNextSection() {
        return nextSection != null;
    }

    public Section getNextSection() {
        return nextSection;
    }

    public void process(int number) {
        int maxQuantity = number / denomination;
        int usingQuantity = Math.min(maxQuantity, amount);
        int left = number - (usingQuantity * denomination);
        amount -= usingQuantity;
        if (left != 0) {
            if (hasNextSection()) {
                nextSection.process(left);
            } else {
                throw new IllegalArgumentException("Not enough currency in the ATM!");
            }
        }
        System.out.println("Denomination: " + denomination + "\nQuantity: " + number / denomination);
    }

}
