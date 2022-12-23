public class main2 {

    public static void coffeemachine(){
        if(isChangeEnough() && aresufficientMaterial()){
            makeCoffee();
        }
    }

    public static bool makeCoffee() {
        aresufficientMaterial();
        makeBlackCoffee();
        if(coffeeContainCream()){
            _creamPowder -= _CUP_CREAM_POWDER;
        }

        if(coffeeContainSugar()){
            _suger -= _CUP_SUGAR;
        }
        ReturnChange();
        return ture;
    }

    public static void aresufficientMaterial() {
        if (checkCreamCoffeeAmount() && checkSugarCoffeeAmount())
        {
            return false;
        }
    }

    public static bool isCreamCoffee(){
        if (coffeeType == CoffeeType.Cream || isCreamAndSuger()){
            return true;
        }
    }

    public static bool isSugerCoffee(){
        if (coffeeType == CoffeeType.Sugar ||isCreamAndSuger()){
            return true;
        }
    }

    public static bool isCreamAndSuger() {
        if( coffeeType == CoffeeType.CreamAndSugar) {
            return true;
        }
    }

    public static bool checkCreamCoffeeAmount() {
        if((isCreamCoffee()) && IsCreamPowderSufficient){
            return true;
        }
    }

    public static bool checkSugarCoffeeAmount() {
        if((isSugerCoffee()) && IsSugarSufficient){
            return true;
        }
    }



    public static void makeBlackCoffee() {
        _cup--;
        _hotwater -= _CUP_HOT_WATER;
        _coffeePowder -= _CUP_COFFEE_POWDER;
    }

    public static bool isChangeEnough(){
        if (_change < _CUP_PRICE || AreCupsSufficient || IsBotWaterSufficient || IsCoffeePowderSufficient)
        {
            return true;
        }
    }
}
