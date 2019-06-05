package core.extensions

import com.crypterium.cryptApi.Auth.service
import com.crypterium.cryptApi.AuthProvider
import com.crypterium.cryptApi.utils.CredentialEntry
import com.crypterium.cryptApi.utils.Environment
import core.annotations.Credentials
import core.rules.CredentialsRule
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.support.AnnotationSupport

class CredentialsExtension : BeforeEachCallback, AfterEachCallback, CredentialsRule() {

    override fun beforeEach(context: ExtensionContext?) {
        val method = context?.requiredTestMethod
        val credentials = AnnotationSupport.findAnnotation(method, Credentials::class.java).orElse(null)

        if (credentials == null) {
            if (currentType.isNotEmpty()) {
                flush(context?.displayName)
            } else {
                println(String.format("%s : default", context?.displayName))
            }
        } else if (credentials.type.isNotEmpty() && !currentType.equals(credentials.type, ignoreCase = true)) {
            service<AuthProvider>().flush()
            val entry = Environment.CREDENTIALS[credentials.type]
            currentEntry = entry
            service<AuthProvider>().basic(entry?.login, entry?.password)
            println(String.format("%s : '%s' -> '%s'", context?.displayName, currentType, credentials.type))

            currentType = credentials.type
        } else if (!credentials.login.isEmpty() && !credentials.password.isEmpty()) {
            service<AuthProvider>().flush()
            service<AuthProvider>().basic(credentials.login, credentials.password)
            currentEntry = CredentialEntry(credentials.login, credentials.password, "custom")
            println(String.format("%s: %s' -> custom ('%s' : '%s')", context?.displayName, currentType, credentials.login, credentials.password))
            currentType = "custom"
        }
    }

    override fun afterEach(context: ExtensionContext?) {
        val method = context?.requiredTestMethod
        val credentials = AnnotationSupport.findAnnotation(method, Credentials::class.java).orElse(null)

        if (credentials != null && credentials.creatingNewUser) {
            flush(context?.displayName)
        }
    }

}