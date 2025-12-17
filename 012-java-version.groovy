pipeline {
    agent any
    stages{
        stage('Java Version'){
            steps{
                script{
                 //1 Ejecutamos comando Shell
                 //2 returnStdout: true -> Devuelva texto
                 //3 .trim() -> para quitar espacios
                 def javaVersion = sh(script:"java -version 2>&1 | head -n 1 | awk -F '\"' '{print \$2}'", returnStdout: true).trim()
                 echo "La version detectada es ${javaVersion}"
                 env.JAVA_DETECTED = javaVersion
                }
            }
        }
        stage('Validación'){
            steps{
                script{
                    if(env.JAVA_DETECTED.startsWith("17")){
                        echo "Buen java para ejecutar"
                    }
                    else{
                        error "Se requiere Java 17, detectada Java ${env.JAVA_DETECTED}"
                    }
                }
            }
        }
    }
}