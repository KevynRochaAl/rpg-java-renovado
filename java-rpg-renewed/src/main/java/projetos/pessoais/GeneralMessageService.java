package projetos.pessoais;

public class GeneralMessageService {

    public static void showErrorMessage(String errorType){}
    public static void showMenuMessage(String menuMessageType){
        switch (menuMessageType){
            case "help" -> System.out.println("Pressione a tecla 'H' para ver os controles do jogo.");
            case "action" -> System.out.print("Comando atual: ");
            case "exit" -> System.out.println("\nSaindo...");
            case "controls" -> {
                System.out.println("""
                \n
                @==========================@
                | W A S D = Movimentação   |
                | H = Menu de controles    |
                | Q = encerrar execução    |
                @==========================@
                """);
            }
        }
    }
}
