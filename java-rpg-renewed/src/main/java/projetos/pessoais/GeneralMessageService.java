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
                | 1 = Utiliza item no slot 1 |
                | 2 = Utiliza item no slot 2 |
                | 3 = Utiliza item no slot 3 |
                | H = Menu de controles      |
                | B = Voltar ao jogo         |
                | Q = Encerrar execução      |
                @============================@
                """);
            }
        }
    }
    public static void showCharacterRelatedMessage(Character character, String messageType){
        switch (messageType){
            case "menu" -> System.out.println("\n"+"-".repeat(24) +"\n❤️HP: "+character.getHealth()+"/5 1["+character.getEquipedItems()[0]+"] 2["+character.getEquipedItems()[0]+"] 3["+character.getEquipedItems()[0]+"]\n"+"-".repeat(24));
        }
    }
}
