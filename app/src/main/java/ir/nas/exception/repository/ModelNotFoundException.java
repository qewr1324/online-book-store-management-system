package ir.nas.exception.repository;

import ir.nas.exception.BusinessException;
import ir.nas.util.ColorCMD;

/**
 * ModelNotFoundException
 */
public class ModelNotFoundException extends BusinessException
{
    public ModelNotFoundException(final String message)
    {
        super(ColorCMD.repositoryError(message));
    }
}
