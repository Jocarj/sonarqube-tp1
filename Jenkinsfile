pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Récupération du code depuis le dépôt (remplacez l'URL par celle de votre dépôt)
                git branch: 'main', url: 'file:///C:/Users/jcb10/Documents/GitHub/sonarqube-copy'
            }
        }

        stage('Build') {
            steps {
                // Nettoyer et construire le projet sans exécuter les tests.
                sh './gradlew clean build -x test'
            }
        }

        stage('Test') {
            steps {
                // Utilisation de catchError pour capturer l'erreur des tests et continuer le pipeline.
                catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE') {
                    sh './gradlew test'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube_Local') {
                    sh './gradlew sonarqube'
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline terminé'
        }
    }
}
