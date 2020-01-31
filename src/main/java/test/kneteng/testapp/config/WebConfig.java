package test.kneteng.testapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	@Autowired
	private ApplicationContext applicationContext;
	/**
	 * performs all of the configuration steps.
	 * ThymeleafViewResolver implements the ViewResolver interface and is used 
	 * to determine which Thymeleaf views to render, given a view name.
	 * */
	@Bean
	public SpringResourceTemplateResolver templateResolver(){
	    // SpringResourceTemplateResolver automatically integrates with Spring's own
	    // resource resolution infrastructure, which is highly recommended.
	    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	    templateResolver.setApplicationContext(this.applicationContext);
	    templateResolver.setPrefix("/WEB-INF/views/");
	    templateResolver.setSuffix(".html");
	    templateResolver.setCharacterEncoding("UTF-8");
	    // HTML is the default value, added here for the sake of clarity.
	    templateResolver.setTemplateMode(TemplateMode.HTML);
	    // Template cache is true by default. Set to false if you want
	    // templates to be automatically updated when modified.
	    templateResolver.setCacheable(true);
	    return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine(){
	    // SpringTemplateEngine automatically applies SpringStandardDialect and
	    // enables Spring's own MessageSource message resolution mechanisms.
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver());
	    // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
	    // speed up execution in most scenarios, but might be incompatible
	    // with specific cases when expressions in one template are reused
	    // across different data types, so this flag is "false" by default
	    // for safer backwards compatibility.
	    templateEngine.setEnableSpringELCompiler(true);
	    return templateEngine;
	}
	
	/**
	 *  Add the ThymeleafViewResolver as a bean.
	 * */
	@Bean
	@Description("Thymeleaf View Resolver")
	public ThymeleafViewResolver viewResolver() {
	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	    viewResolver.setTemplateEngine(templateEngine());
	    viewResolver.setContentType("UTF-8");
	    viewResolver.setOrder(1);
	    return viewResolver;
	}
	
	/**
	 * The th:text=��#{key}�� tag attribute can be used to display values from property files. 
	 * For this to work the property file must be configured as messageSource bean.
	 * */
	@Bean
	@Description("Spring Message Resolver")
	public ResourceBundleMessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
}
