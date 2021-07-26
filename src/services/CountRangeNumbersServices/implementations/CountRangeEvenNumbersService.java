package services.CountRangeNumbersServices.implementations;

import exceptions.NumberOrderError;
import services.CountRangeNumbersServices.CountRangeNumbersService;

public class CountRangeEvenNumbersService implements CountRangeNumbersService
{
  private static CountRangeEvenNumbersService INSTANCE;

  private CountRangeEvenNumbersService() {  }


  public Integer count(Integer firstNumber, Integer lastNumber)
  {
    if(firstNumber > lastNumber) throw new NumberOrderError();

    var firstNumberIsEven = this.isEven(firstNumber); 
    var lastNumberIsEven = this.isEven(lastNumber);
    var amountNumbers = lastNumber - firstNumber + 1;

    if(firstNumberIsEven && lastNumberIsEven)
      return (int) Math.ceil(amountNumbers / 2.0);

    if(!firstNumberIsEven && !lastNumberIsEven)
      return (int) Math.floor(amountNumbers / 2.0);

    else return amountNumbers / 2;
  }

  private Boolean isEven(Integer number)
  {
    return number % 2 == 0;
  }

  public static CountRangeEvenNumbersService getInstance()
  {
    if(!(CountRangeEvenNumbersService.INSTANCE instanceof CountRangeEvenNumbersService))
    CountRangeEvenNumbersService.INSTANCE = new CountRangeEvenNumbersService();
  
    return CountRangeEvenNumbersService.INSTANCE;
  }
}
