package coderadish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import coderadish.action.actionhandler.ActionHandler;
import coderadish.action.actionhandler.ErrorHandler;
import coderadish.action.actionhandler.ExitHandler;
import coderadish.action.actionhandler.TimeHandler;
import coderadish.world.Location;
import coderadish.world.World;

/**
 *
 * @author Stephan
 */
public class Game {
    private BufferedReader input;
    private PrintStream output;
    private List<ActionHandler> actionHandlers;
    private World world;
    
    private boolean shouldExit;
    
    public Game() {
        this.input = new BufferedReader(new InputStreamReader(System.in));
        this.output = System.out;
        this.shouldExit = false;
        
        this.actionHandlers = new ArrayList<>();        
        this.actionHandlers.add(new ExitHandler(this));
        this.actionHandlers.add(new TimeHandler(this));
        
        this.world = new World(new Location("Die dunkle Höhle", "In dieser Höhle ist es dunkel, feucht und bitterlich kalt!"));
    }
    
    public void requestExit() {
        this.shouldExit = true;
    }
    
    public void run() throws IOException {
        String command = "";
        while (!this.shouldExit) {
            this.output.println("\n--------------------------------------------\n" + this.world.getCurrentSituation());
            
            // Eingabe
            this.output.print("> ");
            command = this.input.readLine();
            
            // Verarbeitung
            String outputString = this.update(command);
            
            // Ausgabe
            this.output.println(outputString);
        }
    } 
    
    public String update(String command) {
        ActionHandler relevantHandler = null;
        
        for (ActionHandler handler : this.actionHandlers) {
            if (handler.matches(command)) {
                relevantHandler = handler;
                break;
            }
        }
        
        if (relevantHandler == null) {
            relevantHandler = new ErrorHandler(this);
        }
        
        return relevantHandler.handle();
    }
}
