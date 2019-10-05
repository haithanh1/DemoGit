package Demo.Common;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import Demo.Dao.UserNameDao;
import Demo.Dao.Impl.UserNameDaoImpl;

@Configuration
@ComponentScan("Demo.*")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: datasouce-cfg.properties
	   dataSource
				.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource
				.setUrl("jdbc:sqlserver://USER-PC\\SQLEXPRESS:1433;databaseName=USERNAME");
		dataSource.setUsername("sa");
		dataSource.setPassword("123");

		return dataSource;
	}

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager getTransactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		DataSource dataSource = this.getDataSource();
		txManager.setDataSource(dataSource);
		return txManager;
	}

	@Bean(name = "userNameDao")
	public UserNameDao transferService() {
		return new UserNameDaoImpl(getDataSource());
	}
}
