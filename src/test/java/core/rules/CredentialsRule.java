package core.rules;

import annotations.Credentials;
import core.Auth;
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
                currentType = "";
            }
        } else if (!credentials.type().isEmpty() && !currentType.equalsIgnoreCase(credentials.type())) {
            Auth.flush();
            CredentialEntry entry = Environment.CREDENTIALS.get(credentials.type());
            Auth.basic(entry.getLogin(), entry.getPassword());
            currentType = credentials.type();
        } else if (!credentials.login().isEmpty() && !credentials.password().isEmpty()) {
            Auth.flush();
            Auth.basic(credentials.login(), credentials.password());
            currentType = "custom";
        }
    }

}