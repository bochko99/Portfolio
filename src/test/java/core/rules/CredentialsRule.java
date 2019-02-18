package core.rules;

import core.Auth;
import core.annotations.Credentials;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import utils.CredentialEntry;
import utils.Environment;

public class CredentialsRule extends TestWatcher {

    private static String currentType = "";

    /**
     * Invoked when a test is about to start
     *
     * @param description
     */
    @Override
    protected void starting(Description description) {
        super.starting(description);
        Credentials credentials = description.getAnnotation(Credentials.class);
        if (credentials == null) {
            if (!currentType.isEmpty()) {
                Auth.flush();
                CredentialEntry entry = Environment.CREDENTIALS.get("default");
                Auth.basic(entry.getLogin(), entry.getPassword());
                System.out.println(String.format("%s : '%s' -> default", description.getMethodName(), currentType));
                currentType = "";
            } else {
                System.out.println(String.format("%s : default", description.getMethodName()));
            }
        } else if (!credentials.type().isEmpty() && !currentType.equalsIgnoreCase(credentials.type())) {
            Auth.flush();
            CredentialEntry entry = Environment.CREDENTIALS.get(credentials.type());
            Auth.basic(entry.getLogin(), entry.getPassword());
            System.out.println(String.format("%s : '%s' -> '%s'", description.getMethodName(), currentType, credentials.type()));

            currentType = credentials.type();
        } else if (!credentials.login().isEmpty() && !credentials.password().isEmpty()) {
            Auth.flush();
            Auth.basic(credentials.login(), credentials.password());
            System.out.println(String.format("%s: %s' -> custom ('%s' : '%s')", description.getMethodName(), currentType, credentials.login(), credentials.password()));
            currentType = "custom";
        }
    }

    /**
     * Invoked when a test method finishes (whether passing or failing)
     *
     * @param description
     */
    @Override
    protected void finished(Description description) {
        super.finished(description);
        Credentials credentials = description.getAnnotation(Credentials.class);
        if (credentials!= null && credentials.creatingNewUser()) {
            currentType = "hasNewUser";
        }
    }
}