package main;

import contract.IModel;
import controller.Controller;
import model.Model;
import view.View;

public class Main {

	public static void main(String[] args) {
		final Model model = new Model();
        final View view = new View((IModel) model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);
        controller.start();
    }

}
