package com.example.app.ioc;

import org.springframework.stereotype.Component;

@Component // 해당 클래스를 개체로 만들고, 이를 Ioc 컨테이너에 등록
public class Chef {

    private IngredientFactory ingredientFactory;

    public Chef(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;

    }

    public String cook(String menu) {
//        Pork pork = new Pork("한돈 등신");
        Ingredinet ingredient = ingredientFactory.get(menu);


        return ingredient.getName() + "으로 만든 " + menu;

    }
}
