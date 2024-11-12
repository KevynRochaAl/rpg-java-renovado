package projetos.pessoais;

public class GeneralMessageService {

    public static void showErrorMessage(String errorType){}
    public static void showMenuMessage(String menuMessageType){
        switch (menuMessageType){
            case "help" -> System.out.println("\nPressione a tecla 'H' para ver os controles do jogo.");
            case "action" -> System.out.print("\nComando atual: ");
            case "exit" -> System.out.println("\nSaindo...");
            case "controls" -> {
                System.out.println("""
                \n
                @============================@
                | W A S D = Movimentação     |
                | H = Menu de controles      |
                | Q = encerrar execução      |
                | B = voltar ao jogo         |
                @============================@
                """);
            }
        }
    }
    public static void showCharacterRelatedMessage(Character character, String messageType){
        switch (messageType){
            case "menu" -> System.out.println("\n"+"-".repeat(23) +"\n❤️HP: "+character.getHealth()+"/5 "+character.getEquipedItem()+" "+character.getEquipedWeapon()+"\n"+"-".repeat(23));
        }
    }
}
