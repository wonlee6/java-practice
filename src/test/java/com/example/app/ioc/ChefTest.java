package com.example.app.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ChefTest {

    @Autowired
    IngredientFactory ingredientFactory;

    @Autowired
    Chef chef;

    @Test
    void 돈까스_만들기() {

//        IngredientFactory ingredientFactory = new IngredientFactory();
//        // 준비
//        Chef chef = new Chef(ingredientFactory);
        String menu = "돈까스";
        // 수행
        String food = chef.cook(menu);
        // 예상
        String expected = "한돈 등심으로 만든 돈까스";

        // 검증
        assertEquals(food, expected);
        System.out.println(food);

    }

    @Test
    void 스테이크_만들기() {

//        IngredientFactory ingredientFactory = new IngredientFactory();
//        // 준비
//        Chef chef = new Chef(ingredientFactory);
        String menu = "스테이크";
        // 수행
        String food = chef.cook(menu);
        // 예상
        String expected = "한우 꽃등심으로 만든 스테이크";

        // 검증
        assertEquals(food, expected);
        System.out.println(food);

    }
}