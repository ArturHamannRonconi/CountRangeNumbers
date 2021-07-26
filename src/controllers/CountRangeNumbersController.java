package controllers;

import java.util.Scanner;
import java.util.function.Consumer;

import lambdas.Executor;
import services.GetByOptionServices;
import utils.Controller;

public class CountRangeNumbersController extends Controller
{
  private static CountRangeNumbersController INSTANCE;
  private GetByOptionServices getByOptionServices;

  private CountRangeNumbersController(GetByOptionServices getByOptionServices)
  {
    this.getByOptionServices = getByOptionServices;
  }

  public void handle(Scanner input, Consumer<String> output)
  {
    Executor executor = () -> {
      output.accept("Enter the first number: ");
      var firstNumber = input.nextInt();
      
      output.accept("Enter the last number: ");
      var lastNumber = input.nextInt();
      
      output.accept("Change between \'prime\', \'even\' and \'odd\': ");
      var option = input.next();

      var countRangeService = this.getByOptionServices.execute(option);
      var score = countRangeService.count(firstNumber, lastNumber);

      output.accept("" + score);
    };

    super.tryCatch(executor);
    input.close();
  }
  
  public static CountRangeNumbersController getInstance(GetByOptionServices getByOptionServices)
  {
    if(!(CountRangeNumbersController.INSTANCE instanceof CountRangeNumbersController))
      CountRangeNumbersController.INSTANCE = new CountRangeNumbersController(
        getByOptionServices
      );
  
    return CountRangeNumbersController.INSTANCE;
  }
}