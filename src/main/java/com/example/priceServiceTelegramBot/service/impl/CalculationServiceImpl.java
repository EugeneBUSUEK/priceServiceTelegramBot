package com.example.priceServiceTelegramBot.service.impl;

import com.example.priceServiceTelegramBot.service.CalculationService;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {

    private final int SNEAKERS_COEFF_3 = 650;

    private final int SNEAKERS_COEFF_4 = 1940;

    private final int CLOTHES_COEFF_3 = 300;

    private final int CLOTHES_COEFF_4 = 1240;

    private final int OTHERS_COEFF_3 = 300;

    private final int OTHERS_COEFF_4 = 940;

    @Override
    public int calcSneakersPrice(int yuanPrice) {
        int ruPrice = (int) (yuanPrice * COEFF_1 * COEFF_2 + SNEAKERS_COEFF_3 + SNEAKERS_COEFF_4);

        if (ruPrice % 100 <= 40) {
            ruPrice = (ruPrice / 100 - 1) * 100 + 90;
        } else {
            ruPrice = (ruPrice / 100) * 100 + 40;
        }
        return ruPrice;
    }

    @Override
    public int calcClothesPrice(int yuanPrice) {
        int ruPrice = (int) (yuanPrice * COEFF_1 * COEFF_2 + CLOTHES_COEFF_3 + CLOTHES_COEFF_4);

        if (ruPrice % 100 <= 40) {
            ruPrice = (ruPrice / 100 - 1) * 100 + 90;
        } else {
            ruPrice = (ruPrice / 100) * 100 + 40;
        }
        return ruPrice;
    }

    @Override
    public int calcOthersPrice(int yuanPrice) {
        int ruPrice = (int) (yuanPrice * COEFF_1 * COEFF_2 + OTHERS_COEFF_3 + OTHERS_COEFF_4);

        if (ruPrice % 100 <= 40) {
            ruPrice = (ruPrice / 100 - 1) * 100 + 90;
        } else {
            ruPrice = (ruPrice / 100) * 100 + 40;
        }
        return ruPrice;
    }
}
