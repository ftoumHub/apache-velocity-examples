package fr.velocity;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;

import java.io.Writer;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collection;

import fr.bean.Product;

public class Test6 {

	public Test6() {

		Velocity.init("src/main/resources/velocity.properties");

		Context context = new VelocityContext();

		final Collection<Product> products = Arrays.asList(
				new Product("Widget", 12.99),
				new Product("Wotsit", 13.99),
				new Product("Thingy", 11.99));

		context.put("products", products);

		Template template2 = Velocity.getTemplate("Test7.vm");

		Writer writer2 = new StringWriter();
		template2.merge(context, writer2);

		System.out.println(writer2);
	}
}
