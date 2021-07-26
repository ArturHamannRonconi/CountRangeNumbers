package utils;

import java.util.Arrays;
import java.util.List;

import services.CountRangeNumbersServices.CountRangeNumbersService;
import services.CountRangeNumbersServices.implementations.CountRangeEvenNumbersService;
import services.CountRangeNumbersServices.implementations.CountRangeOddNumbersService;
import services.CountRangeNumbersServices.implementations.CountRangePrimeNumbersService;

public enum CountOptions
{
  PRIME("prime", CountRangePrimeNumbersService.getInstance()),
  EVEN("even", CountRangeEvenNumbersService.getInstance()),
  ODD("odd", CountRangeOddNumbersService.getInstance());

  private String option;
  private CountRangeNumbersService countRangeNumbersService;

  CountOptions(String option, CountRangeNumbersService countRangeNumbersService)
  {
    this.option = option;
    this.countRangeNumbersService = countRangeNumbersService;
  }

  public CountRangeNumbersService getService()
  {
    return this.countRangeNumbersService;
  }
  public String getOption()
  {
    return this.option;
  }
  public static List<CountOptions> getArrayOptions()
  {
    var options = Arrays.asList(
      CountOptions.PRIME,
      CountOptions.EVEN,
      CountOptions.ODD
    );

    return options;
  }
}
