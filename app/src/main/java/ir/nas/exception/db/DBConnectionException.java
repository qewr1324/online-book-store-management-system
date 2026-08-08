package ir.nas.exception.db;

import ir.nas.util.ColorCMD;

/**
 * DBConnectionException
 */
public class DBConnectionException extends RuntimeException
{
    public DBConnectionException(final String message)
    {
        super(ColorCMD.dbError(message));
    }
}