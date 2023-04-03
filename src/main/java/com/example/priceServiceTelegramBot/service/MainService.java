package com.example.priceServiceTelegramBot.service;

import com.example.priceServiceTelegramBot.support.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {

    final CalculationService calculationService;

    private String product = "";
    public String getAnswer(String text) {

        int price = 0;

        if (text.equals("/start")) {
            this.product = "";
            return "Выберете категорию товара, для которого хотите узнать цену.";
        }

        if (text.equals(Constants.SNEAKERS) || text.equals(Constants.CLOTHES) || text.equals(Constants.OTHERS)) {
            this.product = text;
            return "Введите цену товара в юанях (Целое число)";
        }

        if (product.equals("")) {
            return "Не выбрана категория товара.\nВыберете категорию товара, для которого хотите узнать цену.";
        } else if (text.matches("[0-9]+")) {
            price = Integer.parseInt(text);
            String resultPrice = "";
            switch (this.product) {
                case "кросовки":
                    resultPrice = String.valueOf(calculationService.calcSneakersPrice(price));
                    break;
                case "одежда":
                    resultPrice = String.valueOf(calculationService.calcClothesPrice(price));
                    break;
                case "аксессуары":
                    resultPrice = String.valueOf(calculationService.calcOthersPrice(price));
                    break;
                default:
                    resultPrice = "-1";
            }
            this.product = "";
            return "Цена в рублях: " + resultPrice + ".\nДля продолжения введите: /start";
        }

        return "Неверно введена цена!\nВведите цену повторно или вернитесь к выбору категории товара: /start";

    }
}
