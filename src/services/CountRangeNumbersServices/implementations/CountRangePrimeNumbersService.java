package services.CountRangeNumbersServices.implementations;

import exceptions.NumberNegativeError;
import exceptions.NumberOrderError;
import services.CountRangeNumbersServices.CountRangeNumbersService;

public class CountRangePrimeNumbersService implements CountRangeNumbersService
{
  private static CountRangePrimeNumbersService INSTANCE;
  private Integer amountPrimeNumbers = 0;

  private CountRangePrimeNumbersService() {  }


  public Integer count(Integer firstNumber, Integer lastNumber)
  {
    var negativeNumbers = firstNumber < 0 || lastNumber < 0;

    if(firstNumber > lastNumber) throw new NumberOrderError();
    if(negativeNumbers) throw new NumberNegativeError();

    this.verifyThisIsAPrimeNumber(firstNumber, lastNumber);

    return this.amountPrimeNumbers;
  }

  private void verifyThisIsAPrimeNumber(Integer firstNumber, Integer lastNumber)
  {
    var isPrimeNumber = this.divideByBelowNumbers(firstNumber, firstNumber - 1);
    if(isPrimeNumber) this.amountPrimeNumbers++;

    if(firstNumber + 1 <= lastNumber)
      this.verifyThisIsAPrimeNumber(++firstNumber, lastNumber);
  }
  private Boolean divideByBelowNumbers(Integer dividend, Integer divisor)
  {
    if(dividend == 1) return false;
    if(divisor <= 1) return true;

    return dividend % divisor == 0
      ? false
      : this.divideByBelowNumbers(dividend, divisor - 1);
  }

  public static CountRangePrimeNumbersService getInstance()
  {
    if(!(CountRangePrimeNumbersService.INSTANCE instanceof CountRangePrimeNumbersService))
      CountRangePrimeNumbersService.INSTANCE = new CountRangePrimeNumbersService();
  
    return CountRangePrimeNumbersService.INSTANCE;
  }
}
