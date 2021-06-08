
package textadventure.action.actionhandler;

import textadventure.Game;

/**
 *
 * @author Stephan
 */
public abstract class PhraseActionHandler extends ActionHandler {
    
    public PhraseActionHandler(Game game) {
        super(game);
    }
    
    @Override
    public boolean matches(String command) {
        String[] phrases = this.getPhrases();
        for (String phrase : phrases) {
            if (phrase.equals(command)) {
                return true;
            }
        }
        return false;
    }
    
    protected abstract String[] getPhrases();    
}
