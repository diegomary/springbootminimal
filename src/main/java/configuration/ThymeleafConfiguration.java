// Code configuration for ThYmeleaf view engine to be used in place of AutoConfiguration
// Just Uncomment the following


// import org.thymeleaf.spring4.*;
// import org.springframework.context.annotation.*;
// import org.springframework.web.servlet.config.annotation.*;
// import org.thymeleaf.spring4.templateresolver.*;
// import org.thymeleaf.spring4.view.*;

// @Configuration
// @EnableWebMvc
// public class ThymeleafConfiguration {
  
//     @Bean
//     public SpringTemplateEngine templateEngine() {
//         SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//         templateEngine.setTemplateResolver(thymeleafTemplateResolver());
//         return templateEngine;
//     }
 
//     @Bean
//     public SpringResourceTemplateResolver thymeleafTemplateResolver() {
//         SpringResourceTemplateResolver templateResolver 
//           = new SpringResourceTemplateResolver();
//         templateResolver.setPrefix("views/");
//         templateResolver.setSuffix(".html");
//         templateResolver.setTemplateMode("HTML5");
//         return templateResolver;
//     }

//     @Bean
//     public ThymeleafViewResolver thymeleafViewResolver() {
//     ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//     viewResolver.setTemplateEngine(templateEngine());
//     return viewResolver;
// }
// }