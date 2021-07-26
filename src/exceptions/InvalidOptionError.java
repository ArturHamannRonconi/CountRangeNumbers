package exceptions;

public class InvalidOptionError extends AppError
{
  public InvalidOptionError()
  {
    super("This only allowed \'prime\', \'even\' or \'odd\' options");
  }
}
