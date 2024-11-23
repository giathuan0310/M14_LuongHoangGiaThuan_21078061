package fit.iuh.se.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Đảm bảo Spring Boot có thể phục vụ ảnh từ thư mục uploads
        registry.addResourceHandler("/uploads/**")
        .addResourceLocations("file:/C:/Users/luong/Downloads/14_LuongHoangGiaThuan_21078061/14_LuongHoangGiaThuan_21078061/uploads/");

    }
}

