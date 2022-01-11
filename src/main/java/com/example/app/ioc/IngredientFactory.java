package com.example.app.ioc;

import org.springframework.stereotype.Component;

@Component
public class IngredientFactory {


    public Ingredinet get(String menu) {
        switch (menu) {
            case "돈까스":
                return new Pork("한돈 등심");
            case "스테이크":
                return new Beef("한우 꽃등심");
            default:
                return null;
        }

    }
}
