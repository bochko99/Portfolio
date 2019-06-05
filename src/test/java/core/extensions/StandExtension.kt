package core.extensions

import com.crypterium.cryptApi.utils.Environment
import core.annotations.ScopeTarget
import org.junit.Assume
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.support.AnnotationSupport

class StandExtension : BeforeEachCallback {

    override fun beforeEach(context: ExtensionContext?) {
        val method = context?.requiredTestMethod
        val annotation = AnnotationSupport.findAnnotation(method, ScopeTarget::class.java).orElse(null)
        if (annotation != null) {
            val stands = annotation.value.map { it.name }
            val classErrMsg = String.format("Current stand '%s' not in {%s}", Environment.TARGET, stands.joinToString(", "))
            Assume.assumeTrue(classErrMsg, stands.contains(Environment.TARGET))
            val errMsg = String.format("Current stand '%s' not in {%s}", Environment.TARGET, stands.joinToString(", "))
            Assume.assumeTrue(errMsg, stands.contains(Environment.TARGET))
        }
    }

}