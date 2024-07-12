import main.Principal;

import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        while(true) {
            try {
                Principal principal = new Principal();
                principal.showMenu();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\n** Se ha producido un error: El tipo de dato ingresado no es válido **\n");
            } catch (NullPointerException e){
                System.out.println("\n** Se ha producido un error: El dato ingresado no es válido **\n");
            }
        }
    }
}