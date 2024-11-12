package projetos.pessoais;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class Main {
    public interface CLibrary extends Library {
        CLibrary INSTANCE = Native.load(Platform.isWindows() ? "user32" : "X11", CLibrary.class);
        int GetAsyncKeyState(int vKey);
    }

    public static void main(String[] args) {
        String[][] mapaInicial = new String[6][6];
        Character personagemJogavel = new Character("👨");
        WorldGenerator worldGenerator = new WorldGenerator(mapaInicial, personagemJogavel);
        worldGenerator.showWorld(mapaInicial);

        GeneralMessageService.showMenuMessage("help");

        boolean[] keysPressed = new boolean[256]; // Array para rastrear o estado das teclas

        while (true) {
            for (int i = 0; i < 256; i++) {
                // Verifica se a tecla está pressionada
                if (CLibrary.INSTANCE.GetAsyncKeyState(i) != 0) {
                    // Se a tecla foi pressionada e ainda não estava 'notificada'
                    if (!keysPressed[i]) {
                        char key = (char) i;
                        switch (key) {
                            case 'A' -> {
                                if(worldGenerator.moveCharacter("left", null)){
                                    worldGenerator.showWorld(mapaInicial);
                                    GeneralMessageService.showMenuMessage("action");
                                } else {
                                    worldGenerator.showWorld(mapaInicial);
                                }

                            }
                            case 'S' -> {
                                if(worldGenerator.moveCharacter("down", null)){
                                    worldGenerator.showWorld(mapaInicial);
                                    GeneralMessageService.showMenuMessage("action");
                                } else {
                                    worldGenerator.showWorld(mapaInicial);
                                }
                            }
                            case 'D' -> {
                                if(worldGenerator.moveCharacter("right", null)){
                                    worldGenerator.showWorld(mapaInicial);
                                    GeneralMessageService.showMenuMessage("action");
                                } else {
                                    worldGenerator.showWorld(mapaInicial);
                                }
                            }
                            case 'W' -> {
                                if(worldGenerator.moveCharacter("up", null)){
                                    worldGenerator.showWorld(mapaInicial);
                                    GeneralMessageService.showMenuMessage("action");
                                } else {
                                    worldGenerator.showWorld(mapaInicial);
                                }
                            }
                            case 'H' -> {
                                GeneralMessageService.showMenuMessage("controls");
                                GeneralMessageService.showMenuMessage("action");
                            }
                            case 'Q' -> {
                                GeneralMessageService.showMenuMessage("exit");
                                return;
                            }
                        }
                        keysPressed[i] = true; // Marca a tecla como 'notificada'
                    }
                } else {
                    // Se a tecla não está pressionada, a marcação é resetada
                    keysPressed[i] = false;
                }
            }
            try {
                Thread.sleep(100); // Para evitar uso excessivo da CPU
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
