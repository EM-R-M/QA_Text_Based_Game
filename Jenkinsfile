pipeline {
        agent any
        
        tools {
            // Install the Maven version configured as "M3" and add it to the path.
            maven "M3"
        }
        //
        stages {
            stage('Checkout') {
                steps {
                    // Get some code from a GitHub Repository
                    git branch: 'main', url: 'https://github.com/EM-R-M/QA_Text_Based_Game.git'
                }
            }
            stage('Compile') {
                steps {
                    // Run Maven on a Unix agent
                    sh "mvn clean compile"
                }
            }
            stage('Test') {
                steps {
                    sh "mvn -Dmaven.compile.skip test"
                }
            }
            stage('Package') {
                steps {
                    sh "mvn -Dmaven.test.skip -Dmaven.compile.skip package"
                }
            }
            stage('SonarQube Analysis') {
                environment {
                    scannerHome = tool 'sonarqube'
                }
                    steps {
                        withSonarQubeEnv('sonar-qube-1') {
                           sh "${scannerHome}/bin/sonar-scanner"
                        }
                    }
            
                }
        
        }
}
