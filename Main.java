package textadventure;

import java.io.IOException;

/**
 *
 * @author Stephan
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException Throws exception if an input error occures.
     */
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.run();
    }
    
}
