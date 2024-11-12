package projetos.pessoais;

public class Character {
    private String icon;
    private String[][] world;
    private int health;
    private String equipedItem;
    private String equipedWeapon;
    private int xPosition;
    private int yPosition;

    public Character(String icon, String[][] world) {
        this.icon = icon;
        this.world = world;
        this.xPosition = 0;
        this.yPosition = 0;
        this.health = 5;
        this.equipedItem = "🛼";
        this.equipedWeapon = "🔪";
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String[][] getWorld() {
        return world;
    }

    public void setWorld(String[][] world) {
        this.world = world;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public String getEquipedItem() {
        return equipedItem;
    }

    public void setEquipedItem(String equipedItem) {
        this.equipedItem = equipedItem;
    }

    public String getEquipedWeapon() {
        return equipedWeapon;
    }

    public void setEquipedWeapon(String equipedWeapon) {
        this.equipedWeapon = equipedWeapon;
    }

    public boolean moveCharacter(String direction, String exceptionIcon){
        boolean foiPosicionado = false;

        switch (direction) {
            case "left" -> {
                int newCharacterXLocation = this.getxPosition()-1;

                if(this.isOutOfBounds(newCharacterXLocation, this.getyPosition())) {
                    System.out.print("\n\nNão é possível se movimentar para fora do mapa!");
                } else if (this.isValidPosition(newCharacterXLocation, this.getyPosition(), exceptionIcon)) {
                    this.world[this.getyPosition()][this.getxPosition()] = "[ ]";
                    this.setxPosition(newCharacterXLocation);
                    foiPosicionado = true;
                } else {
                    System.out.println("\n\nPosição inválida.");
                }
            }
            case "right" -> {
                int newCharacterXLocation = this.getxPosition()+1;

                if(this.isOutOfBounds(newCharacterXLocation, this.getyPosition())) {
                    System.out.print("\n\nNão é possível se movimentar para fora do mapa!");
                } else if (this.isValidPosition(newCharacterXLocation, this.getyPosition(), exceptionIcon)) {
                    this.world[this.getyPosition()][this.getxPosition()] = "[ ]";
                    this.setxPosition(newCharacterXLocation);
                    foiPosicionado = true;
                } else {
                    System.out.println("Posição inválida.");
                }
            }
            case "up" -> {
                int newCharacterYLocation = this.getyPosition()-1;

                if(this.isOutOfBounds(this.getxPosition(), newCharacterYLocation)) {
                    System.out.print("\n\nNão é possível se movimentar para fora do mapa!");
                } else if (this.isValidPosition(this.getxPosition(), newCharacterYLocation, exceptionIcon)) {
                    this.world[this.getyPosition()][this.getxPosition()] = "[ ]";
                    this.setyPosition(newCharacterYLocation);
                    foiPosicionado = true;
                } else {
                    System.out.println("Posição inválida.");
                }
            }

            case "down" -> {
                int newCharacterYLocation = this.getyPosition()+1;

                if(this.isOutOfBounds(this.getxPosition(), newCharacterYLocation)) {
                    System.out.print("\n\nNão é possível se movimentar para fora do mapa!");
                } else if (this.isValidPosition(this.getxPosition(), newCharacterYLocation, exceptionIcon)) {
                    this.world[this.getyPosition()][this.getxPosition()] = "[ ]";
                    this.setyPosition(newCharacterYLocation);
                    foiPosicionado = true;
                } else {
                    System.out.println("Posição inválida.");
                }
            }

            default -> {
                System.out.println("Direção inválida");
            }
        }
        System.out.println();
        return foiPosicionado;
    }

    private boolean isValidPosition(int x, int y, String iconeExcecao) {
        return this.world[x][y].equalsIgnoreCase("[ ]") || (this.world[x][y].equalsIgnoreCase(this.getIcon()) || this.world[x][y].equalsIgnoreCase(iconeExcecao));
    }

    private boolean isOutOfBounds (int x, int y) {
        return x < 0 || y < 0 || x >= this.world.length || y >= this.world[0].length;
    }
}
