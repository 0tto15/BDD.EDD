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
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Ejecutando pruebas unitarias...'
                sh 'mvn test'
            }
        }

    }
        success {
            echo '¡Felicidades! El pipeline se ha ejecutado correctamente y está en VERDE.'
        }
        failure {
            echo 'Hubo un error en alguna de las etapas del pipeline.'
        }
    }
}
