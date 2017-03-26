package petstore.client;

import static java.util.Collections.singletonList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.intendia.gwt.autorest.client.RequestResourceBuilder;

@SuppressWarnings("GWTStyleCheck")
public class Client implements EntryPoint {

    @Override public void onModuleLoad() {
        Petstore api = new Petstore_RestServiceModel(() -> new RequestResourceBuilder().path("//petstore.swagger.io/"));

        FlowPanel container = new FlowPanel(); container.setStyleName("container"); RootPanel.get().add(container);
        FlowPanel row = new FlowPanel(); row.setStyleName("row"); container.add(row);
        FlowPanel column = new FlowPanel(); column.setStyleName("column"); row.add(column);
        column.add(new HTMLPanel("h1", "Petstore"));
        HTMLPanel ul = new HTMLPanel("ul", ""); column.add(ul);

        api.get_pet_findByStatus(singletonList("available")).take(100).subscribe(pet -> {
            ul.add(new HTMLPanel("li", pet.name + " <code>" + pet.status + "</code> <small>" + pet.id + "</small>"));
        });

    }
}
