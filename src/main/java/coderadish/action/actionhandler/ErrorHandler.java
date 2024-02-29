package coderadish.action.actionhandler;

import coderadish.Game;

/**
 *
 * @author Stephan
 */
public class ErrorHandler extends ActionHandler {
    
    public ErrorHandler(Game game) {
        super(game);
    }
    
    @Override
    public String handle() {
        return "Das eingegebene Kommando ist nicht korrekt.";
    }

    @Override
    public boolean matches(String command) {
        return true;
    }
}
