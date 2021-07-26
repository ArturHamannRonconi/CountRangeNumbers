package services.CountRangeNumbersServices.implementations;

import exceptions.NumberOrderError;
import services.CountRangeNumbersServices.CountRangeNumbersService;

public class CountRangeOddNumbersService implements CountRangeNumbersService
{
  private static CountRangeOddNumbersService INSTANCE;

  private CountRangeOddNumbersService() {  }

  public Integer count(Integer firstNumber, Integer lastNumber)
  {
    if(firstNumber > lastNumber) throw new NumberOrderError();

    var firstNumberIsOdd = this.isOdd(firstNumber); 
    var lastNumberIsOdd = this.isOdd(lastNumber);
    var amountNumbers = lastNumber - firstNumber + 1;

    if(firstNumberIsOdd && lastNumberIsOdd)
      return (int) Math.ceil(amountNumbers / 2.0);
      
    if(!firstNumberIsOdd && !lastNumberIsOdd)
      return (int) Math.floor(amountNumbers / 2.0);

    else return amountNumbers / 2;
  }

  private Boolean isOdd(Integer number)
  {
    return number % 2 != 0;
  }

  public static CountRangeOddNumbersService getInstance()
  {
    if(!(CountRangeOddNumbersService.INSTANCE instanceof CountRangeOddNumbersService))
      CountRangeOddNumbersService.INSTANCE = new CountRangeOddNumbersService();
  
    return CountRangeOddNumbersService.INSTANCE;
  }
}
