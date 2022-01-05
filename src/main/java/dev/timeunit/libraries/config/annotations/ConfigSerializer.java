package dev.timeunit.libraries.config.annotations;

import dev.timeunit.libraries.config.AbstractSerializer;
import dev.timeunit.libraries.config.AbstractSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ConfigSerializer {
    Class<? extends AbstractSerializer<Object>> serializer();
}
