package main;

import contract.IModel;
import controller.Controllergame;
import controller.Controllerother;
import controller.Controllerplayer;
import model.Model;
import view.View;

public class Main {

	public static void main(String[] args) {
		final Model model = new Model();
        final View view = new View((IModel) model);
        
        final Controllergame controllergame = new Controllergame(view,model);
        
        final Controllerother controllerother = new Controllerother(view, model);
        
        final Controllerplayer controllerplayer = new Controllerplayer(view, model);
        
        view.setControllergame(controllergame);
        
        view.setControllerother(controllerother);
        
        view.setControllerplayer(controllerplayer);
        
        controllergame.start();
    }

}
