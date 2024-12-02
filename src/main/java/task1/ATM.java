package task1;

public class ATM {

    private final Section firstSection;

    public ATM() {
        this.firstSection = new Section500();
        Section secondSection = new Section200();
        firstSection.setNextSection(secondSection);
        Section thirdSection = new Section100();
        secondSection.setNextSection(thirdSection);
        Section fourthSection = new Section50();
        thirdSection.setNextSection(fourthSection);
        Section fifthSection = new Section20();
        fourthSection.setNextSection(fifthSection);
        fillATM();
    }

    public void fillATM() {
        Section current = firstSection;
        while (current != null) {
            current.setAmount(100);
            current = current.getNextSection();
        }
    }

    public void giveMeYourMoney(int amount) {
        firstSection.process(amount);
    }

}
