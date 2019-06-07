package core.extensions

import com.crypterium.cryptApi.utils.Environment
import core.annotations.Financial
import org.junit.Assume
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.support.AnnotationSupport

class FinancialExtension : BeforeEachCallback {

    override fun beforeEach(context: ExtensionContext?) {
        if (Environment.FINANCE_OPERATIONS_ALLOWED != "true") {
            val isFinancial = AnnotationSupport.isAnnotated(context?.testMethod
                    ?: context?.testClass, Financial::class.java)
            Assume.assumeFalse(isFinancial)
        }
    }

}