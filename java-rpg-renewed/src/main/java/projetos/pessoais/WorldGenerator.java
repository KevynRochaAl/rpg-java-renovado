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
