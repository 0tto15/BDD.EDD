package org.example.bdd.connexion;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * A tener en cuenta:
 * Este es un ejemplo de un pool de conexiones, el pool de conexiones es una herramienta más potente que nos da
 * la posibilidad de tener diversas conexiones ya listas en caso de necesitarlas, dandonos tambien muchísimas más
 * herramientas que nos serán utiles para tener un control más amplio de esta clase.
 *
 * Para el pool de conexiones habrá que:
 *Añadir al pom.xml la dependencia com.zaxxer y la de MySql
 *en module el requires com.zaxxer.hikari junto con el requires org.postgresql.jdbc.
 */

public class ConnectionPool {
    private static final HikariDataSource dataSource;
    static {
        try {
            HikariConfig config = new HikariConfig();
            // Configuración de la conexión
            config.setJdbcUrl("jdbc:mysql://localhost:3309/PelosBD?serverTimezone=UTC"); //Acá va la url, ya sea del docker o del supabase.
            config.setUsername("root");
            config.setPassword("root");

            // Configuración del pool de conexiones
            config.setMaximumPoolSize(7); // Número de máximo de conexiones (el número de personas que se pueden conectar)
            config.setMinimumIdle(2); // Número de conexiones minimas (conexiones que ya están preparadas, como un almacen)
            config.setIdleTimeout(30000); // 30 segundos. Tiempo de conexion libre sin cerrarse (se mide en milisegundos)
            config.setMaxLifetime(1800000); // 30 minutos. Vida máxima de una conexion
            config.setConnectionTimeout(30000); // 30 segundos. Tiempo máximo de espera a una conexión

            dataSource = new HikariDataSource(config);
        } catch (Exception exception) {
            throw new RuntimeException("Error al inicializar el pool de conexiones\nInformacíon del error: " + exception.getMessage());
        }
    }
    // Getter del objeto dataSource
    public static DataSource getDataSource() {
        return dataSource;
    }
}

