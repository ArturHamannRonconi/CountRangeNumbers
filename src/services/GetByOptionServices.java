package services;

import java.util.HashMap;

import exceptions.InvalidOptionError;
import services.CountRangeNumbersServices.CountRangeNumbersService;
import utils.CountOptions;

public class GetByOptionServices
{
  private static GetByOptionServices INSTANCE;

  private GetByOptionServices() {  }

  public CountRangeNumbersService execute(String option)
  {
    var isInvalidOption = this.verifyIsInvalidOption(option);
    if(isInvalidOption) throw new InvalidOptionError();

    var options = new HashMap<String, CountRangeNumbersService>();

    CountOptions
      .getArrayOptions()
      .forEach(opt -> options.put(opt.getOption(), opt.getService()));

    return options.get(option.toLowerCase());
  }
  
  private Boolean verifyIsInvalidOption(String option)
  {
    return
      !option.equalsIgnoreCase(CountOptions.PRIME.getOption()) &&
      !option.equalsIgnoreCase(CountOptions.EVEN.getOption()) &&
      !option.equalsIgnoreCase(CountOptions.ODD.getOption());
  }

  public static GetByOptionServices getInstance()
  {
    if(!(GetByOptionServices.INSTANCE instanceof GetByOptionServices))
      GetByOptionServices.INSTANCE = new GetByOptionServices();
  
    return GetByOptionServices.INSTANCE;
  }
}
