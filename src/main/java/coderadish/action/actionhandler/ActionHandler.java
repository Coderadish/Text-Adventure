package coderadish.action.actionhandler;

import coderadish.Game;

/**
 *
 * @author Stephan
 */
public abstract class ActionHandler {
    protected Game game;
    
    public ActionHandler(Game game) {
        this.game = game;
    }
    
    public abstract boolean matches(String command);
    
    public abstract String handle();
    
}
