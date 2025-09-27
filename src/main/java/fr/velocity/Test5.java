package fr.velocity;

import fr.bean.Product;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;

import java.io.Writer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test5 {

    public Test5() {

        Velocity.init("src/main/resources/velocity.properties");

        /* Get Velocity template */
        final Template template = Velocity.getTemplate("Test5.vm");

        /* Get Velocity context */
        final Context context = new VelocityContext();

		List<Product> products = Arrays.asList(
				new Product("Apple", 10),
				new Product("Orange", 12),
				new Product("Banana", 11)
		);

		context.put("products", products);

        /* Get Writer */
        final Writer writer = new StringWriter();

        /* Merge data into fr.velocity template */
        template.merge(context, writer);

        System.out.println(writer);
    }
}
