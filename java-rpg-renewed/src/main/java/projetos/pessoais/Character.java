package projetos.pessoais;

public class Character {
    private String icon;
    private int xPosition;
    private int yPosition;

    public Character(String icon) {
        this.icon = icon;
        this.xPosition = 0;
        this.yPosition = 0;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
