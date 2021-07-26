import controllers.CountRangeNumbersController;
import services.GetByOptionServices;
import utils.IO;

public class Start
{
  public static void main(String[] args)
  {
    var getByOptionServices = GetByOptionServices.getInstance();
    var countRangeNumbersController = CountRangeNumbersController.getInstance(
      getByOptionServices
    );

    countRangeNumbersController.handle(
      IO.input,
      IO.output
    );
  }
}