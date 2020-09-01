package com.kodilla.endproject.ui.view;

import com.kodilla.endproject.ui.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;



@Route(value = "caloric", layout = MainView.class)
public class DailyCaloricRequirementView extends VerticalLayout {

    public DailyCaloricRequirementView() {
        addClassName("caloric-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
         add(
                 getContactStats()
         );
    }


    private Component getContactStats() {
        Span stats = new Span(20 + " contacts");
        stats.addClassName("contact-stats");

        return stats;
    }
}
