pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Descargando el código fuente desde GitHub...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Compilando y construyendo el proyecto...'
               
                sh 'echo "Construcción completada exitosamente"'
            }
        }

        stage('Test') {
            steps {
                echo 'Ejecutando pruebas unitarias...'
           
                sh 'echo "0 errores encontrados. Todas las pruebas pasaron."'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Desplegando el artefacto en el entorno simulado...'

                sh '''
                    echo "--- INICIANDO DESPLIEGUE AUTOMÁTICO ---"
                    echo "Copiando archivos al directorio de producción..."
                    echo "Despliegue finalizado correctamente."
                '''
            }
        }
    }

    post {
        success {
            echo '¡Felicidades! El pipeline se ha ejecutado correctamente y está en VERDE.'
        }
        failure {
            echo 'Hubo un error en alguna de las etapas del pipeline.'
        }
    }
}
