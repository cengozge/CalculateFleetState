package enums;


public enum EInstanceType {

    M1(0, "M1"), M2(1, "M2"), M3(2, "M3");
    
    private int kod;
    private String text;
    
    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private EInstanceType(int kod, String text) {
        this.setKod(kod);
        this.setText(text);
    }
}
