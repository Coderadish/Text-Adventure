package coderadish.action.actionhandler;

import coderadish.Game;

/**
 *
 * @author Stephan
 */
public class ExitHandler extends PhraseActionHandler {
    
    public ExitHandler(Game game) {
        super(game);
    }

    @Override
    public String handle() {
        this.game.requestExit();
        return "Programm wird beendet.";
    }

    @Override
    protected String[] getPhrases() {
        return new String[]{"/exit"};
    }    
}
