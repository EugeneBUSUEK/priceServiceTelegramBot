package com.example.priceServiceTelegramBot.service;

public interface CalculationService {

    double COEFF_1 = 11.8;

    double COEFF_2 = 1.05;

    int DELIVERY_COEFF = 500;

    int calcSneakersPrice(int yuanPrice);

    int calcClothesPrice(int yuanPrice);

    int calcOthersPrice(int yuanPrice);
}
