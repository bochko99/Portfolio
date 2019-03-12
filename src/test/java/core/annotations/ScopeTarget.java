package core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ScopeTarget {

    Stand[] stands() default {Stand.BETA, Stand.STAGE, Stand.PROD, Stand.CUSTOM};

    enum Stand {

        BETA("BETA"),
        STAGE("STAGE"),
        PROD("PROD"),
        CUSTOM("CUSTOM");

        private String value;

        Stand(String value) {
            this.value = value;
        }

        /**
         * Returns the name of this enum constant, as contained in the
         * declaration.  This method may be overridden, though it typically
         * isn't necessary or desirable.  An enum type should override this
         * method when a more "programmer-friendly" string form exists.
         *
         * @return the name of this enum constant
         */
        @Override
        public String toString() {
            return this.value;
        }
    }
}
