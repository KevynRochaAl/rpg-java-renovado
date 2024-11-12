package projetos.pessoais;

public class WorldGenerator {
    private String[][] world;
    private Character character;

    public WorldGenerator(String[][] world, Character character) {
        this.character = character;
        this.initializeTiles(world);
        this.world = world;
    }

    public String[][] getWorld() {
        return world;
    }

    public void setWorld(String[][] world) {
        this.world = world;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public boolean moveCharacter(String direction, String exceptionIcon){
        boolean foiPosicionado = false;

        switch (direction) {
            case "left" -> {
                int newCharacterXLocation = this.character.getxPosition()-1;

                if(this.isOutOfBounds(newCharacterXLocation, this.character.getyPosition())) {
                    System.out.println("\nNão é possível se movimentar para fora do mapa!");
                } else if (this.isValidPosition(newCharacterXLocation, this.character.getyPosition(), exceptionIcon)) {
                    this.world[this.character.getyPosition()][this.character.getxPosition()] = "[ ]";
                    this.character.setxPosition(newCharacterXLocation);
                    foiPosicionado = true;
                } else {
                    System.out.println("Posição inválida.");
                }
            }
            case "right" -> {
                int newCharacterXLocation = this.character.getxPosition()+1;

                if(this.isOutOfBounds(newCharacterXLocation, this.character.getyPosition())) {
                    System.out.println("\nNão é possível se movimentar para fora do mapa!");
                } else if (this.isValidPosition(newCharacterXLocation, this.character.getyPosition(), exceptionIcon)) {
                    this.world[this.character.getyPosition()][this.character.getxPosition()] = "[ ]";
                    this.character.setxPosition(newCharacterXLocation);
                    foiPosicionado = true;
                } else {
                    System.out.println("Posição inválida.");
                }
            }
            case "up" -> {
                int newCharacterYLocation = this.character.getyPosition()-1;

                if(this.isOutOfBounds(this.character.getxPosition(), newCharacterYLocation)) {
                    System.out.println("\nNão é possível se movimentar para fora do mapa!");
                } else if (this.isValidPosition(this.character.getxPosition(), newCharacterYLocation, exceptionIcon)) {
                    this.world[this.character.getyPosition()][this.character.getxPosition()] = "[ ]";
                    this.character.setyPosition(newCharacterYLocation);
                    foiPosicionado = true;
                } else {
                    System.out.println("Posição inválida.");
                }
            }

            case "down" -> {
                int newCharacterYLocation = this.character.getyPosition()+1;

                if(this.isOutOfBounds(this.character.getxPosition(), newCharacterYLocation)) {
                    System.out.println("\nNão é possível se movimentar para fora do mapa!");
                } else if (this.isValidPosition(this.character.getxPosition(), newCharacterYLocation, exceptionIcon)) {
                    this.world[this.character.getyPosition()][this.character.getxPosition()] = "[ ]";
                    this.character.setyPosition(newCharacterYLocation);
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

    public void showWorld(String[][] world) {
        for (int linha = 0; linha < world.length; linha++){
            for (int coluna = 0; coluna < world[linha].length; coluna++){
                if (coluna == this.character.getxPosition() && linha == this.character.getyPosition() && (world[linha][coluna].equalsIgnoreCase("[ ]"))){
                    world[linha][coluna]=this.character.getIcon();
                }
                System.out.print(world[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }

    private boolean isValidPosition(int x, int y, String iconeExcecao) {
        return this.world[x][y].equalsIgnoreCase("[ ]") || (this.world[x][y].equalsIgnoreCase(this.character.getIcon()) || this.world[x][y].equalsIgnoreCase(iconeExcecao));
    }

    private boolean isOutOfBounds (int x, int y) {
        return x < 0 || y < 0 || x >= this.world.length || y >= this.world[0].length;
    }

    private void initializeTiles(String[][] world){
        for (int coluna = 0; coluna < world[0].length; coluna++){
            for (int linha = 0; linha < world.length; linha++) {
                world[linha][coluna] = "[ ]";
            }
        }
    }

    public void showActionMessage(){
        System.out.print("Comando atual: ");
    }
}
