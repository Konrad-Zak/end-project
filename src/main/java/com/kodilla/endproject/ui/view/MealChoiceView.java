package com.kodilla.endproject.ui.view;

import com.kodilla.endproject.backend.domian.Meal;
import com.kodilla.endproject.ui.MainView;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "Meals", layout = MainView.class)
public class MealChoiceView extends VerticalLayout {

    List<Meal> personList = new ArrayList<>();
    Grid<Meal> grid = new Grid<>();

    public MealChoiceView() {
        addToList();
        grid.setItems(personList);
        grid.addColumn(Meal::getNameMeal).setHeader("Meal Name");
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.getColumns().forEach(mealColumn -> mealColumn.setAutoWidth(true));
        add(grid);
    }

    private void addToList (){
        personList.add(new Meal("Apple"));
        personList.add(new Meal("anan"));
        personList.add(new Meal("Mieso"));

    }
}
