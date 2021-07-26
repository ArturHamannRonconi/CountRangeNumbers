package exceptions;

public class NumberNegativeError extends AppError
{
  public NumberNegativeError()
  {
    super("Negative numbers are not allowed");
  }  
}
