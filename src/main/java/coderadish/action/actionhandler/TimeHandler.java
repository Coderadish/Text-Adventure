/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderadish.action.actionhandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import coderadish.Game;

/**
 *
 * @author Stephan
 */
public class TimeHandler extends PhraseActionHandler {
    private final SimpleDateFormat timeFormat;
    private final SimpleDateFormat dateFormat;

    public TimeHandler(Game game) {
        super(game);
        
        this.timeFormat = new SimpleDateFormat("H:m");
        this.dateFormat = new SimpleDateFormat("d.M.y");
    }

    @Override
    protected String[] getPhrases() {
        return new String[]{"/time"};
    }

    @Override
    public String handle() {
        Date date = new Date();
        return "Es ist " + this.timeFormat.format(date) + " Uhr am " + this.dateFormat.format(date) + ".";
    }
    
}
