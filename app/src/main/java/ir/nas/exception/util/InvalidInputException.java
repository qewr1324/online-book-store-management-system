package ir.nas.exception.util;

import ir.nas.exception.BusinessException;
import ir.nas.util.ColorCMD;

/**
 * InvalidInputException
 */
public class InvalidInputException extends BusinessException
{
    public InvalidInputException(final String message)
    {
        super(ColorCMD.validationError(message));
    }
}
