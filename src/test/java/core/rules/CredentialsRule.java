package core.rules;

import com.crypterium.cryptApi.utils.CredentialEntry;
import com.crypterium.cryptApi.utils.Environment;
import core.annotations.Credentials;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static com.crypterium.cryptApi.Auth.service;

public class CredentialsRule extends TestWatcher {

    private static String currentType = "";
    private static CredentialEntry currentEntry;

    public static CredentialEntry current() {
        return currentEntry;
    }

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
                service().flush();
                CredentialEntry entry = Environment.CREDENTIALS.get("default");
                service().basic(entry.getLogin(), entry.getPassword());
                currentEntry = entry;
                System.out.println(String.format("%s : '%s' -> default", description.getMethodName(), currentType));
                currentType = "";
            } else {
                System.out.println(String.format("%s : default", description.getMethodName()));
            }
        } else if (!credentials.type().isEmpty() && !currentType.equalsIgnoreCase(credentials.type())) {
            service().flush();
            CredentialEntry entry = Environment.CREDENTIALS.get(credentials.type());
            currentEntry = entry;
            service().basic(entry.getLogin(), entry.getPassword());
            System.out.println(String.format("%s : '%s' -> '%s'", description.getMethodName(), currentType, credentials.type()));

            currentType = credentials.type();
        } else if (!credentials.login().isEmpty() && !credentials.password().isEmpty()) {
            service().flush();
            service().basic(credentials.login(), credentials.password());
            currentEntry = new CredentialEntry(credentials.login(), credentials.password(), "custom");
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
        if (credentials != null && credentials.creatingNewUser()) {
            service().flush();
            CredentialEntry entry = Environment.CREDENTIALS.get("default");
            service().basic(entry.getLogin(), entry.getPassword());
            currentEntry = entry;
            System.out.println(String.format("%s : '%s' -> default", description.getMethodName(), currentType));
            currentType = "";
        }
    }
}