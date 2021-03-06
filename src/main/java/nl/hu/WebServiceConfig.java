package nl.hu;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/soap/*");
    }

    @Bean(name = "bmi")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema bmiSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BmiPort");
        wsdl11Definition.setLocationUri("/soap/bmi");
        wsdl11Definition.setTargetNamespace("http://hu.nl/gsos/soap");
        wsdl11Definition.setSchema(bmiSchema);
        return wsdl11Definition;
    }

    @Bean(name = "calorieIntake")
    public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema calorieIntakeSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CalorieIntakePort");
        wsdl11Definition.setLocationUri("/soap/calorieIntake");
        wsdl11Definition.setTargetNamespace("http://hu.nl/gsos/soap");
        wsdl11Definition.setSchema(calorieIntakeSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema bmiSchema() {
        return new SimpleXsdSchema(new ClassPathResource("bmi.xsd"));
    }

    @Bean
    public XsdSchema calorieIntakeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("calorieIntake.xsd"));
    }
}