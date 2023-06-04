package in.rakesh.comp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "comp1")
@ConfigurationProperties(prefix = "in.rakesh")
public class Company1 {

    @Value("${name}")
    private String name;

    @Value(("${type}"))
    private String type;

    @Value("${location}")
    private String location;

    static
    {
        System.out.println("Company.class file is loading...");
    }

    public Company1()
    {
        System.out.println("Company object is instantiated...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation()
    {
        return location;
    }
    public void setLocation(String location)
    {
        this.location=location;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
