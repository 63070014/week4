package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "/index1")
public class Mathview extends FormLayout {
    private TextField txt1, txt2, ans;
    private Button btnPlus, btnMinus, btnMulti, btnDivide, btnMod, btnMax;
    public  Mathview(){
        TextField txt1 = new TextField();
        txt1.setLabel("Number1");
        TextField txt2 = new TextField();
        txt2.setLabel("Number2");
        TextField ans = new TextField();
        ans.setLabel("Answer");
        Button btnPlus = new Button("+");
        Button btnMinus = new Button("-");
        Button btnMulti = new Button("x");
        Button btnDivide = new Button("/");
        Button btnMod = new Button("Mod");
        Button btnMax = new Button("Max");
        HorizontalLayout h1 = new HorizontalLayout();
        VerticalLayout v1 = new VerticalLayout();
        h1.add(btnPlus, btnMinus, btnMulti, btnDivide, btnMod, btnMax);
        v1.add(txt1, txt2, h1, ans);
        this.add(v1);

        btnPlus.addClickListener(event->{
            double num1 = Double.parseDouble(txt1.getValue());
            double num2 = Double.parseDouble(txt2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/plus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);

        });

        btnMinus.addClickListener(event->{
            double num1 = Double.parseDouble(txt1.getValue());
            double num2 = Double.parseDouble(txt2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);

        });

        btnMulti.addClickListener(event->{
            double num1 = Double.parseDouble(txt1.getValue());
            double num2 = Double.parseDouble(txt2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multi/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        btnDivide.addClickListener(event->{
            double num1 = Double.parseDouble(txt1.getValue());
            double num2 = Double.parseDouble(txt2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        btnMod.addClickListener(event->{
            double num1 = Double.parseDouble(txt1.getValue());
            double num2 = Double.parseDouble(txt2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        btnMax.addClickListener(event->{
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("num1", txt1.getValue());
            formData.add("num2", txt2.getValue());
            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });
    }

}
