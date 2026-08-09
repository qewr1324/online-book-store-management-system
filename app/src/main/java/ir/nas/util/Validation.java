package ir.nas.util;

import ir.nas.exception.util.InvalidInputException;

public final class Validation
{
    private String errorMessage;
    private boolean isValid = true;

    private Validation()
    {}

    public static final Validation of()
    {
        return new Validation();
    }

    public final <T extends Object> Validation requireNotNull(final T obj)
    {
        if (this.isValid && obj == null) {
            this.errorMessage = "Invalid Null Object! -> [%s]"
                    .formatted(obj.getClass().getSimpleName());
            this.isValid = false;
        }

        return this;
    }

    public final <N extends Number> Validation requireNotNegative(final N number)
    {
        if (this.isValid && number == null) {
            this.errorMessage = "Invalid Null Number! -> [%.2f]".formatted(number);
            this.isValid = false;
        }

        if (this.isValid && number.doubleValue() < 0) {
            this.errorMessage = "Invalid Negative Number! -> [%.2f]".formatted(number);
            this.isValid = false;
        }

        return this;
    }

    public final <N extends Number> Validation requireNotNegativeZero(final N number)
    {
        if (this.isValid && number == null) {
            this.errorMessage = "Invalid Null Number! -> [%.2f]".formatted(number);
            this.isValid = false;
        }

        if (this.isValid && number.doubleValue() < 1) {
            this.errorMessage = "Invalid Zero Or Negative Number! -> [%.2f]".formatted(number);
            this.isValid = false;
        }

        return this;
    }

    public final Validation requireString(final String input)
    {
        if (this.isValid && input == null) {
            this.errorMessage = "Invalid Null String! -> [%s]".formatted(input);
            this.isValid = false;
        }

        if (this.isValid && input.isBlank()) {
            this.errorMessage = "Invalid Blank String! -> [%s]".formatted(input);
            this.isValid = false;
        }

        return this;
    }

    public final Validation requireTrueLength(final String input, final int minLength)
    {
        if (this.isValid && input == null) {
            this.errorMessage = "Invalid Null String! -> [%s]".formatted(input);
            this.isValid = false;
        }

        if (this.isValid && input.isBlank()) {
            this.errorMessage = "Invalid Blank String! -> [%s]".formatted(input);
            this.isValid = false;
        }

        if (this.isValid && input.length() > minLength) {
            this.errorMessage = "Invalid less Than %d Length String! -> [%s]"
                    .formatted(minLength, input);
            this.isValid = false;
        }

        return this;
    }

    public final Validation requirePostalCode(final String input)
    {
        final int POSTAL_CODE_LENGTH = 10;

        if (this.isValid && input == null) {
            this.errorMessage = "Invalid Null String! -> [%s]".formatted(input);
            this.isValid = false;
        }

        if (this.isValid && input.isBlank()) {
            this.errorMessage = "Invalid Blank String! -> [%s]".formatted(input);
            this.isValid = false;
        }

        if (this.isValid && input.length() > POSTAL_CODE_LENGTH) {
            this.errorMessage = "Invalid less Than %d Length String! -> [%s]"
                    .formatted(POSTAL_CODE_LENGTH, input);
            this.isValid = false;
        }

        return this;
    }

    public final void validate()
    {
        if (!this.isValid)
            throw new InvalidInputException(this.errorMessage);
    }
}
