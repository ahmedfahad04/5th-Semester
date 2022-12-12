public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static bool ProvideCoffee(CoffeeType coffeeType){

        if (initialCondition() && checkCreamCoffeeAmount() && checkSugarCoffeeAmount())
        {
            return false;
        }

//        if(checkCreamCoffeeAmount()){
//            return false;
//        }
//
//        if(checkSugarCoffeeAmount()){
//            return false;
//        }

        _cup--;
        _hotwater -= _CUP_HOT_WATER;
        _coffeePowder -= _CUP_COFFEE_POWDER;
        if(isCreamCoffee()){
            _creamPowder -= _CUP_CREAM_POWDER;
        }
        if(isSugerCoffee()){
            _suger -= _CUP_SUGAR;
        }

        ReturnChange();
        return ture;

    }

    public static bool initialCondition(){
        if (_change < _CUP_PRICE || AreCupsSufficient || IsBotWaterSufficient || IsCoffeePowderSufficient)
        {
            return true;
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


}