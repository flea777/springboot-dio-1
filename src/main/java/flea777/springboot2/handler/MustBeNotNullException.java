package flea777.springboot2.handler;

public class MustBeNotNullException extends BusinessException{

    public MustBeNotNullException(String field) {
        super("The field %s must be not null", field);
    }
}
