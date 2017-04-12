package main.config

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.InjectionPoint
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

import javax.validation.constraints.NotNull

//@Configuration
//open class MongoDBConfig {
//
//    @Bean
//    open fun getMongoDB(): MongoClient {
//        val mongoURI = MongoClientURI(System.getenv("localhost:27027"))
//        return MongoClient(mongoURI)
//    }
//}

//@Configuration
//@ConfigurationProperties(prefix = "myapp")
//class MyAppProps {
////    @NotNull lateinit var requiredProp: String
//    var optionalProp: String? = null
//}

@Configuration
class SpringConfiguration {

    @Bean
    @Scope("prototype")
    fun logger(injectionPoint: InjectionPoint): Logger {
        return LoggerFactory.getLogger(injectionPoint.methodParameter.containingClass)
    }
}
