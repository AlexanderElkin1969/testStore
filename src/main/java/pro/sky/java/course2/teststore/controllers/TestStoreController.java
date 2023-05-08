package pro.sky.java.course2.teststore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.teststore.exeptions.*;
import pro.sky.java.course2.teststore.model.*;
import pro.sky.java.course2.teststore.service.TestStoreService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/store")
public class TestStoreController {
    private final TestStoreService storeService;

    public TestStoreController(TestStoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping()
    public String hello() {
        return "Добро пожаловать в наш интернет-магазин." +
                "Для просмотра каталога товара воспользуйтесь командой /order.   " +
                "Для выбора товара воспользуйтесь командой /order/add?ID=Артикль_товара&quantity=количество_товара.   " +
                "Для просмотра выбранного товара воспользуйтесь командой /order/get.   ";
    }

    @GetMapping(path = "/order")
    public Map<String, Product> getList() {
        return storeService.getList();
    }

    @GetMapping(path = "/order/add")
    public String addProductToBasket(@RequestParam("ID") String id,
                                     @RequestParam("quantity") int quantity) {
        return storeService.add(id, quantity).toString() + " добавлен в корзину.";
    }

    @GetMapping(path = "/order/get")
    public List<Product> getProductToBasket() {
        return storeService.get();
    }

    @ExceptionHandler(LittleValueProductExeption.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String LittleProductExeption(LittleValueProductExeption e) {
        return e.getMessage();
    }

    @ExceptionHandler(ProductNotFoundExeption.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String ProductNotFoundExeption(ProductNotFoundExeption e) {
        return e.getMessage();
    }


}
