package dev.timeunit.libraries.utilities.commands;

import dev.timeunit.libraries.utilities.commands.param.ParameterType;
import dev.timeunit.libraries.utilities.commands.param.ParameterType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface Type {
    Class<? extends ParameterType> value();
}
