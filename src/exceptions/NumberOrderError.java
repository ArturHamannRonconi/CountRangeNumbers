package exceptions;

public class NumberOrderError extends AppError
{
  public NumberOrderError()
  {
    super("The first number must be less than the last");
  }
}
