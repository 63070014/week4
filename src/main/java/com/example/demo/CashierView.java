package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

//import java.awt.*;

@Route(value = "/index2")
public class CashierView extends VerticalLayout {
    private TextField txt_change, t1000, t500, t100, t20, t10, t5, t1;
    private Button btn;
    public CashierView(){
        TextField txt_change = new TextField();
        txt_change.setPlaceholder("$");
        txt_change.setLabel("เงินทอน");
        Button btn = new Button("คำนวณเงินทอน");
        TextField t1000 = new TextField();
        t1000.setPlaceholder("$1000: ");
        TextField t500 = new TextField();
        t500.setPlaceholder("$500: ");
        TextField t100 = new TextField();
        t100.setPlaceholder("$100: ");
        TextField t20 = new TextField();
        t20.setPlaceholder("$20: ");
        TextField t10 = new TextField();
        t10.setPlaceholder("$10: ");
        TextField t5 = new TextField();
        t5.setPlaceholder("$5: ");
        TextField t1 = new TextField();
        t1.setPlaceholder("$1: ");
        this.add(txt_change, btn, t1000, t500, t100, t20, t10, t5, t1);

        btn.addClickListener(event ->{
            int number = Integer.parseInt(txt_change.getValue());
            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+number)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();
            txt_change.setValue("$"+number);
            t1000.setValue("$1000: "+out.getB1000());
            t500.setValue("$500: "+out.getB500());
            t100.setValue("$100: "+out.getB100());
            t20.setValue("$20: "+out.getB20());
            t10.setValue("$10: "+out.getB10());
            t5.setValue("$5: "+out.getB5());
            t1.setValue("$1: "+out.getB1());
        });

    }

}
