package com.adniyo.ContactApp.test;
import com.adniyo.ContactApp.config.SpringRootConfig;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDataSource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds = ctx.getBean(DataSource.class);
		JdbcTemplate jt = new JdbcTemplate(ds);
		String sql="INSERT INTO users(`name`, `phone`, `email`, `address`, `username`, `password`) VALUES(?,?,?,?,?,?)";
        Object[] param = new Object[]{"Adniyo k", "08081684189", "adniyok@gmail.com", "Ikeja Lagos", "padfoot", "123"};
        jt.update(sql, param);
        System.out.println("------SQL executed-----");
		
		

	}

}
